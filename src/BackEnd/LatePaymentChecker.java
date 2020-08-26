/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Control.BackEndControl;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

/**
 *checks to see if any payments are overdue
 * @author Luke
 */
public class LatePaymentChecker extends TimerTask{
    Calendar cal ;
    

    //String dayOfMonthStr = String.valueOf(dayOfMonth);
    /**
     * checks to see if any late payments are over 10 days late
     */
    @Override
    public void run() {
         cal = Calendar.getInstance();
         checkLatePayments();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(dayOfMonth);
        if (dayOfMonth == 10){
            checkLatePayments();
        }
    }
    /**
     * checks dates of the various jobs to see if their payments have run
     * over the alloted time
     */
    public void checkLatePayments(){
        
        Calendar calStart = Calendar.getInstance();
        calStart.add(Calendar.MONTH, -1);
        calStart.set(Calendar.DATE, 1);
        Date firstDateOfPreviousMonth = calStart.getTime();
        
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(calStart.getTime());
        
        calEnd.set(Calendar.DATE, calEnd.getActualMaximum(Calendar.DATE)); // changed calendar to cal
        Timestamp start = new Timestamp(calStart.getTimeInMillis());
        Timestamp end = new Timestamp(calEnd.getTimeInMillis());
        Date lastDateOfPreviousMonth = cal.getTime();
        
        System.out.println(start.toString() + " " + end.toString());
        String [] startArray = start.toString().split(" ");
        String [] endArray = end.toString().split(" ");
        BackEndControl.viewLateFirst(startArray[0], endArray[0]);
        
    }
    
}
