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

import java.util.Set;
import java.util.Date;
import org.igo.entities.GameComment;
import org.igo.entities.League;
import org.igo.entities.MoveComment;
import org.igo.entities.Room;
import org.igo.entities.Team;
import org.igo.entities.GoUser;
import org.igo.entities.UserBan;
import org.igo.entities.UserDegree;
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
     * Test of getId method, of class GoUser.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
//        GoUser instance = new GoUser();
//        Integer expResult = null;
//        Integer result = instance.getId();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class GoUser.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
//        Integer id = null;
//        GoUser instance = new GoUser();
        //instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDraw method, of class GoUser.
     */
    @Test
    public void testGetDraw() {
        System.out.println("getDraw");
        GoUser instance = new GoUser();
        Integer expResult = null;
        Integer result = instance.getDraw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDraw method, of class GoUser.
     */
    @Test
    public void testSetDraw() {
        System.out.println("setDraw");
        Integer draw = null;
        GoUser instance = new GoUser();
        instance.setDraw(draw);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class GoUser.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        GoUser instance = new GoUser();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class GoUser.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        GoUser instance = new GoUser();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsLogin method, of class GoUser.
     */
    @Test
    public void testGetIsLogin() {
        System.out.println("getIsLogin");
        GoUser instance = new GoUser();
        Boolean expResult = null;
        Boolean result = instance.getIsLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsLogin method, of class GoUser.
     */
    @Test
    public void testSetIsLogin() {
        System.out.println("setIsLogin");
        Boolean isLogin = null;
        GoUser instance = new GoUser();
        instance.setIsLogin(isLogin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastTime method, of class GoUser.
     */
    @Test
    public void testGetLastTime() {
        System.out.println("getLastTime");
        GoUser instance = new GoUser();
        Date expResult = null;
        Date result = instance.getLastTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastTime method, of class GoUser.
     */
    @Test
    public void testSetLastTime() {
        System.out.println("setLastTime");
        Date lastTime = null;
        GoUser instance = new GoUser();
        instance.setLastTime(lastTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLose method, of class GoUser.
     */
    @Test
    public void testGetLose() {
        System.out.println("getLose");
        GoUser instance = new GoUser();
        Integer expResult = null;
        Integer result = instance.getLose();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLose method, of class GoUser.
     */
    @Test
    public void testSetLose() {
        System.out.println("setLose");
        Integer lose = null;
        GoUser instance = new GoUser();
        instance.setLose(lose);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class GoUser.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
//        GoUser instance = new GoUser();
//        String expResult = "";
//        String result = instance.getUserName();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class GoUser.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
//        String name = "";
//        GoUser instance = new GoUser();
//        instance.setUserName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class GoUser.
     */
//    @Test
//    public void testGetPassword() {
//        System.out.println("getPassword");
//        GoUser instance = new GoUser();
//        String expResult = "";
//        String result = instance.getPassword();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setPassword method, of class GoUser.
     */
//    @Test
//    public void testSetPassword() {
//        System.out.println("setPassword");
//        String password = "";
//        GoUser instance = new GoUser();
//        instance.setPassword(password);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getRating method, of class GoUser.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        GoUser instance = new GoUser();
        Integer expResult = null;
        Integer result = instance.getRating();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRating method, of class GoUser.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        Integer rating = null;
        GoUser instance = new GoUser();
        instance.setRating(rating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalt method, of class GoUser.
     */
//    @Test
//    public void testGetSalt() {
//        System.out.println("getSalt");
//        GoUser instance = new GoUser();
//        String expResult = "";
//        String result = instance.getSalt();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setSalt method, of class GoUser.
     */
//    @Test
//    public void testSetSalt() {
//        System.out.println("setSalt");
//        String salt = "";
//        GoUser instance = new GoUser();
//        instance.setSalt(salt);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getStaus method, of class GoUser.
     */
    @Test
    public void testGetStaus() {
        System.out.println("getStaus");
        GoUser instance = new GoUser();
        Integer expResult = null;
        Integer result = instance.getStaus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStaus method, of class GoUser.
     */
    @Test
    public void testSetStaus() {
        System.out.println("setStaus");
        Integer staus = null;
        GoUser instance = new GoUser();
        instance.setStaus(staus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWin method, of class GoUser.
     */
    @Test
    public void testGetWin() {
        System.out.println("getWin");
        GoUser instance = new GoUser();
        Integer expResult = null;
        Integer result = instance.getWin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWin method, of class GoUser.
     */
    @Test
    public void testSetWin() {
        System.out.println("setWin");
        Integer win = null;
        GoUser instance = new GoUser();
        instance.setWin(win);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersBansSet method, of class GoUser.
     */
    @Test
    public void testGetUsersBansSet() {
        System.out.println("getUsersBansSet");
        GoUser instance = new GoUser();
        Set<UserBan> expResult = null;
        Set<UserBan> result = instance.getUserBans();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersBansSet method, of class GoUser.
     */
    @Test
    public void testSetUsersBansSet() {
        System.out.println("setUsersBansSet");
        Set<UserBan> usersBansSet = null;
        GoUser instance = new GoUser();
        instance.setUserBans(usersBansSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLeagueId method, of class GoUser.
     */
    @Test
    public void testGetLeagueId() {
        System.out.println("getLeagueId");
        GoUser instance = new GoUser();
        League expResult = null;
        //League result = instance.getLeague();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLeagueId method, of class GoUser.
     */
    @Test
    public void testSetLeagueId() {
        System.out.println("setLeagueId");
        League leagueId = null;
        GoUser instance = new GoUser();
//        instance.setLeague(leagueId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoleId method, of class GoUser.
     */
    @Test
    public void testGetRoleId() {
        System.out.println("getRoleId");
//        GoUser instance = new GoUser();
//        UserRole expResult = null;
//        UserRole result = instance.getRoleId();
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoleId method, of class GoUser.
     */
    @Test
    public void testSetRoleId() {
        System.out.println("setRoleId");
//        UserRole roleId = null;
//        GoUser instance = new GoUser();
//        instance.setRoleId(roleId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamId method, of class GoUser.
     */
    @Test
    public void testGetTeamId() {
        System.out.println("getTeamId");
        GoUser instance = new GoUser();
        Team expResult = null;
        Team result = instance.getTeam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeamId method, of class GoUser.
     */
    @Test
    public void testSetTeamId() {
        System.out.println("setTeamId");
        Team teamId = null;
        GoUser instance = new GoUser();
        instance.setTeam(teamId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomId method, of class GoUser.
     */
    @Test
    public void testGetRoomId() {
        System.out.println("getRoomId");
        GoUser instance = new GoUser();
        Room expResult = null;
        Room result = instance.getRoom();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoomId method, of class GoUser.
     */
    @Test
    public void testSetRoomId() {
        System.out.println("setRoomId");
        Room roomId = null;
        GoUser instance = new GoUser();
        instance.setRoom(roomId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



    /**
     * Test of hashCode method, of class GoUser.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GoUser instance = new GoUser();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class GoUser.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        GoUser instance = new GoUser();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GoUser.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GoUser instance = new GoUser();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersGamesSet method, of class GoUser.
     */
    @Test
    public void testGetUsersGamesSet() {
        System.out.println("getUsersGamesSet");
        GoUser instance = new GoUser();
        Set<UserGame> expResult = null;
        Set<UserGame> result = instance.getUserGameSet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersGamesSet method, of class GoUser.
     */
    @Test
    public void testSetUsersGamesSet() {
        System.out.println("setUsersGamesSet");
        Set<UserGame> usersGamesSet = null;
        GoUser instance = new GoUser();
        instance.setUserGameSet(usersGamesSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersDegreesSet method, of class GoUser.
     */
    @Test
    public void testGetUsersDegreesSet() {
        System.out.println("getUsersDegreesSet");
        GoUser instance = new GoUser();
        Set<UserDegree> expResult = null;
        Set<UserDegree> result = instance.getUserDegreeSet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersDegreesSet method, of class GoUser.
     */
    @Test
    public void testSetUsersDegreesSet() {
        System.out.println("setUsersDegreesSet");
        Set<UserDegree> usersDegreesSet = null;
        GoUser instance = new GoUser();
        instance.setUserDegreeSet(usersDegreesSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMovesCommentsSet method, of class GoUser.
     */
    @Test
    public void testGetMovesCommentsSet() {
        System.out.println("getMovesCommentsSet");
        GoUser instance = new GoUser();
        Set<MoveComment> expResult = null;
        Set<MoveComment> result = instance.getMoveCommentSet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMovesCommentsSet method, of class GoUser.
     */
    @Test
    public void testSetMovesCommentsSet() {
        System.out.println("setMovesCommentsSet");
        Set<MoveComment> movesCommentsSet = null;
        GoUser instance = new GoUser();
        instance.setMoveCommentSet(movesCommentsSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesCommentsSet method, of class GoUser.
     */
    @Test
    public void testGetGamesCommentsSet() {
        System.out.println("getGamesCommentsSet");
        GoUser instance = new GoUser();
        Set<GameComment> expResult = null;
        Set<GameComment> result = instance.getGameCommentSet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesCommentsSet method, of class GoUser.
     */
    @Test
    public void testSetGamesCommentsSet() {
        System.out.println("setGamesCommentsSet");
        Set<GameComment> gamesCommentsSet = null;
        GoUser instance = new GoUser();
        instance.setGameCommentSet(gamesCommentsSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
