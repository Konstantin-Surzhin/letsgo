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
public class UsersDegreesTest {
    
    public UsersDegreesTest() {
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
     * Test of getUsersDegreesPK method, of class UsersDegrees.
     */
    @Test
    public void testGetUsersDegreesPK() {
        System.out.println("getUsersDegreesPK");
        UsersDegrees instance = new UsersDegrees();
        UsersDegreesPK expResult = null;
        UsersDegreesPK result = instance.getUsersDegreesPK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersDegreesPK method, of class UsersDegrees.
     */
    @Test
    public void testSetUsersDegreesPK() {
        System.out.println("setUsersDegreesPK");
        UsersDegreesPK usersDegreesPK = null;
        UsersDegrees instance = new UsersDegrees();
        instance.setUsersDegreesPK(usersDegreesPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDegreeType method, of class UsersDegrees.
     */
    @Test
    public void testGetDegreeType() {
        System.out.println("getDegreeType");
        UsersDegrees instance = new UsersDegrees();
        Integer expResult = null;
        Integer result = instance.getDegreeType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDegreeType method, of class UsersDegrees.
     */
    @Test
    public void testSetDegreeType() {
        System.out.println("setDegreeType");
        Integer degreeType = null;
        UsersDegrees instance = new UsersDegrees();
        instance.setDegreeType(degreeType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class UsersDegrees.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        UsersDegrees instance = new UsersDegrees();
        Users expResult = null;
        Users result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsers method, of class UsersDegrees.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        Users users = null;
        UsersDegrees instance = new UsersDegrees();
        instance.setUsers(users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDegreeId method, of class UsersDegrees.
     */
    @Test
    public void testGetDegreeId() {
        System.out.println("getDegreeId");
        UsersDegrees instance = new UsersDegrees();
        Degrees expResult = null;
        Degrees result = instance.getDegreeId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDegreeId method, of class UsersDegrees.
     */
    @Test
    public void testSetDegreeId() {
        System.out.println("setDegreeId");
        Degrees degreeId = null;
        UsersDegrees instance = new UsersDegrees();
        instance.setDegreeId(degreeId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UsersDegrees.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UsersDegrees instance = new UsersDegrees();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UsersDegrees.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UsersDegrees instance = new UsersDegrees();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UsersDegrees.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UsersDegrees instance = new UsersDegrees();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
