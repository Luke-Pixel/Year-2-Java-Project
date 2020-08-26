/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Luke
 */
public class DBBackup extends TimerTask{
   
    public void run(){
        backup();
    }
    
    public boolean backup(){
        try {

            /*NOTE: Getting path to the Jar file being executed*/
            CodeSource codeSource = DBBackup.class.getProtectionDomain().getCodeSource();
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();
            System.out.println(jarDir);

            /*NOTE: Creating Database Constraints*/
            String dbName = "bapersdb";
            String dbUser = "root";
            String dbPass = "root";

            /*NOTE: Creating Path Constraints for folder saving*/
            /*NOTE: Here the backup folder is created for saving inside it*/
            String folderPath = jarDir + "\\backup";

            /*NOTE: Creating Folder if it does not exist*/
            File f1 = new File(folderPath);
            f1.mkdir();

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            System.out.println(timeStamp.toString());
            /*NOTE: Creating Path Constraints for backup saving*/
            /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
            String savePath = "\"" + jarDir + "\\backup\\" + timeStamp.toString() + "backup.sql\"";
            System.out.println(savePath);
            /*NOTE: Used to create a cmd command*/
            String executeCmd2 = "C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump -h localhost -u root -p root bapersdb > " + savePath + "root";
            String executeCmd = "C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump -u" + dbUser + " -p" + dbPass + " --databases " + dbName + " -r " + savePath;
            System.out.println(executeCmd);
            System.out.println(executeCmd2);
            /*NOTE: Executing the command here*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            //runtimeProcess = Runtime.getRuntime().exec("root");
            int processComplete = runtimeProcess.waitFor();

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                System.out.println("Backup Complete");
                JOptionPane.showMessageDialog(null, "Databas Backup Completed");
                return true;
            } else {
                System.out.println("Backup Failure");
                return false;
            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error at Backuprestore: " + ex.getMessage());
            return false;
        }
    }
}
