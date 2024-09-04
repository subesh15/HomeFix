package Resources;

public class TechnicianDTO {
    private int technician_id;
    private int user;
    private String specializaton;
    private String availability;

    public TechnicianDTO(int technician_id, int user, String specializaton, String availability) {
        this.technician_id = technician_id;
        this.user = user;
        this.specializaton = specializaton;
        this.availability = availability;
    }

    public int getTechnician_id() {
        return this.technician_id;
    }

    public void setTechnician_id(int technician_id) {
        this.technician_id = technician_id;
    }

    public int getUserId() {
        return this.user;
    }

    public void setUserId(int userId) {
        this.user = userId;
    }

    public String getSpecializaton() {
        return this.specializaton;
    }

    public void setSpecializaton(String specializaton) {
        this.specializaton = specializaton;
    }

    public String getAvailability() {
        return this.availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

}
