/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author Hp
 */
public class Add_VoterNGTest {
    
    Add_Voter addvoter;
    
   

  @BeforeClass
    public void BeforeClass() throws Exception {
        
         System.out.println("Before class Adding_voter");
        addvoter = new Add_Voter();
     
    }
    
      @BeforeMethod
    public void beforetestanyfieldempty() throws Exception 
    {
        System.out.println("Before test fieldempty");
    
    }
    
    @Test
	@Parameters({ "CNIC","Name","Address","DOB" })
    public void testfieldempty(String C,String N,String A,String D) {
        
        addvoter.SetText1(C);
        addvoter.SetText2(N);
        addvoter.SetText3(A);
       addvoter.SetText4(D);
        int testvalue=addvoter.AddVoter();
        Assert.assertEquals(0, testvalue);// will return unsuccessful as field missing
        
    }
      @AfterMethod
    public void aftertestanyfieldempty() throws Exception {
        
        System.out.println("After test field empty");
        
    }
	
    
    @BeforeMethod
    public void beforetestvoteradd() throws Exception 
    {
        System.out.println("Before test voter added");
    
    }
    
    @Test
	@Parameters({ "CNIC","Name","Address","DOB" })
    public void testsuccesful(String C,String N,String A,String D) {
        
         addvoter.SetText1(C);
        addvoter.SetText2(N);
        addvoter.SetText3(A);
       addvoter.SetText4(D);
        int testvalue=addvoter.AddVoter();
        Assert.assertEquals(1, testvalue);// return successful when Add Successful
        
    }
      @AfterMethod
    public void aftertestvoteradded() throws Exception {
        
        System.out.println("After test voter added");
        
    }
    
    
     @BeforeMethod
    public void beforetestalreadyexist() throws Exception 
    {
        System.out.println("Before test voter already exist");
    
    }
    
    @Test
	@Parameters({ "CNIC","Name","Address","DOB" })
    public void testAlreadyexist(String C,String N,String A,String D) {
        
        addvoter.SetText1(C);
       addvoter.SetText2(N);
       addvoter.SetText3(A);
       addvoter.SetText4(D);
        int testvalue=addvoter.AddVoter();
        Assert.assertEquals(0, testvalue);// return unsuccessful as voter already exist
        
    }
      @AfterMethod
    public void aftertestalreadyexist() throws Exception {
        
        System.out.println("After test voter already exist");
        
    }
 
    
    @AfterClass
    public static void AfterClass() throws Exception {
        
        System.out.println("After class Adding_Voter"); 
        
    }
}
