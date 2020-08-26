///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package Database_Connection;
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//
///**
// *implementation for all backend methods
// * @author Luke
// */
public class My_JDBC_BackEnd implements JDBC_BackEnd{
    private static Connection con;
    ResultSet rs = null;
    Statement stmt;
    PreparedStatement pStmt;
    /**
     * tests the connection to the database
     */
    @Override
    public void test_Connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(My_JDBC_Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(My_JDBC_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        close_Connection();
        System.out.println("Connection Closed");
        
    }
    
    @Override
    public void SetLateJobs(){
        try{
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("SELECT deadline, late, job_number, SUM(duration) from baper_work WHERE state <> ? GROUP BY job_number");
            pStmt.setString(1, "COMPLETE");
            //pStmt.setString(2, "NEW");
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()){
                Calendar calendar = Calendar.getInstance();    
                Timestamp start = new Timestamp(calendar.getTimeInMillis());
                Timestamp deadline = rs.getTimestamp("deadline");
            
                Date dNow = new Date( ); // Instantiate a Date object
                Calendar estCal = Calendar.getInstance();
                estCal.setTime(dNow);
                estCal.add(Calendar.MINUTE, rs.getInt("SUM(duration)"));
                int remainingInt = rs.getInt("SUM(duration)");
                long remaining = Long.valueOf(remainingInt);
                System.out.println(remaining);
            
                Timestamp estimated = new Timestamp(calendar.getTimeInMillis());
                estimated.setTime(estimated.getTime() + TimeUnit.MINUTES.toMillis(remaining));
                System.out.println(estimated);
            
                ResultSet rs2 = null;
                PreparedStatement pStmt3;
                pStmt3 = con.prepareStatement("SELECT * FROM Late_Alert WHERE job_job_number = ? AND Aknowledged = 0");
                pStmt3.setString(1, rs.getString("job_number"));
                rs2 = pStmt3.executeQuery();
                
                ResultSet rs3 = null;
                PreparedStatement pStmt4;
                pStmt4 = con.prepareStatement("SELECT * FROM Late_Alert WHERE job_job_number = ? AND Aknowledged = 1");
                pStmt4.setString(1, rs.getString("job_number"));
                rs3 = pStmt4.executeQuery();
                //System.out.println(rs2.next());
                
                
                if (!rs2.next() && !rs3.next()){
                    PreparedStatement pStmt2;
                    if (estimated.after(deadline)){
                        setJobStatus(1,1, rs.getString("job_number"));
                        pStmt2 = con.prepareStatement("INSERT INTO Late_Alert VALUES(null, 0, ?)");
                        pStmt2.setString(1, rs.getString("job_number"));
                        System.out.println("setting Late: " + rs.getString("job_number"));
                        pStmt2.execute();
                        
                        }
                    }else if(!estimated.after(deadline)){
                        setJobStatus(0,2, rs.getString("job_number"));
                        
                }
                }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            close_Connection();
        }
    }
    /**
     * updates the status of a job
     * @param late allows the job to be set as late
     * @param priority defines the priority of the job
     * @param jobNum the job number of the job being changed
     */
    public void setJobStatus(int late, int priority, String jobNum){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("UPDATE job SET late = ?, priority = ? WHERE job_number = ? ");
            pStmt.setInt(1, late);
            pStmt.setInt(2, priority);
            pStmt.setString(3, jobNum);
            pStmt.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }finally{
           // close_Connection();
        }
    }
    
    
    /**
     * checks to see if any late alerts are active
     * @return 
     */
    @Override
    public LinkedList checkLateAlerts() {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from Late_Alert WHERE aknowledged = 0");
            LinkedList<String> late = new LinkedList<String>();
            while (rs.next()){
                late.add(rs.getString("job_job_number"));
            }
            return late;
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            close_Connection();
        }
        return null;
    }
    /**
     * sets late alerts to have been aknowledged 
     * @param jobNum 
     */
    @Override
    public void setLateAlertSeen(String jobNum) {
        try{
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("UPDATE Late_Alert SET aknowledged = 1 WHERE job_job_number = ?");
            pStmt.setString(1, jobNum);
            pStmt.execute();
    
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            close_Connection();
        }
    }
    /**
     * selects the payments from the database that are late
     * @param date1
     * @param date2
     * @return 
     */
    @Override
    public ResultSet viewFirstLatePayments(String date1, String date2) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("SELECT * FROM valued_customer_payments WHERE payment_state = ? AND completion_date BETWEEN ? AND ?");
            pStmt.setString(1, "UNPAID");
            pStmt.setString(2,date1);
            pStmt.setString(3, date2);
            rs = pStmt.executeQuery();
            
            while(rs.next()){
                addLateReminder(rs.getString("Job_number"));
            }
            return rs;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            //close_Connection();
        }
        return null;
    }
    /**
     * addes a late reminder to the database
     * @param jobNum 
     */
    public void addLateReminder(String jobNum){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("INSERT INTO Late_Alert VALUES(null, 0, ?)");
            pStmt.setString(1, jobNum);
            pStmt.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            close_Connection();
        }
    }
    /**
     * gets the late alerts from the database
     * @return 
     */
    @Override
    public LinkedList getLateReminders() {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("SELECT * FROM late_alert_view");
            //pStmt.setInt(1, jobNum);
            rs = pStmt.executeQuery();
            LinkedList <String> reminders = new LinkedList<String>();
            while(rs.next()){
                reminders.add(rs.getString("first_name") + " " + rs.getString("second_name") + " Has Not Paid On Time" + " ID: " + rs.getString("customer_id"));
            }
            return reminders;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }finally{
            close_Connection();
        }
    }
