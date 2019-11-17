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
public class loggedIn {
    
    private static loggedIn logg;
    String id;
    
   private loggedIn ()
    {
        
    }
   
   public static loggedIn getInstance()
   {
       if (logg == null)
           logg = new loggedIn();
       
       return logg;
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
   
    public void setNull ()
    {
        id = null;
    }
   
    
}
