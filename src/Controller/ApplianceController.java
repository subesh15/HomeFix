package Controller;

import java.util.ArrayList;

import Model.AppliancesDAO;
import Resources.AppliancesDTO;

public class ApplianceController {
    public static void addappliance(String appliance_type,String brand,String model) throws Exception{
        AppliancesDAO appliance=AppliancesDAO.getInstanceAppliancesDAO();
        AppliancesDTO app=new AppliancesDTO(0, appliance_type, brand, model);
        appliance.addAppliance(app);
    }
    public static ArrayList<AppliancesDTO> viewappliacne() throws Exception{
        AppliancesDAO view = AppliancesDAO.getInstanceAppliancesDAO();
        return view.viewappliance();
    }
    
}
