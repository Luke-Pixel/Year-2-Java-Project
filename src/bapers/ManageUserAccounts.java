/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import Control.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luke
 */
public class ManageUserAccounts extends javax.swing.JFrame {
    ResultSet rs;
    DefaultTableModel tableModel;
    String userID = "";
    /**
     * Creates new form ManageUserAccounts
     */
    public ManageUserAccounts() {
        initComponents();
        viewAllUsers();
       // DefaultTableModel 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rolesGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        srchFName = new javax.swing.JTextField();
        srchSName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        employeeIdTxt = new javax.swing.JTextField();
        selectUserBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        newID = new javax.swing.JTextField();
        passTxt = new javax.swing.JPasswordField();
        rePassTxt = new javax.swing.JPasswordField();
        editUserBtn = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        mainMenuBtn = new javax.swing.JButton();
        officeBtn = new javax.swing.JRadioButton();
        shiftBtn = new javax.swing.JRadioButton();
        receptionistBtn = new javax.swing.JRadioButton();
        technicianBtn = new javax.swing.JRadioButton();
        deleteBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        firstNameTxt = new javax.swing.JTextField();
        secondNameTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Employee ID / Username", "Name", "Role"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Manage User Accounts");

        jLabel2.setText("First Name:");

        jLabel3.setText("Second Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Search User Accounts:");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Edit / Delete User Account: ");

        jLabel6.setText("User ID: ");

        selectUserBtn.setText("Select User Account (Edit)");
        selectUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectUserBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Select User Account: ");

        jLabel9.setText("User ID: ");

        jLabel10.setText("Role: ");

        jLabel11.setText("Password: ");

        jLabel12.setText("Retype Password: ");

