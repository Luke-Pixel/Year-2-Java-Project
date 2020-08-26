/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Control.BackEndControl;
import Control.Controller;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *Generates payment alerts for the office manager
 * @author luke1
 */
public class PaymentAlerts extends TimerTask{
    LetterReminder ltF = new LetterReminder("first");
    LetterReminder ltS = new LetterReminder("second");
    
    @Override
    public void run() {
        if(Controller.isLogedIn() == true){
        if (Controller.getUa().getRole().equals("Office Manager")) {   
        
        ResultSet rs = BackEndControl.viewFirstLetterReminders();
        try{
            if (rs != null){
                while (rs.next()){
                    int result = JOptionPane.showConfirmDialog((Component) null,"A Job Paymnent is Late, Job ID: " + rs.getString("job_Job_number") + " Customer ID: " + rs.getString("job_Customer_customer_id") ,
                    "alert", JOptionPane.OK_CANCEL_OPTION);
                    if (rs.getString("alert_type").equals("FIRST LETTER")   && result == 0 ) {
                        BackEndControl.setPaymentAlertSeen(rs.getInt("idAlert"));
                        int result2 = JOptionPane.showConfirmDialog((Component) null,"A Letter can be printed for this job, Print now?" ,
                    "alert", JOptionPane.OK_CANCEL_OPTION);
                        if (result2 == 0){
                            ltF.printLetter(rs.getString("job_Job_number"));
                        }
                    }else if(rs.getString("alert_type").equals("SECOND LETTER")   && result == 0){
                        int result2 = JOptionPane.showConfirmDialog((Component) null,"A Letter can be printed for this job, Print now?" ,
                    "alert", JOptionPane.OK_CANCEL_OPTION);
                        if (result2 == 0){
                            ltS.printLetter(rs.getString("job_Job_number"));
                        }
                    }else if(result == 0){
                       BackEndControl.setPaymentAlertSeen(rs.getInt("idAlert")); 
                    }
                }
            }
        }catch(SQLException ex ){
            System.out.println(ex.getMessage());
        }
    
    }
    }
    }
    
}
