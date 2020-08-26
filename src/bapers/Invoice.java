/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import Control.BackEndControl;
import Control.Controller;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextPane;


/**
 *The following class is for creation and use in Invoices 
 * @author luke1
 */
public class Invoice {
    String jobNumber;
    boolean surCharge;
    boolean eXtra;
    ResultSet data;
    public Invoice(String jobNumber, boolean surCharcge, boolean eXtra) {
        this.jobNumber = jobNumber;
        this.surCharge = surCharcge;
        this.eXtra = eXtra;
        
    }
    
    String invoice;
       /**
    * This method is called to create an Invoice, adding the necessary bapers
    * details before adding the data from the particular job the Invoice 
    * has been created for
    * @return 
    */
    private String generateInvoice(){
        float totalPrice;
        String name = "";
        String Adress = "";
        String tasks = "";
        String phone= "";
        String strPrice= "";
        String surChargeString = "";
        String BapersAddress = "THE LAB" + "\n" + "2 Wynyatt Street" + "\n" + "London, EC1V 7HU" + "\n" + "Phone: 0207 235 7534";
        
        if (data != null){
            try{
            data.next();
            Adress = data.getString("address_line1") + "\n" + data.getString("city") + "\n" + data.getString("postcode") + "\n" + "Account: " + data.getString("Job_number") + "\n";
            name = data.getString("first_name") + " " + data.getString("second_name");
            phone = data.getString("phone");
            totalPrice = data.getFloat("total_cost");
            if (surCharge == true && !eXtra){
                surChargeString = "Surcharge of 100% added for rushed job";
            }else if(surCharge == true && eXtra == true){
                surChargeString = "Surcharge of 200% added for rushed job";
            }
            strPrice = "Total Price: £" + totalPrice;
            while (data.next()){
                tasks = tasks + data.getString("task_description") + " " + "price £: " + data.getFloat("price") + "\n";
            }
                    }catch(SQLException ex){
                        System.out.println("invoice: " + ex.getMessage());
                    }
        }
        return name + "\n" + "\n" + Adress + "\n" + phone + "\n" + "\n" + "\n" + tasks + "\n" + "\n" + strPrice + "\n" + "\n" + "Any applicable discounts and VAT of 20% have been applied to the total price" + "\n" + surChargeString + "\n" + "\n " + "\n " + BapersAddress;
    }
    
    private String genrateRecipt(){
        return "hello";
    }
        
    /**
     * This method is used to print an Invoice, by converting it to 
     * a printable format
     */
    public void printInvoice(){
        data = Controller.getInvoiceData(jobNumber);
        if (data != null){
            
            
            JTextPane jtp = new JTextPane();
            jtp.setBackground(Color.white);
            jtp.setText(generateInvoice());
            
            boolean show = true;
            try {
                jtp.print(null, null, show, null, null, show);
            } catch (java.awt.print.PrinterException ex) {
                ex.printStackTrace();
            }
        }else{
            System.out.println("error invoice data null");
        }
    }
}
