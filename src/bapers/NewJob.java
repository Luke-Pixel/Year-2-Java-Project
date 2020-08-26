/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;
import Control.*;
import java.awt.Component;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

    /**
     * Creates new form NewJob
     * @param custId
     */
public class NewJob extends javax.swing.JFrame {
       float price = 0;
       double VAT = 0;
       DefaultListModel availModel = new DefaultListModel();
       DefaultListModel selectModel = new DefaultListModel();
       private static String custId;
       ArrayList <String> availTasks = new ArrayList <String>();
       ArrayList <String> selectedTasks = new ArrayList <String>();
       boolean valued;
       LinkedList<String> discData = new LinkedList();
       CalculateDiscounts cd;
       String discType = "";
       boolean surCharge = false;
       boolean extra = false;
       DecimalFormat dec = new DecimalFormat("#0.00");
    /**
     * Creates new form NewJob
     * @param custId
     */
    public NewJob(String custId) {
        initComponents();
        this.custId = custId;
        initialiseLists();
         java.util.Date today = new java.util.Date();
         System.out.println(new java.sql.Timestamp(today.getTime()));
         valued = Controller.checkValued(custId);
         boolean discounted = Controller.checkDiscounted(custId);
         System.out.println("Has Discount: " + discounted);
         if (valued == true && discounted == true){
             discData = Controller.getDiscData(custId);
             cd = new CalculateDiscounts(discData.get(1), this.custId,Integer.parseInt(discData.get(0)));
             discType = discData.get(1);
             System.out.println("VALUED");
         }else{
             valued = false;
         }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalPriceLabel = new javax.swing.JLabel();
        addJobBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        availableTasksList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        addedTasksList = new javax.swing.JList<>();
        twentyFourHours = new javax.swing.JRadioButton();
        sixHours = new javax.swing.JRadioButton();
        threeHours = new javax.swing.JRadioButton();
        custom = new javax.swing.JRadioButton();
        custDeadlineTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        specialInstructions = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jobNum = new javax.swing.JTextField();
        vatTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Create Job");

        jLabel2.setText("Available Tasks:");

        jLabel3.setText("Tasks Added:");

        totalPriceLabel.setText("Sub Total Price:");

        addJobBtn.setText("Add job");
        addJobBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJobBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        availableTasksList.setModel(new DefaultListModel());
        availableTasksList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                availableTasksListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(availableTasksList);

        addedTasksList.setModel(new DefaultListModel());
        addedTasksList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addedTasksListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(addedTasksList);

        buttonGroup1.add(twentyFourHours);
        twentyFourHours.setSelected(true);
        twentyFourHours.setText("24 Hours");
        twentyFourHours.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                twentyFourHoursMousePressed(evt);
            }
        });
        twentyFourHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twentyFourHoursActionPerformed(evt);
            }
        });

        buttonGroup1.add(sixHours);
        sixHours.setText("6 Hours");
        sixHours.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sixHoursMousePressed(evt);
            }
        });

        buttonGroup1.add(threeHours);
        threeHours.setText("3 hours");
        threeHours.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                threeHoursMousePressed(evt);
            }
        });
        threeHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeHoursActionPerformed(evt);
            }
        });

        buttonGroup1.add(custom);
        custom.setText("Custom: (min)");
        custom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                customMousePressed(evt);
            }
        });
        custom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customActionPerformed(evt);
            }
        });

        jLabel4.setText("Deadline:");

        specialInstructions.setColumns(20);
        specialInstructions.setRows(5);
        jScrollPane1.setViewportView(specialInstructions);

        jLabel5.setText("Special Instructions:");

        jLabel6.setText("Job Number: ");

        vatTxt.setText("VAT: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cancelBtn)
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(twentyFourHours)
                                                .addGap(27, 27, 27)
                                                .addComponent(sixHours)
                                                .addGap(18, 18, 18)
                                                .addComponent(threeHours)
                                                .addGap(18, 18, 18)
                                                .addComponent(custom)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(custDeadlineTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel4)))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1)
                                .addGap(14, 14, 14)
                                .addComponent(addJobBtn))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(134, 134, 134)
                                .addComponent(vatTxt)))
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(totalPriceLabel)
                                .addGap(127, 127, 127)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jobNum)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalPriceLabel)
                    .addComponent(jLabel6)
                    .addComponent(jobNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vatTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(twentyFourHours)
                            .addComponent(sixHours)
                            .addComponent(threeHours)
                            .addComponent(custom)
                            .addComponent(cancelBtn)
                            .addComponent(custDeadlineTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addJobBtn)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
/**
 * Closes this form and opens the main menu
 * @param evt 
 */
    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
this.dispose();
Controller.openMainMenu();// TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed
/**
 * Adds the job, consisting of the tasks that have been added
 * @param evt 
 */
    private void addJobBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJobBtnActionPerformed
        
        /*Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if (threeHours.isSelected()){
            calendar.add(Calendar.HOUR, 3);
        }else if (sixHours.isSelected()){
            calendar.add(Calendar.HOUR, 6);
        }else if(twentyFourHours.isSelected()){
            calendar.add(Calendar.DATE, 1);
        }else if(custom.isSelected()){
            //code for custom here
        }
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
        System.out.println(timestamp);
        */
        if (checkSuspended(custId) == false){
            if (selectedTasks.isEmpty()){
                JOptionPane.showMessageDialog(null, "No Tasks Added To Job",  "Empty Job", JOptionPane.ERROR_MESSAGE);
            }else {
                addJob(); 
            }
        }else {
            JOptionPane.showMessageDialog(null, "This Customers Account Has Been Suspended For Late Payments",  "Suspended Account", JOptionPane.ERROR_MESSAGE);
        }
        
        

       // JOptionPane.showMessageDialog(null, "Job Created, Job Number: 22665");
    }//GEN-LAST:event_addJobBtnActionPerformed

    private void twentyFourHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twentyFourHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_twentyFourHoursActionPerformed

    private void customActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customActionPerformed

    private void threeHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_threeHoursActionPerformed
