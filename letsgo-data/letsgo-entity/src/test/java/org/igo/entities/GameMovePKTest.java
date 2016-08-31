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
public class GameMovePKTest {
    
    public GameMovePKTest() {
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
     * Test of getGameId method, of class GameMovePK.
     */
    @Test
    public void testGetGameId() {
        System.out.println("getGameId");
        GameMovePK instance = new GameMovePK();
        long expResult = 0L;
        long result = instance.getGameId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameId method, of class GameMovePK.
     */
    @Test
    public void testSetGameId() {
        System.out.println("setGameId");
        long gameId = 0L;
        GameMovePK instance = new GameMovePK();
        instance.setGameId(gameId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNdx method, of class GameMovePK.
     */
    @Test
    public void testGetNdx() {
        System.out.println("getNdx");
        GameMovePK instance = new GameMovePK();
        int expResult = 0;
        int result = instance.getNdx();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNdx method, of class GameMovePK.
     */
    @Test
    public void testSetNdx() {
        System.out.println("setNdx");
        int ndx = 0;
        GameMovePK instance = new GameMovePK();
        instance.setNdx(ndx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class GameMovePK.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GameMovePK instance = new GameMovePK();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class GameMovePK.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        GameMovePK instance = new GameMovePK();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GameMovePK.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GameMovePK instance = new GameMovePK();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
