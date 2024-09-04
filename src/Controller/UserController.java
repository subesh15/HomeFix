package Controller;

import Model.IssueDAO;
import Model.UserDAO;
import Resources.IssueDTO;
import Resources.UserDTO;
import Util.Cookie;
// import at.favre.lib.crypto.bcrypt.BCrypt;

public class UserController {
    public static int login(String email,String Password) throws Exception {
        UserDAO usrModal=UserDAO.getInstanceUserDAO();
        UserDTO user=usrModal.getByEmail(email);

        if (user == null){
            throw new Exception("Invalid User");
        }
        // BCrypt.Result verf=BCrypt.verifyer().verify(Password.toCharArray(),user.getPassword());

        // if(!verf.verified){
        //     throw new Exception("Invalid Password");
        // }
        if(!Password.equals(user.getPassword())){
            throw new Exception("Invalid Pass");
        }
        Cookie.setUser(user);
        if(user.getRole().equals("user")){
            return 1;
        }
        return user.getUser_id(); 
    }


    public static void registerUser(String user_name,String email,String ph_no,String role,String password) throws Exception{
        UserDAO user=UserDAO.getInstanceUserDAO();
        UserDTO usr=new UserDTO(0, user_name, ph_no, role, email, password);
        user.addUser(usr);
    }

/// in this we need to changee 
    public static void registerIssue(String description,int appliance_id) throws Exception{
        IssueDAO usrIssue=IssueDAO.getInstanceIssueDAO();
        IssueDTO issue =new IssueDTO( 0,Cookie.getUser().getUser_id(), description, appliance_id, 0,"");
        usrIssue.addIssue(issue);
    }


    public static void removeIssue(int issue_id) throws Exception{
        IssueDAO usrIssue=IssueDAO.getInstanceIssueDAO();
        usrIssue.deleteIssue(issue_id);
    }

    
}
