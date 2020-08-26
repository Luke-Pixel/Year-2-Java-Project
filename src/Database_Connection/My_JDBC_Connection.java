/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Connection;

import Control.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *implements the methods in the JDBC_Connection class
 * @author Luke
 */
public class My_JDBC_Connection implements JDBC_Connection {

    private static Connection con;
    ResultSet rs = null;
    Statement stmt;
    PreparedStatement pStmt;
    String userName;
    String password;
    
    //set user id
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    //set their password
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    
    //test if database connection works
    @Override
    public boolean testNewConnection(String user, String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", user, pass);
            System.out.println("Database Connection Created");
            con.close();
            return true;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error Connecting To Database, Check MySQL Username And Password: " + ex.getMessage(),  "Test Connection", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Connecting To Database, Check MySQL Username And Password: " + ex.getMessage(),  "Test Connection", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        //close_Connection();
        //System.out.println("Connection Closed");
    }

    
     //old method to test if database connection works    
    @Override
    public void test_Connection() throws SQLException {
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //display all tasks
    @Override
    public ResultSet viewTaks() throws SQLException {

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM TASK"); //appropriate sql query
            //con.close();
            //System.out.println("Connection Closed");
            while (rs.next()) {
                int iD = rs.getInt("task_id");
                System.out.println(iD);
            }

        } /*catch (ClassNotFoundException ex) {
            Logger.getLogger(My_JDBC_Connection.class.getName()).log(Level.SEVERE, null, ex);
        } */ catch (SQLException ex) { //concurrency checks
            Logger.getLogger(My_JDBC_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
        //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //login to system
    @Override
    public ResultSet login(String username, String password) throws SQLException {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            //PreparedStatement stmt ;
            pStmt = con.prepareStatement("SELECT * FROM user_account WHERE employee_id = ? AND password = ?");//= con.createPreparedStatement(); //appropriate sql query
            pStmt.setString(1, username);
            pStmt.setString(2, password);
            rs = pStmt.executeQuery();
            //con.close();
            //System.out.println("Connection Closed");

            return rs;
        } /*catch (ClassNotFoundException ex) {
            Logger.getLogger(My_JDBC_Connection.class.getName()).log(Level.SEVERE, null, ex);
        } */ catch (SQLException ex) {
            Logger.getLogger(My_JDBC_Connection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // con.close();
            //System.out.println("Connection Closed");
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //view all the customers 
    @Override
    public ResultSet viewCustomers() throws SQLException {
        //DefaultTableModel custTable = table.getModel;
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM customer"); //appropriate sql query
            return rs;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return rs;
        }

        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * allows the user to search for customers based on their:
     * @param fName first name
     * @param sName second name
     * @param postcode postcode
     * @return
     * @throws SQLException 
     */
    @Override
    public ResultSet searchCustomers(String fName, String sName, String postcode) throws SQLException {

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from customer Where first_name = ? AND second_name = ? AND postcode = ?"); //appropriate sql query
            pStmt.setString(1, fName);
            pStmt.setString(2, sName);
            pStmt.setString(3, postcode);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException e) { 
            System.out.println("SQL Exception");
        }
        return null;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ResultSet viewStoredTasks() throws SQLException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM task");
            return rs;
        } catch (SQLException e) {
            System.out.println("SQL Exception");
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * adds a new task to the database
     * @param id the id of the new task 
     * @param description the description of the new task 
     * @param Location the location of the new task
     * @param shelfSlot the shelfslot of the new task
     * @param price the price of the new task
     * @param time the time of the new task
     * @return 
     */
    @Override
    public String addNewTask(int id, String description, String Location, String shelfSlot, float price, int time) {

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");

            pStmt = con.prepareStatement("INSERT INTO Task VALUES (?, ?, ?, ?, ?, ?) ");
            pStmt.setInt(1, id);
            pStmt.setString(2, description);
            pStmt.setString(3, Location);
            pStmt.setString(4, shelfSlot);
            pStmt.setFloat(5, price);
            pStmt.setInt(6, time);
            pStmt.execute();
            return "Complete";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "SQL Exception";
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * searches for a task based on the id given
     * @param id the task id used to search
     * @return 
     */
    @Override
    public List searchTask(int id) {
        List<String> taskItems = new LinkedList<String>();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM Task WHERE task_id = ?");
            pStmt.setInt(1, id);
            rs = pStmt.executeQuery();
            //fill arraylist
            rs.next();
            taskItems.add(rs.getString("task_id"));
            taskItems.add(rs.getString("task_Description"));
            taskItems.add(rs.getString("price"));
            taskItems.add(rs.getString("duration"));
            taskItems.add(rs.getString("location"));
            taskItems.add((rs.getString("shelfSlot")));
            return taskItems;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return taskItems;
        } finally {
            close_Connection();
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * allows the user to update the task 
     * @param description the description that can be updated
     * @param Location the location that can be updated
     * @param shelfSlot the shelf slot that can be updated
     * @param price the price that can be updated
     * @param time the time that can be updated
     * @param id the id that can be updated
     * @return 
     */
    @Override
    public boolean updateTask(String description, String Location, String shelfSlot, float price, int time, int id) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("UPDATE Task Set task_Description = ?, location = ?, shelfSlot = ?, price = ?, duration = ? WHERE task_id = ?");
            pStmt.setString(1, description);
            pStmt.setString(2, Location);
            pStmt.setString(3, shelfSlot);
            pStmt.setFloat(4, price);
            pStmt.setInt(5, time);
            pStmt.setInt(6, id);
            pStmt.execute();
            return true;
        } catch (SQLException ex) { //concurrency checks
            System.out.println(ex.getMessage());
            return false;
        } finally {
            close_Connection();
        }
    }
    /**
     * delete a task based on the id provided
     * @param id
     * @return 
     */
    @Override 
    public boolean deleteTask (int id){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("delete from task where task_id = ?");
            pStmt.setInt(1, id);            
            pStmt.execute();
            return true;
        } catch (SQLException ex) { //concurrency checks
            System.out.println(ex.getMessage());
            return false;
        } finally {
            close_Connection();
        }
    }
    /**
     * delete a customer based on the id provided
     * @param id
     * @return 
     */
    @Override 
    public boolean deleteCust (String id){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("delete from customer where customer_id = ?");
            pStmt.setString(1, id);            
            pStmt.execute();
            return true;
        } catch (SQLException ex) { //concurrency checks
            System.out.println(ex.getMessage());
            return false;
        } finally {
            close_Connection();
        }
    }
    
    
    /**
     * update the customer data as follows:
     * @param firstname
     * @param secondname
     * @param state
     * @param phone
     * @param ad2
     * @param city
     * @param postcode
     * @param ad1
     * @param holdername
     * @param valued
     * @param email
     * @param id
     * @return 
     */
    @Override
    public boolean updateCust(String firstname, String secondname, String state, int phone, String ad2, String city, String postcode, 
            String ad1, String holdername, String valued, String email, String id){
    try {
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("UPDATE customer Set first_name = ?, second_name = ?, state = ?, phone = ?, address_Line2 = ?, city = ?, postcode = ?, address_line1=?, accountholdername=?, valued_customer = ?, email=? WHERE customer_id = ?");
            pStmt.setString(1, firstname);
            pStmt.setString(2, secondname);
            pStmt.setString(3, state);
            pStmt.setInt(4, phone);
            pStmt.setString(5, ad2);
            pStmt.setString(6, city);
            pStmt.setString(7, postcode);
            pStmt.setString(8, ad1);
            pStmt.setString(9, holdername);
            pStmt.setString(10, valued);
            pStmt.setString(11, email);
            pStmt.setString(12, id);
            pStmt.execute();
            return true;
        } catch (SQLException ex) { //concurrency checks
            System.out.println(ex.getMessage());
            return false;
        } finally {
            close_Connection();
        }

    }
    /**
     * allows the user to select the customer from the database using their id
     * @param custId
     * @return 
     */
    @Override
    public boolean selectCustomer(String custId) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM Customer WHERE customer_id = ?");
            pStmt.setString(1, custId);
            rs = pStmt.executeQuery();
            if (!rs.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) { //concurrency checks
            System.out.println(ex.getMessage());
            return false;
        } finally {
            close_Connection();
        }
    }
    /**
     * gets the tasks from the database
     * @return 
     */
    @Override
    public ArrayList getTaskList() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from Task");
            ArrayList<String> tasksList = new ArrayList<String>();
            while (rs.next()) {
                tasksList.add(rs.getString("task_id") + " " + rs.getString("task_Description"));
            }
            return tasksList;
        } catch (SQLException ex) { //concurrency checks
            System.out.println(ex.getMessage());
            return null;
        } finally {
            close_Connection();
        }
    }

