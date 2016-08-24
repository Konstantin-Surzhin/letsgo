/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author surzhin.konstantin
 */
public class UsersDegreesPKTest {
    
    public UsersDegreesPKTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAppointmentDate method, of class UsersDegreesPK.
     */
    @Test
    public void testGetAppointmentDate() {
        System.out.println("getAppointmentDate");
        UsersDegreesPK instance = new UsersDegreesPK();
        Date expResult = null;
        Date result = instance.getAppointmentDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppointmentDate method, of class UsersDegreesPK.
     */
    @Test
    public void testSetAppointmentDate() {
        System.out.println("setAppointmentDate");
        Date appointmentDate = null;
        UsersDegreesPK instance = new UsersDegreesPK();
        instance.setAppointmentDate(appointmentDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class UsersDegreesPK.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        UsersDegreesPK instance = new UsersDegreesPK();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class UsersDegreesPK.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        UsersDegreesPK instance = new UsersDegreesPK();
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UsersDegreesPK.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UsersDegreesPK instance = new UsersDegreesPK();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UsersDegreesPK.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UsersDegreesPK instance = new UsersDegreesPK();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UsersDegreesPK.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UsersDegreesPK instance = new UsersDegreesPK();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
