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
public class UserrolesTest {
    
    public UserrolesTest() {
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
     * Test of getId method, of class Userroles.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Userroles instance = new Userroles();
        Short expResult = null;
        Short result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Userroles.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Short id = null;
        Userroles instance = new Userroles();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Userroles.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Userroles instance = new Userroles();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Userroles.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Userroles instance = new Userroles();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserrole method, of class Userroles.
     */
    @Test
    public void testGetUserrole() {
        System.out.println("getUserrole");
        Userroles instance = new Userroles();
        String expResult = "";
        String result = instance.getUserrole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserrole method, of class Userroles.
     */
    @Test
    public void testSetUserrole() {
        System.out.println("setUserrole");
        String userrole = "";
        Userroles instance = new Userroles();
        instance.setUserrole(userrole);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersCollection method, of class Userroles.
     */
    @Test
    public void testGetUsersCollection() {
        System.out.println("getUsersCollection");
        Userroles instance = new Userroles();
        Collection<Users> expResult = null;
        Collection<Users> result = instance.getUsersCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersCollection method, of class Userroles.
     */
    @Test
    public void testSetUsersCollection() {
        System.out.println("setUsersCollection");
        Collection<Users> usersCollection = null;
        Userroles instance = new Userroles();
        instance.setUsersCollection(usersCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Userroles.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Userroles instance = new Userroles();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Userroles.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Userroles instance = new Userroles();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Userroles.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Userroles instance = new Userroles();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}