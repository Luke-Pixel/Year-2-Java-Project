/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import Control.Controller;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luke
 */
public class DBRestore {

    public DBRestore() {
        main();
    }
    
    
    
    public  void main() {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JButton(new AbstractAction("Load Backup") {

            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(frame, "Test", FileDialog.LOAD);
                fd.setFile("*.sql");
                fd.setVisible(true);
                File newFile = new File(fd.getFile());
                System.out.println(fd.getFile());
                System.out.println(newFile.getAbsolutePath());
                restore(fd.getFile());
            }
        }));
        frame.add(new JButton(new AbstractAction("Main Menu") {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Main Menu clicked");
                frame.hide();
                dispose();
            }
        }));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public  void dispose(){
        
        //Controller.openMainMenu();
    }
    
    public boolean restore(String s){
        try {
            /*NOTE: String s is the mysql file name including the .sql in its name*/
            /*NOTE: Getting path to the Jar file being executed*/
            /*NOTE: YourImplementingClass-> replace with the class executing the code*/
            CodeSource codeSource = DBRestore.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();

            /*NOTE: Creating Database Constraints*/
             String dbName = "bapersdb";
             String dbUser = "root";
             String dbPass = "root";

            /*NOTE: Creating Path Constraints for restoring*/
            String restorePath = jarDir + "\\backup" + "\\" + s;

            /*NOTE: Used to create a cmd command*/
            /*NOTE: Do not create a single large string, this will cause buffer locking, use string array*/
            String[] executeCmd = new String[]{"C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysql", dbName, "-u" + dbUser, "-p" + dbPass, "-e", " source " + restorePath};

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(null, "Successfully restored from SQL: " + s);
                
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Error at restoring");
                return false;
            }


        } catch (URISyntaxException | IOException | InterruptedException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error at Restoredbfromsql: " + ex.getMessage());
            System.out.println(ex.getMessage());
            return false;
        }

        
    }
}
