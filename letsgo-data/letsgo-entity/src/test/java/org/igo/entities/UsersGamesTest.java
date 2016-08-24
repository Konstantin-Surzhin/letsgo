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
public class UsersGamesTest {
    
    public UsersGamesTest() {
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
     * Test of getUsersGamesPK method, of class UsersGames.
     */
    @Test
    public void testGetUsersGamesPK() {
        System.out.println("getUsersGamesPK");
        UsersGames instance = new UsersGames();
        UsersGamesPK expResult = null;
        UsersGamesPK result = instance.getUsersGamesPK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersGamesPK method, of class UsersGames.
     */
    @Test
    public void testSetUsersGamesPK() {
        System.out.println("setUsersGamesPK");
        UsersGamesPK usersGamesPK = null;
        UsersGames instance = new UsersGames();
        instance.setUsersGamesPK(usersGamesPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class UsersGames.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        UsersGames instance = new UsersGames();
        int expResult = 0;
        int result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class UsersGames.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        int color = 0;
        UsersGames instance = new UsersGames();
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGames method, of class UsersGames.
     */
    @Test
    public void testGetGames() {
        System.out.println("getGames");
        UsersGames instance = new UsersGames();
        Games expResult = null;
        Games result = instance.getGames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGames method, of class UsersGames.
     */
    @Test
    public void testSetGames() {
        System.out.println("setGames");
        Games games = null;
        UsersGames instance = new UsersGames();
        instance.setGames(games);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsers method, of class UsersGames.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        UsersGames instance = new UsersGames();
        Users expResult = null;
        Users result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsers method, of class UsersGames.
     */
    @Test
    public void testSetUsers() {
        System.out.println("setUsers");
        Users users = null;
        UsersGames instance = new UsersGames();
        instance.setUsers(users);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UsersGames.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UsersGames instance = new UsersGames();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UsersGames.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UsersGames instance = new UsersGames();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UsersGames.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UsersGames instance = new UsersGames();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
