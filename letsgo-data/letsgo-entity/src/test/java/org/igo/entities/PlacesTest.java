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
public class PlacesTest {
    
    public PlacesTest() {
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
     * Test of getId method, of class Places.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Places instance = new Places();
        Long expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Places.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        Places instance = new Places();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlaceName method, of class Places.
     */
    @Test
    public void testGetPlaceName() {
        System.out.println("getPlaceName");
        Places instance = new Places();
        String expResult = "";
        String result = instance.getPlaceName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlaceName method, of class Places.
     */
    @Test
    public void testSetPlaceName() {
        System.out.println("setPlaceName");
        String placeName = "";
        Places instance = new Places();
        instance.setPlaceName(placeName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Places.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Places instance = new Places();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Places.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Places instance = new Places();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Places.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Places instance = new Places();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
