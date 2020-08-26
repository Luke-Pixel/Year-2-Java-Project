/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Control.BackEndControl;
import java.util.Calendar;
import java.util.TimerTask;

/**
 *Checks to see if any letters need to be generated 
 * @author luke1
 */
public class FirstLetterChecker extends TimerTask{
    Calendar cal; 
    @Override
    public void run() {
        BackEndControl.checkFirstLetter();
    }
    
    
}
