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
public class GamesMovesTest {
    
    public GamesMovesTest() {
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
     * Test of getGamesMovesPK method, of class GamesMoves.
     */
    @Test
    public void testGetGamesMovesPK() {
        System.out.println("getGamesMovesPK");
        GamesMoves instance = new GamesMoves();
        GamesMovesPK expResult = null;
        GamesMovesPK result = instance.getGamesMovesPK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesMovesPK method, of class GamesMoves.
     */
    @Test
    public void testSetGamesMovesPK() {
        System.out.println("setGamesMovesPK");
        GamesMovesPK gamesMovesPK = null;
        GamesMoves instance = new GamesMoves();
        instance.setGamesMovesPK(gamesMovesPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class GamesMoves.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        GamesMoves instance = new GamesMoves();
        Character expResult = null;
        Character result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class GamesMoves.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        Character x = null;
        GamesMoves instance = new GamesMoves();
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class GamesMoves.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        GamesMoves instance = new GamesMoves();
        Character expResult = null;
        Character result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class GamesMoves.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        Character y = null;
        GamesMoves instance = new GamesMoves();
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMovesCommentsCollection method, of class GamesMoves.
     */
    @Test
    public void testGetMovesCommentsCollection() {
        System.out.println("getMovesCommentsCollection");
        GamesMoves instance = new GamesMoves();
        Collection<MovesComments> expResult = null;
        Collection<MovesComments> result = instance.getMovesCommentsCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMovesCommentsCollection method, of class GamesMoves.
     */
    @Test
    public void testSetMovesCommentsCollection() {
        System.out.println("setMovesCommentsCollection");
        Collection<MovesComments> movesCommentsCollection = null;
        GamesMoves instance = new GamesMoves();
        instance.setMovesCommentsCollection(movesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGames method, of class GamesMoves.
     */
    @Test
    public void testGetGames() {
        System.out.println("getGames");
        GamesMoves instance = new GamesMoves();
        Games expResult = null;
        Games result = instance.getGames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGames method, of class GamesMoves.
     */
    @Test
    public void testSetGames() {
        System.out.println("setGames");
        Games games = null;
        GamesMoves instance = new GamesMoves();
        instance.setGames(games);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class GamesMoves.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GamesMoves instance = new GamesMoves();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class GamesMoves.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        GamesMoves instance = new GamesMoves();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GamesMoves.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GamesMoves instance = new GamesMoves();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
