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
import org.igo.entities.City;
import org.igo.entities.GameComment;
import org.igo.entities.League;
import org.igo.entities.MoveComment;
import org.igo.entities.Room;
import org.igo.entities.Team;
import org.igo.entities.UserDetails;
import org.igo.entities.UserBan;
import org.igo.entities.UserDegree;
import org.igo.entities.UserGame;
import org.igo.entities.UserRole;
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
public class UserTest {
    
    public UserTest() {
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
     * Test of getId method, of class UserDetails.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
//        UserDetails instance = new UserDetails();
//        Integer expResult = null;
//        Integer result = instance.getId();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class UserDetails.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
//        Integer id = null;
//        UserDetails instance = new UserDetails();
        //instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDraw method, of class UserDetails.
     */
    @Test
    public void testGetDraw() {
        System.out.println("getDraw");
        UserDetails instance = new UserDetails();
        Integer expResult = null;
        Integer result = instance.getDraw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDraw method, of class UserDetails.
     */
    @Test
    public void testSetDraw() {
        System.out.println("setDraw");
        Integer draw = null;
        UserDetails instance = new UserDetails();
        instance.setDraw(draw);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class UserDetails.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        UserDetails instance = new UserDetails();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class UserDetails.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        UserDetails instance = new UserDetails();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsLogin method, of class UserDetails.
     */
    @Test
    public void testGetIsLogin() {
        System.out.println("getIsLogin");
        UserDetails instance = new UserDetails();
        Boolean expResult = null;
        Boolean result = instance.getIsLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsLogin method, of class UserDetails.
     */
    @Test
    public void testSetIsLogin() {
        System.out.println("setIsLogin");
        Boolean isLogin = null;
        UserDetails instance = new UserDetails();
        instance.setIsLogin(isLogin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastTime method, of class UserDetails.
     */
    @Test
    public void testGetLastTime() {
        System.out.println("getLastTime");
        UserDetails instance = new UserDetails();
        Date expResult = null;
        Date result = instance.getLastTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastTime method, of class UserDetails.
     */
    @Test
    public void testSetLastTime() {
        System.out.println("setLastTime");
        Date lastTime = null;
        UserDetails instance = new UserDetails();
        instance.setLastTime(lastTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLose method, of class UserDetails.
     */
    @Test
    public void testGetLose() {
        System.out.println("getLose");
        UserDetails instance = new UserDetails();
        Integer expResult = null;
        Integer result = instance.getLose();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLose method, of class UserDetails.
     */
    @Test
    public void testSetLose() {
        System.out.println("setLose");
        Integer lose = null;
        UserDetails instance = new UserDetails();
        instance.setLose(lose);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class UserDetails.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
//        UserDetails instance = new UserDetails();
//        String expResult = "";
//        String result = instance.getUserName();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class UserDetails.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
//        String name = "";
//        UserDetails instance = new UserDetails();
//        instance.setUserName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class UserDetails.
     */
//    @Test
//    public void testGetPassword() {
//        System.out.println("getPassword");
//        UserDetails instance = new UserDetails();
//        String expResult = "";
//        String result = instance.getPassword();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setPassword method, of class UserDetails.
     */
//    @Test
//    public void testSetPassword() {
//        System.out.println("setPassword");
//        String password = "";
//        UserDetails instance = new UserDetails();
//        instance.setPassword(password);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getRating method, of class UserDetails.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        UserDetails instance = new UserDetails();
        Integer expResult = null;
        Integer result = instance.getRating();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRating method, of class UserDetails.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        Integer rating = null;
        UserDetails instance = new UserDetails();
        instance.setRating(rating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalt method, of class UserDetails.
     */
//    @Test
//    public void testGetSalt() {
//        System.out.println("getSalt");
//        UserDetails instance = new UserDetails();
//        String expResult = "";
//        String result = instance.getSalt();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setSalt method, of class UserDetails.
     */
//    @Test
//    public void testSetSalt() {
//        System.out.println("setSalt");
//        String salt = "";
//        UserDetails instance = new UserDetails();
//        instance.setSalt(salt);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getStaus method, of class UserDetails.
     */
    @Test
    public void testGetStaus() {
        System.out.println("getStaus");
        UserDetails instance = new UserDetails();
        Integer expResult = null;
        Integer result = instance.getStaus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStaus method, of class UserDetails.
     */
    @Test
    public void testSetStaus() {
        System.out.println("setStaus");
        Integer staus = null;
        UserDetails instance = new UserDetails();
        instance.setStaus(staus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWin method, of class UserDetails.
     */
    @Test
    public void testGetWin() {
        System.out.println("getWin");
        UserDetails instance = new UserDetails();
        Integer expResult = null;
        Integer result = instance.getWin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWin method, of class UserDetails.
     */
    @Test
    public void testSetWin() {
        System.out.println("setWin");
        Integer win = null;
        UserDetails instance = new UserDetails();
        instance.setWin(win);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersBansCollection method, of class UserDetails.
     */
    @Test
    public void testGetUsersBansCollection() {
        System.out.println("getUsersBansCollection");
        UserDetails instance = new UserDetails();
        Collection<UserBan> expResult = null;
        Collection<UserBan> result = instance.getUserBanCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersBansCollection method, of class UserDetails.
     */
    @Test
    public void testSetUsersBansCollection() {
        System.out.println("setUsersBansCollection");
        Collection<UserBan> usersBansCollection = null;
        UserDetails instance = new UserDetails();
        instance.setUserBanCollection(usersBansCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLeagueId method, of class UserDetails.
     */
    @Test
    public void testGetLeagueId() {
        System.out.println("getLeagueId");
        UserDetails instance = new UserDetails();
        League expResult = null;
        //League result = instance.getLeague();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLeagueId method, of class UserDetails.
     */
    @Test
    public void testSetLeagueId() {
        System.out.println("setLeagueId");
        League leagueId = null;
        UserDetails instance = new UserDetails();
//        instance.setLeague(leagueId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoleId method, of class UserDetails.
     */
    @Test
    public void testGetRoleId() {
        System.out.println("getRoleId");
//        UserDetails instance = new UserDetails();
//        UserRole expResult = null;
//        UserRole result = instance.getRoleId();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoleId method, of class UserDetails.
     */
    @Test
    public void testSetRoleId() {
        System.out.println("setRoleId");
//        UserRole roleId = null;
//        UserDetails instance = new UserDetails();
//        instance.setRoleId(roleId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamId method, of class UserDetails.
     */
    @Test
    public void testGetTeamId() {
        System.out.println("getTeamId");
        UserDetails instance = new UserDetails();
        Team expResult = null;
        Team result = instance.getTeam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeamId method, of class UserDetails.
     */
    @Test
    public void testSetTeamId() {
        System.out.println("setTeamId");
        Team teamId = null;
        UserDetails instance = new UserDetails();
        instance.setTeam(teamId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomId method, of class UserDetails.
     */
    @Test
    public void testGetRoomId() {
        System.out.println("getRoomId");
        UserDetails instance = new UserDetails();
        Room expResult = null;
        Room result = instance.getRoom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoomId method, of class UserDetails.
     */
    @Test
    public void testSetRoomId() {
        System.out.println("setRoomId");
        Room roomId = null;
        UserDetails instance = new UserDetails();
        instance.setRoom(roomId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



    /**
     * Test of hashCode method, of class UserDetails.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserDetails instance = new UserDetails();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UserDetails.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UserDetails instance = new UserDetails();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UserDetails.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserDetails instance = new UserDetails();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersGamesCollection method, of class UserDetails.
     */
    @Test
    public void testGetUsersGamesCollection() {
        System.out.println("getUsersGamesCollection");
        UserDetails instance = new UserDetails();
        Collection<UserGame> expResult = null;
        Collection<UserGame> result = instance.getUserGameCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersGamesCollection method, of class UserDetails.
     */
    @Test
    public void testSetUsersGamesCollection() {
        System.out.println("setUsersGamesCollection");
        Collection<UserGame> usersGamesCollection = null;
        UserDetails instance = new UserDetails();
        instance.setUserGameCollection(usersGamesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersDegreesCollection method, of class UserDetails.
     */
    @Test
    public void testGetUsersDegreesCollection() {
        System.out.println("getUsersDegreesCollection");
        UserDetails instance = new UserDetails();
        Collection<UserDegree> expResult = null;
        Collection<UserDegree> result = instance.getUserDegreeCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersDegreesCollection method, of class UserDetails.
     */
    @Test
    public void testSetUsersDegreesCollection() {
        System.out.println("setUsersDegreesCollection");
        Collection<UserDegree> usersDegreesCollection = null;
        UserDetails instance = new UserDetails();
        instance.setUserDegreeCollection(usersDegreesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMovesCommentsCollection method, of class UserDetails.
     */
    @Test
    public void testGetMovesCommentsCollection() {
        System.out.println("getMovesCommentsCollection");
        UserDetails instance = new UserDetails();
        Collection<MoveComment> expResult = null;
        Collection<MoveComment> result = instance.getMoveCommentCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMovesCommentsCollection method, of class UserDetails.
     */
    @Test
    public void testSetMovesCommentsCollection() {
        System.out.println("setMovesCommentsCollection");
        Collection<MoveComment> movesCommentsCollection = null;
        UserDetails instance = new UserDetails();
        instance.setMoveCommentCollection(movesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesCommentsCollection method, of class UserDetails.
     */
    @Test
    public void testGetGamesCommentsCollection() {
        System.out.println("getGamesCommentsCollection");
        UserDetails instance = new UserDetails();
        Collection<GameComment> expResult = null;
        Collection<GameComment> result = instance.getGameCommentCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesCommentsCollection method, of class UserDetails.
     */
    @Test
    public void testSetGamesCommentsCollection() {
        System.out.println("setGamesCommentsCollection");
        Collection<GameComment> gamesCommentsCollection = null;
        UserDetails instance = new UserDetails();
        instance.setGameCommentCollection(gamesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
