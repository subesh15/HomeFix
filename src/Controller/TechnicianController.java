package Controller;

import java.util.ArrayList;

import Model.IssueDAO;
import Model.TechnicianDAO;
import Model.UserDAO;
import Resources.TechnicianDTO;
import Resources.UserDTO;
import Util.Cookie;

public class TechnicianController {
    public static void registerTech(String user_name,String email,String ph_no,String role,String password,String specialization) throws Exception{
        UserDAO userModal=UserDAO.getInstanceUserDAO();
        UserDTO user=new UserDTO(0, user_name, ph_no, role, email, password);
        int id=userModal.addUser(user);
        TechnicianDAO tech=TechnicianDAO.getInstanceTechnicianDAO();
        TechnicianDTO techni=new TechnicianDTO(0, id, specialization,"YES");
        tech.addTechnician(techni);
    }

    public static void removeTech(int techid) throws Exception{
        TechnicianDAO tech=TechnicianDAO.getInstanceTechnicianDAO();
        tech.deleteTechnician(techid);
    }

    public static ArrayList<TechnicianDTO> viewtechnician() throws Exception {
        TechnicianDAO view =TechnicianDAO.getInstanceTechnicianDAO();
        return view.viewtechnician();
    }

    public static void bookissue(int id) throws Exception{
        IssueDAO issueModal=IssueDAO.getInstanceIssueDAO();
        if(!issueModal.isBooked(id)){
            throw new Exception("Already Booked");
        }
        TechnicianDAO techModal=TechnicianDAO.getInstanceTechnicianDAO();
        int techId=techModal.getTechId(Cookie.getUser().getUser_id());
        if(techId==-1){
            throw new Exception("Invalid technician");
        }
        issueModal.updateTechId(id, techId);
    }
}
