package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.TechnicianDTO;

public class TechnicianDAO extends Connect {
    private static TechnicianDAO inst;
    private PreparedStatement insertintoTechnician;
    private PreparedStatement viewtech;
    private PreparedStatement deleteintoTechnician;
    private PreparedStatement selectTechId;


    private TechnicianDAO() throws SQLException{
        insertintoTechnician = conn.prepareStatement("INSERT INTO technician(user_id,specialization,available) VALUES (?,?,?)");
        viewtech = conn.prepareStatement("SELECT * FROM technician ");
        deleteintoTechnician = conn.prepareStatement("DELETE FROM technician WHERE techid  = ?");
        selectTechId = conn.prepareStatement("SELECT technician_id FROM technician WHERE user_id=?");

    }

    public static TechnicianDAO getInstanceTechnicianDAO() throws SQLException {
        if(inst ==null){
            inst =new TechnicianDAO();
        }
        return inst;
    }
    
    public void addTechnician(TechnicianDTO technician) throws SQLException{
        insertintoTechnician.setInt(1, technician.getUserId());
        insertintoTechnician.setString(2, technician.getSpecializaton());
        insertintoTechnician.setString(3, technician.getAvailability());
        insertintoTechnician.executeUpdate();
        return;
    }



    public ArrayList<TechnicianDTO> viewtechnician() throws Exception{
        ResultSet rs=viewtech.executeQuery();
        ArrayList<TechnicianDTO> ar=new ArrayList<>();
        while(rs.next()){
            ar.add(new TechnicianDTO(rs.getInt(1),rs.getInt(4), rs.getString(2),rs.getString(3)));
        }
        return ar;
    }

    public void deleteTechnician(int techid) throws SQLException{
        deleteintoTechnician.setInt(1, techid);
        deleteintoTechnician.executeUpdate();
        return;
    }

    public int getTechId(int userId) throws SQLException{
        selectTechId.setInt(1, userId);
        ResultSet res=selectTechId.executeQuery();
        if(res.next()){
            return res.getInt(1);
        }
        return -1;
    }
}
