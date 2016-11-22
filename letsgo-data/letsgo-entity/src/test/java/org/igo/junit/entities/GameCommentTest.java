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
import java.util.Date;
import org.igo.entities.Game;
import org.igo.entities.GameComment;
import org.igo.entities.UserDetails;
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
public class GameCommentTest {
    
    public GameCommentTest() {
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
     * Test of getId method, of class GameComment.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        GameComment instance = new GameComment();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class GameComment.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        GameComment instance = new GameComment();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComment method, of class GameComment.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        GameComment instance = new GameComment();
        String expResult = "";
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComment method, of class GameComment.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        GameComment instance = new GameComment();
        instance.setComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostDateTime method, of class GameComment.
     */
    @Test
    public void testGetPostDateTime() {
        System.out.println("getPostDateTime");
        GameComment instance = new GameComment();
        Date expResult = null;
        Date result = instance.getPostDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPostDateTime method, of class GameComment.
     */
    @Test
    public void testSetPostDateTime() {
        System.out.println("setPostDateTime");
        Date postDateTime = null;
        GameComment instance = new GameComment();
        instance.setPostDateTime(postDateTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameId method, of class GameComment.
     */
    @Test
    public void testGetGameId() {
        System.out.println("getGameId");
        GameComment instance = new GameComment();
        Game expResult = null;
        Game result = instance.getGame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameId method, of class GameComment.
     */
    @Test
    public void testSetGameId() {
        System.out.println("setGameId");
        Game gameId = null;
        GameComment instance = new GameComment();
        instance.setGame(gameId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesCommentsCollection method, of class GameComment.
     */
    @Test
    public void testGetGamesCommentsCollection() {
        System.out.println("getGamesCommentsCollection");
        GameComment instance = new GameComment();
        Collection<GameComment> expResult = null;
        Collection<GameComment> result = instance.getGameCommentCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesCommentsCollection method, of class GameComment.
     */
    @Test
    public void testSetGamesCommentsCollection() {
        System.out.println("setGamesCommentsCollection");
        Collection<GameComment> gamesCommentsCollection = null;
        GameComment instance = new GameComment();
        instance.setGameCommentCollection(gamesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInReplayToId method, of class GameComment.
     */
    @Test
    public void testGetInReplayToId() {
        System.out.println("getInReplayToId");
        GameComment instance = new GameComment();
        GameComment expResult = null;
        GameComment result = instance.getInReplayToId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInReplayToId method, of class GameComment.
     */
    @Test
    public void testSetInReplayToId() {
        System.out.println("setInReplayToId");
        GameComment inReplayToId = null;
        GameComment instance = new GameComment();
        instance.setInReplayToId(inReplayToId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class GameComment.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        GameComment instance = new GameComment();
        UserDetails expResult = null;
        UserDetails result = instance.getUserDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class GameComment.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
//        UserDetails userId = null;
//        GameComment instance = new GameComment();
//        instance.sesetUserserId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class GameComment.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GameComment instance = new GameComment();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class GameComment.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        GameComment instance = new GameComment();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GameComment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GameComment instance = new GameComment();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
