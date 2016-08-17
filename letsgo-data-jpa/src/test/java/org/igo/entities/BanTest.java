/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import org.igo.entities.Ban;
import org.igo.entities.User;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pl
 */
public class BanTest {
    
    public BanTest() {
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
     * Test of getId method, of class Ban.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Ban instance = new Ban();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Ban.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Ban instance = new Ban();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Ban.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Ban instance = new Ban();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Ban.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Ban instance = new Ban();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Ban.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ban instance = new Ban();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class Ban.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        Ban instance = new Ban();
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class Ban.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        Date startDate = null;
        Ban instance = new Ban();
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDuration method, of class Ban.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        Ban instance = new Ban();
        Short expResult = null;
        Short result = instance.getDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDuration method, of class Ban.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        Short duration = null;
        Ban instance = new Ban();
        instance.setDuration(duration);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComment method, of class Ban.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        Ban instance = new Ban();
        String expResult = "";
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComment method, of class Ban.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        Ban instance = new Ban();
        instance.setComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Ban.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Ban instance = new Ban();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class Ban.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = null;
        Ban instance = new Ban();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
