package Resources;

public class IssueDTO {
    private int issue_id;
    private int user_id;
    private String description;
    private int appliances_id;
    private int technician_id;
    private String status;
    private String user_name;
    private String ph_no;


    public IssueDTO() {
    }

    public IssueDTO(int issue_id, int user_id, String description, int appliances_id, int technician_id, String status) {
        this.issue_id = issue_id;
        this.user_id = user_id;
        this.description = description;
        this.appliances_id = appliances_id;
        this.technician_id = technician_id;
        this.status=status;

    }

    public String getPh_no() {
        return this.ph_no;
    }

    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }


    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIssue_id() {
        return this.issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAppliances_id() {
        return this.appliances_id;
    }

    public void setAppliances_id(int appliances_id) {
        this.appliances_id = appliances_id;
    }

    public int getTechnician_id() {
        return this.technician_id;
    }

    public void setTechnician_id(int technician_id) {
        this.technician_id = technician_id;
    }

}
