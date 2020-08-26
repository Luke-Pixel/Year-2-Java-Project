/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Control.BackEndControl;
import bapers.BAPERS;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *This class will backup the bapers system
 * @author Luke
 */
public class BackupDatabase {

    public BackupDatabase() {
        getBackup();
    }
    
    
    
    /**
     * Methods gets the backup data based on the input requests of the user
     */
    public void getBackup(){
        String type = BackEndControl.getBackupType();
        System.out.println("getting backup data");
        if(type.equals("Daily")){
            BackEndControl control = BAPERS.getBackEnd();
            control.setupBackup(24);
        }else if(type.equals("Monthly")){
            BackEndControl control = BAPERS.getBackEnd();
            control.setupBackup(731);
        }else if(type.equals("Weekly")){
            BackEndControl control = BAPERS.getBackEnd();
            control.setupBackup(168);
        }
    }
    /**
     * Checks the type of backup before starting it
     * @param s 
     */
    public void nextBackup(String s){
        if (s.equals("Daily")){
            
        }else if(s.equals("Monthly")){
            
        }
    }
}