    /**
     *gets the prices of tasks from the database
     * @param id
     * @return
     */
    @Override
    public float getTaskPrice(int id) {
        float price = 0;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT price FROM Task WHERE task_id = ?");
            pStmt.setInt(1, id);
            rs = pStmt.executeQuery();
            rs.next();
            price = rs.getFloat("price");

            return price;
        } catch (SQLException ex) { //concurrency checks
            System.out.println("get price " + ex.getMessage());
            return 0;
        } finally {
            close_Connection();
        }
    }

    /**
     *adds a job to the database 
     * @param deadline the deadline for the job
     * @param price the price of the job
     * @param custId the id for the customer placing the job
     * @param instructions special instructions for the job
     * @return
     */
    @Override
    public void addJob(String jobNum,String deadline, float price, String custId, String instructions,int priority, boolean rushed) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            System.out.println(deadline + "time sent");
            pStmt = con.prepareStatement("INSERT INTO job VALUES (?, ?, ?,?,?, null,?,?,null, ? ,1, ?, ?)");
            pStmt.setString(1, jobNum);
            pStmt.setString(2, deadline);
            pStmt.setString(3, "UNPAID");
            pStmt.setString(4, instructions);
            pStmt.setBoolean(5, false);
            pStmt.setString(6, custId);
            //pStmt.setInt(6, custId);
            pStmt.setFloat(7, price);
            pStmt.setInt(8, priority);
            pStmt.setBoolean(9, rushed);
            pStmt.setString(10, "RECEPTION");
            pStmt.execute();
            //retrieve new job ID
            /*
            pStmt = con.prepareStatement("SELECT Job_number FROM job WHERE deadline = ? AND payment_state = ? AND total_cost = ? AND Customer_customer_id = ?");
            pStmt.setString(1, deadline);
            pStmt.setString(2, "UNPAID");
            pStmt.setFloat(3, price);
            pStmt.setString(4, custId);
            rs = pStmt.executeQuery();
            rs.next();
            //return job number for adding tasks
            return rs.getInt("Job_number");
            */
        } catch (SQLException ex) { //concurrency checks
            System.out.println("Job " +ex.getMessage());
            //return -1;
        } finally {
            close_Connection();
        }
    }
    /**
     * checks if the customer is valued
     * @param cusID id used to check the customer
     * @return 
     */
    @Override
    public boolean checkValued(String cusID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM customer WHERE customer_id = ?");
            pStmt.setString(1, cusID);
            
            rs = pStmt.executeQuery();
            rs.next();
            if(rs.getString("valued_customer").equals("YES")){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {//concurrency checks
            System.out.println( ex.getMessage());
            return false;
        } finally {
            close_Connection();
        }
    }

    @Override
    public boolean addJobTask(int taskId, String jobNum, String custID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("INSERT INTO job_task VALUES (null,null,null,?,null,null,null,?,?,?,null,null)");
            pStmt.setString(1, "NEW");
            
            pStmt.setInt(2, taskId);
            pStmt.setString(3, jobNum);
            pStmt.setString(4, custID);
            //pStmt.setString(5,)
            //pStmt.setString(6, "NORMAL");
            pStmt.execute();
            return true;
        } catch (SQLException ex) {//concurrency checks
            System.out.println("Job Task " + ex.getMessage());
            return false;
        } finally {
            close_Connection();
        }
    }

    /**
     *checks to see if the customer is suspended based on their id
     * @param custId
     * @return
     */
    @Override
    public boolean checkSuspended(String custId) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM customer WHERE customer_id = ? AND state = ? OR state = ?");
            pStmt.setString(1, custId);
            pStmt.setString(2, "SUSPENDED");
            pStmt.setString(3, "IN DEFAULT");
            rs = pStmt.executeQuery();
            if (!rs.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            close_Connection();
        }
    }

    @Override
    public LinkedList<String> getDiscountType(String custID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM valued_customer WHERE customer_customer_id = ?");
            pStmt.setString(1, custID);
            
            rs = pStmt.executeQuery();
            rs.next();
            int discID = rs.getInt("Discount_idDiscount");
            pStmt = con.prepareStatement("SELECT * FROM discount WHERE idDiscount = ?");
            pStmt.setInt(1, discID);
            rs = pStmt.executeQuery();
            rs.next();
            String type = rs.getString("discount_type");
            LinkedList<String> discData = new LinkedList();
            discData.add(Integer.toString(discID));
            discData.add(type);
            return discData;
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return null;
        } finally {
            close_Connection();
        }
    }
    
    

    /**
     *gets the users from the database
     * @return
     */
    @Override
    public ResultSet getUsers() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from user_account");
            return rs;
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     *gets a specific user from the database given their employee id
     * @param empId
     * @return
     */
    @Override
    public ArrayList getUser(String empId) {
        try {
            ArrayList<String> employee = new ArrayList<String>();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM user_account WHERE employee_id = ?");
            pStmt.setString(1, empId);
            rs = pStmt.executeQuery();
            //check result set not empty
            if (!rs.next()) {
                return null;

            } else {
                employee.add(rs.getString("employee_id"));
                employee.add(rs.getString("password"));
                employee.add(rs.getString("role"));
                employee.add(rs.getString("first_name"));
                employee.add(rs.getString("second_name"));
                return employee;
            }
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     *searches the database for a user
     * @param fName first name to search with 
     * @param sName second name to search with
     * @return
     */
    @Override
    public ResultSet searchUser(String fName, String sName) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("select * from user_account WHERE first_name = ? AND second_name = ?");
            pStmt.setString(1, fName);
            pStmt.setString(2, sName);
            rs = pStmt.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                //rs.previous();
                System.out.println("name found: " + rs.getString("first_name"));
                rs.previous();
                return rs;
            }
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    /**
     * allows the user to edit other users details:
     * @param employeeId
     * @param newID
     * @param password
     * @param role
     * @param fName
     * @param sName
     * @return 
     */
    @Override
    public boolean editUser(String employeeId, String newID, String password, String role, String fName, String sName) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("UPDATE user_account SET employee_id = ?, password = ?, role = ?, first_name = ?, second_name = ? WHERE employee_id = ?");
            
            pStmt.setString(1, newID);
            pStmt.setString(2, password);
            pStmt.setString(3, role);
            pStmt.setString(6, employeeId);
            pStmt.setString(4, fName);
            pStmt.setString(5, sName);
            pStmt.execute();
            return true;
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * gets data of an invoice for a particular customer
     * @param custId id used to define which customer
     * @return 
     */
    @Override
    public ResultSet retrieveInvoiceData(int custId) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from invoice WHERE job_number = ?");
            pStmt.setInt(1, custId);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return null;
        }
    }
    /**
     * returns the result set of all jobs in the database
     * @return 
     */
    @Override
    public ResultSet viewAllJobs() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from baper_work");
            return rs;
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return null;
        }
    }
    /**
     * returns the result set of all jobs in-progress in the database
     * @return 
     */
    @Override
    public ResultSet viewJobsInProgress() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from baper_work WHERE state <> ?");
            pStmt.setString(1, "COMPLETE");
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return null;
        }
    }
    /**
     * searches for a job in the database given its number
     * @param jobNum
     * @return 
     */
    @Override
    public ResultSet searchJob(String jobNum) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from baper_work WHERE job_number = ?");
            pStmt.setString(1, jobNum);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    @Override
    public boolean setTaskWorking(int id, String time, String shiftType) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("UPDATE job_task SET user_account_employee_id = ?, start_time = ?, state = ?, shift_type = ? WHERE Job_TaskID = ?");
            pStmt.setString(1, Controller.getUa().getEmployee_id());
            pStmt.setString(2, time);
            pStmt.setString(3, "IN PROGRESS");
            pStmt.setString(4, shiftType);
            pStmt.setInt(5, id);
            pStmt.execute();
            return true;
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return false;
        } finally {
            close_Connection();
        }
    }

    @Override
    public boolean setTaskEnd(int id, String time, int duration) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("UPDATE job_task SET end_time = ?, state = ?, duration = ? WHERE Job_TaskID = ?");
            pStmt.setString(1, time);
            pStmt.setString(2, "COMPLETE");
            pStmt.setInt(3, duration);
            pStmt.setInt(4, id);
            pStmt.execute();
            checkJobFinished(id, time);
            return true;
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean checkFirstUse() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from user_account");
            if (!rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return false;
        }
    }
    /**
     * checks if a job has finished 
     * @param id
     * @param time 
     */
    @Override
    public void checkJobFinished(int id, String time) {
        try {
            
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            
             pStmt = con.prepareStatement("SELECT * from job_task WHERE Job_TaskID = ?");
            pStmt.setInt(1, id);
            rs = pStmt.executeQuery();
            rs.next();
            String job = rs.getString("Job_job_number");
            
            pStmt = con.prepareStatement("SELECT * from job_task WHERE Job_TaskID = ? AND state <> ?");
            pStmt.setInt(1, id);
            pStmt.setString(2, "COMPLETE");
            rs = pStmt.executeQuery();
            
            if (!rs.next()) {
                pStmt = con.prepareStatement("UPDATE job SET completion_date = ? WHERE Job_number = ?");
                pStmt.setString(1, time);
                pStmt.setString(2, job);
                pStmt.execute();
                JOptionPane.showMessageDialog(null, "Job Is Complete, Ready For Payment And Collection",  "Update Work", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
        }
    }
    /**
     * gets the start time for a particular job in the database
     * @param id
     * @return 
     */
    @Override
    public String getStartTime(int id) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT start_time FROM job_task WHERE Job_TaskID = ?");
            pStmt.setInt(1, id);
            rs = pStmt.executeQuery();
            rs.next();
            return rs.getString("start_time");
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return "";
        }
    }
    
    /**
     * views the jobs that have been performed by a customer 
     * @param custID
     * @return 
     */
    @Override
    public ResultSet viewcustJob(String custID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from baper_work WHERE Job_Customer_customer_id = ?");
            pStmt.setString(1, custID);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return rs;
        }
    }
    /**
     * allows the user to edit the details of a specified customer:
     * @param custID
     * @param fName
     * @param sName
     * @param phone
     * @param ad1
     * @param ad2
     * @param city
     * @param postcode
     * @param email
     * @param holder
     * @return 
     */
    @Override
    public boolean editCust(String custID, String fName, String sName, String phone, String ad1, String ad2, String city, String postcode, String email, int holder) {
        try {
            boolean ready = true;
            if (holder != -1){
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
                System.out.println("Database Connection Succesful");
                pStmt = con.prepareStatement("SELECT * from account_holer WHERE idaccount_holer = ? ");
                pStmt.setInt(1, holder);
                rs = pStmt.executeQuery();
                if (!rs.next()){
                    ready = false;
                    JOptionPane.showMessageDialog(null,"Accout Holder Not Found " ,  "Edit Customer", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
            if(ready == true){
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
                System.out.println("Database Connection Succesful");
                pStmt = con.prepareStatement("UPDATE customer SET first_name = ?, second_name = ?, phone = ?, address_line1 = ?,address_Line2 = ?, city = ?, postcode = ?,email = ?, account_holer_idaccount_holer = ? WHERE customer_id = ? ");
                pStmt.setString(1, fName);
                pStmt.setString(2, sName);
                pStmt.setString(3, phone);
                pStmt.setString(4, ad1);
                pStmt.setString(5, ad2);
                pStmt.setString(6, city);
                pStmt.setString(7, postcode);
                pStmt.setString(10, custID);
                pStmt.setString(8, email);
                if (holder == -1){
                    pStmt.setNull(9, 0);
                }else{
                    pStmt.setInt(9, holder);
                }
                pStmt.execute();
                return true;
            }
        } catch (SQLException ex) {//concurrency checks
            System.out.println(ex.getMessage());
            return false;
        }
        return false;
    }
    
    @Override
    public ResultSet viewCustById(String custID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM customer WHERE customer_id = ? ");
            pStmt.setString(1, custID);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return rs;
        }
    }
/**
 * gets the type of discount given the id of that discount
 * @param discID
 * @return 
 */
    @Override
    public String getDiscountType(int discID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM discount WHERE idDiscount = ? ");
            pStmt.setInt(1, discID);
            rs = pStmt.executeQuery();
            return rs.getString("discount_type");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return "error";
        }
    }
    /**
     * gets a flexible discount given that discounts id
     * @param discID
     * @return 
     */
    @Override
    public int getFlexibleDiscountID(int discID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM flexible_discount WHERE Discount_idDiscount = ? ");
            pStmt.setInt(1, discID);
            rs = pStmt.executeQuery();
            return rs.getInt("idflexible_discount");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
    }
    /**
     * returns the upper bands for a certain flexible discount
     * @param flexID
     * @return 
     */
    @Override
    public LinkedList<Float> getUpperBands(int flexID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("select * from flexible_band WHERE discount_idDiscount = ? ");
            pStmt.setInt(1, flexID);
            rs = pStmt.executeQuery();
            LinkedList<Float> upper = new LinkedList<Float> ();
            while (rs.next()){
                upper.add(rs.getFloat("upper_limit"));
            }
            return upper;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    
    /**
     * returns the lower bands for a certain flexible discount
     * @param flexID
     * @return 
     */
    @Override
    public LinkedList<Float> getLowerBands(int flexID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("select * from flexible_band WHERE discount_idDiscount = ? ");
            pStmt.setInt(1, flexID);
            rs = pStmt.executeQuery();
            LinkedList<Float> lower = new LinkedList<Float> ();
            while (rs.next()){
                lower.add(rs.getFloat("lower_limit"));
            }
            return lower;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    /**
     * gets the discount rates for the bands in a particular flexible discount
     * @param discID the discount id that will be checked
     * @return 
     */
    @Override
    public LinkedList<Float> getDiscountRates(int discID) {
       try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("select * from flexible_band WHERE discount_idDiscount = ? ");
            pStmt.setInt(1, discID);
            rs = pStmt.executeQuery();
            LinkedList<Float> percentage = new LinkedList<Float> ();
            while (rs.next()){
                percentage.add(rs.getFloat("discount_Percentage"));
            }
            return percentage;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    

    @Override
    public float getPreviousVolume(String custID) {
        Calendar aCalendar = Calendar.getInstance();
        Calendar bCalendar = Calendar.getInstance();
        // add -1 month to current month
        aCalendar.add(Calendar.MONTH, -1);
        // set DATE to 1, so first date of previous month
        aCalendar.set(Calendar.DATE, 1);

        Date firstDateOfPreviousMonth = aCalendar.getTime();
        Timestamp start = new Timestamp(aCalendar.getTimeInMillis());
        // set actual maximum date of previous month
        aCalendar.set(Calendar.DATE,     aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        //read it
        Date lastDateOfPreviousMonth = aCalendar.getTime();
        
        
        Timestamp end = new Timestamp(aCalendar.getTimeInMillis());
        System.out.println("start Stamp " + start.toString() + " end stamp" + end.toString()  );
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("select SUM(total_cost) from job WHERE Customer_customer_id =? AND (completion_date BETWEEN DATE(?) AND DATE(?) ) AND payment_state = ? ORDER BY Customer_customer_id");
            pStmt.setString(1, custID);
            pStmt.setString(2,start.toString() );
            pStmt.setString(3,end.toString() );
            pStmt.setString(4, "PAID");
            rs = pStmt.executeQuery();
            if(rs.next() == false){
                return 0;
            }else{
            float previousVolume = rs.getFloat("SUM(total_cost)");
                System.out.println("Previosu Volume: " + rs.getFloat("SUM(total_cost)"));
            return previousVolume;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }

    @Override
    public float getVarDisc(int taskID, int discID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from variable_discount WHERE Discount_idDiscount = ? AND Task_task_id = ?");
            pStmt.setInt(1, discID);
            pStmt.setInt(2, taskID);
            rs = pStmt.executeQuery();
            if(!rs.next()){
                return 0;
            }else{
                return rs.getFloat("discount_rate");
            }      
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    /**
     * gets a fixed discount from the database given that discounts id
     * @param discID
     * @return 
     */
    @Override
    public float getFixedDisc(int discID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from fixed_discount WHERE Discount_idDiscount = ? ");
            pStmt.setInt(1, discID);
            
            rs = pStmt.executeQuery();
            if(!rs.next()){
                return 0;
            }else{
                return rs.getFloat("discount_rate");
            }      
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    /**
     * returns the unpaid jobs for a certain customer
     * @param custID
     * @return 
     */
    @Override
    public ResultSet getUnpaidJobs(String custID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from job WHERE Customer_customer_id = ? AND payment_state <> ?");
            pStmt.setString(1, custID);
            pStmt.setString(2,"PAID");
            rs = pStmt.executeQuery();
            return rs; 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    /**
     * gets the jobs for which the customer is late paying for
     * @param custID the id used to define which customer
     * @return 
     */
    @Override
    public ResultSet getLatePaymentJobs(String custID) {
         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from job WHERE Customer_customer_id = ? AND (payment_state = ? OR payment_state = ? OR payment_state = ?)");
            pStmt.setString(1, custID);
            pStmt.setString(2,"LATE");
            pStmt.setString(3, "FIRST LTR");
            pStmt.setString(4, "SCND LTR");
            rs = pStmt.executeQuery();
            return rs; 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public LinkedList<String> getJobPayment(int jobID) {
         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from job WHERE Job_number = ?");
            pStmt.setInt(1, jobID);    
            rs = pStmt.executeQuery();
            LinkedList<String> payData = new LinkedList();
            if (!rs.next()){
                return null;
            }else {
                payData.add(rs.getString("Job_number"));
                payData.add(rs.getString("total_cost"));
                return payData;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    /**
     * allows the user to process a card payment into the database
     * @param custID
     * @param ammount
     * @param cardNum
     * @param expiry
     * @param type
     * @param jobs
     * @return 
     */
    @Override
    public Boolean payForJobsCard(String custID,float ammount, String cardNum, String expiry,String type, LinkedList<String> jobs) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("INSERT INTO payment VALUES(null, ? , ?, ? ,?, ?, 1, ?)");
            pStmt.setFloat(1,ammount);   
            pStmt.setString(2, "CARD");
            pStmt.setString(3, cardNum);
            pStmt.setString(4,expiry);
            pStmt.setString(5, type);
            pStmt.setString(6, custID);
            pStmt.execute();
            for (int i = 0; i < jobs.size(); i++){
                updateJobsPaid(jobs.get(i));
            }
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    /**
     * allows the user to process cash payment into the database
     * @param custID
     * @param ammount
     * @param jobs
     * @return 
     */
    @Override
    public Boolean payForJobsCash(String custID, float ammount, LinkedList<String> jobs) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("INSERT INTO payment VALUES(null, ? , ?, null,null, null, 1, ?)");
            pStmt.setFloat(1,ammount);   
            pStmt.setString(2, "CASH");
            pStmt.setString(3, custID);
            pStmt.execute();
            for (int i = 0; i < jobs.size(); i++){
                updateJobsPaid(jobs.get(i));
            }
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    
    /**
     * updates the jobs to have been paid 
     * @param jobNum 
     */
    @Override
    public void updateJobsPaid(String jobNum) {
         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("UPDATE job SET payment_state = ? WHERE Job_number = ?");
            pStmt.setString(1, "PAID");
            pStmt.setString(2, jobNum);
            pStmt.execute();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
    }
    /**
     * gets the names of account holders from the database
     * @return 
     */
    @Override
    public ResultSet getAccountHolders() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM account_holer");
            rs = pStmt.executeQuery();
            return rs;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    /**
     * allows the user to add the name of an account holder
     * @param namme the name being added
     * @return 
     */
    @Override
    public boolean addAcntHolder(String namme) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("INSERT INTO account_holer VALUES(null, ?)");
            pStmt.setString(1, namme);
            pStmt.execute();
            return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean checkJobNum(String jobNum) {
         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from job WHERE Job_number = ?");
            pStmt.setString(1, jobNum);
            rs = pStmt.executeQuery();
            if(!rs.next()){
                System.out.println("New Job Number");
                return true;
            }else {
                return false;
            }   
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    /**
     * returns the users who have not paid 
     * @return 
     */
    @Override
    public ResultSet viewLatePayers() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM late_alert_view WHERE payment_state <> ? OR payment_state <> ? GROUP BY customer_id AND state = ?");
            pStmt.setString(1, "PAID");
            pStmt.setString(2, "UNPAID");
            pStmt.setString(3, "IN DEFAULT");
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }


    @Override
    public ResultSet viewLetterCust(String type) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM late_alert_view WHERE payment_state <> ? OR payment_state <> ? GROUP BY customer_id AND alert_type = ?");
            pStmt.setString(1, "PAID");
            pStmt.setString(2, "UNPAID");
            pStmt.setString(3, type);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
/**
 * gets the invoice data for a specific job from the database
 * @param jobNum
 * @return 
 */
    @Override
    public ResultSet getInvoiceData(String jobNum) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM invoice WHERE Job_number = ?");
            pStmt.setString(1, jobNum);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public void suspendedPayment(String custID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM customer WHERE customer_id = ? AND state = ?");
            pStmt.setString(1, custID);
            pStmt.setString(2, "SUSPENDED");
            rs = pStmt.executeQuery();
            while(rs.next()){
                pStmt = con.prepareStatement("UPDATE customer SET state = ? where customer_id = ?");
                pStmt.setString(2, custID);
                pStmt.setString(1, "ACTIVATED");
                pStmt.execute();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            
        } finally {
            close_Connection();
        
            
        }
    }
    
    
    
    
    

    @Override
    /**
     *
     */
    public void close_Connection() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Connection Closed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (rs != null) {
                rs.close();
                System.out.println("Result Set Closed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (pStmt != null) {
                pStmt.close();
                System.out.println("Prepared Statement Closed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (stmt != null) {
                stmt.close();
                System.out.println("Statement Closed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeResultSet() throws SQLException {
        try {
            if (rs != null) {
                rs.close();;
            }
        } catch (Exception e) {
        }
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeStatement() throws SQLException {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closePreparedStatement() throws SQLException {
        try {
            if (pStmt != null) {
                pStmt.close();
            }
        } catch (Exception e) {
        }

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * allows the user to create an account with the appropriate data fields 
 * @param ID
 * @param role
 * @param password
 * @param firstName
 * @param secondName
 * @return 
 */
    @Override
    public String create_Account(String ID, String role, String password, String firstName, String secondName) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            PreparedStatement stmt;
            stmt = con.prepareStatement("INSERT INTO user_account VALUES (?,?,?,?,?)");//= con.createPreparedStatement();
            System.out.println(ID);
            stmt.setString(1, ID);
            stmt.setString(3, role);
            stmt.setString(2, password);
            stmt.setString(4, firstName);
            stmt.setString(5, secondName);
            stmt.execute();
            return "Complete";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "SQL Exception";
        }
    }
    /**
     * allows the user to create a new customer in the database with the 
     * data listed below
     * @param id
     * @param firstname
     * @param secondname
     * @param state
     * @param phone
     * @param ad2
     * @param city
     * @param postcode
     * @param ad1
     * @param holdername
     * @param valued
     * @param email
     * @return 
     */
    @Override
    public String createCust(String id, String firstname, String secondname, String state, String phone, String ad2,
            String city, String postcode, String ad1, int holdername, String valued, String email) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");//= con.createPreparedStatement();
            pStmt.setString(1, id);
            pStmt.setString(2, firstname);
            pStmt.setString(3, secondname);
            pStmt.setString(4, "ACTIVATED");
            pStmt.setString(5, phone);
            pStmt.setString(6, ad2);
            pStmt.setString(7, city);
            pStmt.setString(8, postcode);
            pStmt.setString(9, ad1);
            pStmt.setString(10, valued);
            pStmt.setString(11, email);
            if (holdername == -1){
            pStmt.setNull(12, 0);
            }else{
                pStmt.setInt(12, holdername);
            }
            /*if (holderID.equals("null")){
                pStmt.setNull(9, 0);
            }else{
                pStmt.setInt(9, Integer.parseInt(holderID));
            }*/
            pStmt.execute();

            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return "Complete";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "SQL Exception";
        } finally {
            close_Connection();
        }

    }
    /**
     * gets all letters of the specified type
     * @param type
     * @return 
     */
    @Override
    public LinkedList<String> getAllLetters(String type) {
        try {
            LinkedList<String> jobNums = new LinkedList();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM late_alert_view WHERE alert_type = ?");
            pStmt.setString(1, type);
            rs = pStmt.executeQuery();
            while (rs.next()){
                jobNums.add(rs.getString("Job_number"));
            }
            return jobNums;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    /**
     * gets all fixed discounts from the database
     * @return 
     */
    @Override
    public ResultSet getFixedDiscounts() {
        try {
            LinkedList<String> jobNums = new LinkedList();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM fixed_discount");
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println("get fixed discounts " + ex.getMessage());
            return null;
        }
    }
    /**
     * gets all the flexible discounts from the database
     * @return 
     */
    @Override
    public ResultSet getFlexDiscounts() {
        try {
            LinkedList<String> jobNums = new LinkedList();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM flexible_discounts ORDER BY Discount_idDiscount");
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println("get variable discounts " + ex.getMessage());
            return null;
        }
    }
/**
 * gets the variable discounts from the database
 * @return 
 */
    @Override
    public ResultSet getVariablediscounts() {
        try {
            LinkedList<String> jobNums = new LinkedList();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM flexible_band ORDER BY discount_idDiscount");
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println("get variable discounts " + ex.getMessage());
            return null;
        }
    }
    /**
     * sets the discount to the customer based on the given discount id and 
     * the id of the customer to set the discount for
     * @param discID
     * @param CustId 
     */
    @Override
    public void SetDiscount(int discID, String CustId) {
        try {
            boolean discountfound = true;
            int dialogResult = JOptionPane.YES_OPTION;
            boolean valued = true;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * from discount WHERE idDiscount = ?");
            pStmt.setInt(1, discID);
            rs = pStmt.executeQuery();
                if(!rs.next()){
                    JOptionPane.showMessageDialog(null, "Discount Not Found, check discount ID",  "Set Discount", JOptionPane.WARNING_MESSAGE);
                    discountfound = false;
                }else{
                    pStmt = con.prepareStatement("Select * from customer WHERE customer_id = ? AND valued_customer = ?");
                    pStmt.setString(1, CustId);
                    pStmt.setString(2, "YES");
                    rs = pStmt.executeQuery();
                    if(!rs.next()){
                        valued = false;
                        dialogResult = JOptionPane.showConfirmDialog (null, "This customer is not a valud cutomer, Upgraded account?","Warning",JOptionPane.YES_NO_OPTION);
                        if(dialogResult == JOptionPane.YES_OPTION){
                            upgradeAccount(CustId);
                            valued = true;
                        }
                    }
                if (dialogResult == JOptionPane.YES_OPTION && valued == true){
                    pStmt = con.prepareStatement("UPDATE valued_customer SET discount_idDiscount = ? WHERE customer_customer_id = ?");
                    pStmt.setInt(1, discID);
                    pStmt.setString(2, CustId);
                    pStmt.execute(); 
                    JOptionPane.showMessageDialog(null, "Discount Set",  "Set Discount", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("get variable discounts " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),  "Set Discount", JOptionPane.WARNING_MESSAGE);
        }
    }
    /**
     * upgrades an account in the database given that accounts id
     * @param custID 
     */
    @Override
    public void upgradeAccount(String custID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM valued_customer WHERE customer_customer_id = ?");
            pStmt.setString(1, custID);
            rs = pStmt.executeQuery();
            if(rs.next() == true){
                JOptionPane.showMessageDialog(null, "Customer is already a valued customer",  "Upgrade Customer", JOptionPane.WARNING_MESSAGE);
            }else{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
                System.out.println("Database Connection Succesful");
                pStmt = con.prepareStatement("UPDATE customer SET valued_customer = ? WHERE customer_id = ?");
                pStmt.setString(1, "YES");
                pStmt.setString(2, custID);
                pStmt.execute();
                pStmt = con.prepareStatement("INSERT INTO valued_customer VALUES (?,null)");
                pStmt.setString(1, custID);
                pStmt.execute();
                JOptionPane.showMessageDialog(null, "Customer Account Upgraded",  "Upgrade Customer", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("upgrade customer: " + ex.getMessage());
           
        }
    }
    /**
     * adds a fixed discount to the database and assigns it a rate and discount id
     * @param discId
     * @param rate 
     */
    @Override
    public void addFixedDiscount(int discId, float rate) {
        try {
            LinkedList<String> jobNums = new LinkedList();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM discount WHERE idDiscount = ?");
            pStmt.setInt(1, discId);
            rs = pStmt.executeQuery();
            if (!rs.next()){
                pStmt = con.prepareStatement("INSERT INTO discount VALUES(?,?)");
                pStmt.setInt(1, discId);
                pStmt.setString(2, "Fixed");
                pStmt.execute();
                pStmt = con.prepareStatement("INSERT INTO fixed_discount VALUES(?,?)");
                pStmt.setFloat(1, rate);
                pStmt.setInt(2,discId);
                pStmt.execute();
                JOptionPane.showMessageDialog(null, "Discount Added",  "Add Discount", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Discount ID Already In Use",  "Set Discount", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex) {
            System.out.println("add discounts " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),  "Set Discount", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void addVariableDiscount(LinkedList<Float> upper, LinkedList<Float> lower, LinkedList<Float> rates, int discId) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM discount WHERE idDiscount = ?");
            pStmt.setInt(1, discId);
            rs = pStmt.executeQuery();
            if (!rs.next()){
                pStmt = con.prepareStatement("INSERT INTO discount VALUES(?,?)");
                pStmt.setInt(1, discId);
                pStmt.setString(2, "Variable");
                pStmt.execute();
                for(int i = 0; i < upper.size(); i++){
                    pStmt = con.prepareStatement("INSERT INTO flexible_band VALUES(null,?,?,?,?)");
                    pStmt.setFloat(1,upper.get(i));
                    pStmt.setFloat(2,lower.get(i));
                    pStmt.setFloat(3, rates.get(i));
                    pStmt.setInt(4,discId);
                    pStmt.execute();
                }
                JOptionPane.showMessageDialog(null, "Discount Added",  "Add Discount", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Discount ID Already In Use",  "Set Discount", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex) {
            System.out.println("add discounts " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),  "Set Discount", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public ResultSet getAllTaskItems() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM TASK");
            return rs;
            

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error Retrieveing Tasks: " + ex.getMessage(),  "Retrieve Tasks", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        
    }
    /**
     * gets a task given its id
     * @param taskID
     * @return 
     */
    @Override
    public boolean getTaskById(int taskID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM task WHERE task_id = ?");
            pStmt.setInt(1, taskID);
            rs = pStmt.executeQuery();
            if(!rs.next()){
                return false;
            }else{
                return true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error Retrieveing Task: " + ex.getMessage(),  "Retrieve Tasks", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    @Override
    public boolean addFlexiblediscount(LinkedList<Integer> tasks, LinkedList<Float> rates, int DiscID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM discount WHERE idDiscount = ?");
            pStmt.setInt(1, DiscID);
            rs = pStmt.executeQuery();
            if (!rs.next()){
                pStmt = con.prepareStatement("INSERT INTO discount VALUES(?,?)");
                pStmt.setInt(1, DiscID);
                pStmt.setString(2, "Flexible");
                pStmt.execute();
                for(int i = 0; i < tasks.size(); i++){
                    pStmt = con.prepareStatement("INSERT INTO variable_discount VALUES(?,?,?)");
                    pStmt.setFloat(1,rates.get(i));
                    pStmt.setInt(2,tasks.get(i));
                    pStmt.setInt(3,DiscID);  
                    pStmt.execute();
                }
                JOptionPane.showMessageDialog(null, "Discount Added",  "Add Discount", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "Discount ID Already In Use",  "Set Discount", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println("add discounts " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),  "Set Discount", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    /**
     * deletes a discount given its id
     * @param discID
     * @return 
     */
    @Override
    public boolean deleteDiscounts(int discID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM discount WHERE idDiscount = ?");
            pStmt.setInt(1, discID);
            rs = pStmt.executeQuery();
            if (rs.next()){
                setDiscountNull(discID);
                deleteFlexDisc(discID);
                deleteVarDisc(discID);
                deleteFixedDisc(discID);
                deleteDisc(discID);
                JOptionPane.showMessageDialog(null, "Discount Deleted",  "Delete Discount", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }else {
                JOptionPane.showMessageDialog(null, "Discount Not Found",  "Delete Discount", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            
        } catch (SQLException ex) {
            System.out.println("add discounts " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(),  "Set Discount", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }

    }
    /**
     * deletes a flexible discount given its id
     * @param discID 
     */
    private void deleteFlexDisc(int discID){
        try{
            pStmt = con.prepareStatement("DELETE FROM variable_discount WHERE Discount_idDiscount = ?");
            pStmt.setInt(1, discID);
            pStmt.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }        
    /**
     * deletes a variable discount given its id
     * @param discID 
     */
    private void deleteVarDisc(int discID){
        try{
            pStmt = con.prepareStatement("DELETE FROM flexible_band WHERE Discount_idDiscount = ?");
            pStmt.setInt(1, discID);
            pStmt.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    /**
     * deletes a fixed discount given its id
     * @param discID 
     */
    private void deleteFixedDisc(int discID){
        try{
            pStmt = con.prepareStatement("DELETE FROM fixed_discount WHERE Discount_idDiscount = ?");
            pStmt.setInt(1, discID);
            pStmt.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void deleteDisc(int discID){
        try{
            pStmt = con.prepareStatement("DELETE FROM discount WHERE idDiscount = ?");
            pStmt.setInt(1, discID);
            pStmt.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void setDiscountNull(int discID){
        try{
            pStmt = con.prepareStatement("UPDATE valued_customer SET Discount_idDiscount = null WHERE Discount_idDiscount =  ?");
            pStmt.setInt(1, discID);
            pStmt.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteReminder(String jobNum) {
       try{
            pStmt = con.prepareStatement("DELETE FROM payment_alert WHERE job_Job_number = ?");
            pStmt.setString(1, jobNum);
            pStmt.execute();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void setcurrentShelf(int jobTaskID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM job_task WHERE Job_TaskID = ?");
            pStmt.setInt(1, jobTaskID);
            rs = pStmt.executeQuery();
            rs.next();
            int taskID = rs.getInt("Task_task_id");
            String job = rs.getString("Job_job_number");
            pStmt = con.prepareStatement("SELECT * FROM task WHERE task_id = ?");
            pStmt.setInt(1, taskID);
            rs = pStmt.executeQuery();
            rs.next();
            String shelf = rs.getString("shelfSlot");
            pStmt = con.prepareStatement("UPDATE Job SET current_shelf = ? Where job_number = ?");
            pStmt.setString(1, shelf);
            pStmt.setString(2, job);
            pStmt.execute();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error Updating Shelf Number: " + ex.getMessage(),  "Update Work", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }

    @Override
    public void updateCurrentShelves(String shelf, String newShelf) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            pStmt = con.prepareStatement("UPDATE job SET current_shelf = ? WHERE current_shelf = ?");
            pStmt.setString(1, newShelf);
            pStmt.setString(2, shelf);
            pStmt.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    /**
     * removes a discount from a customer given that persons id
     * @param custID 
     */
    @Override
    public void removeDiscount(String custID) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            pStmt = con.prepareStatement("UPDATE valued_customer set discount_idDiscount = null WHERE customer_customer_id = ?");
            pStmt.setString(1, custID);
            pStmt.execute();
            JOptionPane.showMessageDialog(null,"Discount Removed",  "Remove Discount", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    /**
     * checks to see if a customer has a discount when given their id
     * @param custID
     * @return 
     */
    @Override
    public boolean checkDiscounted(String custID) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            pStmt = con.prepareStatement("SELECT * FROM valued_customer WHERE customer_customer_id = ? AND discount_idDiscount <> 0");
            pStmt.setString(1, custID);
            rs = pStmt.executeQuery();
            if(rs.next() == false){
                System.out.println("No Discount");
                return false;
            }else {
                return true;
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    /**
     * deletes a user from the database given that users id
     * @param userID 
     */
    @Override
    public void DeleteUsr(String userID) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            pStmt = con.prepareStatement("DELETE from user_account WHERE employee_id = ?");
            pStmt.setString(1, userID);
            pStmt.execute();
            JOptionPane.showMessageDialog(null, "User Deleted",  "Delete User", JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException ex){//concurrency checks
            System.out.println(ex.getMessage());
            
        }
    }
    
    
    
    
    
    
    
     @Override
    public String generateReportView() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("CREATE VIEW Performance_Data as\n"
                    + "select UA.Name, UA.Surname,T.task_id,T.location, JT.start_time,JT.time_taken,UA.second_name,UA.first_name, UA.employee_id, JT.shift_type, JT.Job_Job_number, J.total_cost, JT.Job_TaskID, T.shelfSlot, J.deadline, JT. Job_Customer_customer_id\n"
                    + "FROM user_account UA\n"
                    + "JOIN job_Task JT ON UA.employee_id = JT.user_Account_employee_id JOIN Task T ON Task_task_id = T.task_id JOIN job J ON J.Job_number = JT.Job_Job_number");
            pStmt.execute();
            return "Complete";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "SQL Exception";
        } finally {
            close_Connection();
        }
    }

    @Override
    public ResultSet generateIndividualReportA(String startDate, String endDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT first_name, second_name, job_job_number, task_id, location, DATE(start_time), TIME(start_time), duration\n"
                    + "From Performance_Data\n"
                    + "WHERE DATE (start_time) between ? AND ? ORDER BY employee_id, DATE(start_time)");
            pStmt.setString(1, startDate);
            pStmt.setString(2, endDate);
            rs = pStmt.executeQuery();
            /*while (rs.next()){
            System.out.println(rs.getString(1));}*/
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        /*finally {
            close_Connection();
        }*/
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet generateIndividualReportB(String startDate, String endDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT SUM(duration) as 'Total' FROM Performance_Data WHERE DATE(start_time) between ? AND ? GROUP BY employee_id");
            pStmt.setString(1, startDate);
            pStmt.setString(2, endDate);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        /*finally {
            close_Connection();
        }*/
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet generateIndividualReportC(String startDate, String endDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT SUM(duration) as 'Total effort' FROM performance_data WHERE DATE(start_time) between ? AND ?");
            pStmt.setString(1, startDate);
            pStmt.setString(2, endDate);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }/* finally {
            close_Connection();
        }*/
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet generateSummaryReportA(String startDate, String endDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT SUM(duration) as 'Duration', location as 'Location', DATE(start_time) as 'Date' FROM Performance_Data\n"
                    + "WHERE shift_type = 'DAY 1' AND DATE(start_time) BETWEEN  ? AND ? \n"
                    + "GROUP BY location , DATE(start_time)\n"
                    + "ORDER BY DATE(start_time)");
            pStmt.setString(1, startDate);
            pStmt.setString(2, endDate);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet generateSummaryReportB(String startDate, String endDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("Select SUM(duration) as 'Total', location as 'Location' From Performance_Data\n"
                    + "WHERE shift_type = 'DAY 1' AND DATE(start_time) between ? AND ?\n"
                    + "GROUP BY location");
            pStmt.setString(1, startDate);
            pStmt.setString(2, endDate);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet generateSummaryReportC(String startDate, String endDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT SUM(duration) as 'Duration', location as 'Location', Date(start_time) as 'Date' From Performance_Data\n"
                    + "WHERE shift_type = 'DAY 2' AND DATE(start_time) between ? AND ?\n"
                    + "GROUP BY location , DATE(start_time) ORDER BY Date(start_time)");
            pStmt.setString(1, startDate);
            pStmt.setString(2, endDate);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet generateSummaryReportD(String startDate, String endDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT SUM(duration) as 'Total', location as 'Location' From Performance_Data\n"
                    + "WHERE shift_type = 'DAY 2' AND DATE(start_time) between ? AND ?\n"
                    + "GROUP BY location");
            pStmt.setString(1, startDate);
            pStmt.setString(2, endDate);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet generateSummaryReportE(String startDate, String endDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT SUM(duration) as 'Total', location as 'Location', Date(start_time) as 'Date' From Performance_Data\n"
                    + "WHERE shift_type = 'NIGHT 1' AND DATE(start_time) between ? AND ?\n"
                    + "GROUP BY location , DATE(start_time) ORDER BY Date(start_time)");
            pStmt.setString(1, startDate);
            pStmt.setString(2, endDate);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet generateSummaryReportF(String startDate, String endDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("Select SUM(duration) as 'Duation', location as 'Location' From Performance_Data\n"
                    + "WHERE shift_type = 'NIGHT 1' AND DATE(start_time) between ? AND ? \n"
                    + "GROUP BY location");
            pStmt.setString(1, startDate);
            pStmt.setString(2, endDate);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet generateSummaryReportG(String startDate, String endDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT SUM(duration) as 'Duration', location as 'Location', shift_type FROM Performance_Data\n"
                    + "WHERE DATE(start_time) between ? AND ? GROUP BY shift_type, location");
            pStmt.setString(1, startDate);
            pStmt.setString(2, endDate);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet generateSummaryReportH(String startDate, String endDate) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT SUM(duration) as 'Duration', location as 'Location'\n"
                    + "FROM Performance_Data\n"
                    + "WHERE DATE(start_time) between ? AND ? GROUP BY location");
            pStmt.setString(1, startDate);
            pStmt.setString(2, endDate);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResultSet generateCustomerReport(String CustomerID, String Date) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("select Job_Job_number as 'Code', total_cost as 'Price, £', Job_TaskID as 'Task', location as 'Department', start_time as 'Start Time', \n" +
"duration as 'Time Taken', Name as 'Name', Surname as 'Surname', shelfSlot as 'Shelf on completion'   \n" +
"FROM Performance_Data\n" +
"WHERE Job_Customer_customer_id = ? AND deadline = ? \n" +
"GROUP BY Job_Customer_customer_id");
            pStmt.setString(1, CustomerID);
            pStmt.setString(2, Date);
            rs = pStmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;

    }

    @Override
    public void setupDatabase() {
        setupViews();
        discountView();
        letterView();
        lateView();
        InvoiceView();
        PerformanceView();
    }
    /**
     * downgrades a specific customer account
     * @param custID 
     */
    @Override
    public void downgradeAccount(String custID) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("UPDATE customer SET valued_customer = ? WHERE customer_id = ?");
            pStmt.setString(1, "NO");
            pStmt.setString(2, custID);
            pStmt.execute();
            pStmt = con.prepareStatement("DELETE FROM valued_customer WHERE customer_customer_id = ?");
            pStmt.setString(1, custID);
            pStmt.execute();
            JOptionPane.showMessageDialog(null, "Customer Downgraded",  "Downgrade Customer", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error Downgrading Customer",  "Downgrade Customer", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    public void setupViews(){
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            stmt.execute("CREATE VIEW baper_work as\n" +
"SELECT J.current_shelf,J.job_number, J.deadline, J.late,J.special_instructions,J.rushed,T.shelfSlot, T.task_id, T.task_Description, T.location, T.duration, JT.Job_TaskID, JT.start_time, JT.end_Time,  JT.state, JT.time_taken, JT.shift_type, JT.user_account_employee_id, JT.Job_Customer_customer_id\n" +
"FROM job_task JT\n" +
"JOIN job J ON JT.Job_Job_number = J.Job_number\n" +
"JOIN Task T ON JT.Task_task_id = T.task_id\n" +
"order by J.rushed DESC ,J.priority ASC\n"); 
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    
    private void discountView(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            stmt.execute("CREATE VIEW flexible_discounts AS\n" +
"SELECT  VD.Discount_idDiscount, VD.Task_task_id, VD.discount_rate,T.task_Description\n" +
"FROM variable_discount VD\n" +
"JOIN task T ON VD.Task_task_id = T.task_id\n");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void letterView(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            stmt.execute("CREATE VIEW letter_view AS\n" +
"SELECT  C.first_name, C.second_name,C.customer_id, C.phone, C.address_line1, C.city, C.postcode, J.Job_number, J.payment_state, J.completion_date, J.total_cost\n" +
"FROM customer C \n" +
"JOIN job J ON C.customer_id = J.Customer_customer_id\n"); 
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void lateView(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            stmt.execute( "CREATE VIEW late_alert_view AS\n" +
"SELECT  C.first_name, C.second_name,C.customer_id, C.state, C.valued_customer,PA.aknowledged,PA.alert_type, PA.next_check,PA.idAlert, J.Job_number, J.payment_state, C.address_line1,C.phone, C.email,C.city, C.postcode\n" +
"FROM customer C \n" +
"JOIN job J ON C.customer_id = J.Customer_customer_id\n" +
"JOIN Payment_Alert PA ON PA.job_Job_number = J.Job_number\n");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    private void InvoiceView(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            stmt.execute( "CREATE VIEW Invoice as\n" +
"SELECT JT.Task_task_id,J.Job_number,J.total_cost,J.deadline, T.task_Description, T.price, C.customer_id, C.first_name, C.second_name, C.address_line1, C.city, C.postcode, C.phone\n" +
"\n" +
"FROM job_task JT\n" +
"\n" +
"JOIN job J ON JT.Job_Job_number = J.Job_number\n" +
"JOIN customer C ON JT.Job_Customer_customer_id = C.customer_id\n" +
"JOIN Task T ON JT.Task_task_id = T.task_id\n" );
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    
    private void PerformanceView(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            stmt = con.createStatement();
            stmt.execute( "CREATE VIEW Performance_Data as\n" +
"select UA.first_name, UA.second_name,T.task_id,T.location,T.shelfSlot, JT.start_time,JT.time_taken, UA.employee_id, JT.shift_type, JT.Job_Job_number,JT.duration\n" +
"FROM user_Account UA \n" +
"JOIN job_Task JT  ON UA.employee_id = JT.user_Account_employee_id\n" +
"JOIN Task T ON Task_task_id = T.task_id");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
        @Override
        public ResultSet customerReport1(String date1, String date2, String customerID){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement( "SELECT Job_number,payment_state,completion_date, total_cost,rushed\n" +
"FROM job\n" +
"WHERE (completion_date between ? AND ? )AND Customer_customer_id = ?");
            pStmt.setString(1, date1);
            pStmt.setString(2, date2);
            pStmt.setString(3,customerID);
            rs = pStmt.executeQuery();
            return rs;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Float customerReport2(String date1, String date2, String customerid) {
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT SUM(total_cost) FROM job WHERE payment_state = ? AND Customer_customer_id = ?  AND (completion_date between ? AND ?)");
            pStmt.setString(3, date1);
            pStmt.setString(4, date2);
            pStmt.setString(2,customerid);
            pStmt.setString(1,"PAID");
            rs = pStmt.executeQuery();
            rs.next();
            System.out.println(rs.getFloat("SUM(total_cost)"));
            return rs.getFloat("SUM(total_cost)");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return (float)0;
        }
    }

    @Override
    public String getTaskIDS(String jobNum) {
        String tasks = "";
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bapersdb", "root", "root");
            System.out.println("Database Connection Succesful");
            pStmt = con.prepareStatement("SELECT * FROM job_task WHERE Job_job_number = ?");
            pStmt.setString(1,jobNum);
            rs = pStmt.executeQuery();
            while (rs.next()){
                tasks = tasks + (rs.getString("Task_task_id") + " ");
            }
            return tasks;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return "";
        }
    }
        
    
        
}
