package Views;


import java.util.ArrayList;

import Controller.ApplianceController;
import Controller.IssueController;
import Controller.TechnicianController;
import Resources.IssueDTO;
import Resources.AppliancesDTO;
import Util.Input;

public class Technician extends Input{
    public static void start(int id){
        while(true){
            try{
                System.out.println("Welcome !!");
                System.out.println("1.Remove technician");
                System.out.println("2.Book Issue");
                System.out.println("3.View Issue");
                System.out.println("4.Update Status");
                System.out.println("5.Add Appliances");
                System.out.println("6.View Appliances");
                System.out.println("7.Exit to profile");
                System.out.println("_____________________");
                System.out.println();
                System.out.println("Enter your Option :");
                System.out.println("____________________");
                System.out.println();

                int techchoice=sc.nextInt();
                sc.nextLine();

                if(techchoice==1){
                    System.out.println("Enter Technician ID:");
                    System.out.println("----------------------");
                    int techid=sc.nextInt();
                    TechnicianController.removeTech(techid);
                    System.out.println();
                    System.out.println("Technician removed ");
                    System.out.println("------------------");
                }
                else if (techchoice==2){
                    System.out.println("Enter Issue_id :");
                    System.out.println("------------------");
                    int issueid=sc.nextInt();
                    TechnicianController.bookissue(issueid);
                    System.out.println("Issue Booked Successfully!!");
                    System.out.println("---------------------------");
                }
                else if (techchoice==3){
                   ArrayList<IssueDTO> ar=IssueController.viewissue();
                   System.out.printf("%-20s%-20s%-30s%-20s%-20s%-20s\n","issue_id","user_id","description","appliances_id","technician_id","status");
                   System.out.println("-".repeat(120));
                   for(IssueDTO show:ar){
                       System.out.printf("%-20s%-20s%-30s%-20s%-20s%-20s\n",show.getIssue_id(),show.getUser_id(),show.getDescription(),show.getAppliances_id(),show.getTechnician_id(),show.getStatus());
                   }
                }   
                else if(techchoice==4){
                    System.out.println("Enter Issue ID :");
                    System.out.println("------------------");
                    int issue_id=sc.nextInt();
                    IssueController.updateStatus(issue_id,id);
                    System.out.println("Hello User your issue status completed");
                    System.out.println("--------------------------------------");
                }
                else if(techchoice==5){
                    System.out.println("Enter Appliance Name :");
                    String appliances_type=sc.nextLine();
                    System.out.println("Enter Brand Name :");
                    String brand=sc.nextLine();
                    System.out.println("Enter Model :");
                    String model=sc.nextLine();
                    ApplianceController.addappliance(appliances_type,brand,model);
                    System.out.println("Appliances Added Successfully");
                    System.out.println("-------------xxx-------------");
                }
                else if(techchoice ==6){
                    ArrayList<AppliancesDTO> ar=ApplianceController.viewappliacne();
                    System.out.println("-".repeat(40));
                    System.out.printf("%-20s%-20s\n","APPLIANCE_ID","APPLIANCE_NAME");
                    System.out.println("-".repeat(40));
                    for(AppliancesDTO show:ar){
                        System.out.printf("%-20s%-20s\n",show.getAppliances_id(),show.getAppliances_type());
                    }
                    
                }
                // System.out.println();
                else if (techchoice == 7){
                    return;
                }
                else{
                    System.out.println("-------------------");
                    System.out.println("Enter Valid Choice :");
                    System.out.println("-------------------");
                }
                // else if(techchoice == 6){
                //     System.out.println("5.Book Appoinment");
                //     return;
                // }
            } 
            catch(Exception err){
                System.out.println(err.getMessage());
            }
        }

    }
    
}
