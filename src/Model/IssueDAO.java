package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Resources.IssueDTO;

public class IssueDAO extends Connect {
    private static IssueDAO inst;
    private PreparedStatement insertIntoIssue;
    private PreparedStatement viewisu;
    private PreparedStatement viewstatus;
    private PreparedStatement updateTechId;
    private PreparedStatement updateStatus;
    private PreparedStatement viewbooktech;
    private PreparedStatement GetStatus;
    private PreparedStatement deleteIntoIssue;

    private IssueDAO() throws SQLException{
        insertIntoIssue =conn.prepareStatement("INSERT INTO issue(user_id,description,appliances_id,status) VALUES (?,?,?,'pending')");
        viewisu = conn.prepareStatement("SELECT * FROM issue");
        viewstatus = conn.prepareStatement("SELECT U.user_id,U.user_name,I.issue_id,I.description,I.status FROM issue I JOIN user U USING (user_id) WHERE U.user_id=?");
        viewbooktech=conn.prepareStatement("SELECT U.user_id,U.user_name,U.ph_no,I.issue_id,I.description,T.user_id,I.status FROM issue I JOIN user U USING (user_id) JOIN technician T USING (technician_id) WHERE U.user_id=?");
        deleteIntoIssue =conn.prepareStatement("DELETE FROM issue WHERE issue_id = ?");
        updateTechId = conn.prepareStatement("UPDATE issue SET technician_id=? WHERE issue_id=?");
        GetStatus = conn.prepareStatement("SELECT * FROM issue WHERE issue_id=?");
        updateStatus = conn.prepareStatement("UPDATE issue SET status='Completed' WHERE issue_id=? AND technician_id=?");
    }

    public static IssueDAO getInstanceIssueDAO() throws SQLException {
        if(inst ==null){
            inst =new IssueDAO();
        }
        return inst;
    }


    public void addIssue(IssueDTO isu) throws SQLException{
        insertIntoIssue.setInt(1, isu.getUser_id());
        // insertIntoIssue.setString(2, isu.getUser_name());
        insertIntoIssue.setString(2, isu.getDescription());
        // insertIntoIssue.setInt(4, isu.getIssue_id());
        insertIntoIssue.setInt(3, isu.getAppliances_id());
        // insertIntoIssue.setInt(4, isu.getTechnician_id());
        // insertIntoIssue.setString(6, isu.getStatus());
        insertIntoIssue.executeUpdate();
        return;
    }

    
    public ArrayList<IssueDTO> viewissue() throws Exception{
        ResultSet rs=viewisu.executeQuery();
        ArrayList<IssueDTO> ar=new ArrayList<>();
        while(rs.next()){
            ar.add(new IssueDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
        }
        return ar;
    }
    
    public ArrayList<IssueDTO> viewstatus(int id) throws Exception{
        viewstatus.setInt(1, id);
        ResultSet rs=viewstatus.executeQuery();
        ArrayList<IssueDTO> ar=new ArrayList<>();
        while (rs.next()) {
            IssueDTO issue=new IssueDTO();
            issue.setUser_id(rs.getInt(1));
            issue.setUser_name(rs.getString(2));
            issue.setIssue_id(rs.getInt(3));
            issue.setDescription(rs.getString(4));
            // issue.setName(rs.getString(5));
            issue.setStatus(rs.getString(5));
            ar.add(issue);
        }
        return ar;
    }

    public ArrayList<IssueDTO> viewbooktech(int id) throws Exception{
        viewbooktech.setInt(1, id);
        ResultSet rs=viewbooktech.executeQuery();
        ArrayList<IssueDTO> ar=new ArrayList<>();
        while (rs.next()) {
            IssueDTO issue=new IssueDTO();
            issue.setUser_id(rs.getInt(1));
            issue.setUser_name(rs.getString(2));
            issue.setPh_no(rs.getString(3));
            issue.setIssue_id(rs.getInt(4));
            issue.setDescription(rs.getString(5));
            issue.setTechnician_id(rs.getInt(6));
            issue.setStatus(rs.getString(7));
            ar.add(issue);
        }
        return ar;
    }


    public void deleteIssue(int issue_id) throws SQLException{
       deleteIntoIssue.setInt(1,issue_id);
        deleteIntoIssue.executeUpdate();
        return;
    }

    public void updateTechId(int issueId,int techId) throws SQLException{
        updateTechId.setInt(1, techId);
        updateTechId.setInt(2, issueId);
        updateTechId.executeUpdate();
    }

    public boolean isBooked(int id) throws SQLException{
        ResultSet res=state.executeQuery("SELECT * FROM issue WHERE technician_id IS NOT NULL AND issue_id="+id);
        if(res.next()){
            return false;
        }
        return true;
    }

    public boolean updateStatus(int issue_id,int id) throws SQLException{
        GetStatus.setInt(1, id);
        ResultSet rt=GetStatus.executeQuery();
        if(rt.next())
        {
            String uid=rt.getString("technician_id");
            if(uid==null)
            return false;
            else{
                updateStatus.setInt(1, issue_id);
                updateStatus.setInt(2, id);
                int k= updateStatus.executeUpdate();
                if(k>0)
                return true;
                else 
                return false;
            }
        }
        return false;
    }
}
