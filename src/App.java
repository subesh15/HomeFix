import java.sql.SQLException;
import java.util.InputMismatchException;

import Controller.TechnicianController;
import Controller.UserController;
import Model.Connect;
import Util.Input;
import Views.Technician;
import Views.User;


public class App extends Input{
    public static void main(String[] args) {
        try{
            Connect.getConnection();
            System.out.println("database connected");
        }
        catch(SQLException err){
            System.out.println("database not connected");
        }
        while(true){
            try{
                System.out.println("--------------------");
                System.out.println("1.Login");
                System.out.println("2.SignUp");
                System.out.println("3.Exit");
                System.out.println("--------------------");
                System.out.println("Enter your choice :");
                System.out.println("--------------------");
                int choice=sc.nextInt();
                sc.nextLine();
                
               
                 if(choice==1){
                    System.out.println("Enter Email :");
                    System.out.println("--------------------");
                    String email=sc.nextLine();
                    System.out.println("Enter Password");
                    System.out.println("--------------------");
                    String password=sc.nextLine();
                    int check=UserController.login(email,password);
                    if(check ==1){
                        // System.out.println("Hello User");
                        // System.out.println("Register your Issue");
                        User.start();
                    }
                    else{
                        System.out.println("-------------------");
                        System.out.print("Welcome Technician ");
                        System.out.println("-------------------");
                        Technician.start(check);
                    }
                }

                else if(choice==2){
                    System.out.println("Enter your Name :");
                    String username=sc.nextLine();
                    System.out.println("Enter your Email :");
                    String email=sc.nextLine();
                    System.out.println("Enter your PhoneNumber :");
                    String phno=sc.nextLine();
                    System.out.println("Enter your Role (user/technician) :");
                    String role=sc.nextLine();
                    System.out.println("Enter your Password :");
                    String password=sc.nextLine();
                    if(role.equals("user")){
                        UserController.registerUser(username,email,phno,role,password);
                    }
                    else{
                        System.out.println("Enter specialization :");
                        String specialization=sc.nextLine();
                        TechnicianController.registerTech(username,email,phno,role,password,specialization);
                    }
                }
                else if(choice==3){
                    break;
                }
            }
            catch(SQLException err){
                System.out.println("Database Error");
                System.out.println(err);

            }
            catch(InputMismatchException err){
                System.out.println("Invalid Input");
            }
            catch(Exception err){
                System.out.println(err.getMessage());
            }
            System.out.println();
        }
        // System.out.println("Hello, World!");
    }
}
