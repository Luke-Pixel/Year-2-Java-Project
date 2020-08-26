/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Control.BackEndControl;
import Control.Controller;
import java.util.LinkedList;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *creates an alert of a new job and sends it to the shift manage if he is logged in
 * @author luke1
 */
public class NewJobAlert extends TimerTask{
    LinkedList<String> newJobs;
    @Override
    public void run() {
        //System.out.println("Checking new Jobs");
        if (Controller.isLogedIn()){
            if(Controller.getUa().getRole().equals("Shift Manager")){
                newJobs = BackEndControl.getNewJobs();
                //System.out.println("Checking new Jobs now");
                    if(newJobs != null){
                        System.out.println("List not empty");
                        System.out.println(newJobs.size());
                        for(int i = 0; i < newJobs.size(); i++){
                            //System.out.println(newJobs.size());
                            //JOptionPane.showMessageDialog(null, "New Job At Reception Job: " + newJobs.get(i),  "Login Failed", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }
}
