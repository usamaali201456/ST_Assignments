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
public class Candidate extends Person {

  

    String type;

    public Candidate(String type, String id, String name, String dob, String address) {
        super(id, name, dob, address);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
    
  
    
    
    
}
