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
public class PlaceTest {
    
    public PlaceTest() {
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
     * Test of getId method, of class Place.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Place instance = new Place();
        Long expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Place.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Place instance = new Place();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlaceName method, of class Place.
     */
    @Test
    public void testGetPlaceName() {
        System.out.println("getPlaceName");
        Place instance = new Place();
        String expResult = "";
        String result = instance.getPlaceName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlaceName method, of class Place.
     */
    @Test
    public void testSetPlaceName() {
        System.out.println("setPlaceName");
        String placeName = "";
        Place instance = new Place();
        instance.setPlaceName(placeName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Place.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Place instance = new Place();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Place.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Place instance = new Place();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Place.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Place instance = new Place();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
