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
public class GamesDatesPKTest {
    
    public GamesDatesPKTest() {
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
     * Test of getGameId method, of class GamesDatesPK.
     */
    @Test
    public void testGetGameId() {
        System.out.println("getGameId");
        GamesDatesPK instance = new GamesDatesPK();
        long expResult = 0L;
        long result = instance.getGameId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameId method, of class GamesDatesPK.
     */
    @Test
    public void testSetGameId() {
        System.out.println("setGameId");
        long gameId = 0L;
        GamesDatesPK instance = new GamesDatesPK();
        instance.setGameId(gameId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNdx method, of class GamesDatesPK.
     */
    @Test
    public void testGetNdx() {
        System.out.println("getNdx");
        GamesDatesPK instance = new GamesDatesPK();
        int expResult = 0;
        int result = instance.getNdx();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNdx method, of class GamesDatesPK.
     */
    @Test
    public void testSetNdx() {
        System.out.println("setNdx");
        int ndx = 0;
        GamesDatesPK instance = new GamesDatesPK();
        instance.setNdx(ndx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class GamesDatesPK.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GamesDatesPK instance = new GamesDatesPK();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class GamesDatesPK.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        GamesDatesPK instance = new GamesDatesPK();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GamesDatesPK.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GamesDatesPK instance = new GamesDatesPK();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
