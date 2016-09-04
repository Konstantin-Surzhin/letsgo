/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.junit.entities;

import java.util.Collection;
import org.igo.entities.User;
import org.igo.entities.UserRole;
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
public class UserRoleTest {
    
    public UserRoleTest() {
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
     * Test of getId method, of class UserRole.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        UserRole instance = new UserRole();
        Short expResult = null;
        Short result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class UserRole.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Short id = null;
        UserRole instance = new UserRole();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class UserRole.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        UserRole instance = new UserRole();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class UserRole.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        UserRole instance = new UserRole();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserrole method, of class UserRole.
     */
    @Test
    public void testGetUserrole() {
        System.out.println("getUserrole");
        UserRole instance = new UserRole();
        String expResult = "";
        String result = instance.getUserrole();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserrole method, of class UserRole.
     */
    @Test
    public void testSetUserrole() {
        System.out.println("setUserrole");
        String userrole = "";
        UserRole instance = new UserRole();
        instance.setUserrole(userrole);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersCollection method, of class UserRole.
     */
    @Test
    public void testGetUsersCollection() {
        System.out.println("getUsersCollection");
        UserRole instance = new UserRole();
        Collection<User> expResult = null;
        Collection<User> result = instance.getUserCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersCollection method, of class UserRole.
     */
    @Test
    public void testSetUsersCollection() {
        System.out.println("setUsersCollection");
        Collection<User> usersCollection = null;
        UserRole instance = new UserRole();
        instance.setUserCollection(usersCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UserRole.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserRole instance = new UserRole();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UserRole.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UserRole instance = new UserRole();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UserRole.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserRole instance = new UserRole();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
