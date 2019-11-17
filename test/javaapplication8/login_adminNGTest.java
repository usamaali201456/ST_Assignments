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
 * @author Hassan Minhas
 */
public class login_adminNGTest {
    String successful, empty,empty1,empty2,wrong,wrong1,wrong2;
    login_admin obj = new login_admin();
    public login_adminNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
         successful = "Successfully logged in";
         empty = "field cannot be empty";
         wrong = "Wrong Password or Username";
         empty1 = "field cannot be empty";
         wrong1 = "Wrong Password or Username";
         empty2 = "field cannot be empty";
         wrong2 = "Wrong Password or Username";
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of main method, of class login_admin.
     */
    
    
    @Test 
    public void testBothEmpty()
    {
        Assert.assertEquals(empty,obj.login("", ""));
    }
    
    @Test 
    public void testUnameEmpty()
    {
        Assert.assertEquals(empty1,obj.login("", "1234"));
    }
    
    @Test 
    public void testPswdEmpty()
    {
        Assert.assertEquals(empty2,obj.login("admin", ""));
    }
    
    @Test 
    public void testwrongUname()
    {
        Assert.assertEquals(wrong,obj.login("a", "1234"));
    }
    
    @Test 
    public void testwrongPswd()
    {
        Assert.assertEquals(wrong1,obj.login("admin", "1"));
    }
    
    @Test 
    public void testwrongBoth()
    {
        Assert.assertEquals(wrong2,obj.login("a", "1"));
    }
    
    @Test 
    public void correct()
    {
        String name = "admin";
        String pswd = "1234";
        Assert.assertEquals(successful,obj.login(name, pswd));
    }
}