//    
//    
//    
    @Override
//    /**
//     * closes the database connection
//     */
   public void close_Connection() {
       try {
           if (con != null) {
                con.close();
               //System.out.println("Connection Closed");
           }
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }

      try {
            if (rs != null) {
              rs.close();
              // System.out.println("Result Set Closed");
           }
     } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

       try {
            if (pStmt != null) {
                pStmt.close();
              // System.out.println("Prepared Statement Closed");
         }
       } catch (SQLException e) {
            System.out.println(e.getMessage());
       }

        try {
            if (stmt != null) {
                stmt.close();
             //  System.out.println("Statement Closed");
           }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
       }

        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   /**
    * Returns result set of late customers 
    * @param start start date
    * @param end end date
    */
    @Override
    public void getFirstLate(String start, String end) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("select * from valuedcustjobs WHERE completion_date between( ? AND ? ) AND payment_state = ?");
            pStmt.setString(1,start );
            pStmt.setString(2, end);
            pStmt.setString(3, "UNPAID");
            rs = pStmt.executeQuery();
            
            while(rs.next()){
                setFirstJobReminder(rs.getString("customer_id"), rs.getString("Job_number"));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }finally{
            close_Connection();
        }
    }
    
    /**
     * sets a first reminder for a job payment, into the database
     * @param custID the customer for who the job is late
     * @param jobNum the number of the late paid job
     */
    @Override
    public void setFirstJobReminder(String custID, String jobNum) {
        try{
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, 1);
            cal.add(Calendar.DAY_OF_YEAR, 10);
            System.out.println(cal.toString());
            Timestamp date = new Timestamp(cal.getTimeInMillis());
            String [] splitDate = date.toString().split(" ");
            String dateString = splitDate[0];
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("INSERT INTO payment_alert VALUES(null, 0,?,?,?,?)");
            pStmt.setString(1,"FIRST REMINDER" );
            pStmt.setString(2, dateString);
            pStmt.setString(3, "jonNum");
            pStmt.setString(4, custID);
            pStmt.execute();
            
            
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }finally{
            close_Connection();
        }
    }

    @Override
    public void checkFirstLetter() {
        try{
            Calendar cal = Calendar.getInstance();
            System.out.println(cal.toString());
            Timestamp date1 = new Timestamp(cal.getTimeInMillis());
            String [] splitDate = date1.toString().split(" ");
            String dateString = splitDate[0];
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("SELECT * FROM payment_alert ");
            //pStmt.setInt(1,"FIRST );
            rs = pStmt.executeQuery();
            String alertType = "";
            while(rs.next()){
                if (rs.getString("next_check").equals(dateString)){
                    setFirstLetter(rs.getInt("idAlert"), rs.getString("alert_type"), rs.getString("Job_Customer_customer_id"));
                }
            }     
        }catch(SQLException ex){
            System.out.println(ex.getMessage());   
        }finally{
            close_Connection();
        }
    }
    
    public void setFirstLetter(int alertID, String type, String custID){
        try{
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, 1);
            System.out.println(cal.toString());
            Timestamp date1 = new Timestamp(cal.getTimeInMillis());
            String [] splitDate = date1.toString().split(" ");
            String dateString = splitDate[0];
            String newType = "";
            if (type.equals("FIRST REMINDER")){
                newType = "FIRST LETTER";
            }else if (type.equals("FIRST LETTER")){
                newType = "SECOND LETTER";
                setCustomerState(custID,"SUSPENDED");
            }else if(type.equals("SECOND LETTER"))
                newType = "SECOND LETTER";
                setCustomerState(custID,"IN DEFAULT");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("UPDATE payment_alert SET alert_type = ?, aknowledged = 0, next_check = ? WHERE idAlert = ?");
            pStmt.setString(1,newType );
            pStmt.setString(2, dateString);
            pStmt.setInt(3, alertID);
            pStmt.execute();  
        }catch(SQLException ex){
            System.out.println(ex.getMessage());   
        }finally{
            close_Connection();
        }
    }
    /**
     * sets the state of the customer to allow them to be suspended 
     * @param CustID the customer being changed
     * @param state the state that is being changed
     * @return 
     */
    @Override
    public boolean setCustomerState(String CustID, String state){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("UPDATE customer SET state = ? WHERE customer_id = ?");
            pStmt.setString(1,state );
            pStmt.setString(2, CustID);
            
            pStmt.execute();
            return true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());   
            return false;
        }finally{
            
        }
    }
    /**
     * gets all the first letter reminder alerts from the database
     * @return 
     */
    @Override
    public ResultSet getFirstLetterAlerts() {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("SELECT * FROM payment_alert WHERE aknowledged = ? ");
            pStmt.setInt(1,0 );
            
            rs = pStmt.executeQuery();
            return rs;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());   
            return null;
        }finally{
            
        }
    }
    /**
     * updates the alert in the database that it has been seen
     * @param id 
     */
    @Override
    public void setPaymentSeen(int id) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("UPDATE payment_alert SET aknowledged = 1 WHERE idAlert = ?");
            pStmt.setInt(1, id);
            pStmt.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());   
            
        }finally{
            close_Connection();
        }
    }
    /**
     * gets new jobs from the database to create alerts for them
     * @return 
     */
    @Override
    public LinkedList getNewJobs() {
        try{
            LinkedList<String> jobs = new LinkedList();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("SELECT * FROM Job WHERE new = ?");
            pStmt.setInt(1, 1);
            ResultSet rs = pStmt.executeQuery();
            //jobs.add(rs.getString("Job_number"));
            //System.out.println("job num " + rs.getString("Job_nnumber"));
            while (rs.next()==true){
                jobs.add(rs.getString("Job_number"));
                JOptionPane.showMessageDialog(null, "New Job At Reception Job: " + rs.getString("Job_number"),  "Login Failed", JOptionPane.WARNING_MESSAGE);
                System.out.println(rs.getString("Job_number"));
                setJobSeen(rs.getString("Job_number"));
            }
            rs.close();
            return jobs;
        }catch(SQLException ex){
            System.out.println("new jobs "+ex.getMessage());   
            return null;
        }finally{
            close_Connection();
        }
        
       
    }
    
    /**
     * informs the database that the job has been seen/acknowledged
     * @param jobNum 
     */
    public void setJobSeen(String jobNum){
        try{
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("UPDATE Job SET new = 0 WHERE Job_number = ?");
            pStmt.setString(1, jobNum);
            pStmt.execute();   
        }catch(SQLException ex){
            System.out.println(ex.getMessage());   
        }finally{
            close_Connection();
        }
    }
    /**
     * gets the information for a letter given a job number
     * @param jobNum
     * @return 
     */
    @Override
    public ResultSet getLetterData(String jobNum) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("SELECT * FROM letter_view WHERE Job_number = ?");
            pStmt.setString(1, jobNum);
            rs = pStmt.executeQuery();
            return rs;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());  
            return null;
        }finally{
           // close_Connection();
        }
    }
    
    @Override
    public String getBackupType() {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("SELECT * FROM BackupData");
            //pStmt.setInt(1, jobNum);
            rs = pStmt.executeQuery();
            if(!rs.next()){
                return "none";
            }else {
                return rs.getString("Type");
            }
            
          
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return "none";
        }finally{
            close_Connection();
        }
    }

    @Override
    public boolean setBackupType(String Type) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Created");
            pStmt = con.prepareStatement("SELECT * FROM BackupData");
            //pStmt.setInt(1, jobNum);
            rs = pStmt.executeQuery();
            if(!rs.next()){
                PreparedStatement pStmt2 = con.prepareStatement("INSERT INTO BackupData VALUES (1, ?)");
                pStmt2.setString(1, Type);
                pStmt2.execute();
                JOptionPane.showMessageDialog(null, "Backup Setup" ,  "Auto Backup", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }else {
                PreparedStatement pStmt2 = con.prepareStatement("UPDATE BackupData SET tyoe = ? WHERE idBackupData = 1");
                pStmt2.setString(1, Type);
                pStmt2.execute();
                JOptionPane.showMessageDialog(null, "Backup Setup" ,  "Auto Backup", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            
          
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }finally{
            close_Connection();
        }
    }
    
    
   
   
}
