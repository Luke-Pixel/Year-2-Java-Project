/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;
import Control.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author luke1
 */
public class SelectJob extends javax.swing.JFrame {
    ResultSet data; 
    static String custID;
    static String usage;
    /**
     * Creates new form ViewJobStatus
     * @param usage
     * @param custID
     */
    public SelectJob(String custID, String usage) {
        initComponents();
       // data = Controller.viewAllJobs();
        this.custID = custID;
        this.usage = usage;
        if (usage.equals("custPaym")){
            data = Controller.viewCustJobs(custID);
            System.out.println(custID);
            byCustBtn.setSelected(true);
            IndividualRadio.setEnabled(false);
            byCustBtn.setEnabled(false);
            progressRadio.setEnabled(false);
            allJobsRadio.setEnabled(false);
            workNumTxt.setEnabled(false);
            
            updateTaskBtn.setEnabled(false);
            //waiting.setEnabled(false);
            complete.setEnabled(false);
            jRadioButton1.setEnabled(false);
        }else{
            data = Controller.viewAllJobs();
        }
        updateTable();
        
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        workNumTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jobTable = new javax.swing.JTable();
        updateTaskBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jRadioButton1 = new javax.swing.JRadioButton();
        complete = new javax.swing.JRadioButton();
        allJobsRadio = new javax.swing.JRadioButton();
        progressRadio = new javax.swing.JRadioButton();
        jSeparator3 = new javax.swing.JSeparator();
        IndividualRadio = new javax.swing.JRadioButton();
        jobNum = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        byCustBtn = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Work ID: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Jobs");

        jobTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Number", "Work ID", "Current Shelf", "Work Descripton", "Special Instructions", "Department", "Work Status", "Late", "Job Deadlinne", "Rushed job", "Shelf On Finish"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jobTable);

        updateTaskBtn.setText("Update Status");
        updateTaskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTaskBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Close");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Work In progress");

