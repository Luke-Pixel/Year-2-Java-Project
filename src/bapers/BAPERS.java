/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

//import Control.BackEndControl;
import Control.BackEndControl;
import Database_Connection.JDBC_Connection;
import Database_Connection.My_JDBC_Connection;
import Entity.*;
import Control.Controller;



/**
 *
 * @author luke1
 */
public class BAPERS {
    
    //initialise for database connection
    static JDBC_Connection con = new My_JDBC_Connection();
    static UserAccount ua;
    static Controller cntrl = new Controller();
    static BackEndControl backEnd = new BackEndControl();
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
    
       
  /*
// tests
        try{
        con.viewTaks();
        }catch (SQLException ex){
            System.out.println("SQL EXCEPTION!");
        }
        
        login("luke", "rewgfd");
        login("EMP5765", "root");
        
        //application start here
        LoginDesign ld = new LoginDesign();
        ld.setVisible(true);
        */
    }
        
    /* CODE MOVED TO CONTROLLER CLASS
    static public boolean login(String Username, String password){
        ResultSet loginResults;
        boolean success = false;
        try{
        loginResults = con.login(Username, password);
        if (!loginResults.isBeforeFirst() ){
            System.out.println("WRONG LOGIN");
            success = false;
             con.close_Connection();
        } else{
            //initialise new UserAccount
            loginResults.next();
            String employee_id = loginResults.getString("employee_id");
            String first_name = loginResults.getString("first_name");
            String second_name = loginResults.getString("second_name");
            String role = loginResults.getString("role");
            if (role.equals("Office Manager")){
            ua = new Office_Manager(employee_id,first_name,second_name,role);
            success = true;
            }else if (role.equals("Shift Manager")){
            ua = new Shift_Manager(employee_id,first_name,second_name,role); 
            success = true;
            }else if (role.equals("Technician")){
            ua = new Technician(employee_id,first_name,second_name,role);  
            success = true;
            }else if (role .equals("Receptionist")){
            ua = new Receptionist(employee_id,first_name,second_name,role);    
            success = true;
            }
            System.out.println(employee_id + first_name + second_name + role);
             con.close_Connection();
        }
        }catch (SQLException ex){
            System.out.println("SQL EXCEPTION! 1");
        }
        //System.out.println("ERROR");
       
        return success;
        
        
    }
    
    public static String addAccount(String role, String id, String fName, String sName, String password){
      return ((Office_Manager)ua).newUserAccount(role, id, fName, sName, password);
      
    }
            

    public static UserAccount getUa() {
        return ua;
    }

    public static void setUa(UserAccount ua) {
        BAPERS.ua = ua;
    }
    
    public static void openMainMenu(){
         MainMenu mm = new MainMenu();
         mm.setVisible(true);
    }

    public static JDBC_Connection getCon() {
        return con;
    }
    
    public static String newCustomer(){
     
        return "0";
}
    
    public static ResultSet viewCustomers(){
        try{
        return con.viewCustomers();
    }catch (SQLException e){}
        return null;
    }
    
    public static ResultSet searchCustomers(String fName, String sName, String postcode){
       try{
        return con.searchCustomers(fName, sName, postcode);
       }catch (SQLException e){}
    return null;
    }
    
    public void closeConnections(){
    try{
    con.close_Connection();
    }catch (Exception e){}
}
*/
    //retrieve the backend for alerts and other functionallity
    public static BackEndControl getBackEnd() {
        return backEnd;
    }
    
    
}
