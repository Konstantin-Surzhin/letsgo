/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.junit.entities;

import org.igo.entities.UserGamePK;
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
public class UserGamePKTest {
    
    public UserGamePKTest() {
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
     * Test of getGameId method, of class UserGamePK.
     */
    @Test
    public void testGetGameId() {
        System.out.println("getGameId");
        UserGamePK instance = new UserGamePK();
        long expResult = 0L;
        long result = instance.getGameId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameId method, of class UserGamePK.
     */
    @Test
    public void testSetGameId() {
        System.out.println("setGameId");
        long gameId = 0L;
        UserGamePK instance = new UserGamePK();
        instance.setGameId(gameId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class UserGamePK.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        UserGamePK instance = new UserGamePK();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class UserGamePK.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        UserGamePK instance = new UserGamePK();
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UserGamePK.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserGamePK instance = new UserGamePK();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UserGamePK.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UserGamePK instance = new UserGamePK();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UserGamePK.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserGamePK instance = new UserGamePK();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
