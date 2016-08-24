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
public class TeamsTest {

    public TeamsTest() {
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
     * Test of getId method, of class Teams.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Teams instance = new Teams();
        Short expResult = null;
        Short result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Teams.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Short id = null;
        Teams instance = new Teams();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamName method, of class Teams.
     */
    @Test
    public void testGetTeamName() {
        System.out.println("getTeamName");
        Teams instance = new Teams();
        String expResult = "";
        String result = instance.getTeamName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeamName method, of class Teams.
     */
    @Test
    public void testSetTeamName() {
        System.out.println("setTeamName");
        String teamName = "";
        Teams instance = new Teams();
        instance.setTeamName(teamName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLeagueId method, of class Teams.
     */
    @Test
    public void testGetLeagueId() {
        System.out.println("getLeagueId");
        Teams instance = new Teams();
        Leagues expResult = null;
        Leagues result = instance.getLeagueId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLeagueId method, of class Teams.
     */
    @Test
    public void testSetLeagueId() {
        System.out.println("setLeagueId");
        Leagues leagueId = null;
        Teams instance = new Teams();
        instance.setLeagueId(leagueId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersCollection method, of class Teams.
     */
    @Test
    public void testGetUsersCollection() {
        System.out.println("getUsersCollection");
        Teams instance = new Teams();
        Collection<Users> expResult = null;
        Collection<Users> result = instance.getUsersCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersCollection method, of class Teams.
     */
    @Test
    public void testSetUsersCollection() {
        System.out.println("setUsersCollection");
        Collection<Users> usersCollection = null;
        Teams instance = new Teams();
        instance.setUsersCollection(usersCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Teams.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Teams instance = new Teams();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Teams.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Teams instance = new Teams();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Teams.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Teams instance = new Teams();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
