/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.util.Date;
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
public class GamesDatesTest {
    
    public GamesDatesTest() {
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
     * Test of getGamesDatesPK method, of class GamesDates.
     */
    @Test
    public void testGetGamesDatesPK() {
        System.out.println("getGamesDatesPK");
        GamesDates instance = new GamesDates();
        GamesDatesPK expResult = null;
        GamesDatesPK result = instance.getGamesDatesPK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesDatesPK method, of class GamesDates.
     */
    @Test
    public void testSetGamesDatesPK() {
        System.out.println("setGamesDatesPK");
        GamesDatesPK gamesDatesPK = null;
        GamesDates instance = new GamesDates();
        instance.setGamesDatesPK(gamesDatesPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameDate method, of class GamesDates.
     */
    @Test
    public void testGetGameDate() {
        System.out.println("getGameDate");
        GamesDates instance = new GamesDates();
        Date expResult = null;
        Date result = instance.getGameDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameDate method, of class GamesDates.
     */
    @Test
    public void testSetGameDate() {
        System.out.println("setGameDate");
        Date gameDate = null;
        GamesDates instance = new GamesDates();
        instance.setGameDate(gameDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGames method, of class GamesDates.
     */
    @Test
    public void testGetGames() {
        System.out.println("getGames");
        GamesDates instance = new GamesDates();
        Games expResult = null;
        Games result = instance.getGames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGames method, of class GamesDates.
     */
    @Test
    public void testSetGames() {
        System.out.println("setGames");
        Games games = null;
        GamesDates instance = new GamesDates();
        instance.setGames(games);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class GamesDates.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GamesDates instance = new GamesDates();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class GamesDates.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        GamesDates instance = new GamesDates();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GamesDates.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GamesDates instance = new GamesDates();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
