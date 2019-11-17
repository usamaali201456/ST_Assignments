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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author Uzair Rehman
 */
public class Add_CandidateNGTest {
    
    public Add_CandidateNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of main method, of class Add_Candidate.
     */
    @Parameters({ "CNIC","Name","Address","DOB" })
    @Test
    public void testAdd(@Optional("CNIC") String Cnic,@Optional("Name")String name,@Optional("Address")String address,@Optional("DOB")String Dob) {
        System.out.println("main");
        String[] args = null;
        Add_Candidate test=new Add_Candidate();
        test.SetText1(Cnic);
        test.SetText2(name);
        test.SetText3(address);
        test.SetText4(Dob);
        int value=test.Perform();
        Assert.assertEquals(1, value);
    }
    @Parameters({ "CNIC","Name","Address","DOB" })
    @Test
    public void testAddFail(@Optional("CNIC") String Cnic,@Optional("Name")String name,@Optional("Address")String address,@Optional("DOB")String Dob) {
        System.out.println("main");
        String[] args = null;
        Add_Candidate test=new Add_Candidate();
        test.SetText1(Cnic);
        test.SetText2(name);
        test.SetText3(address);
        test.SetText4(Dob);
        int value=test.Perform();
        Assert.assertEquals(0, value);
    
}
}
