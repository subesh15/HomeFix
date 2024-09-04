package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.AppliancesDTO;

public class AppliancesDAO extends Connect{
    private static AppliancesDAO inst;
    private PreparedStatement insertintoAppliance;
    private PreparedStatement viewappliance;


    private AppliancesDAO() throws SQLException{
        insertintoAppliance = conn.prepareStatement("INSERT INTO appliances(appliances_type,brand,model) VALUES (?,?,?)");
        viewappliance = conn.prepareStatement("SELECT appliances_id,appliances_type FROM appliances ");
    }
    public static AppliancesDAO getInstanceAppliancesDAO() throws SQLException {
        if(inst ==null){
            inst =new AppliancesDAO();
        }
        return inst;
    }

    public void addAppliance(AppliancesDTO appliance) throws SQLException{
        insertintoAppliance.setString(1, appliance.getAppliances_type());
        insertintoAppliance.setString(2, appliance.getBrand());
        insertintoAppliance.setString(3, appliance.getModel());
        insertintoAppliance.executeUpdate();
        return;
    }
    public ArrayList<AppliancesDTO> viewappliance() throws SQLException{
        ResultSet rs=viewappliance.executeQuery();
        ArrayList<AppliancesDTO> ar=new ArrayList<>();
        while(rs.next()){
            ar.add(new AppliancesDTO(rs.getInt(1), rs.getString(2), null, null));
        }
        return ar;
    } 
}