/**
 * gets the position of the mouse in the Available Tasks list and removes the 
 * task (element) there, adding it to the Added Tasks list
 * @param evt 
 */
    private void availableTasksListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_availableTasksListMouseClicked
        JList tasksList = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            int index = tasksList.locationToIndex(evt.getPoint());
            updatePrice(1,index);
            selectTask(availTasks.get(index));
            System.out.println("index: "+index);
            availModel.removeElementAt(index);
            selectedTasks.add(availTasks.get(index));
            availTasks.remove(index);
        } // TODO add your handling code here:
    }//GEN-LAST:event_availableTasksListMouseClicked
/**
 * gets the position of the mouse in the Added Tasks list and removes the 
 * task (element) there, adding it to the Available Tasks list
 * @param evt 
 */
    private void addedTasksListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addedTasksListMouseClicked
       
        JList tasksList = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            int index = tasksList.locationToIndex(evt.getPoint());
            updatePrice(2,index);
            deselectTask(selectedTasks.get(index));
            System.out.println("index: "+index);
            selectModel.removeElementAt(index);
            availTasks.add(selectedTasks.get(index));
            selectedTasks.remove(index);
        }
            
       
        
    }//GEN-LAST:event_addedTasksListMouseClicked
/**
 * If this is selected when the add job button is pressed it will add
 * a surcharge to the cost
 * @param evt 
 */
    private void threeHoursMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threeHoursMousePressed
        if (!threeHours.isSelected()){
            JOptionPane.showMessageDialog(null, "Rushed Jobs of Three Hours, 100% surcharge will be applied at receipt" ,  "Rushed Jobs", JOptionPane.WARNING_MESSAGE);
            
        }
          surCharge = true;
            extra = false;  
        
    }//GEN-LAST:event_threeHoursMousePressed
/**
 * If this is selected when the add job button is pressed it will add
 * a surcharge to the cost
 * @param evt 
 */
    private void sixHoursMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sixHoursMousePressed
       surCharge = false;
    }//GEN-LAST:event_sixHoursMousePressed
/**
 * If this is selected when the add job button is pressed it will add
 * a surcharge to the cost
 * @param evt 
 */
    private void twentyFourHoursMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twentyFourHoursMousePressed
        surCharge = true;
    }//GEN-LAST:event_twentyFourHoursMousePressed
/**
 * If this is selected when the add job button is pressed it will add
 * a surcharge to the cost
 * @param evt 
 */
    private void customMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customMousePressed
        surCharge = true;
            extra = true;
            if (!threeHours.isSelected()){
            JOptionPane.showMessageDialog(null, "Rushed Job, 200% surcharge will be applied at receipt" ,  "Rushed Jobs", JOptionPane.WARNING_MESSAGE);
            }
    }//GEN-LAST:event_customMousePressed
