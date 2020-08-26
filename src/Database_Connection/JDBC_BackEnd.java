///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package Database_Connection;
//
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
//
///**
// *interface for all backend methods
// * @author Luke
// */
public interface JDBC_BackEnd {
    public void test_Connection();
   public void close_Connection();
   public void SetLateJobs();
   public LinkedList checkLateAlerts();
    public void setLateAlertSeen(String jobNum);
    public ResultSet viewFirstLatePayments(String date1, String date2);
   public LinkedList getLateReminders();
   public void getFirstLate(String start, String end);
   public void setFirstJobReminder(String custID, String jobNum);
   public void checkFirstLetter();
   public ResultSet getFirstLetterAlerts();
   public void setPaymentSeen(int id);
   public LinkedList getNewJobs();
   public ResultSet getLetterData(String jobNum);
   public String getBackupType();
   public boolean setBackupType(String Type);
   public boolean setCustomerState(String CustID, String state);
}
