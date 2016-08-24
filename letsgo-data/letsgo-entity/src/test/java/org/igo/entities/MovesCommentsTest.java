/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.util.Collection;
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
public class MovesCommentsTest {
    
    public MovesCommentsTest() {
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
     * Test of getId method, of class MovesComments.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        MovesComments instance = new MovesComments();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class MovesComments.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        MovesComments instance = new MovesComments();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMoveComment method, of class MovesComments.
     */
    @Test
    public void testGetMoveComment() {
        System.out.println("getMoveComment");
        MovesComments instance = new MovesComments();
        String expResult = "";
        String result = instance.getMoveComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMoveComment method, of class MovesComments.
     */
    @Test
    public void testSetMoveComment() {
        System.out.println("setMoveComment");
        String moveComment = "";
        MovesComments instance = new MovesComments();
        instance.setMoveComment(moveComment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostDateTime method, of class MovesComments.
     */
    @Test
    public void testGetPostDateTime() {
        System.out.println("getPostDateTime");
        MovesComments instance = new MovesComments();
        Date expResult = null;
        Date result = instance.getPostDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPostDateTime method, of class MovesComments.
     */
    @Test
    public void testSetPostDateTime() {
        System.out.println("setPostDateTime");
        Date postDateTime = null;
        MovesComments instance = new MovesComments();
        instance.setPostDateTime(postDateTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesMoves method, of class MovesComments.
     */
    @Test
    public void testGetGamesMoves() {
        System.out.println("getGamesMoves");
        MovesComments instance = new MovesComments();
        GamesMoves expResult = null;
        GamesMoves result = instance.getGamesMoves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesMoves method, of class MovesComments.
     */
    @Test
    public void testSetGamesMoves() {
        System.out.println("setGamesMoves");
        GamesMoves gamesMoves = null;
        MovesComments instance = new MovesComments();
        instance.setGamesMoves(gamesMoves);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMovesCommentsCollection method, of class MovesComments.
     */
    @Test
    public void testGetMovesCommentsCollection() {
        System.out.println("getMovesCommentsCollection");
        MovesComments instance = new MovesComments();
        Collection<MovesComments> expResult = null;
        Collection<MovesComments> result = instance.getMovesCommentsCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMovesCommentsCollection method, of class MovesComments.
     */
    @Test
    public void testSetMovesCommentsCollection() {
        System.out.println("setMovesCommentsCollection");
        Collection<MovesComments> movesCommentsCollection = null;
        MovesComments instance = new MovesComments();
        instance.setMovesCommentsCollection(movesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInReplayToId method, of class MovesComments.
     */
    @Test
    public void testGetInReplayToId() {
        System.out.println("getInReplayToId");
        MovesComments instance = new MovesComments();
        MovesComments expResult = null;
        MovesComments result = instance.getInReplayToId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInReplayToId method, of class MovesComments.
     */
    @Test
    public void testSetInReplayToId() {
        System.out.println("setInReplayToId");
        MovesComments inReplayToId = null;
        MovesComments instance = new MovesComments();
        instance.setInReplayToId(inReplayToId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class MovesComments.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        MovesComments instance = new MovesComments();
        Users expResult = null;
        Users result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class MovesComments.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        Users userId = null;
        MovesComments instance = new MovesComments();
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class MovesComments.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        MovesComments instance = new MovesComments();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class MovesComments.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        MovesComments instance = new MovesComments();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MovesComments.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MovesComments instance = new MovesComments();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
