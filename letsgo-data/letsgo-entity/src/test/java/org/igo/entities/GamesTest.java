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
public class GamesTest {
    
    public GamesTest() {
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
     * Test of getId method, of class Games.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Games instance = new Games();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Games.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Games instance = new Games();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBayomeeNumber method, of class Games.
     */
    @Test
    public void testGetBayomeeNumber() {
        System.out.println("getBayomeeNumber");
        Games instance = new Games();
        Short expResult = null;
        Short result = instance.getBayomeeNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBayomeeNumber method, of class Games.
     */
    @Test
    public void testSetBayomeeNumber() {
        System.out.println("setBayomeeNumber");
        Short bayomeeNumber = null;
        Games instance = new Games();
        instance.setBayomeeNumber(bayomeeNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBayomeeTime method, of class Games.
     */
    @Test
    public void testGetBayomeeTime() {
        System.out.println("getBayomeeTime");
        Games instance = new Games();
        Short expResult = null;
        Short result = instance.getBayomeeTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBayomeeTime method, of class Games.
     */
    @Test
    public void testSetBayomeeTime() {
        System.out.println("setBayomeeTime");
        Short bayomeeTime = null;
        Games instance = new Games();
        instance.setBayomeeTime(bayomeeTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGandicap method, of class Games.
     */
    @Test
    public void testGetGandicap() {
        System.out.println("getGandicap");
        Games instance = new Games();
        Short expResult = null;
        Short result = instance.getGandicap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGandicap method, of class Games.
     */
    @Test
    public void testSetGandicap() {
        System.out.println("setGandicap");
        Short gandicap = null;
        Games instance = new Games();
        instance.setGandicap(gandicap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameSize method, of class Games.
     */
    @Test
    public void testGetGameSize() {
        System.out.println("getGameSize");
        Games instance = new Games();
        int expResult = 0;
        int result = instance.getGameSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameSize method, of class Games.
     */
    @Test
    public void testSetGameSize() {
        System.out.println("setGameSize");
        int gameSize = 0;
        Games instance = new Games();
        instance.setGameSize(gameSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameStatus method, of class Games.
     */
    @Test
    public void testGetGameStatus() {
        System.out.println("getGameStatus");
        Games instance = new Games();
        int expResult = 0;
        int result = instance.getGameStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameStatus method, of class Games.
     */
    @Test
    public void testSetGameStatus() {
        System.out.println("setGameStatus");
        int gameStatus = 0;
        Games instance = new Games();
        instance.setGameStatus(gameStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameTime method, of class Games.
     */
    @Test
    public void testGetGameTime() {
        System.out.println("getGameTime");
        Games instance = new Games();
        Short expResult = null;
        Short result = instance.getGameTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameTime method, of class Games.
     */
    @Test
    public void testSetGameTime() {
        System.out.println("setGameTime");
        Short gameTime = null;
        Games instance = new Games();
        instance.setGameTime(gameTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameType method, of class Games.
     */
    @Test
    public void testGetGameType() {
        System.out.println("getGameType");
        Games instance = new Games();
        int expResult = 0;
        int result = instance.getGameType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameType method, of class Games.
     */
    @Test
    public void testSetGameType() {
        System.out.println("setGameType");
        int gameType = 0;
        Games instance = new Games();
        instance.setGameType(gameType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersGamesCollection method, of class Games.
     */
    @Test
    public void testGetUsersGamesCollection() {
        System.out.println("getUsersGamesCollection");
        Games instance = new Games();
        Collection<UsersGames> expResult = null;
        Collection<UsersGames> result = instance.getUsersGamesCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersGamesCollection method, of class Games.
     */
    @Test
    public void testSetUsersGamesCollection() {
        System.out.println("setUsersGamesCollection");
        Collection<UsersGames> usersGamesCollection = null;
        Games instance = new Games();
        instance.setUsersGamesCollection(usersGamesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesCommentsCollection method, of class Games.
     */
    @Test
    public void testGetGamesCommentsCollection() {
        System.out.println("getGamesCommentsCollection");
        Games instance = new Games();
        Collection<GamesComments> expResult = null;
        Collection<GamesComments> result = instance.getGamesCommentsCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesCommentsCollection method, of class Games.
     */
    @Test
    public void testSetGamesCommentsCollection() {
        System.out.println("setGamesCommentsCollection");
        Collection<GamesComments> gamesCommentsCollection = null;
        Games instance = new Games();
        instance.setGamesCommentsCollection(gamesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesMovesCollection method, of class Games.
     */
    @Test
    public void testGetGamesMovesCollection() {
        System.out.println("getGamesMovesCollection");
        Games instance = new Games();
        Collection<GamesMoves> expResult = null;
        Collection<GamesMoves> result = instance.getGamesMovesCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesMovesCollection method, of class Games.
     */
    @Test
    public void testSetGamesMovesCollection() {
        System.out.println("setGamesMovesCollection");
        Collection<GamesMoves> gamesMovesCollection = null;
        Games instance = new Games();
        instance.setGamesMovesCollection(gamesMovesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesDatesCollection method, of class Games.
     */
    @Test
    public void testGetGamesDatesCollection() {
        System.out.println("getGamesDatesCollection");
        Games instance = new Games();
        Collection<GamesDates> expResult = null;
        Collection<GamesDates> result = instance.getGamesDatesCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesDatesCollection method, of class Games.
     */
    @Test
    public void testSetGamesDatesCollection() {
        System.out.println("setGamesDatesCollection");
        Collection<GamesDates> gamesDatesCollection = null;
        Games instance = new Games();
        instance.setGamesDatesCollection(gamesDatesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventId method, of class Games.
     */
    @Test
    public void testGetEventId() {
        System.out.println("getEventId");
        Games instance = new Games();
        Events expResult = null;
        Events result = instance.getEventId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEventId method, of class Games.
     */
    @Test
    public void testSetEventId() {
        System.out.println("setEventId");
        Events eventId = null;
        Games instance = new Games();
        instance.setEventId(eventId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Games.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Games instance = new Games();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Games.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Games instance = new Games();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Games.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Games instance = new Games();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
