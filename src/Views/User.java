package Views;

import java.util.ArrayList;

import Controller.ApplianceController;
import Controller.IssueController;
import Controller.TechnicianController;
import Controller.UserController;
import Resources.AppliancesDTO;
import Resources.IssueDTO;
import Resources.TechnicianDTO;
import Util.Input;

public class User extends Input{
    public static void start(){
        while(true){
            try{
                System.out.println("--------------------");
                System.out.println("Welcome to this page");
                System.out.println("--------------------");
                System.out.println("1.Register issue");
                System.out.println("2.Remove issue");
                System.out.println("3.View Technician");
                System.out.println("4.View Status Completion");
                System.out.println("6.View technician booked status");

                System.out.println("7.Goto Login");
                System.out.println();
                System.out.println("------------------");
                System.out.println("Enter Your choice");
                System.out.println("------------------");
                int userchoice=sc.nextInt();
                sc.nextLine();
                if(userchoice == 1){  
                    System.out.println("------------------");
                    System.out.println("Enter your Issue :");
                    System.out.println("------------------");
                    String description=sc.nextLine();
                    // sc.nextLine();
                    System.out.println();
                    ArrayList<AppliancesDTO> ar=ApplianceController.viewappliacne();
                    System.out.printf("%-20s%-20s\n","Appliance_ID","Appliance Name");
                    System.out.println("-".repeat(50));
                    for(AppliancesDTO show:ar){
                        System.out.printf("%-20s%-20s\n",show.getAppliances_id(),show.getAppliances_type());
                    }
                    System.out.println();
                    System.out.println("------------------");
                    System.out.println("Enter Appliance ID");
                    System.out.println("------------------");
                    int appliances_id=sc.nextInt();
                    UserController.registerIssue(description, appliances_id);
                    sc.nextLine();
                    System.out.println("Issue Registered Successfully!");
                    System.out.println("-------------xxx--------------");
                }
                else if(userchoice==2){
                    ArrayList<IssueDTO> ar=IssueController.viewissue();
                    System.out.println("-".repeat(120));
                   System.out.printf("%-20s%-20s%-30s%-20s%-20s%-20s\n","Issue_ID","User_ID","Description","Appliances_ID","Technician_ID","Status","|");
                   System.out.println("-".repeat(120));
                   for(IssueDTO show:ar){
                       System.out.printf("%-20s%-20s%-30s%-20s%-20s%-20s\n",show.getIssue_id(),show.getUser_id(),show.getDescription(),show.getAppliances_id(),show.getTechnician_id(),show.getStatus());
                   }
                   System.out.println("------------------");
                    System.out.println("Enter Issue ID :");
                    System.out.println("------------------");
                    int issue_id=sc.nextInt();
                    UserController.removeIssue(issue_id);
                    System.out.println("Issue Removed Successfully!");
                    System.out.println("-------------xxx-----------");
                }
                else if(userchoice==3){
                    ArrayList<TechnicianDTO> ar=TechnicianController.viewtechnician();
                    System.out.println("-".repeat(80));
                    System.out.printf("%-20s%-20s%-20s%-20s\n","Technicia_ID","User_ID","Specialization","Availability","|");
                    System.out.println("-".repeat(80));
                    for(TechnicianDTO show:ar){
                        System.out.printf("%-20s%-20s%-20s%-20s\n",show.getTechnician_id(),show.getUserId(),show.getSpecializaton(),show.getAvailability());
                    }
                    
                }
                else if(userchoice==4){
                    ArrayList<IssueDTO> ar=IssueController.viewstatus();
                    System.out.println("-".repeat(120));
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s\n","USER_ID","USERNAME","ISSUE ID","Description","Status","|");
                    System.out.println("-".repeat(120));
                    for(IssueDTO show:ar){
                        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n",show.getUser_id(),show.getUser_name(),show.getIssue_id(),show.getDescription(),show.getStatus());
                    }
                    System.out.println();
                    
                }
                
                else if(userchoice==6){
                //     ArrayList<IssueDTO> ar=IssueController.viewissue();
                //    System.out.printf("%-20s%-20s%-30s%-20s%-20s%-20s\n","issue_id","user_id","description","appliances_id","technician_id","status");
                //    System.out.println("-".repeat(120));
                //    for(IssueDTO show:ar){
                //        System.out.printf("%-20s%-20s%-30s%-20s%-20s%-20s\n",show.getIssue_id(),show.getUser_id(),show.getDescription(),show.getAppliances_id(),show.getTechnician_id(),show.getStatus());
                //    }
                    // System.out.println("Enter Issue ID :");
                    // String issue_id=sc.nextLine();
                    // IssueController.viewbooktech(issue_id);
                    ArrayList<IssueDTO> arr=IssueController.viewbooktech();
                    System.out.println("-".repeat(145));
                   System.out.printf("%-20s%-20s%-30s%-20s%-20s%-20s%-20s\n","ISSUE_ID","USER_ID","DESCRIPTION","APPLIANCE_ID","TECHNICIAN ID","CONTACT NO","STATUS");
                   System.out.println("-".repeat(145));
                   for(IssueDTO show:arr){
                       System.out.printf("%-20s%-20s%-30s%-20s%-20s%-20s%-20s\n",show.getIssue_id(),show.getUser_id(),show.getDescription(),show.getAppliances_id(),show.getTechnician_id(),show.getPh_no(),show.getStatus());
                   }
                }
                else if(userchoice==7){
                    return;
                }
                else{
                    System.out.println("-------------------");
                    System.out.println("Enter Valid Choice :");
                    System.out.println("-------------------");
                }
            }
            catch(Exception err){
                System.out.println("Database Error");
                System.out.println(err);
            }
        }
    }
}
