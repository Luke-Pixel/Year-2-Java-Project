/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import BackEnd.LetterReminder;
import Control.BackEndControl;
import Control.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *Creates the Manage Late Payments form
 * @author Luke
 */
public class ManageLatePayments extends javax.swing.JFrame {
    ResultSet customers;
    DefaultTableModel tableModel;
    LetterReminder lrf = new LetterReminder("FIRST LETTER");
    LetterReminder lrs = new LetterReminder("SECOND LETTER");
    /**
     * Creates new form InDefault
     */
    public ManageLatePayments() {
        initComponents();
        tableModel = (DefaultTableModel)customerTable.getModel();
        getIndefault();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        custIdTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        firstLtr = new javax.swing.JButton();
        firstRadio = new javax.swing.JRadioButton();
        secondRadio = new javax.swing.JRadioButton();
        inDefaultBtn = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        ActivateBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        firstRemindersBtn = new javax.swing.JButton();
        secondRemindersBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jobNum = new javax.swing.JTextField();
        scndLtr = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cust ID", "First Name", "Second Name", "Address 1", "City", "Postcode", "Phone", "Email", "Job Number"
            }
        ));
        jScrollPane1.setViewportView(customerTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Manage Late Payments");

        custIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custIdTxtActionPerformed(evt);
            }
        });

        jLabel2.setText("Customer ID: ");

        firstLtr.setText("Print First Letter");
        firstLtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstLtrActionPerformed(evt);
            }
        });

        buttonGroup1.add(firstRadio);
        firstRadio.setText("First Reminder");
        firstRadio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                firstRadioMousePressed(evt);
            }
        });
        firstRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(secondRadio);
        secondRadio.setText("Second Reminder");
        secondRadio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                secondRadioMousePressed(evt);
            }
        });
        secondRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(inDefaultBtn);
        inDefaultBtn.setSelected(true);
        inDefaultBtn.setText("In Default");
        inDefaultBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inDefaultBtnMousePressed(evt);
            }
        });
        inDefaultBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inDefaultBtnActionPerformed(evt);
            }
        });

        ActivateBtn.setText("Activate Account");
        ActivateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActivateBtnActionPerformed(evt);
            }
        });

        exitBtn.setText("Close");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        firstRemindersBtn.setText("Print All First Reminders");
        firstRemindersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstRemindersBtnActionPerformed(evt);
            }
        });

        secondRemindersBtn.setText("Print All Seond Reminders");
        secondRemindersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondRemindersBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Job Number:");

        jobNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobNumActionPerformed(evt);
            }
        });

        scndLtr.setText("Print Second Letter");
        scndLtr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scndLtrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(firstRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondRadio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inDefaultBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(firstRemindersBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondRemindersBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jobNum, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(firstLtr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scndLtr)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(custIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ActivateBtn)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(657, 657, 657)
                        .addComponent(exitBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstRadio)
                    .addComponent(secondRadio)
                    .addComponent(inDefaultBtn)
                    .addComponent(secondRemindersBtn)
                    .addComponent(firstRemindersBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jobNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstLtr)
                    .addComponent(scndLtr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(custIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActivateBtn)
                    .addComponent(exitBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void custIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custIdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custIdTxtActionPerformed
/**
 * This button disposes of this form and opens the main menu
 * @param evt 
 */
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
this.dispose();
Controller.openMainMenu();// TODO add your handling code here:
    }//GEN-LAST:event_exitBtnActionPerformed
/**
 * Pressing this button will print the first late payment letter
 * @param evt 
 */
    private void firstLtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstLtrActionPerformed
printLetter("first");        // TODO add your handling code here:
    }//GEN-LAST:event_firstLtrActionPerformed
/**
 * This will activate the account of the specified customer, by changing its state
 * @param evt 
 */
    private void ActivateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActivateBtnActionPerformed
        
        if(custIdTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter Customer ID",  "Activate Account", JOptionPane.WARNING_MESSAGE);
        }else{
        boolean result = BackEndControl.setCustState(custIdTxt.getText(), "ACTIVATED");   
            if(!result){
                JOptionPane.showMessageDialog(null, "Error updating user account, Check Customer ID",  "Activate Account", JOptionPane.WARNING_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Customer account activated",  "Activate Account", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_ActivateBtnActionPerformed

    private void firstRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstRadioActionPerformed

    private void secondRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondRadioActionPerformed

    private void inDefaultBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inDefaultBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inDefaultBtnActionPerformed
/**
 * Gets all of the first late payment letters and prints them
 * @param evt 
 */
    private void firstRemindersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstRemindersBtnActionPerformed
    LinkedList<String> jobNums = Controller.getAllLetters("FIREST LETTER");  
    if (jobNums != null){
        for(int i = 0; i < jobNums.size(); i++){
            lrf.printLetter(jobNums.get(i));
        }
    }
    }//GEN-LAST:event_firstRemindersBtnActionPerformed
/**
 * Gets all of the second late payment letters and prints them
 * @param evt 
 */
    private void secondRemindersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondRemindersBtnActionPerformed
    LinkedList<String> jobNums = Controller.getAllLetters("SECOND LETTER");  
    if (jobNums != null){
        for(int i = 0; i < jobNums.size(); i++){
            lrs.printLetter(jobNums.get(i));
        }
    }
    }//GEN-LAST:event_secondRemindersBtnActionPerformed
/**
 * switches the table to display the second late payment accounts
 * @param evt 
 */
    private void secondRadioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_secondRadioMousePressed
        getSecond();
    }//GEN-LAST:event_secondRadioMousePressed
/**
 * switches the table to display the first late payment accounts
 * @param evt 
 */
    private void firstRadioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstRadioMousePressed
        getFirst();
    }//GEN-LAST:event_firstRadioMousePressed

    private void jobNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobNumActionPerformed
/**
 * Prints the second late payment letter of a certain account
 * @param evt 
 */
    private void scndLtrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scndLtrActionPerformed
printLetter("second");        // TODO add your handling code here:
    }//GEN-LAST:event_scndLtrActionPerformed
