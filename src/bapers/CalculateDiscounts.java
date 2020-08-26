/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import Control.Controller;
import java.util.LinkedList;

/**
 *
 * @author luke1
 */

//class for the math behind discounts
public class CalculateDiscounts {
    String Type;
    String custID;
    int discountID;
    float previousVolume;
    float taskID;
    float discountRate = 0;

    //constructor for calculating discoutns
    public CalculateDiscounts(String Type, String custID, int discountID) {
        this.Type = Type;
        this.custID = custID;
        this.discountID = discountID;
        
    }
    
    public void calculateDiscount(){
        
    }
    
    //uses discount id (1,2,3) to identify which ine to apply
    public float calcVariableDisc(){
        LinkedList<Float> lower = new LinkedList<Float>();
        LinkedList<Float> upper = new LinkedList<Float>();
        LinkedList<Float> discountRates = new LinkedList<Float>();
        
        lower = Controller.getLowerBounds(discountID);
        upper = Controller.getupperBounds(discountID);
        discountRates = Controller.getDiscountRates(discountID);
        previousVolume = Controller.getPreviousVolume(custID);
        System.out.println(lower.size() + " " + upper.size() + " " + discountRates.size());
        for (int i = 0; i < lower.size(); i++){
            if (lower.get(i)== 0){
                if (previousVolume < upper.get(i)){
                   discountRate = discountRates.get(i);
                }
            }else if(upper.get(i) == 0){
                if(previousVolume > lower.get(i)){
                    discountRate = discountRates.get(i);
                }
            }else if(previousVolume < upper.get(i) && previousVolume > lower.get(i)){
                discountRate = discountRates.get(i);
            }
        }
        return discountRate;
    }
    
    //uses discount id (1,2,3) to identify which ine to apply
    public float calcFlexDisc(int taskID){
        return Controller.getVarRate(taskID, discountID);
    }
    
    //uses discount id (1,2,3) to identify which ine to apply
    public float calcFixedDisc(){
        return discountRate = Controller.getFixedDisc(discountID);
    }
}
