/*
 * Copyright (C) 2016 surzhin.konstantin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.igo.junit.entities;

import java.util.Collection;
import org.igo.entities.League;
import org.igo.entities.Team;
import org.igo.entities.UserDetails;
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
public class TeamTest {

    public TeamTest() {
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
     * Test of getId method, of class Team.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Team instance = new Team();
        Short expResult = null;
        Short result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Team.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Short id = null;
        Team instance = new Team();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamName method, of class Team.
     */
    @Test
    public void testGetTeamName() {
        System.out.println("getTeamName");
        Team instance = new Team();
        String expResult = "";
        String result = instance.getTeamName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeamName method, of class Team.
     */
    @Test
    public void testSetTeamName() {
        System.out.println("setTeamName");
        String teamName = "";
        Team instance = new Team();
        instance.setTeamName(teamName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLeagueId method, of class Team.
     */
    @Test
    public void testGetLeagueId() {
        System.out.println("getLeagueId");
        Team instance = new Team();
        League expResult = null;
        League result = instance.getLeague();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLeagueId method, of class Team.
     */
    @Test
    public void testSetLeagueId() {
        System.out.println("setLeagueId");
        League leagueId = null;
        Team instance = new Team();
        instance.setLeague(leagueId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersCollection method, of class Team.
     */
    @Test
    public void testGetUsersCollection() {
        System.out.println("getUsersCollection");
        Team instance = new Team();
        Collection<UserDetails> expResult = null;
        Collection<UserDetails> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersCollection method, of class Team.
     */
    @Test
    public void testSetUsersCollection() {
        System.out.println("setUsersCollection");
        Collection<UserDetails> usersCollection = null;
        Team instance = new Team();
        instance.setUsers(usersCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Team.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Team instance = new Team();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Team.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Team instance = new Team();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Team.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Team instance = new Team();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
