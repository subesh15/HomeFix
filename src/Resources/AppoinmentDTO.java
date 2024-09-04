package Resources;

public class AppoinmentDTO {
    private int appoinment_id;
    private int user_id;
    private String date_fixed;
    private String time;
    private String location;

    public AppoinmentDTO(int appoinment_id, int user_id, String date_fixed, String time, String location) {
        this.appoinment_id = appoinment_id;
        this.user_id = user_id;
        this.date_fixed = date_fixed;
        this.time = time;
        this.location = location;
    }
    
    public int getAppoinment_id() {
        return this.appoinment_id;
    }

    public void setAppoinment_id(int appoinment_id) {
        this.appoinment_id = appoinment_id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDate_fixed() {
        return this.date_fixed;
    }

    public void setDate_fixed(String date_fixed) {
        this.date_fixed = date_fixed;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
}