        buttonGroup1.add(complete);
        complete.setText("Work Complete");
        complete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeActionPerformed(evt);
            }
        });

        buttonGroup2.add(allJobsRadio);
        allJobsRadio.setSelected(true);
        allJobsRadio.setText("All Jobs");
        allJobsRadio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                allJobsRadioMousePressed(evt);
            }
        });

        buttonGroup2.add(progressRadio);
        progressRadio.setText("In Progress");
        progressRadio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                progressRadioMousePressed(evt);
            }
        });
        progressRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progressRadioActionPerformed(evt);
            }
        });

        buttonGroup2.add(IndividualRadio);
        IndividualRadio.setText("Individual Job");
        IndividualRadio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                IndividualRadioMousePressed(evt);
            }
        });
        IndividualRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IndividualRadioActionPerformed(evt);
            }
        });

        jobNum.setEnabled(false);
        jobNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobNumActionPerformed(evt);
            }
        });

        jButton1.setText("Search Job");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(byCustBtn);
        byCustBtn.setText("By Customer");
        byCustBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                byCustBtnMousePressed(evt);
            }
        });
        byCustBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                byCustBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cancelBtn)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(workNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(complete)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateTaskBtn)))
                        .addGap(1007, 1007, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(allJobsRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IndividualRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(byCustBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jobNum, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(IndividualRadio)
                        .addComponent(byCustBtn)
                        .addComponent(jobNum, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(allJobsRadio)
                        .addComponent(progressRadio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(workNumTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(complete)
                    .addComponent(updateTaskBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
this.dispose();
Controller.openMainMenu();// TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void updateTaskBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTaskBtnActionPerformed

        if (jRadioButton1.isSelected()){
            setInProgress();
        }else if(complete.isSelected() ){
            setComplete();
        }
        refreshTable();
        
    }//GEN-LAST:event_updateTaskBtnActionPerformed

    private void progressRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progressRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_progressRadioActionPerformed

    private void completeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_completeActionPerformed

    private void jobNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobNumActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String id = jobNum.getText();
        IndividualRadio.setSelected(true);
        if (id.equals("")){
            JOptionPane.showMessageDialog(null, "Enter a job number",  "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            
                data = Controller.searchJob(jobNum.getText());
                updateTable();
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void progressRadioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_progressRadioMousePressed
        jobNum.setEnabled(false);  
        jButton1.setEnabled(false);
        System.out.println("clicked");  
        data = Controller.viewInProgress();
        updateTable();
    }//GEN-LAST:event_progressRadioMousePressed

    private void allJobsRadioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allJobsRadioMousePressed
        jobNum.setEnabled(false);  
        jButton1.setEnabled(false);
        System.out.println("clicked");  
        data = Controller.viewAllJobs();
        updateTable();
    }//GEN-LAST:event_allJobsRadioMousePressed

    private void byCustBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_byCustBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_byCustBtnActionPerformed

    private void byCustBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_byCustBtnMousePressed
        jobNum.setEnabled(true);
        jButton1.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_byCustBtnMousePressed

    private void IndividualRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IndividualRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IndividualRadioActionPerformed

    private void IndividualRadioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IndividualRadioMousePressed
        jobNum.setEnabled(true);
        jButton1.setEnabled(true);
    }//GEN-LAST:event_IndividualRadioMousePressed
    
    private void refreshTable(){
        if(allJobsRadio.isSelected()){
            data = Controller.viewAllJobs();
            updateTable();
        }else if(progressRadio.isSelected()){
            data = Controller.viewInProgress();
            updateTable();
        }
    }
    
    public void updateTable(){
        
        DefaultTableModel tableModel = (DefaultTableModel) jobTable.getModel();
        tableModel.setRowCount(0);
        try{
            while (data.next()){
                String jobNum =  data.getString("job_number");
                String wordID =  Integer.toString(data.getInt("Job_TaskID"));
                String shelf = data.getString("current_shelf");
                String description = data.getString("task_description");
                String specialInstructions = data.getString("special_instructions");
                String department = data.getString("location");
                String status = data.getString("state");
                boolean lateBool = data.getBoolean("late");
                String finishShelf = data.getString("shelfSlot");
                String late = "";
                int rushed = data.getInt("rushed");
                String rushString = "";
                if(rushed == 0){
                    rushString = "N0";
                }else {
                    rushString = "YES";
                }
                        
                if (lateBool == true){
                    late = "YES";
                }else{
                    late = "NO";
                }
                String deadline = data.getString("deadline");
                tableModel.addRow(new Object [] {jobNum, wordID, shelf, description, specialInstructions, department,status, late, deadline,rushString, finishShelf});
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void setInProgress(){
        String shiftType = "";
        Calendar calendar = Calendar.getInstance();    
        Timestamp start = new Timestamp(calendar.getTimeInMillis());
        System.out.println(start);
        String startString = start.toString();   
        try{
        String string2 = "14:30:00";
            Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);
            calendar2.add(Calendar.DATE, 1);

            String someRandomTime = "22:00:00";
            Date d = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(d);
            calendar3.add(Calendar.DATE, 1);  
        
            String string3 = "05:00:00";
            Date time3 = new SimpleDateFormat("HH:mm:ss").parse(string3);
            Calendar calendar4 = Calendar.getInstance();
            calendar4.setTime(time3);
            calendar4.add(Calendar.DATE, 1);

            String someRandomTime2 = "14:30:00";
            Date d2 = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime2);
            Calendar calendar5 = Calendar.getInstance();
            calendar5.setTime(d2);
            calendar5.add(Calendar.DATE, 1);  
            
            String someRandomTime3 = "00:00:00";
            Date d3 = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime3);
            Calendar calendar7 = Calendar.getInstance();
            calendar7.setTime(d3);
            calendar7.add(Calendar.DATE, 1);
        
            String someRandomTime6 = "24:00:00";
            Date midnight = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime3);
            Calendar calendar8 = Calendar.getInstance();
            calendar8.setTime(midnight);
            calendar8.add(Calendar.DATE, 1);
            
            Calendar calendarNew = Calendar.getInstance();    
            //Date x = calendarNew.getTime();
            String timeParts [] = startString.split(" ");
            String timeParts2 [] = timeParts[1].split("\\.");
            
            Date x = new SimpleDateFormat("HH:mm:ss").parse(timeParts2[0]);
            calendarNew.setTime(x);
            calendarNew.add(Calendar.DATE, 1);
            
            System.out.println( "current: " + x.getTime());
            System.out.println(calendar2.getTime());
            System.out.println(calendar5.getTime());
            System.out.println(calendar3.getTime());
            System.out.println(calendar4.getTime());
            System.out.println(calendarNew.getTime());
            System.out.println(calendarNew.getTime().after(calendar2.getTime()) && x.before(calendar3.getTime()));
        if (calendarNew.getTime().after(calendar2.getTime()) && calendarNew.getTime().before(calendar3.getTime())) {
        //checkes whether the current time is between 14:49:00 and 20:11:13.
            shiftType = "DAY 2";
            System.out.println(true);
        }else if (calendarNew.getTime().after(calendar4.getTime()) && calendarNew.getTime().before(calendar5.getTime())) {
            //checkes whether the current time is between 14:49:00 and 20:11:13.
            shiftType = "DAY 1";
            System.out.println(true);
        }else {
            //checkes whether the current time is between 14:49:00 and 20:11:13.
            shiftType = "NIGHT 1";
            System.out.println(true);
        }
            System.out.println("Current Shift: " + shiftType);
        }catch (ParseException ex){
            System.out.println(ex.getMessage());
        }
        int id = 0;
        boolean invalid = false;
        try{
            id = Integer.parseInt(workNumTxt.getText());
        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Invalid Job Number Format",  "Error", JOptionPane.ERROR_MESSAGE);
            invalid = true;
        }
        if (!invalid){
            boolean result = Controller.setWorkActice(id, startString, shiftType);
            if(!result){
                JOptionPane.showMessageDialog(null, "Invalid Work Number",  "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Work Updatated",  "Updated", JOptionPane.INFORMATION_MESSAGE);
                
            }
        }        
    }
    
    public void setComplete(){
        if (workNumTxt.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Enter work number",  "Updated", JOptionPane.INFORMATION_MESSAGE);
        }else{
            Calendar calendar = Calendar.getInstance();    
            Timestamp end = new Timestamp(calendar.getTimeInMillis());
            System.out.println(end);
            String endString = end.toString();    
            
            String startString = Controller.getStartTiume(Integer.parseInt(workNumTxt.getText()));
            System.out.println(startString);
            Timestamp start = null;
            boolean failed = false;
            try{
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:SS");
                Date parsedDate = dateFormat.parse(startString);
                start = new Timestamp(parsedDate.getTime());
            }catch (ParseException ex){
                System.out.println(ex.getMessage());
                failed = true;
            }
            int mins = 0;
            if (!failed){
                long milliseconds = end.getTime() - start.getTime();
                System.out.println(milliseconds);
                int secs = (int) milliseconds/1000;
                System.out.println(secs);
                mins = (secs % 3600) / 60;
                System.out.println(mins);
            }
            
            boolean result = Controller.setWorkEnd(Integer.parseInt(workNumTxt.getText()), endString,mins);
            if (result == true){
                JOptionPane.showMessageDialog(null, "Work Updatated",  "Updated", JOptionPane.INFORMATION_MESSAGE);
                Controller.setcurrentShelf(Integer.parseInt(workNumTxt.getText()));
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Work Number",  "Error", JOptionPane.ERROR_MESSAGE);
            } 
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
            java.util.logging.Logger.getLogger(SelectJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectJob(custID, usage).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton IndividualRadio;
    private javax.swing.JRadioButton allJobsRadio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton byCustBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JRadioButton complete;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jobNum;
    private javax.swing.JTable jobTable;
    private javax.swing.JRadioButton progressRadio;
    private javax.swing.JButton updateTaskBtn;
    private javax.swing.JTextField workNumTxt;
    // End of variables declaration//GEN-END:variables
}