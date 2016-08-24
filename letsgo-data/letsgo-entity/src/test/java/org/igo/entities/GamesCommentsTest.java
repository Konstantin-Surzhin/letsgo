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
public class GamesCommentsTest {
    
    public GamesCommentsTest() {
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
     * Test of getId method, of class GamesComments.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        GamesComments instance = new GamesComments();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class GamesComments.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        GamesComments instance = new GamesComments();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComment method, of class GamesComments.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        GamesComments instance = new GamesComments();
        String expResult = "";
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComment method, of class GamesComments.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        GamesComments instance = new GamesComments();
        instance.setComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostDateTime method, of class GamesComments.
     */
    @Test
    public void testGetPostDateTime() {
        System.out.println("getPostDateTime");
        GamesComments instance = new GamesComments();
        Date expResult = null;
        Date result = instance.getPostDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPostDateTime method, of class GamesComments.
     */
    @Test
    public void testSetPostDateTime() {
        System.out.println("setPostDateTime");
        Date postDateTime = null;
        GamesComments instance = new GamesComments();
        instance.setPostDateTime(postDateTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameId method, of class GamesComments.
     */
    @Test
    public void testGetGameId() {
        System.out.println("getGameId");
        GamesComments instance = new GamesComments();
        Games expResult = null;
        Games result = instance.getGameId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameId method, of class GamesComments.
     */
    @Test
    public void testSetGameId() {
        System.out.println("setGameId");
        Games gameId = null;
        GamesComments instance = new GamesComments();
        instance.setGameId(gameId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesCommentsCollection method, of class GamesComments.
     */
    @Test
    public void testGetGamesCommentsCollection() {
        System.out.println("getGamesCommentsCollection");
        GamesComments instance = new GamesComments();
        Collection<GamesComments> expResult = null;
        Collection<GamesComments> result = instance.getGamesCommentsCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesCommentsCollection method, of class GamesComments.
     */
    @Test
    public void testSetGamesCommentsCollection() {
        System.out.println("setGamesCommentsCollection");
        Collection<GamesComments> gamesCommentsCollection = null;
        GamesComments instance = new GamesComments();
        instance.setGamesCommentsCollection(gamesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInReplayToId method, of class GamesComments.
     */
    @Test
    public void testGetInReplayToId() {
        System.out.println("getInReplayToId");
        GamesComments instance = new GamesComments();
        GamesComments expResult = null;
        GamesComments result = instance.getInReplayToId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInReplayToId method, of class GamesComments.
     */
    @Test
    public void testSetInReplayToId() {
        System.out.println("setInReplayToId");
        GamesComments inReplayToId = null;
        GamesComments instance = new GamesComments();
        instance.setInReplayToId(inReplayToId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class GamesComments.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        GamesComments instance = new GamesComments();
        Users expResult = null;
        Users result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class GamesComments.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        Users userId = null;
        GamesComments instance = new GamesComments();
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class GamesComments.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GamesComments instance = new GamesComments();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class GamesComments.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        GamesComments instance = new GamesComments();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GamesComments.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GamesComments instance = new GamesComments();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
