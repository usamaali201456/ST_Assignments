/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

/**
 *
 * @author DELL 3542
 */
public class Admin {
    
    String name, password;
    public Admin() {
        name = "admin";
        password = "1234";
    }
    
    boolean Login (String Name, String Password)
    {
        if ((Name.equals(this.name)) && (Password.equals(this.password)))
        {
            return true;
        }
        
        return false;
    }
    
}
