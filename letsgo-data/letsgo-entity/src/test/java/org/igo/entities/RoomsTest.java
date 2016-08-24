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
public class RoomsTest {

    public RoomsTest() {
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
     * Test of getId method, of class Rooms.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Rooms instance = new Rooms();
        Short expResult = null;
        Short result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Rooms.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
         Short id = null;
        Rooms instance = new Rooms();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomName method, of class Rooms.
     */
    @Test
    public void testGetRoomName() {
        System.out.println("getRoomName");
        Rooms instance = new Rooms();
        String expResult = "";
        String result = instance.getRoomName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoomName method, of class Rooms.
     */
    @Test
    public void testSetRoomName() {
        System.out.println("setRoomName");
        String roomName = "";
        Rooms instance = new Rooms();
        instance.setRoomName(roomName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersCollection method, of class Rooms.
     */
    @Test
    public void testGetUsersCollection() {
        System.out.println("getUsersCollection");
        Rooms instance = new Rooms();
        Collection<Users> expResult = null;
        Collection<Users> result = instance.getUsersCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersCollection method, of class Rooms.
     */
    @Test
    public void testSetUsersCollection() {
        System.out.println("setUsersCollection");
        Collection<Users> usersCollection = null;
        Rooms instance = new Rooms();
        instance.setUsersCollection(usersCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Rooms.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Rooms instance = new Rooms();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Rooms.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Rooms instance = new Rooms();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Rooms.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Rooms instance = new Rooms();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
