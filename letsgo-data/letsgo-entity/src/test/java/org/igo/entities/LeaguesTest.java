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
public class LeaguesTest {
    
    public LeaguesTest() {
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
     * Test of getId method, of class Leagues.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Leagues instance = new Leagues();
        Long expResult = null;
        Short result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Leagues.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Short id = null;
        Leagues instance = new Leagues();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLeagueName method, of class Leagues.
     */
    @Test
    public void testGetLeagueName() {
        System.out.println("getLeagueName");
        Leagues instance = new Leagues();
        String expResult = "";
        String result = instance.getLeagueName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLeagueName method, of class Leagues.
     */
    @Test
    public void testSetLeagueName() {
        System.out.println("setLeagueName");
        String leagueName = "";
        Leagues instance = new Leagues();
        instance.setLeagueName(leagueName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamsCollection method, of class Leagues.
     */
    @Test
    public void testGetTeamsCollection() {
        System.out.println("getTeamsCollection");
        Leagues instance = new Leagues();
        Collection<Teams> expResult = null;
        Collection<Teams> result = instance.getTeamsCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeamsCollection method, of class Leagues.
     */
    @Test
    public void testSetTeamsCollection() {
        System.out.println("setTeamsCollection");
        Collection<Teams> teamsCollection = null;
        Leagues instance = new Leagues();
        instance.setTeamsCollection(teamsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersCollection method, of class Leagues.
     */
    @Test
    public void testGetUsersCollection() {
        System.out.println("getUsersCollection");
        Leagues instance = new Leagues();
        Collection<Users> expResult = null;
        Collection<Users> result = instance.getUsersCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersCollection method, of class Leagues.
     */
    @Test
    public void testSetUsersCollection() {
        System.out.println("setUsersCollection");
        Collection<Users> usersCollection = null;
        Leagues instance = new Leagues();
        instance.setUsersCollection(usersCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Leagues.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Leagues instance = new Leagues();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Leagues.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Leagues instance = new Leagues();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Leagues.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Leagues instance = new Leagues();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
