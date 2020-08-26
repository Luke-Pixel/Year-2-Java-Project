///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package BackEnd;
//
import Control.BackEndControl;
import java.awt.Component;
import java.util.LinkedList;
import java.util.TimerTask;
import javax.swing.JOptionPane;
//
///**
// *class for generating late payment alerts
// * @author Luke
// */
public class LatePaymentAlerts extends TimerTask{
    LinkedList<String> reminders;
    

    @Override
    public void run() {
       reminders = BackEndControl.getLateReminders();
       for (int i = 0; i < reminders.size(); i++){
           int result = okcancel(reminders.get(i));
           if (result == 0){
               //set reminder aknowledged TODO
           }
       }
    }
    /**
     * allows the user to cancel the alert 
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
