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
        instance.sesetUserGamePKsersGamesPK);
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
        User expResult = null;
        User result = instance.getUsers();
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
        User users = null;
        UserGame instance = new UserGame();
        instance.setUsers(users);
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
