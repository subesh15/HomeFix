package Model;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Resources.UserDTO;

public class UserDAO extends Connect{
    private static UserDAO inst;
    private PreparedStatement selectByEmail;
    private PreparedStatement insertIntoLogin;
    private PreparedStatement insertIntoUser;
    // private PreparedStatement selectByDesignation;

    private UserDAO() throws SQLException{

        selectByEmail=conn.prepareStatement("SELECT L.email,L.password,L.user_id,U.user_name,U.ph_no,U.role FROM login L JOIN user U USING(user_id) WHERE email =?");

        insertIntoLogin =conn.prepareStatement("INSERT INTO login(email,password,user_id) VALUES (?,?,?)");

        insertIntoUser =conn.prepareStatement("INSERT INTO user(user_name,ph_no,role) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);

    }

    public static UserDAO getInstanceUserDAO() throws SQLException {
        if(inst ==null){
            inst =new UserDAO();
        }
        return inst;
    }
    public UserDTO getByEmail(String email) throws SQLException {
        selectByEmail.setString(1,email);
        ResultSet rs=selectByEmail.executeQuery();
        if(rs.next()){
            return new UserDTO(rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(1), rs.getString(2));
        }
        return null;
    }
    
    public int addUser(UserDTO user) throws SQLException{
        insertIntoUser.setString(1, user.getUser_name());
        insertIntoUser.setString(2, user.getPh_no());
        insertIntoUser.setString(3, user.getRole());
        insertIntoUser.executeUpdate();
        ResultSet res=insertIntoUser.getGeneratedKeys();
        if(res.next()){
            insertIntoLogin.setString(1, user.getEmail());
            insertIntoLogin.setString(2, user.getPassword());
            insertIntoLogin.setInt(3, res.getInt(1));
            insertIntoLogin.executeUpdate();
            return res.getInt(1);
        }
        return -1;
    }
    
    
}
