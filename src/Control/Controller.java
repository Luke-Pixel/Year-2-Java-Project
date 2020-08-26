/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import BackEnd.PaymentAlerts;
import bapers.LoginDesign;
import Database_Connection.JDBC_Connection;
import Database_Connection.My_JDBC_Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entity.*;
import bapers.CreateAccount;
import bapers.MainMenu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 *Creates the controller, with a all of the essential methods for 
 *the operation of the entire system 
 * @author Luke
 */
public class Controller {
    static JDBC_Connection con = new My_JDBC_Connection();
    static UserAccount ua;
    static boolean logedIn;
    public Controller() {
        
        
//        try{
//        con.viewTaks();
//        }catch (SQLException ex){
//            System.out.println("SQL EXCEPTION!");
//        }
        
//        login("luke", "rewgfd");
//        login("EMP5765", "root");
        
        //application start here
        setUsername();
        boolean result = con.checkFirstUse();
        if (result == true){
            CreateAccount ca = new CreateAccount();
            ca.setVisible(true);
            ca.firstUse();
        }else{
            LoginDesign ld = new LoginDesign();
            ld.setVisible(true);
    
        }
        
        con.setupDatabase();
    }
    /**
     * Method sets the userName based on the file passed in
     */
    public static void setUsername(){
        String username = "";
        String password = "";
        
        try(BufferedReader br = new BufferedReader(new FileReader("userame.txt"))) {
        StringBuilder sb = new StringBuilder();
        username = br.readLine();

        }catch(IOException ex){
            
        }
        
        try(BufferedReader br = new BufferedReader(new FileReader("password.txt"))) {
        StringBuilder sb = new StringBuilder();
        password = br.readLine();

        }catch(IOException ex){
            
        }
        
        con.setUserName(username);
        con.setPassword(password);
    }
        /**
     * This method allows the user to log onto the system and checks
     * which type of user they are, disallowing certain privileges 
     * @param Username The username provided by the user upon log in
     * @param password The password provided by the user upon log in
     * @return 
     */
      public static boolean login(String Username, String password){
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
            String role = loginResults.getString("role");
            if (role.equals("Office Manager")){
            ua = new Office_Manager(employee_id,role);
            PaymentAlerts pay = new PaymentAlerts();
            pay.run();
            success = true;
            }else if (role.equals("Shift Manager")){
            ua = new Shift_Manager(employee_id,role); 
            success = true;
            }else if (role.equals("Technician")){
            ua = new Technician(employee_id,role);  
            success = true;
            }else if (role .equals("Receptionist")){
            ua = new Receptionist(employee_id,role);    
            success = true;
            
            }
            //BackEndControl.setUa(ua);
            logedIn = true;
            System.out.println(employee_id + role);
             con.close_Connection();
        }
        }catch (SQLException ex){
            System.out.println("SQL EXCEPTION! 1");
        }
        //System.out.println("ERROR");
       
        return success;
        
        
    }
        /**
     * Allows another account to be added by using the data provided and
     * connecting to the database
     * @param role allows user to specify the type of role the new account will have
     * @param id allows user to specify the id number the new account will have
     * @param password allows user to specify the password the new account will have
     * @return 
     */
    public static boolean addAccount(String role, String id, String password, String firstName, String secondName){
       String result = con.create_Account(role, id, password,firstName, secondName);
       if (result.equals("Complete")){
            return true;
        }else {
        return false;
      }
    }
   /**
     * Boolean to check if anyone is logged in
     * @return 
     */
    public static boolean isLogedIn() {
        return logedIn;
    }
    /**
     * Calls the controller to set logged in to true
     * @param logedIn 
     */
    public static void setLogedIn(boolean logedIn) {
        Controller.logedIn = logedIn;
    }
    
    
    
    /**
     * Gets the user account
     * @return 
     */
    public static UserAccount getUa() {
        return ua;
    }
    /**
     * Sets the user account 
     * @param ua 
     */
    public static void setUa(UserAccount ua) {
        Controller.ua = ua;
    }

    
    /**
     * Creates a new main menu and sets it to visible 
     */
    public static void openMainMenu(){
         MainMenu mm = new MainMenu();
         mm.setVisible(true);
    }
   /**
     * Gets the connection to the database
     * @return 
     */
    public static JDBC_Connection getCon() {
        return con;
    }
        /**
     * Allows a new customer to be created with the data inputed from the 
     * the Create Customer account
     * @param id The new id assigned to the customer account
     * @param firstname The new first name assigned to the customer account
     * @param secondname The new second name assigned to the customer account
     * @param state The new state assigned to the customer account
     * @param phone The new phone number assigned to the customer account
     * @param ad2 The new address two assigned to the customer account
     * @param city The new city assigned to the customer account
     * @param postcode The new postcode assigned to the customer account
     * @param ad1 The new address one assigned to the customer account
     * @param holdername The new name of the account holder assigned to the customer account
     * @param valued The new state of value assigned to the customer account
     * @param email The new email address assigned to the customer account
     * @return 
     */
    public static boolean newCustomer(String id, String firstname, String secondname, String state, String phone, String ad2, String city, String postcode, String ad1, int holdername, String valued, String email){
      String result = con.createCust(id, firstname, secondname, state, phone, ad2, city, postcode, ad1, holdername, valued, email);
        if (result.equals("Complete")){
            return true;
        }else {
        return false;
      }
}
    /**
     * Returns the result set of the customers currently in the database
     * @return 
     */
    public static ResultSet viewCustomers(){
        try{
        return con.viewCustomers();
    }catch (SQLException e){}
        return null;
    }
        /**
     * Searches the database based on the first name, second name  //LUKE check this is right
     * and the postcode provided
     * @param fName The first name variable to be used for searching
     * @param sName The second name variable to be used for searching
     * @param postcode The postcode variable to be used for searching
     * @return 
     */
    public static ResultSet searchCustomers(String fName, String sName, String postcode){
       try{
        return con.searchCustomers(fName, sName, postcode);
       }catch (SQLException e){}
    return null;
    }
    /**
     * Called by several classes to close the connection to the database
     */
    public static void closeConnections(){
    try{
    con.close_Connection();
    }catch (Exception e){}
}
    /**
     * Returns the results set of all tasks currently stored by the database
     * @return 
     */
    public static ResultSet retrieveTasks(){
        try{
            return con.viewStoredTasks();
        }catch (SQLException ex){
            System.out.println("SQL Exception");
        }
        return null;
    }
    /**
     * Allows the user to add a new task using input from the add tasks form
     * @param id The id number of the new task being added
     * @param description The description number of the new task being added
     * @param Location The location of the new task being added
     * @param shelfSlot The shelf slot of the new task being added
     * @param price The price of the new task being added
     * @param time The time of the new task being added
     * @return 
     */
    public static boolean addTask(int id, String description, String Location, String shelfSlot, float price, int time){
        
        String result = con.addNewTask(id, description, Location, shelfSlot, price, time);
        if (result.equals("Complete")){
            return true;
        }else {
        return false;
        }
    }
    /**
     * Allows the user to select a task from the database using the ID they provide
     * @param id
     * @return 
     */
    public static List  selectTask(int id){
       return con.searchTask(id);
    }
    
    public static boolean lengthChecker(int i, String s){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Using data inputted to the edit tasks form, this method allows
     * tasks to be edited 
     * @param description the new description for the task
     * @param Location the new location for the task
     * @param shelfSlot the new shelf slot for the task
     * @param price the new price of the task
     * @param time the new time of the task
     * @param id the new ID of the task
     * @return 
     */
    public static boolean editTasks(String description, String Location, String shelfSlot, float price, int time, int id){
        return con.updateTask(description, Location, shelfSlot, price, time, id);
    }
    /**
     * Deletes a task based on the ID given
     * @param id
     * @return 
     */
    public static boolean deleteTask (int id) {
        return con.deleteTask(id);
    }
    /**
     * Deletes a customer based on the ID given
     * @param id
     * @return 
     */
    public static boolean deleteCust (String id){
        return con.deleteCust(id);
    }

    public static boolean updateCust(String firstname, String secondname, String state, int phone, String ad2, String city, String postcode, 
            String ad1, String holdername, String valued, String email, String id){
        return con.updateCust(firstname, secondname, state, phone, ad2, city, postcode, ad1, holdername, valued, email, id);
    }
    /**
     * selects a customer from the database, based on the id given
     * @param custId
     * @return 
     */
    public static boolean selectCustomer(String custId){
        return con.selectCustomer(custId);
    }
    /**
     * returns the list of tasks in the database
     * @return 
     */
    public static ArrayList getTaskList(){
        return con.getTaskList();
    }
    
    /**
     * gets the price of a task given that tasks id
     * @param id
     * @return 
     */
    public static float getTaskPrice(int id){
        return con.getTaskPrice(id);
    }
    
    /**
     * adds a new job based on the data given in the NewJob form
     * @param deadline the deadline for the new job
     * @param price the price for the new job
     * @param custId the customer id associated with the new job
     * @param specialInstructions and special instructions that the new job might have 
     * @return 
     */
    public static void addJob(String jobNum,String deadline, float price, String custId, String specialInstructions, int priority, boolean rushed){
        
        con.addJob(jobNum,deadline, price, custId, specialInstructions, priority, rushed);
    }
    
    /**
     * adds a task with a specified id to a job with a specified number and a specified customer id 
     * @param taskId the id given for the task
     * @param jobNum the number given for the job
     * @param custID the id given for the customer
     * @return 
     */
    public static boolean addJobTasks(int taskId, String jobNum, String custID){
        return con.addJobTask(taskId, jobNum, custID);
    }
    
    /**
     * checks to see if a particular customer has been suspended based on the id given
     * @param custID
     * @return 
     */
    public static boolean checkSuspended(String custID){
       return con.checkSuspended(custID);
    }
    
    /**
     * returns the result set of the users currently in the database
     * @return 
     */
    public static ResultSet getUsers(){
      return con.getUsers();
    }
    
    /**
     * gets a particular user of the system based on their employee id
     * @param empId the employee id used to get the user
     * @return 
     */
    public static ArrayList getUser(String empId){
        return con.getUser(empId);
    }
    
    /**
     * returns the result set of users with the specified name or surname
     * @param fName first name used to search 
     * @param sName second name used to search 
     * @return 
     */
    public static ResultSet searchUser(String fName, String sName){
        return con.searchUser(fName, sName);
    }
    /**
     * retrieves the data for an invoice for a specified customer
     * @param custId the customer id used to specify which customer
     * @return 
     */
    public static ResultSet retrieveInvoiceData(int custId){
        return con.retrieveInvoiceData(custId);
    }
    
    /**
     * allows the user to edit another user in the system 
     * @param empId the id to be edited
     * @param fName the first name that can be edited
     * @param sName the second name that can be edited
     * @param password the password that can be edited
     * @param role the role that can be edited
     * @return 
     */
    public static boolean editUser(String empId,  String newID,String password, String role, String firstName, String secondName){
        return con.editUser(empId,  newID, password, role, firstName, secondName);
    }
    /**
     * returns the results set of all jobs currently in the database
     * @return 
     */
    public static ResultSet viewAllJobs(){
        return con.viewAllJobs();
    }
    /**
     * returns the results set of all jobs that are in progress currently in the database
     * @return 
     */
    public static ResultSet viewInProgress(){
        return con.viewJobsInProgress();
    }
    /**
     * returns a specified job based on the job number provided
     * @param id
     * @return 
     */
    public static ResultSet searchJob(String id){
        return con.searchJob(id);
    }
    /**
     * sets the state of a task to be active, to show its being worked on
     * @param id the id of the task being set to active
     * @param time the time the task has been set to active
     * @param shift 
     * @return 
     */
    public static boolean setWorkActice(int id, String time, String shift){
        return con.setTaskWorking(id, time, shift);
    }
    /**
     * sets the state of the task to have ended, showing the task has finished 
     * being worked on
     * @param id the id of the task being set to end
     * @param time the time that the task has been set to end
     * @param duration the duration of that task
     * @return 
     */
    public static boolean setWorkEnd(int id, String time, int duration){
        return con.setTaskEnd(id, time, duration);
    }
     /**
     * gets the start time of a task in a particlar job
     * @param id 
     * @return 
     */
    public static String getStartTiume(int id){
        return con.getStartTime(id);
    }
    /**
     * returns the results set of all jobs from a certain customer
     * @param custID the customer id used to specify which jobs to return
     * @return 
     */
    public static ResultSet viewCustJobs(String custID){
        return con.viewcustJob(custID);
    }
    /**
     * returns the customer with the specified customer id
     * @param custID the customer id used 
     * @return 
     */
    public static ResultSet viewCustById(String custID){
        return con.viewCustById(custID);
    }
    
    public static boolean editCust(String custID, String fName, String sName, String phone, String ad1, String ad2,String city, String postcode,String email, int holder ){
        return con.editCust(custID, fName, sName, phone, ad1,ad2,city, postcode, email, holder);
    }
    /**
     * Gets the lower bound of a particular discount being added to flexible discounts
     * @param discID the id of the discount to get the lower bound from
     * @return 
     */
    public static LinkedList<Float> getLowerBounds(int discID){
        return con.getLowerBands(discID);
    }
        /**
     * Gets the upper bound of a particular discount being added to flexible discounts
     * @param discID the id of the discount to get the upper bound from
     * @return 
     */
    public static LinkedList<Float> getupperBounds(int discID){
        return con.getUpperBands(discID);
    }
    
    public static float getPreviousVolume(String CustID){
        return con.getPreviousVolume(CustID);
    }
    /**
     * Gets the variable discount rate for a certain task in a particular discount
     * @param taskID the id of the task 
     * @param discID the id of the discount
     * @return 
     */
    public static float getVarRate(int taskID, int discID){
        return con.getVarDisc(taskID, discID);
    }
    /**
     * Gets the value of a fixed discount given its id
     * @param discID the id of the fixed discount to get
     * @return 
     */
    public static float getFixedDisc(int discID){
        return con.getFixedDisc(discID);
    }
    /**
     * Gets the payment for a specific job
     * @param jobID the job id used to specify which job
     * @return 
     */
    public static LinkedList<String> getJobPayment (int jobID){
        return con.getJobPayment(jobID);
    }
    /**
     * Gets jobs that are late for a particular customer 
     * @param custID the customer id used to get the jobs
     * @return 
     */
    public static ResultSet getlLAteJobs(String custID){
        return con.getLatePaymentJobs(custID);
    }
    /**
     * Gets the jobs that are available to be paid for by a certain customer
     * @param custID the customer id to be used
     * @return 
     */
    public static ResultSet getAvailPAyJobs(String custID){
        return con.getUnpaidJobs(custID);
    }
    /**
     * Method to allow the user to pay for a job by card
     * @param custID the id of the customer paying 
     * @param ammount the amount of the payment
     * @param cardNum the card number being used
     * @param expiry the expiry date of the card
     * @param type the type of card being used
     * @param jobs the job being paid for
     * @return 
     */
    public static Boolean payForJobsCard(String custID,float ammount, String cardNum, String expiry,String type, LinkedList<String> jobs){
        return con.payForJobsCard(custID, ammount, cardNum, expiry, type, jobs);
    }
    /**
     * Allows the user to pay for a job in cash 
     * @param custID the customer id, who is paying for the job
     * @param ammount the amount being paid
     * @param jobs the job being paid for
     * @return 
     */
    public static Boolean payForJobsCash(String custID, float ammount, LinkedList<String> jobs){
        return con.payForJobsCash(custID, ammount, jobs);
    }
    /**
     * gets the names of all account holders
     * @return 
     */
    public static ResultSet getHolders(){
        return con.getAccountHolders();
    }
    /**
     * adds a new account holder name to the database
     * @param name the name that will be added
     * @return 
     */
    public static boolean addAccntHolder(String name){
        return con.addAcntHolder(name);
    }
    
    public static boolean checkJobNum(String jobNum){
        return con.checkJobNum(jobNum);
    }
    /**
     * uses the customer id to check if that customer is valued
     * @param cusID the customer id used
     * @return 
     */
    public static boolean checkValued(String cusID){
        return con.checkValued(cusID);
    }
    /**
     * returns the data relating to discounts that a certain customer has
     * @param cstID the customer id used to define which customer 
     * @return 
     */
    public static LinkedList<String> getDiscData(String cstID){
        return con.getDiscountType(cstID);
    }
    /**
     * returns the result set of all customers that are in default 
     * @return 
     */
    public static ResultSet viewInDefault(){
        return con.viewLatePayers();
    }
    /**
     * returns the results set of invoice data for a particular job
     * @param jobNum the job number for which the invoice data will be returned
     * @return 
     */
    public static ResultSet getInvoiceData(String jobNum){
        return con.getInvoiceData(jobNum);
    }
    /**
     * gets all of the letters based on which type they are
     * @param type allows the user to define the type of letter(first or second)
     * @return 
     */
    public static LinkedList<String> getAllLetters(String type){
        return con.getAllLetters(type);
    }
 
    public static void suspendedPayment(String custID){
        con.suspendedPayment(custID);
    }
    /**
     * gets all fixed discounts in the database
     * @return 
     */
    public static ResultSet getFixedDiscounts(){
        return con.getFixedDiscounts();
    }
    /**
     * gets all flexible discounts in the database
     * @return 
     */
    public static ResultSet getFlexDiscounts(){
        return con.getFlexDiscounts();
    }
    /**
     * gets all variable discounts in the database
     * @return 
     */
    public static ResultSet getVariableDiscounts(){
        return con.getVariablediscounts();
    }
    /**
     * Sets the discount for a specific customer
     * @param discID the id for the discount
     * @param custId the id for the customer
     */
    public static void setDiscount(int discID, String custId){
        con.SetDiscount(discID, custId);
    }
    /**
     * Sets the fixed discount for a specific customer
     * @param discId the id for the discount
     * @param rate the rate of the discount
     */
    public static void addFixedDiscount(int discId, float rate){
        con.addFixedDiscount(discId, rate);
    }
    /**
     * Sets the variable discount 
     * @param upper the upper level of each band
     * @param lower the lower level of each band
     * @param rates the discount rates for each band
     * @param discId the id given to each discount
     */
    public static void addVariableDiscount(LinkedList<Float> upper,LinkedList<Float> lower,LinkedList<Float> rates, int discId){
        con.addVariableDiscount(upper, lower, rates, discId);
    }
    /**
     * gets all of the tasks to be used the database
     * @return 
     */
    public static ResultSet getAllTaskItems(){
        return con.getAllTaskItems();
    }
    /**
     * gets a task given its id
     * @param taskID the id to be used to get the task
     * @return 
     */
    public static boolean getTaskById(int taskID){
        return con.getTaskById(taskID);
    }
    /**
     * adds a flexible discount to tasks 
     * @param tasks the id for the tasks to add discounts to
     * @param rates the rates of discount for each task
     * @param discID the id given to this discount
     */
    public static void addFlexidisc(LinkedList<Integer> tasks, LinkedList<Float> rates, int discID){
        con.addFlexiblediscount(tasks, rates, discID);
    }
    /**
     * allows the user to delete the discount using its id
     * @param DiscId the discount id to be deleted
     * @return 
     */
    public static boolean deleteDiscount(int DiscId){
        return con.deleteDiscounts(DiscId);
    }
    /**
     * sets the current shelf slot of a task
     * @param jobTaskID 
     */
    public static void setcurrentShelf(int jobTaskID){
        con.setcurrentShelf(jobTaskID);
    }
    
    /**
     * generates an individual report based on dates
     * @param startDate the start date for the report
     * @param endDate the end date for the report
     * @return 
     */
    public static ResultSet generateIndividualReportA(String startDate, String endDate){
        return con.generateIndividualReportA(startDate, endDate);
    }
    /**
     * generates an individual report based on dates
     * @param startDate the start date for the report
     * @param endDate the end date for the report
     * @return 
     */
    public static ResultSet generateIndividualReportB(String startDate, String endDate){
        return con.generateIndividualReportB(startDate, endDate);
    }
    /**
     * generates an individual report based on dates
     * @param startDate the start date for the report
     * @param endDate the end date for the report
     * @return 
     */
    public static ResultSet generateIndividualReportC(String startDate, String endDate){
        return con.generateIndividualReportC(startDate, endDate);
    }
    
    /**
     * generates a summary report based on the dates given
     * @param startDate the start date for the report
     * @param endDate the end date for the report
     * @return 
     */
    public static ResultSet generateSummaryReportA(String startDate, String endDate){
        return con.generateSummaryReportA(startDate, endDate);
    }
    /**
     * generates a summary report based on the dates given
     * @param startDate the start date for the report
     * @param endDate the end date for the report
     * @return 
     */
    public static ResultSet generateSummaryReportB(String startDate, String endDate){
        return con.generateSummaryReportB(startDate, endDate);
    }
    /**
     * generates a summary report based on the dates given
     * @param startDate the start date for the report
     * @param endDate the end date for the report
     * @return 
     */
    public static ResultSet generateSummaryReportC(String startDate, String endDate){
        return con.generateSummaryReportC(startDate, endDate);
    }
    /**
     * generates a summary report based on the dates given
     * @param startDate the start date for the report
     * @param endDate the end date for the report
     * @return 
     */
    public static ResultSet generateSummaryReportD(String startDate, String endDate){
        return con.generateSummaryReportD(startDate, endDate);
    }
    /**
     * generates a summary report based on the dates given
     * @param startDate the start date for the report
     * @param endDate the end date for the report
     * @return 
     */
    public static ResultSet generateSummaryReportE(String startDate, String endDate){
        return con.generateSummaryReportE(startDate, endDate);
    }
    /**
     * generates a summary report based on the dates given
     * @param startDate the start date for the report
     * @param endDate the end date for the report
     * @return 
     */
    public static ResultSet generateSummaryReportF(String startDate, String endDate){
        return con.generateSummaryReportF(startDate, endDate);
    }
    /**
     * generates a summary report based on the dates given
     * @param startDate the start date for the report
     * @param endDate the end date for the report
     * @return 
     */
    public static ResultSet generateSummaryReportG(String startDate, String endDate){
        return con.generateSummaryReportG(startDate, endDate);
    }
    /**
     * generates a summary report based on the dates given
     * @param startDate the start date for the report
     * @param endDate the end date for the report
     * @return 
     */
    public static ResultSet generateSummaryReportH(String startDate, String endDate){
        return con.generateSummaryReportH(startDate, endDate);
    }
    
    /**
     * Generates a customer report given the date and customer id
     * @param CustomerID the customer id used
     * @param Date the date for the report
     * @return 
     */
    public static ResultSet generateCustomerReport(String CustomerID, String Date){
        return con.generateCustomerReport(CustomerID, Date);
    }
    /**
     * allows the office manager to remove a payment alert
     * @param jobNum the job number for which the alert is for
     */
    public static void removePaymentAlert(String jobNum){
        con.deleteReminder(jobNum);
    }
    
    public static boolean testNewConnection(String user, String pass){
        return con.testNewConnection(user, pass);
    }
    /**
     * allows the customer to be upgraded
     * @param custID 
     */
    public static void upgradeCustomer(String custID){
        con.upgradeAccount(custID);
    }
    /**
     * allows the customer to be downgraded
     * @param custID id used to identify which customer
     */
    public static void downgradeCustomer(String custID){
        con.downgradeAccount(custID);
    }
    /**
     * removes a discount from the customer 
     * @param custID id used to identify the customer
     */
    public static void removeDiscCust(String custID){
        con.removeDiscount(custID);
    }
    /**
     * checks that a customer doesn't already have a discount
     * @param custID
     * @return 
     */
    public static boolean checkDiscounted(String custID){
        return con.checkDiscounted(custID);
    }
    
    public static void UpdateCurrentShelfs(String shelf, String newShelf){
        con.updateCurrentShelves(shelf, newShelf);
    }
    /**
     * deletes a user based on their user id
     * @param userID 
     */
    public static void DeleteUsr(String userID){
        con.DeleteUsr(userID);
    }
    /**
     * gets the discount rates for a specific discount
     * @param discID
     * @return 
     */
    public static LinkedList<Float> getDiscountRates(int discID){
        return con.getDiscountRates(discID);
    }
    
    public static ResultSet customerReport1(String date1, String date2, String customerid){
        return con.customerReport1(date1, date2, customerid);
    }
    
    public static Float customerReport2(String date1, String date2, String customerid){
        return con.customerReport2(date1, date2, customerid);
    }
    /**
     * gets the ids of tasks in a job
     * @param jobNum
     * @return 
     */
    public static String getTaskIDS(String jobNum){
        return con.getTaskIDS(jobNum);
    } 
}
