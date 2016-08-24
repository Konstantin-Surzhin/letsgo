/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

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
public class UsersGamesPKTest {
    
    public UsersGamesPKTest() {
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
     * Test of getGameId method, of class UsersGamesPK.
     */
    @Test
    public void testGetGameId() {
        System.out.println("getGameId");
        UsersGamesPK instance = new UsersGamesPK();
        long expResult = 0L;
        long result = instance.getGameId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameId method, of class UsersGamesPK.
     */
    @Test
    public void testSetGameId() {
        System.out.println("setGameId");
        long gameId = 0L;
        UsersGamesPK instance = new UsersGamesPK();
        instance.setGameId(gameId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class UsersGamesPK.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        UsersGamesPK instance = new UsersGamesPK();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class UsersGamesPK.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        UsersGamesPK instance = new UsersGamesPK();
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UsersGamesPK.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UsersGamesPK instance = new UsersGamesPK();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UsersGamesPK.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UsersGamesPK instance = new UsersGamesPK();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UsersGamesPK.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UsersGamesPK instance = new UsersGamesPK();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
