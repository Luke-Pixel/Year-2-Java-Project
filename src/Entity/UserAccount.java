/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import bapers.CreateCustomer;
import bapers.NewJob;

/**
 *This class defines the user account that will be extended by
 * the more specific user types
 * @author Luke
 */
public class UserAccount {

    String employee_id;
    String role;

    public UserAccount(String employee_id, String role) {
        this.employee_id = employee_id;
        this.role = role;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public String getRole() {
        return role;
    }

}
