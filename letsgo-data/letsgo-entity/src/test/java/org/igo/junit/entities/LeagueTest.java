/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.junit.entities;

import java.util.Collection;
import org.igo.entities.League;
import org.igo.entities.Team;
import org.igo.entities.User;
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
public class LeagueTest {
    
    public LeagueTest() {
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
     * Test of getId method, of class League.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        League instance = new League();
        Long expResult = null;
        Short result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class League.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Short id = null;
        League instance = new League();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLeagueName method, of class League.
     */
    @Test
    public void testGetLeagueName() {
        System.out.println("getLeagueName");
        League instance = new League();
        String expResult = "";
        String result = instance.getLeagueName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLeagueName method, of class League.
     */
    @Test
    public void testSetLeagueName() {
        System.out.println("setLeagueName");
        String leagueName = "";
        League instance = new League();
        instance.setLeagueName(leagueName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamsCollection method, of class League.
     */
    @Test
    public void testGetTeamsCollection() {
        System.out.println("getTeamsCollection");
        League instance = new League();
        Collection<Team> expResult = null;
        Collection<Team> result = instance.getTeamsCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeamsCollection method, of class League.
     */
    @Test
    public void testSetTeamsCollection() {
        System.out.println("setTeamsCollection");
        Collection<Team> teamsCollection = null;
        League instance = new League();
        instance.setTeamsCollection(teamsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersCollection method, of class League.
     */
    @Test
    public void testGetUsersCollection() {
        System.out.println("getUsersCollection");
        League instance = new League();
        Collection<User> expResult = null;
        Collection<User> result = instance.getUsersCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersCollection method, of class League.
     */
    @Test
    public void testSetUsersCollection() {
        System.out.println("setUsersCollection");
        Collection<User> usersCollection = null;
        League instance = new League();
        instance.setUsersCollection(usersCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class League.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        League instance = new League();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class League.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        League instance = new League();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class League.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        League instance = new League();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
