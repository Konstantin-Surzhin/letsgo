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
import org.igo.entities.Event;
import org.igo.entities.Game;
import org.igo.entities.GameComment;
import org.igo.entities.GameDate;
import org.igo.entities.GameMove;
import org.igo.entities.GameStatus;
import org.igo.entities.GameType;
import org.igo.entities.UserGame;
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
public class GameTest {
    
    public GameTest() {
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
     * Test of getId method, of class Game.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Game instance = new Game();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Game.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Game instance = new Game();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBayomeeNumber method, of class Game.
     */
    @Test
    public void testGetBayomeeNumber() {
        System.out.println("getBayomeeNumber");
        Game instance = new Game();
        short expResult = 0;
        short result = instance.getBayomeeNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBayomeeNumber method, of class Game.
     */
    @Test
    public void testSetBayomeeNumber() {
        System.out.println("setBayomeeNumber");
        short bayomeeNumber = 0;
        Game instance = new Game();
        instance.setBayomeeNumber(bayomeeNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBayomeeTime method, of class Game.
     */
    @Test
    public void testGetBayomeeTime() {
        System.out.println("getBayomeeTime");
        Game instance = new Game();
        short expResult = 0;
        short result = instance.getBayomeeTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBayomeeTime method, of class Game.
     */
    @Test
    public void testSetBayomeeTime() {
        System.out.println("setBayomeeTime");
        short bayomeeTime = 0;
        Game instance = new Game();
        instance.setBayomeeTime(bayomeeTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGandicap method, of class Game.
     */
    @Test
    public void testGetGandicap() {
        System.out.println("getGandicap");
        Game instance = new Game();
        short expResult = 0;
        short result = instance.getGandicap();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGandicap method, of class Game.
     */
    @Test
    public void testSetGandicap() {
        System.out.println("setGandicap");
        short gandicap = 0;
        Game instance = new Game();
        instance.setGandicap(gandicap);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameSize method, of class Game.
     */
    @Test
    public void testGetGameSize() {
        System.out.println("getGameSize");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.getGameSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameSize method, of class Game.
     */
    @Test
    public void testSetGameSize() {
        System.out.println("setGameSize");
        short gameSize = 0;
        Game instance = new Game();
        instance.setGameSize(gameSize);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameStatus method, of class Game.
     */
    @Test
    public void testGetGameStatus() {
        System.out.println("getGameStatus");
        Game instance = new Game();
        GameStatus expResult = null;
        GameStatus result = instance.getGameStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameStatus method, of class Game.
     */
    @Test
    public void testSetGameStatus() {
        System.out.println("setGameStatus");
        GameStatus gameStatus = null;
        Game instance = new Game();
        instance.setGameStatus(gameStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameTime method, of class Game.
     */
    @Test
    public void testGetGameTime() {
        System.out.println("getGameTime");
        Game instance = new Game();
        short expResult = 0;
        short result = instance.getGameTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameTime method, of class Game.
     */
    @Test
    public void testSetGameTime() {
        System.out.println("setGameTime");
        short gameTime = 0;
        Game instance = new Game();
        instance.setGameTime(gameTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameType method, of class Game.
     */
    @Test
    public void testGetGameType() {
        System.out.println("getGameType");
        Game instance = new Game();
        GameType expResult = null;
        GameType result = instance.getGameType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameType method, of class Game.
     */
    @Test
    public void testSetGameType() {
        System.out.println("setGameType");
        GameType gameType = null;
        Game instance = new Game();
        instance.setGameType(gameType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersGamesCollection method, of class Game.
     */
    @Test
    public void testGetUsersGamesCollection() {
        System.out.println("getUsersGamesCollection");
        Game instance = new Game();
        Collection<UserGame> expResult = null;
        Collection<UserGame> result = instance.getUsersGamesCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersGamesCollection method, of class Game.
     */
    @Test
    public void testSetUsersGamesCollection() {
        System.out.println("setUsersGamesCollection");
        Collection<UserGame> usersGamesCollection = null;
        Game instance = new Game();
        instance.setUsersGamesCollection(usersGamesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesCommentsCollection method, of class Game.
     */
    @Test
    public void testGetGamesCommentsCollection() {
        System.out.println("getGamesCommentsCollection");
        Game instance = new Game();
        Collection<GameComment> expResult = null;
        Collection<GameComment> result = instance.getGamesCommentsCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesCommentsCollection method, of class Game.
     */
    @Test
    public void testSetGamesCommentsCollection() {
        System.out.println("setGamesCommentsCollection");
        Collection<GameComment> gamesCommentsCollection = null;
        Game instance = new Game();
        instance.setGamesCommentsCollection(gamesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesMovesCollection method, of class Game.
     */
    @Test
    public void testGetGamesMovesCollection() {
        System.out.println("getGamesMovesCollection");
        Game instance = new Game();
        Collection<GameMove> expResult = null;
        Collection<GameMove> result = instance.getGamesMovesCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesMovesCollection method, of class Game.
     */
    @Test
    public void testSetGamesMovesCollection() {
        System.out.println("setGamesMovesCollection");
        Collection<GameMove> gamesMovesCollection = null;
        Game instance = new Game();
        instance.setGamesMovesCollection(gamesMovesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesDatesCollection method, of class Game.
     */
    @Test
    public void testGetGamesDatesCollection() {
        System.out.println("getGamesDatesCollection");
        Game instance = new Game();
        Collection<GameDate> expResult = null;
        Collection<GameDate> result = instance.getGamesDatesCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesDatesCollection method, of class Game.
     */
    @Test
    public void testSetGamesDatesCollection() {
        System.out.println("setGamesDatesCollection");
        Collection<GameDate> gamesDatesCollection = null;
        Game instance = new Game();
        instance.setGamesDatesCollection(gamesDatesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEventId method, of class Game.
     */
    @Test
    public void testGetEventId() {
        System.out.println("getEventId");
        Game instance = new Game();
        Event expResult = null;
        Event result = instance.getEventId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEventId method, of class Game.
     */
    @Test
    public void testSetEventId() {
        System.out.println("setEventId");
        Event eventId = null;
        Game instance = new Game();
        instance.setEventId(eventId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Game.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Game.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Game.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Game instance = new Game();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
