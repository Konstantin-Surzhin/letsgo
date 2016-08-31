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
public class UsersBansTest {
    
    public UsersBansTest() {
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
     * Test of getId method, of class UsersBans.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        UsersBans instance = new UsersBans();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class UsersBans.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        UsersBans instance = new UsersBans();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComment method, of class UsersBans.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        UsersBans instance = new UsersBans();
        String expResult = "";
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComment method, of class UsersBans.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        UsersBans instance = new UsersBans();
        instance.setComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDuration method, of class UsersBans.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        UsersBans instance = new UsersBans();
        short expResult = 0;
        short result = instance.getDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDuration method, of class UsersBans.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        short duration = 0;
        UsersBans instance = new UsersBans();
        instance.setDuration(duration);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class UsersBans.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        UsersBans instance = new UsersBans();
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class UsersBans.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        Date startDate = null;
        UsersBans instance = new UsersBans();
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class UsersBans.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        UsersBans instance = new UsersBans();
        User expResult = null;
        User result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class UsersBans.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        User userId = null;
        UsersBans instance = new UsersBans();
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UsersBans.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UsersBans instance = new UsersBans();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UsersBans.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UsersBans instance = new UsersBans();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UsersBans.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UsersBans instance = new UsersBans();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
