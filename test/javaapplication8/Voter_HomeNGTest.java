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
 * @author User 01
 */
public class Voter_HomeNGTest {
    String t1="";
    String t2="";
    String t3="";
    String t4="";
    String t5="";
    Voter_Home obj;
    
    
    public Voter_HomeNGTest() {
    }

    @BeforeClass
    public void beforeclassvoterhome() throws Exception {
        System.out.println("Beforeclass Voter home");
        obj=new Voter_Home();
    }
     @BeforeMethod
    public void beforecastavote() throws Exception {
        System.out.println("Before cast a vote");
        t1="Cast Vote screen displayed successfully";
    }
    
    @Test
    public void testcastavote()
    {
       Assert.assertEquals(t1, obj.CastAvote());
    }
   
    
    @AfterMethod
    public void aftercastavote() throws Exception {
        System.out.println("after cast a vote");
    }
    
     @BeforeMethod
    public void Beforeuserdetails() throws Exception {
        System.out.println("Before userdetails");
        t2="User Details screen displayed successfully";
    }
    
    @Test
    public void testuserdetails()
    {
       Assert.assertEquals(t2, obj.UserDetails());
    }
   
    
    @AfterMethod
    public void afteruserdetails() throws Exception {
        System.out.println("after user details");
    }
    
        @BeforeMethod
    public void Beforechangepass() throws Exception {
        System.out.println("Before cangepassword");
        t3="Change password screen displayed successfully";
    }
    
    @Test
    public void testchangepass()
    {
       Assert.assertEquals(t3, obj.Changepassword());
    }
   
    
    @AfterMethod
    public void afterchangepass() throws Exception {
        System.out.println("after change password");
    }
    
            @BeforeMethod
    public void Beforelogout() throws Exception {
        System.out.println("Before logout");
        t4="Logged out successfully";
    }
    
    @Test
    public void testlogout()
    {
       Assert.assertEquals(t4, obj.logout());
    }
   
    
    @AfterMethod
    public void afterlogout() throws Exception {
        System.out.println("after logout");
    }

                @BeforeMethod
    public void Beforecancel() throws Exception {
        System.out.println("Before cancel");
        t5="Cancelled successfully";
    }
    
    @Test
    public void testcancel()
    {
       Assert.assertEquals(t5, obj.cancelfun());
    }
   
    
    @AfterMethod
    public void aftercancel() throws Exception {
        System.out.println("after cancel");
    }
    
    @AfterClass
    public static void afterclassvoterhome() throws Exception {
        System.out.println("Afterclass Voter home");
    }

   


    /**
     * Test of main method, of class Voter_Home.
     */

    
}
