/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.junit.entities;

import java.util.Date;
import org.igo.entities.Game;
import org.igo.entities.GameDate;
import org.igo.entities.GameDatePK;
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
public class GameDateTest {
    
    public GameDateTest() {
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
     * Test of getGameDatePK method, of class GameDate.
     */
    @Test
    public void testGetGameDatePK() {
        System.out.println("getGameDatePK");
        GameDate instance = new GameDate();
        GameDatePK expResult = null;
        GameDatePK result = instance.getGameDatePK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameDatePK method, of class GameDate.
     */
    @Test
    public void testSetGameDatePK() {
        System.out.println("setGameDatePK");
        GameDatePK gamesDatesPK = null;
        GameDate instance = new GameDate();
        instance.setGameDatePK(gamesDatesPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameDate method, of class GameDate.
     */
    @Test
    public void testGetGameDate() {
        System.out.println("getGameDate");
        GameDate instance = new GameDate();
        Date expResult = null;
        Date result = instance.getGameDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameDate method, of class GameDate.
     */
    @Test
    public void testSetGameDate() {
        System.out.println("setGameDate");
        Date gameDate = null;
        GameDate instance = new GameDate();
        instance.setGameDate(gameDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGames method, of class GameDate.
     */
    @Test
    public void testGetGames() {
        System.out.println("getGames");
        GameDate instance = new GameDate();
        Game expResult = null;
        Game result = instance.getGame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGames method, of class GameDate.
     */
    @Test
    public void testSetGames() {
        System.out.println("setGames");
        Game games = null;
        GameDate instance = new GameDate();
        instance.setGame(games);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class GameDate.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GameDate instance = new GameDate();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class GameDate.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        GameDate instance = new GameDate();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GameDate.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GameDate instance = new GameDate();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
