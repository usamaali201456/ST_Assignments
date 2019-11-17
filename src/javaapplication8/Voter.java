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
public class Voter extends Person {
    
    
    private String password;

    public Voter( String password, String id, String name, String dob, String address) {
        super(id, name, dob, address);
        
        this.password = password;
    }

   

    public String getPassword() {
        return password;
    }

   

    public void setPassword(String password) {
        this.password = password;
    }

   
    
    
    
    
}
