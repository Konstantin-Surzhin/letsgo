/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.util.Collection;
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
public class EventsTest {
    
    public EventsTest() {
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
     * Test of getId method, of class Events.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Events instance = new Events();
        Long expResult = null;
        Short result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Events.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Short id = null;
        Events instance = new Events();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventName method, of class Events.
     */
    @Test
    public void testGetEventName() {
        System.out.println("getEventName");
        Events instance = new Events();
        String expResult = "";
        String result = instance.getEventName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEventName method, of class Events.
     */
    @Test
    public void testSetEventName() {
        System.out.println("setEventName");
        String eventName = "";
        Events instance = new Events();
        instance.setEventName(eventName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesCollection method, of class Events.
     */
    @Test
    public void testGetGamesCollection() {
        System.out.println("getGamesCollection");
        Events instance = new Events();
        Collection<Games> expResult = null;
        Collection<Games> result = instance.getGamesCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesCollection method, of class Events.
     */
    @Test
    public void testSetGamesCollection() {
        System.out.println("setGamesCollection");
        Collection<Games> gamesCollection = null;
        Events instance = new Events();
        instance.setGamesCollection(gamesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Events.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Events instance = new Events();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Events.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Events instance = new Events();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Events.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Events instance = new Events();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