/**
 * this method will initialise the lists on startup of the form
 */
    private void initialiseLists(){
        availModel = (DefaultListModel) availableTasksList.getModel();
        selectModel = (DefaultListModel) addedTasksList.getModel();
        availTasks = Controller.getTaskList();                                   
        for(int i = 0; i < availTasks.size(); i++){
            availModel.addElement(availTasks.get(i));
        }
    }
    /**
     * calculates the VAT that will be applied to the job
     */
    public void updateVat(){
        VAT = price * 0.12;
        System.out.println(VAT);
        System.out.println(price * (20/100));
        vatTxt.setText("VAT: £ " + dec.format(VAT));
    }
    /**
     * adds particular task to the select model (added list)
     * @param task 
     */
    public void selectTask(String task){
        selectModel.addElement(task);
    }
    /**
     * adds particular task to the avail model
     * @param task 
     */
    public void deselectTask(String task){
        availModel.addElement(task);
    }
    
    public void updatePrice(int i, int index){
        if (i == 1){
            
            String task = availTasks.get(index);
            String [] parts = task.split(" ", 2);
            float taskPrice = Controller.getTaskPrice(Integer.parseInt(parts[0]));
            System.out.println(valued);
            System.out.println(discType);
            if (valued == true){
                System.out.println(discType);
                if (discType.equals("Fixed")){
                   float rate = cd.calcFixedDisc();
                    JOptionPane.showMessageDialog(null, "Fixed Discount Of " + rate + "% Applied" ,  "Discount", JOptionPane.WARNING_MESSAGE);
                   taskPrice = taskPrice - (taskPrice *(rate /100));
                }else if (discType.equals("Variable")){
                     float rate = cd.calcVariableDisc();
                     if (rate != 0){
                        JOptionPane.showMessageDialog(null, "Variable Discount Of " + rate + "% Applied" ,  "Discount", JOptionPane.WARNING_MESSAGE);
                     }
                    taskPrice = taskPrice - (taskPrice *(rate /100));
                }else if(discType.equals("Flexible")){
                   float rate = cd.calcFlexDisc(Integer.parseInt(parts[0]));
                   if (rate != 0){
                        JOptionPane.showMessageDialog(null, "Flexible Discount Of " + rate + "% Applied" ,  "Discount", JOptionPane.WARNING_MESSAGE);
                   }
                    taskPrice = taskPrice - (taskPrice *(rate /100));
                }
            }
            price = price + taskPrice;
            
        }else{
            String task = selectedTasks.get(index);
            String [] parts = task.split(" ", 2);
            float taskPrice = Controller.getTaskPrice(Integer.parseInt(parts[0]));
            
            if (valued == true){
                if (discType.equals("Fixed")){
                   float rate = cd.calcFixedDisc();
                   taskPrice = taskPrice - (taskPrice *(rate /100));
                }else if (discType.equals("Flexible")){
                    float rate = cd.calcFlexDisc(Integer.parseInt(parts[0]));
                    taskPrice = taskPrice - (taskPrice *(rate /100));
                }else if(discType.equals("Variable")){
                    float rate = cd.calcVariableDisc();
                    taskPrice = taskPrice - (taskPrice *(rate /100));
                }
            }
            price = price - taskPrice;
            
        }
        totalPriceLabel.setText("Total Price: " + "£" +   dec.format(price));
        System.out.println(price);
        updateVat();
    }
    
    /**
     * Adds the new job into the database 
     */
    public void addTasks(){
        ArrayList <String> taskId = new ArrayList <String>();
        //add tasks into arraylist
        for (int i = 0; i < selectedTasks.size(); i++){
        
        }
    }
    
     /**
     * Adds the new job into the database 
     */
    public void addJob(){
        int priority = 2;
        boolean ready = true;
        if (jobNum.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter a Job Number",  "New Job", JOptionPane.ERROR_MESSAGE);
            ready = false;
        }
        if (custDeadlineTxt.getText().isEmpty() && custom.isSelected()){
            JOptionPane.showMessageDialog(null, "Enter Minutes For Deadline",  "New Job", JOptionPane.ERROR_MESSAGE);
            ready = false;
        }
        if (Controller.checkJobNum(jobNum.getText()) == false){
            if (Controller.checkJobNum(jobNum.getText())){
                JOptionPane.showMessageDialog(null, "Job Number Allready In Use",  "New Job", JOptionPane.ERROR_MESSAGE);
                ready = false;
            }
        }
        
        if(Controller.checkSuspended(custId)== true){
            ready = false;
            JOptionPane.showMessageDialog(null, "This customers account is suspended or in default, No new Jobs can be processed",  "Account Suspended", JOptionPane.ERROR_MESSAGE);
        }
        
        if(ready == true && custom.isSelected()){
            try{
                int custom = Integer.parseInt(custDeadlineTxt.getText());
            }catch(NumberFormatException ex){
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Enter A Valid Custom Deadline","New Job", JOptionPane.ERROR_MESSAGE);
                ready = false;
            }
        }
        float newP = price;
        if (ready == true){
            int result = 0;
            
            if (surCharge == true && extra == false){
                newP = price*2 + (float)VAT*2;
            result = JOptionPane.showConfirmDialog((Component) null, "Rushed Job, Surcharge Added, Total Price: £ " + (newP+VAT) + ", Complete Job Request?",
    "Surcharge", JOptionPane.OK_CANCEL_OPTION);
            }else if (surCharge == true && extra == true){
                float old = price;
                newP = price*3 + (float)VAT *3;
                String parse = String.format("%.2f", newP);
                newP = Float.parseFloat(parse);
                result = JOptionPane.showConfirmDialog((Component) null, "Rushed Job, Surcharge Added, Total Price: £ " + (newP+VAT) + ", Complete Job Request?",
    "Surcharge", JOptionPane.OK_CANCEL_OPTION);
            }
        //get current time
        if (result == 0){
            Calendar calendar = Calendar.getInstance();
            newP = newP + (float)VAT;
      //Determine deadline
            calendar.setTime(new Date());
            if (threeHours.isSelected()){
                calendar.add(Calendar.HOUR, 3);
            }else if (sixHours.isSelected()){
                calendar.add(Calendar.HOUR, 6);
            }else if(twentyFourHours.isSelected()){
                calendar.add(Calendar.DATE, 1);
            }else if(custom.isSelected()){
                calendar.add(Calendar.MINUTE,Integer.parseInt(custDeadlineTxt.getText()) );
                priority = 1;
            }
            Timestamp deadline = new Timestamp(calendar.getTimeInMillis());
            System.out.println(deadline);
            String deadlineString = deadline.toString();
            //remove milliseconds
            String[] deadlineParts = deadlineString.split("\\.",2);
            deadlineString = deadlineParts[0];
            System.out.println(deadlineParts[0] + "other: " + deadlineParts[1]);
            Controller.addJob(jobNum.getText(),deadlineString, price,custId, specialInstructions.getText(), priority, surCharge);
            System.out.println(jobNum.getText());
            addJobTasks(jobNum.getText());
            }
        }
    }
        /**
     * adds the tasks to a particular job, specified by the job ID
     * @param jobID 
     */  
    public void addJobTasks(String jobID){
        boolean result = true;
        for (int i = 0; i < selectedTasks.size(); i++){
            String taskParts [] = selectedTasks.get(i).split(" ");
            int taskID = Integer.parseInt(taskParts[0]); 
            result = Controller.addJobTasks(taskID,jobNum.getText(),custId );
            
        }
        if (result == true){
            
            JOptionPane.showMessageDialog(null, "Job Added Succesfully",  "Job Added", JOptionPane.INFORMATION_MESSAGE);
            Invoice invoice = new Invoice(jobNum.getText(), surCharge, extra);
            invoice.printInvoice();
            
            this.dispose();
            Controller.openMainMenu();
        }else {
            JOptionPane.showMessageDialog(null, "Error Addiing Job",  "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * checks to see if the customer is a Valued Customer
     */
    private void checkValued(){
        
    }
    
    /**
     * 
     * @param custID
     * @return 
     */
    public boolean checkSuspended(String custID){
        return Controller.checkSuspended(custID);
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
            java.util.logging.Logger.getLogger(NewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJob(custId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJobBtn;
    private javax.swing.JList<String> addedTasksList;
    private javax.swing.JList<String> availableTasksList;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField custDeadlineTxt;
    private javax.swing.JRadioButton custom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jobNum;
    private javax.swing.JRadioButton sixHours;
    private javax.swing.JTextArea specialInstructions;
    private javax.swing.JRadioButton threeHours;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JRadioButton twentyFourHours;
    private javax.swing.JLabel vatTxt;
    // End of variables declaration//GEN-END:variables
}
