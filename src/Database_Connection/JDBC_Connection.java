/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *interface for all front end methods
 * @author Luke
 */
public interface JDBC_Connection {
    void test_Connection() throws SQLException;
    ResultSet viewTaks() throws SQLException;
    void close_Connection() ;
    void closeResultSet () throws SQLException;
    void closeStatement() throws SQLException;
    void closePreparedStatement() throws SQLException;
    ResultSet login(String username, String password) throws SQLException;
    String create_Account (String id, String role, String password, String firstName,String secondName);
    String createCust (String id, String firstname, String secondname, String state, String phone, String ad2, String city, String postcode, String ad1, int holdername, String valued, String email);
    boolean updateCust (String firstname, String secondname, String state, int phone, String ad2, String city, String postcode, String ad1, String holdername, String valued, String email, String id);
    ResultSet viewCustomers () throws SQLException;
    ResultSet searchCustomers(String fName, String sName, String postcode) throws SQLException;
    ResultSet viewStoredTasks () throws SQLException;
    String addNewTask(int id, String description, String Location, String shelfSlot, float price, int time) ;
    List searchTask(int id);
    boolean updateTask(String description, String Location, String shelfSlot, float price, int time, int id);
    boolean deleteTask(int id);
    boolean deleteCust (String id);
    boolean selectCustomer(String custId);
    ArrayList getTaskList();
    float getTaskPrice(int id);
    void addJob(String jobNum,String deadline, float price, String custId, String instructions,int priority, boolean rushed);
    public boolean addJobTask(int taskId, String jobNum, String custID);
    public boolean checkSuspended(String custId);
    public ResultSet getUsers();
    public ArrayList getUser(String empId);
    public ResultSet searchUser(String fName, String sName);
    public boolean editUser(String employeeId, String newID, String password, String role, String fname, String sName);
    public ResultSet retrieveInvoiceData(int custId);
    public ResultSet viewAllJobs();
    public ResultSet viewJobsInProgress();
    public ResultSet searchJob(String jobNum);
    public boolean setTaskWorking(int id, String time, String shiftType);
    public boolean setTaskEnd(int id, String time, int duration);
    public void checkJobFinished(int id, String time);
    public String getStartTime(int id);
    public ResultSet viewcustJob(String custID);
    public boolean editCust(String custID,String fName, String sName, String phone, String ad1, String ad2, String city, String postcode, String email, int holder);
    public ResultSet viewCustById(String custID);
    public boolean checkFirstUse();
    public String getDiscountType(int discID);
    int getFlexibleDiscountID(int discID);
    public LinkedList<Float> getLowerBands(int flexID);
    public LinkedList<Float> getUpperBands(int flexID);
    public LinkedList<Float> getDiscountRates(int discID);
    public float getPreviousVolume(String custID);
    float getVarDisc(int taskID, int discID);
    float getFixedDisc(int discID);
    ResultSet getUnpaidJobs(String custID);
    ResultSet getLatePaymentJobs(String custID);
    LinkedList<String> getJobPayment(int jobID);
    Boolean payForJobsCard(String custID,float ammount, String cardNum, String expiry,String type, LinkedList<String> jobs);
    void updateJobsPaid(String jobNum);
    Boolean payForJobsCash(String custID,float ammount ,LinkedList<String> jobs);
    ResultSet getAccountHolders();
    boolean addAcntHolder(String namme);
    boolean checkJobNum(String jobNum);
    boolean checkValued(String cusID);
    LinkedList<String> getDiscountType(String custID);
    ResultSet viewLatePayers();
    ResultSet viewLetterCust(String type);
    ResultSet getInvoiceData(String jobNum);
    LinkedList<String> getAllLetters(String type);
    void suspendedPayment(String custID);
    ResultSet getFixedDiscounts();
    ResultSet getFlexDiscounts();
    ResultSet getVariablediscounts();
    void SetDiscount(int discID, String CustId);
    void upgradeAccount(String custID);
    void addFixedDiscount(int discId, float rate);
    void addVariableDiscount(LinkedList<Float> upper,LinkedList<Float> lower,LinkedList<Float> rates, int custId);
    ResultSet getAllTaskItems();
    boolean getTaskById(int taskID);
    boolean addFlexiblediscount(LinkedList<Integer> tasks, LinkedList<Float> rates, int DiscID);
    boolean deleteDiscounts(int discID);
    void deleteReminder(String jobNum);
    boolean testNewConnection(String user, String pass);
    void setcurrentShelf(int jobTaskID);
    void setupDatabase();
    public void setUserName(String userName);
    public void setPassword(String password);
    void downgradeAccount(String custID);
    void removeDiscount(String custID);
    boolean checkDiscounted(String custID);
    void updateCurrentShelves(String shelf, String newShelf);
    void DeleteUsr(String userID);
    public String generateReportView();
    public ResultSet generateIndividualReportA(String startDate, String endDate);
    public ResultSet generateIndividualReportB(String startDate, String endDate);
    public ResultSet generateIndividualReportC(String startDate, String endDate);
    
    public ResultSet generateSummaryReportA (String startDate, String endDate);
    public ResultSet generateSummaryReportB (String startDate, String endDate);
    public ResultSet generateSummaryReportC (String startDate, String endDate);
    public ResultSet generateSummaryReportD (String startDate, String endDate);
    public ResultSet generateSummaryReportE (String startDate, String endDate);
    public ResultSet generateSummaryReportF (String startDate, String endDate);
    public ResultSet generateSummaryReportG (String startDate, String endDate);
    public ResultSet generateSummaryReportH (String startDate, String endDate);
    
    public ResultSet generateCustomerReport(String CustomerID, String Date);
    
    public Float customerReport2(String date1, String date2, String customerid);
    public String getTaskIDS(String jobNum);
     ResultSet customerReport1(String date1, String date2, String customerID);
}
