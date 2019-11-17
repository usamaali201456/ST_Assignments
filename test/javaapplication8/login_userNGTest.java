/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author zohaib
 */
public class login_userNGTest {
    
    login_user myobj;
    String msg="";
    String msg2="";
    String msg3="";
    String msg4="";
    
    
    public login_userNGTest() {
    }

    @BeforeClass
    public void beforeclaas() throws Exception {
        
         System.out.println("Before class login_user");
        myobj = new login_user();
        
    }
   
  
    @BeforeMethod
    public void beforetestusernameempty() throws Exception 
    {
        System.out.println("Before testusernameempty");
        msg= "Fields cannot be empty... Please write your CNIC and password then try again";
    
    }
   
    @Test
    public void testusernameempty()
    {
       
       Assert.assertEquals(msg, myobj.loginuser("","123123" ));
    }
   
            
      @AfterMethod
    public void aftertestusernameempty() throws Exception {
        
        System.out.println("After testusernameempty");
        
    }
  

      
    @BeforeMethod
    public void beforetestpasswordempty() throws Exception 
    {
        System.out.println("Before testpasswordempty");
        msg= "Fields cannot be empty... Please write your CNIC and password then try again";
    
    }
   
    @Test
    public void testpasswordempty()
    {
       
       Assert.assertEquals(msg, myobj.loginuser("345","" ));
    }
   
            
      @AfterMethod
    public void aftertestpasswordempty() throws Exception {
        
        System.out.println("After testpasswordempty");
        
    }
    
    
    @BeforeMethod
    public void beforetestbothempty() throws Exception 
    {
        System.out.println("Before testbothempty");
        msg= "Fields cannot be empty... Please write your CNIC and password then try again";
    
    }
   
    @Test
    public void testbothempty()
    {
       
       Assert.assertEquals(msg, myobj.loginuser("","" ));
    }
   
            
      @AfterMethod
    public void aftertestbothempty() throws Exception {
        
        System.out.println("After testbothempty");
        
    }
  
        @BeforeMethod
    public void beforetestloginsuccess() throws Exception 
    {
        System.out.println("Before testloginsuccess");
        msg2= "Successfully logged in";
    
    }
   
    @Test
    public void testloginsuccess()
    {
       
       Assert.assertEquals(msg2, myobj.loginuser("345","123123" ));
       
    }
   
            
      @AfterMethod
    public void aftertestloginsuccess() throws Exception {
        
        System.out.println("After testloginsuccess");
        
        
    }
    

    
    @BeforeMethod
    public void beforetestwrongpassword() throws Exception 
    {
        System.out.println("Before testwrongpassword");
        msg3= "Wrong Password or Username!!!!! Please Try again";
    
    }
   
    @Test
    public void testwrongpassword()
    {
       
       Assert.assertEquals(msg3, myobj.loginuser("345","1278" ));
       
    }
   
            
      @AfterMethod
    public void aftertestwrongpassword() throws Exception {
        
        System.out.println("After testwrongpassword");
        
        
    }
    
    
    @BeforeMethod
    public void beforetestwrongusername() throws Exception 
    {
        System.out.println("Before testwrongusername");
        msg3= "Wrong Password or Username!!!!! Please Try again";
    
    }
   
    @Test
    public void testwrongusername()
    {
       
       Assert.assertEquals(msg3, myobj.loginuser("888","123123" ));
       
    }
   
            
      @AfterMethod
    public void aftertestwrongusername() throws Exception {
        
        System.out.println("After testwrongusername");
        
        
    }
    
    

        
    @BeforeMethod
    public void beforetestclickcancel() throws Exception 
    {
        System.out.println("Before testclickcancel");
        msg4= "Cancelled successfully";
    
    }
   
    @Test
    public void testclickcancel()
    {
       
       Assert.assertEquals(msg4, myobj.onClickCancel() );
       
    }
   
            
      @AfterMethod
    public void aftertestclickcancel() throws Exception {
        
        System.out.println("After testclickcancel");
        
        
    }
    
     @AfterClass
    public static void afterclass() throws Exception {
        
        System.out.println("After class login_user"); 
        
    }
    
    
    
    
    
}
