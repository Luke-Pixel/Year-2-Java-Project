/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Control.BackEndControl;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.AttributedString;
import java.util.Calendar;
import javax.swing.JTextPane;

/**
 *Generates the reminder letters with the type and relevant data
 * @author luke1
 */
public class LetterReminder {
    String reminderType;
    //String custID;
    //String jobNum;
    //String header;
    String reminder;
    String address;
    String labAddress;
    String body;
    String body2;
    String date;
    String greting;
    ResultSet data;
   /**
    * Sets up the settings of the letter and sets various constants 
    * @param reminderType 
    */
    public LetterReminder(String reminderType) {
        this.reminderType = reminderType;
        //this.custID = custID;
        //this.jobNum = jobNum;
        Font font = new Font("Ariel", Font.BOLD, 20);
        AttributedString header= new AttributedString("The Lab"); 
        header.addAttribute(TextAttribute.FONT, font);
        Calendar cal = Calendar.getInstance();
        Timestamp timeStmp = new Timestamp(cal.getTimeInMillis());
        String [] dateParts = timeStmp.toString().split(" ");
        date = dateParts[0];   
    }
    /**
     * generates each letter with the appropriate data
     * @return 
     */
    public String generateLetter(){
        try{
            
            address=  data.getString("first_name") + " " + data.getString("second_name")+  "\n";
            address= data.getString("address_line1") + "\n";
            address= address + data.getString("city") + "\n"; 
            address= address + data.getString("postcode") + "\n";
            
            
            
            
        if(reminderType.equals("FIRST LETTER")){
            body = "According to our records, it appears that we have not yet received payment of the above invoice, which was posted" + "\n" + " to you on " + data.getString("completion_date") +  ",for photographic work done in our laboratory. " + "\n" + "\n" + "We would appreciate payment at your earliest convenience." 
                    + "\n" +
"If you have already sent a payment to us recently, please accept our apologies" +"\n"  +"\n"  +"\n"  +"\n"  +"\n"  +"\n"  +"\n" + "Yours Sinerly G.Lancaster" + "\n" + "\n" + "The Lab";
            
            reminder = "                        REMINDER - JOB NUMBER: " + data.getString("Job_number") + " Total payable" + data.getString("total_cost") + "\n";
            
            String letter = address + "\n" + "\n" + date +  "\n" + "\n" + "Dear " + data.getString("first_name") + " " + data.getString("second_name") + "\n" + "\n" +
                reminder + "\n" + "\n" + body;
            return letter;
        }else{
        //String letter;
        body = "It appears that we still have not received payment of the above invoice, which was posted to you on " + data.getString("completion_date") +"\n" +
"2017, for photographic work done in our laboratory, despite a reminder letter posted to you 1 month later.\n" +
"Unless you pay the outstanding amount in full within SEVEN DAYS, or contact us with proposals for repayment, we\n" +
"will have no option but to refer the matter to our solicitor.\n" +
"Please send payment immediately to avoid further action. "  +"\n"  +"\n"  +"\n"  +"\n"  +"\n"  +"\n"  +"\n" + "Yours Sinerly G.Lancaster" + "\n" + "\n" + "The Lab";
        
        
        reminder = "                   FINAL REMINDER - JOB NUMBER: " + data.getString("Job_number") + " Total payable" + data.getString("total_cost") + "\n";
        
        String letter = address + "\n" + "\n" + date +  "\n" + "\n" + "Dear " + data.getString("first_name") + " " + data.getString("second_name") + "\n" + "\n" +
                reminder + "\n" + "\n" + body;
        return letter;
        
        }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return "error check job number";
        }
       
    }
    /**
     * gets the letter from the database and prints it
     * @param jobNum the job number of which this letter is being printed
     */
    public void printLetter(String jobNum){
        data = BackEndControl.getLetterData(jobNum);
        if (data != null){
            
            
            JTextPane jtp = new JTextPane();
            jtp.setBackground(Color.white);
            jtp.setText(generateLetter());
            
            boolean show = true;
            try {
                jtp.print(null, null, show, null, null, show);
            } catch (java.awt.print.PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}