/**
 * switches the table to display the accounts in default
 * @param evt 
 */
    private void inDefaultBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inDefaultBtnMousePressed
        getIndefault();
    }//GEN-LAST:event_inDefaultBtnMousePressed
/**
 * Prints the late payment letter based on the job number given
 * @param type 
 */
    private void printLetter(String type){
        if (jobNum.getText().equals("")){
            
        }else{
            if (type.equals("first")){
                lrf.printLetter(jobNum.getText());
            }else{
                 lrs.printLetter(jobNum.getText());
            }
        }
    }
        /**
     * returns the result set for all customers in default 
     */
    private void getIndefault(){
        customers = Controller.viewInDefault();
        updateTable();
    }
    /**
     * returns the result set for all the customers that require their
     * first late payment letter
     */
    private void getFirst(){
        customers = Controller.getlLAteJobs("FIRST LETTER");
        updateTable();
    }
    /**
     * returns the result set for all the customers that require their
     * second late payment letter
     */
    private void getSecond(){
        customers = Controller.getlLAteJobs("SECOND LETTER");
        updateTable();
    }
    /**
     * Clears the current table and reloads/refreshes it with current data
     */
    private void updateTable(){
        tableModel.setRowCount(0);
        try{
            if (customers != null){
                while(customers.next()){
                    String fName = customers.getString("first_name");
                    String sName = customers.getString("second_name");
                    String custID = customers.getString("customer_id");
                    String address1 = customers.getString("address_line1");
                    String city = customers.getString("city");
                    String postcode = customers.getString("postcode");
                    String phone = customers.getString("phone");
                    String email = customers.getString("email");
                    String jobNum = customers.getString("Job_number");
                    tableModel.addRow(new Object [] {custID, fName, sName, address1,city,postcode,phone,email, jobNum});
                }
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageLatePayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageLatePayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageLatePayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageLatePayments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageLatePayments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActivateBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField custIdTxt;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton firstLtr;
    private javax.swing.JRadioButton firstRadio;
    private javax.swing.JButton firstRemindersBtn;
    private javax.swing.JRadioButton inDefaultBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jobNum;
    private javax.swing.JToggleButton scndLtr;
    private javax.swing.JRadioButton secondRadio;
    private javax.swing.JButton secondRemindersBtn;
    // End of variables declaration//GEN-END:variables
}
