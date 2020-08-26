///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package BackEnd;
//
import BackEnd.LateJobChecker;
import Control.BackEndControl;
import Control.Controller;
import java.awt.Component;
import java.util.LinkedList;
import java.util.TimerTask;
import javax.swing.JOptionPane;
//
///**
// *produces late job alerts when certain times have been passed
// * @author Luke
// */
public class LateJobAlerts extends TimerTask{
    LinkedList <String> late ;
    @Override
    public void run() {
         System.out.println("Alerting Late Jobs");
         showAlerts();
    }
    /**
     * method to show the alerts to the office manager or the shift manager if 
     * if they are logged in
     */
       public void showAlerts(){
       late = BackEndControl.getAlerts();
       //okcancel("Test");
       if (Controller.isLogedIn()){
           if(Controller.getUa().getRole().equals("Shift Manager") || Controller.getUa().getRole().equals("Office Manager")){
               if (late != null){
           int i = 0;
           while(!late.isEmpty()){
               int result = okcancel("Job Number: " + late.get(i) + " is running late!");
               if (result == 0){
                   BackEndControl.setLateAlertSeen(late.get(i));
               }
               showAlerts();
           }
           
       } 
           }
       }
             
   }
   /**
    * allows the user to cancel the alert to stop receiving it
    * @param theMessage
    * @return 
    */
    public static int okcancel(String theMessage) {
        
    int result = JOptionPane.showConfirmDialog((Component) null, theMessage,
    "alert", JOptionPane.OK_CANCEL_OPTION);
        System.out.println("Result: " + result);
    return result;
  }
    
}