        newID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newIDActionPerformed(evt);
            }
        });

        editUserBtn.setText("Edit User Account ");
        editUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserBtnActionPerformed(evt);
            }
        });

        mainMenuBtn.setText("Close");
        mainMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuBtnActionPerformed(evt);
            }
        });

        rolesGroup.add(officeBtn);
        officeBtn.setText("Office Manager");
        officeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                officeBtnActionPerformed(evt);
            }
        });

        rolesGroup.add(shiftBtn);
        shiftBtn.setText("Shift Manager");
        shiftBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shiftBtnActionPerformed(evt);
            }
        });

        rolesGroup.add(receptionistBtn);
        receptionistBtn.setText("Receptionsit");

        rolesGroup.add(technicianBtn);
        technicianBtn.setText("Technician");

        deleteBtn.setText("Delete User Account");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("First Name: ");

        jLabel13.setText("Second Name: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(srchSName))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(srchFName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(mainMenuBtn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(employeeIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectUserBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(officeBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(shiftBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(receptionistBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(technicianBtn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(rePassTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                            .addComponent(passTxt))
                                        .addGap(226, 226, 226)
                                        .addComponent(editUserBtn))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(secondNameTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(firstNameTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(newID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(srchFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(srchSName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(selectUserBtn)
                    .addComponent(deleteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(newID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(firstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(secondNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(officeBtn)
                    .addComponent(shiftBtn)
                    .addComponent(receptionistBtn)
                    .addComponent(technicianBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(passTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(rePassTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editUserBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainMenuBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * searches for user accounts based on the first or second name
 * @param evt 
 */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(srchFName.getText().equals("") || srchSName.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter First Name And Second Name",  "Empty Feilds", JOptionPane.WARNING_MESSAGE);
        }else{
            ResultSet rs2 = Controller.searchUser(srchFName.getText(), srchSName.getText());   
            if (rs2 == null){
                JOptionPane.showMessageDialog(null, "Invalid Search",  "No Results", JOptionPane.WARNING_MESSAGE);
            }else{
               // updateTable();
                //tableModel = (DefaultTableModel) userTable.getModel();
                tableModel.setRowCount(0);
                
                try{
                    int i = 0;
                    while(rs2.next() == true){
                        String id = rs2.getString("employee_id");
                        System.out.println(rs2.getString("employee_id"));
                        String fName = rs2.getString("first_name") + " " + rs2.getString("second_name");
                        String role = rs2.getString("role");
                        tableModel.addRow(new Object [] {id, fName,role});
                        i++;
                    }
                }catch (SQLException ex){
                    System.out.println(ex.getMessage());
                }finally{
                    Controller.closeConnections();
                }                
            }
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
/**
 * selects a user based on their employee ID, displaying their details
 * @param evt 
 */
    private void selectUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectUserBtnActionPerformed
        if(employeeIdTxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter a Emplyee ID",  "Enter Emplyee ID", JOptionPane.WARNING_MESSAGE);
        }else {
            ArrayList <String> employee = Controller.getUser(employeeIdTxt.getText());
            if (employee == null){
                JOptionPane.showMessageDialog(null, "Invalid Employee ID",  "Invalid ID", JOptionPane.WARNING_MESSAGE);
            }else{
                //employee = Controller.getUser(employeeIdTxt.getText());
                userID = employee.get(0);
                newID.setText(employee.get(0));
                System.out.println(employee.get(0));
                passTxt.setText(employee.get(1));
                rePassTxt.setText(employee.get(1));
                firstNameTxt.setText(employee.get(3));
                secondNameTxt.setText(employee.get(4));
                //check role
                if(employee.get(2).equals("Receptionist")){
                    receptionistBtn.setSelected(true);
                }else if(employee.get(2).equals("Technician")){
                    technicianBtn.setSelected(true);
                }else if (employee.get(2).equals("Shift Manager")){
                    shiftBtn.setSelected(true);
                }else if (employee.get(2).equals("Office Manager")){
                    officeBtn.setSelected(true);
                }
            }
        }    
    }//GEN-LAST:event_selectUserBtnActionPerformed

    private void newIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newIDActionPerformed

    private void officeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_officeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_officeBtnActionPerformed

    private void shiftBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shiftBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shiftBtnActionPerformed
/**
 * Applies any changes made to the user, to the database
 */
    private void editUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserBtnActionPerformed
        
        if(passTxt.getText().equals("")|| rePassTxt.getText().equals("") || newID.getText().equals("") || firstNameTxt.getText().equals("") || secondNameTxt.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Required Feilds Empty",  "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            if(passTxt.getText().equals(rePassTxt.getText())){
                String role = "";
                if (receptionistBtn.isSelected()){
                    role = "Receptionist";
                }else if(technicianBtn.isSelected()){
                    role = "Technician";
                }else if(shiftBtn.isSelected()){
                    role = "Shift Manager";
                }else if(officeBtn.isSelected()){
                    role = "Office Manager";
                }
                boolean result = Controller.editUser(userID,  newID.getText(), passTxt.getText(), role, firstNameTxt.getText(), secondNameTxt.getText());
                if(result == true){
                    JOptionPane.showMessageDialog(null, "Employee Details Updated",  "Employee Updated", JOptionPane.INFORMATION_MESSAGE);
                    viewAllUsers();
                }else{
                    JOptionPane.showMessageDialog(null, "Error Updating Employee Details",  "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Passwords Do Not Match",  "Error", JOptionPane.ERROR_MESSAGE);
            }
        }// TODO add your handling code here:
    }//GEN-LAST:event_editUserBtnActionPerformed
/**
 * disposes of this form and opens the main menu
 * @param evt 
 */
    private void mainMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuBtnActionPerformed
        this.dispose();
        Controller.openMainMenu();
    }//GEN-LAST:event_mainMenuBtnActionPerformed
/**
 * Allows the user to delete another user, based on the employee id given
 * @param evt 
 */
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(employeeIdTxt.getText().equals(Controller.getUa().getEmployee_id())){
            JOptionPane.showMessageDialog(null, "Cannot Delete Current Logged In User!",  "Error", JOptionPane.WARNING_MESSAGE);
        }else{
            Controller.DeleteUsr(employeeIdTxt.getText());  
            viewAllUsers();
        }// TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnActionPerformed
/**
 * Displays the result of all the users onto the table
 */
    public void viewAllUsers(){
        rs = Controller.getUsers();
        updateTable();
    }
    
    /**
     * Clears the current table, and reloads it with all current and updated data
     */
    public void updateTable(){
       
        tableModel = (DefaultTableModel) userTable.getModel();
        tableModel.setRowCount(0);
        try{
            while(rs.next()){
                String id = rs.getString("employee_id");
                String name = rs.getString("first_name") + " " + rs.getString("second_name");
                String role = rs.getString("role");
                tableModel.addRow(new Object [] {id,name, role});
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            rs = null;
            Controller.closeConnections();
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
            java.util.logging.Logger.getLogger(ManageUserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUserAccounts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUserAccounts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editUserBtn;
    private javax.swing.JTextField employeeIdTxt;
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton mainMenuBtn;
    private javax.swing.JTextField newID;
    private javax.swing.JRadioButton officeBtn;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JPasswordField rePassTxt;
    private javax.swing.JRadioButton receptionistBtn;
    private javax.swing.ButtonGroup rolesGroup;
    private javax.swing.JTextField secondNameTxt;
    private javax.swing.JButton selectUserBtn;
    private javax.swing.JRadioButton shiftBtn;
    private javax.swing.JTextField srchFName;
    private javax.swing.JTextField srchSName;
    private javax.swing.JRadioButton technicianBtn;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
