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
public class UserDegreeTest {
    
    public UserDegreeTest() {
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
     * Test of getUsersDegreesPK method, of class UserDegree.
     */
    @Test
    public void testGetUsersDegreesPK() {
        System.out.println("getUsersDegreesPK");
        UserDegree instance = new UserDegree();
        UserDegreePK expResult = null;
        UserDegreePK result = instance.getUserDegreePK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersDegreesPK method, of class UserDegree.
     */
    @Test
    public void testSetUsersDegreesPK() {
        System.out.println("setUsersDegreesPK");
        UserDegreePK usersDegreesPK = null;
        UserDegree instance = new UserDegree();
        instance.setUserDegreePK(usersDegreesPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDegreeType method, of class UserDegree.
     */
    @Test
    public void testGetDegreeType() {
        System.out.println("getDegreeType");
        UserDegree instance = new UserDegree();
        Integer expResult = null;
        Integer result = instance.getDegreeType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDegreeType method, of class UserDegree.
     */
    @Test
    public void testSetDegreeType() {
        System.out.println("setDegreeType");
        Integer degreeType = null;
        UserDegree instance = new UserDegree();
        instance.setDegreeType(degreeType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class UserDegree.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        UserDegree instance = new UserDegree();
        User expResult = null;
        User result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsers method, of class UserDegree.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        User users = null;
        UserDegree instance = new UserDegree();
        instance.setUsers(users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDegreeId method, of class UserDegree.
     */
    @Test
    public void testGetDegreeId() {
        System.out.println("getDegreeId");
        UserDegree instance = new UserDegree();
        Degree expResult = null;
        Degree result = instance.getDegreeId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDegreeId method, of class UserDegree.
     */
    @Test
    public void testSetDegreeId() {
        System.out.println("setDegreeId");
        Degree degreeId = null;
        UserDegree instance = new UserDegree();
        instance.setDegreeId(degreeId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UserDegree.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserDegree instance = new UserDegree();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UserDegree.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UserDegree instance = new UserDegree();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UserDegree.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserDegree instance = new UserDegree();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}