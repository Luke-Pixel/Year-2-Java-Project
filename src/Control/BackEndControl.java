///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package Control;
//
import BackEnd.*;
import Database_Connection.JDBC_BackEnd;
import Database_Connection.My_JDBC_BackEnd;
import Entity.UserAccount;
import bapers.DBBackup;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
//
///**
// *
// * @author Luke
// */
public class BackEndControl {
        static JDBC_BackEnd con = new My_JDBC_BackEnd();
        static UserAccount ua;
    public BackEndControl() {
        /**
         * initalise checking late jobs
         */
        Timer timer = new Timer();
        timer.schedule(new LateJobChecker(), 0, 5000);  
        timer.schedule(new LateJobAlerts(), 0, 5000);
        //timer.schedule(new LatePaymentChecker(), 0,86400000 );  
        timer.schedule(new FirstLetterChecker(), 0,86400000);
        timer.schedule(new PaymentAlerts(), 0, 900000);
        timer.schedule(new NewJobAlert(), 0,2000);
        
    }

    public static void setUa(UserAccount ua) {
        BackEndControl.ua = ua;
        System.out.println(ua.getRole());
    }
    
    public static LinkedList getAlerts(){
        return con.checkLateAlerts();
    }
    
    public static void setLateJobs(){
        con.SetLateJobs();
    }
    
    public static void setLateAlertSeen(String jobNum){
        con.setLateAlertSeen(jobNum);
    }
    
    public static void viewLateFirst(String date1, String date2){
        con.viewFirstLatePayments(date1, date2);
    }
    
    public static LinkedList getLateReminders(){
        return con.getLateReminders();
    }
    
    public void checkLatepaymentsFirst(String start, String end){
        con.getFirstLate(start, end);
    }
    
    public static void checkFirstLetter(){
        con.checkFirstLetter();
    }
    
    public static ResultSet viewFirstLetterReminders(){
        return con.getFirstLetterAlerts();
    }
    
    public static void setPaymentAlertSeen(int id){
        con.setPaymentSeen(id);
    }
    
    public static LinkedList getNewJobs(){
        return con.getNewJobs();
    }
    
    public static ResultSet getLetterData(String jobNumD){
        return con.getLetterData(jobNumD);
    }

    public static boolean setupAutoBackup(String Type){
        return con.setBackupType(Type);
    }
    
    public static String getBackupType(){
        return con.getBackupType();
    }
    
     public void setupBackup(long duration){

        Calendar calendar = Calendar.getInstance();
        calendar.set(
           Calendar.DAY_OF_WEEK,
           Calendar.MONDAY
        );
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 40);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);



        Timer time = new Timer(); // Instantiate Timer Object

        // Start running the task on Monday at 15:40:00, period is set to 8 hours
        // if you want to run the task immediately, set the 2nd parameter to 0
        time.schedule(new DBBackup(), calendar.getTime(), TimeUnit.HOURS.toMillis(duration));
}
     
     public static boolean setCustState(String custID, String state){
         return con.setCustomerState(custID, state);
     }
}
