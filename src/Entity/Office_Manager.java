/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;
import Control.*;
import java.sql.SQLException;
/** 
 *This class creates the Office manager user type and defines the methods
 *that this user can have
 * @author Luke
 */
public class Office_Manager extends Shift_Manager{

    public Office_Manager(String employee_id, String role) {
        super(employee_id, role);
    }
    
   public void create_Backup(){
        
    }
    
   public void restore_From_Backup(){
    }
    
   public void add_Discount(){
        
    }
    
   public void remove_Discount(){
        
    }
    
   public void add_Task(){
        
   }
    
//   public String newUserAccount(String role, String id, String firstName, String secondName, String Password){
//        if (role .equals("") || id.equals("") || firstName.equals("") || secondName.equals("") ){
//            return "empty values";
//        } else {
//            try{
//           Controller.getCon().create_Account(role, id, firstName, secondName, Password);
//           return "Success";
//            }catch (SQLException ex){
//                System.out.println("SQL Exception on add");
//                return "SQL Exception";
//            }
//        }
//        
//        
//    }
}
