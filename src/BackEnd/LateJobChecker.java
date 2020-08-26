///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package BackEnd;
//
import Control.BackEndControl;
import java.awt.Component;
import java.util.LinkedList;
import java.util.TimerTask;
import javax.swing.JOptionPane;
//
///**
// *class to check if a job is late
// * @author Luke
// */
public class LateJobChecker extends TimerTask{
    LinkedList <String> late = new LinkedList<String>();
    /**
     * if a job is found late its status will be set to be late
     */
 public void run() {
       System.out.println("setting late jobs"); 
       BackEndControl.setLateJobs();
       //okcancel("Test");
       
    }
 

   
   
}

//// And From your main() method or any other method


