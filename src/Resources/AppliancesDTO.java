package Resources;

public class AppliancesDTO {
    private int appliances_id;
    private String appliances_type;
    private String brand;
    private String model;
    
    public AppliancesDTO(int appliances_id, String appliances_type, String brand, String model) {
        this.appliances_id = appliances_id;
        this.appliances_type = appliances_type;
        this.brand = brand;
        this.model = model;
    }

    public int getAppliances_id() {
        return this.appliances_id;
    }

    public void setAppliances_id(int appliances_id) {
        this.appliances_id = appliances_id;
    }

    public String getAppliances_type() {
        return this.appliances_type;
    }

    public void setAppliances_type(String appliances_type) {
        this.appliances_type = appliances_type;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
