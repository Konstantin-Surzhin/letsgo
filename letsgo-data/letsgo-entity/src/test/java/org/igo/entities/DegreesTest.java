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
public class DegreesTest {
    
    public DegreesTest() {
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
     * Test of getId method, of class Degree.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Degree instance = new Degree();
        Byte expResult = null;
        Byte result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Degree.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Byte id = null;
        Degree instance = new Degree();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDegreeValue method, of class Degree.
     */
    @Test
    public void testGetDegreeValue() {
        System.out.println("getDegreeValue");
        Degree instance = new Degree();
        String expResult = "";
        String result = instance.getDegreeValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDegreeValue method, of class Degree.
     */
    @Test
    public void testSetDegreeValue() {
        System.out.println("setDegreeValue");
        String degreeValue = "";
        Degree instance = new Degree();
        instance.setDegreeValue(degreeValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersDegreesCollection method, of class Degree.
     */
    @Test
    public void testGetUsersDegreesCollection() {
        System.out.println("getUsersDegreesCollection");
        Degree instance = new Degree();
        Collection<UsersDegrees> expResult = null;
        Collection<UsersDegrees> result = instance.getUsersDegreesCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersDegreesCollection method, of class Degree.
     */
    @Test
    public void testSetUsersDegreesCollection() {
        System.out.println("setUsersDegreesCollection");
        Collection<UsersDegrees> usersDegreesCollection = null;
        Degree instance = new Degree();
        instance.setUsersDegreesCollection(usersDegreesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Degree.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Degree instance = new Degree();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Degree.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Degree instance = new Degree();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Degree.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Degree instance = new Degree();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
