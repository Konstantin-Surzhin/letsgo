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
public class GameMoveTest {
    
    public GameMoveTest() {
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
     * Test of getGamesMovesPK method, of class GameMove.
     */
    @Test
    public void testGetGamesMovesPK() {
        System.out.println("getGamesMovesPK");
        GameMove instance = new GameMove();
        GameMovePK expResult = null;
        GameMovePK result = instance.getGameMovePK();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesMovesPK method, of class GameMove.
     */
    @Test
    public void testSetGamesMovesPK() {
        System.out.println("setGamesMovesPK");
        GameMovePK gamesMovesPK = null;
        GameMove instance = new GameMove();
        instance.setGameMovePK(gamesMovesPK);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class GameMove.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        GameMove instance = new GameMove();
        Character expResult = null;
        Character result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class GameMove.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        Character x = null;
        GameMove instance = new GameMove();
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class GameMove.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        GameMove instance = new GameMove();
        Character expResult = null;
        Character result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class GameMove.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        Character y = null;
        GameMove instance = new GameMove();
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMovesCommentsCollection method, of class GameMove.
     */
    @Test
    public void testGetMovesCommentsCollection() {
        System.out.println("getMovesCommentsCollection");
        GameMove instance = new GameMove();
        Collection<MoveComment> expResult = null;
        Collection<MoveComment> result = instance.getMovesCommentsCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMovesCommentsCollection method, of class GameMove.
     */
    @Test
    public void testSetMovesCommentsCollection() {
        System.out.println("setMovesCommentsCollection");
        Collection<MoveComment> movesCommentsCollection = null;
        GameMove instance = new GameMove();
        instance.setMovesCommentsCollection(movesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGames method, of class GameMove.
     */
    @Test
    public void testGetGames() {
        System.out.println("getGames");
        GameMove instance = new GameMove();
        Game expResult = null;
        Game result = instance.getGames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGames method, of class GameMove.
     */
    @Test
    public void testSetGames() {
        System.out.println("setGames");
        Game games = null;
        GameMove instance = new GameMove();
        instance.setGames(games);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class GameMove.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GameMove instance = new GameMove();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class GameMove.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        GameMove instance = new GameMove();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GameMove.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GameMove instance = new GameMove();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
