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

import org.igo.entities.Game;
import org.igo.entities.UserDetails;
import org.igo.entities.UserGame;
import org.igo.entities.UserGamePK;
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
public class UserGameTest {
    
    public UserGameTest() {
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
     * Test of getUsersGamesPK method, of class UserGame.
     */
    @Test
    public void testGetUsersGamesPK() {
        System.out.println("getUsersGamesPK");
        UserGame instance = new UserGame();
        UserGamePK expResult = null;
        UserGamePK result = instance.getUserGamePK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersGamesPK method, of class UserGame.
     */
    @Test
    public void testSetUsersGamesPK() {
        System.out.println("setUsersGamesPK");
        UserGamePK usersGamesPK = null;
        UserGame instance = new UserGame();
        instance.setUserGamePK(usersGamesPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class UserGame.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        UserGame instance = new UserGame();
        int expResult = 0;
        int result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class UserGame.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        int color = 0;
        UserGame instance = new UserGame();
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGames method, of class UserGame.
     */
    @Test
    public void testGetGames() {
        System.out.println("getGames");
        UserGame instance = new UserGame();
        Game expResult = null;
        Game result = instance.getGames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGames method, of class UserGame.
     */
    @Test
    public void testSetGames() {
        System.out.println("setGames");
        Game games = null;
        UserGame instance = new UserGame();
        instance.setGames(games);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class UserGame.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        UserGame instance = new UserGame();
        UserDetails expResult = null;
        UserDetails result = instance.getUserDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsers method, of class UserGame.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        UserDetails users = null;
        UserGame instance = new UserGame();
        instance.setUserDetails(users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UserGame.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserGame instance = new UserGame();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UserGame.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UserGame instance = new UserGame();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UserGame.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserGame instance = new UserGame();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
