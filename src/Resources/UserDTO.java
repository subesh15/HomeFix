package Resources;

public class UserDTO {
    private int user_id;
    private String user_name;
    private String ph_no;
    private String role;
    private String email;
    private String password;

    public UserDTO(int user_id, String user_name, String ph_no, String role,String email,String password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.ph_no = ph_no;
        this.role = role;
        this.email=email;
        this.password=password;
    }

    public int getUser_id() {
        return this.user_id;
    }
    
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    
    public String getPh_no() {
        return this.ph_no;
    }
    
    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
