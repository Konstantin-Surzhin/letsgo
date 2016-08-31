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
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        User instance = new User();
        Integer expResult = null;
        Integer result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Integer id = null;
        User instance = new User();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDraw method, of class User.
     */
    @Test
    public void testGetDraw() {
        System.out.println("getDraw");
        User instance = new User();
        Integer expResult = null;
        Integer result = instance.getDraw();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDraw method, of class User.
     */
    @Test
    public void testSetDraw() {
        System.out.println("setDraw");
        Integer draw = null;
        User instance = new User();
        instance.setDraw(draw);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = new User();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsLogin method, of class User.
     */
    @Test
    public void testGetIsLogin() {
        System.out.println("getIsLogin");
        User instance = new User();
        Boolean expResult = null;
        Boolean result = instance.getIsLogin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsLogin method, of class User.
     */
    @Test
    public void testSetIsLogin() {
        System.out.println("setIsLogin");
        Boolean isLogin = null;
        User instance = new User();
        instance.setIsLogin(isLogin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastTime method, of class User.
     */
    @Test
    public void testGetLastTime() {
        System.out.println("getLastTime");
        User instance = new User();
        Date expResult = null;
        Date result = instance.getLastTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastTime method, of class User.
     */
    @Test
    public void testSetLastTime() {
        System.out.println("setLastTime");
        Date lastTime = null;
        User instance = new User();
        instance.setLastTime(lastTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLose method, of class User.
     */
    @Test
    public void testGetLose() {
        System.out.println("getLose");
        User instance = new User();
        Integer expResult = null;
        Integer result = instance.getLose();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLose method, of class User.
     */
    @Test
    public void testSetLose() {
        System.out.println("setLose");
        Integer lose = null;
        User instance = new User();
        instance.setLose(lose);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        User instance = new User();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new User();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRating method, of class User.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        User instance = new User();
        Integer expResult = null;
        Integer result = instance.getRating();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRating method, of class User.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        Integer rating = null;
        User instance = new User();
        instance.setRating(rating);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSalt method, of class User.
     */
    @Test
    public void testGetSalt() {
        System.out.println("getSalt");
        User instance = new User();
        String expResult = "";
        String result = instance.getSalt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSalt method, of class User.
     */
    @Test
    public void testSetSalt() {
        System.out.println("setSalt");
        String salt = "";
        User instance = new User();
        instance.setSalt(salt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStaus method, of class User.
     */
    @Test
    public void testGetStaus() {
        System.out.println("getStaus");
        User instance = new User();
        Integer expResult = null;
        Integer result = instance.getStaus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStaus method, of class User.
     */
    @Test
    public void testSetStaus() {
        System.out.println("setStaus");
        Integer staus = null;
        User instance = new User();
        instance.setStaus(staus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWin method, of class User.
     */
    @Test
    public void testGetWin() {
        System.out.println("getWin");
        User instance = new User();
        Integer expResult = null;
        Integer result = instance.getWin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWin method, of class User.
     */
    @Test
    public void testSetWin() {
        System.out.println("setWin");
        Integer win = null;
        User instance = new User();
        instance.setWin(win);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersBansCollection method, of class User.
     */
    @Test
    public void testGetUsersBansCollection() {
        System.out.println("getUsersBansCollection");
        User instance = new User();
        Collection<UserBan> expResult = null;
        Collection<UserBan> result = instance.getUserBanCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersBansCollection method, of class User.
     */
    @Test
    public void testSetUsersBansCollection() {
        System.out.println("setUsersBansCollection");
        Collection<UserBan> usersBansCollection = null;
        User instance = new User();
        instance.setUserBanCollection(usersBansCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLeagueId method, of class User.
     */
    @Test
    public void testGetLeagueId() {
        System.out.println("getLeagueId");
        User instance = new User();
        League expResult = null;
        League result = instance.getLeagueId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLeagueId method, of class User.
     */
    @Test
    public void testSetLeagueId() {
        System.out.println("setLeagueId");
        League leagueId = null;
        User instance = new User();
        instance.setLeagueId(leagueId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoleId method, of class User.
     */
    @Test
    public void testGetRoleId() {
        System.out.println("getRoleId");
        User instance = new User();
        UserRole expResult = null;
        UserRole result = instance.getRoleId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoleId method, of class User.
     */
    @Test
    public void testSetRoleId() {
        System.out.println("setRoleId");
        UserRole roleId = null;
        User instance = new User();
        instance.setRoleId(roleId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeamId method, of class User.
     */
    @Test
    public void testGetTeamId() {
        System.out.println("getTeamId");
        User instance = new User();
        Team expResult = null;
        Team result = instance.getTeamId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeamId method, of class User.
     */
    @Test
    public void testSetTeamId() {
        System.out.println("setTeamId");
        Team teamId = null;
        User instance = new User();
        instance.setTeamId(teamId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoomId method, of class User.
     */
    @Test
    public void testGetRoomId() {
        System.out.println("getRoomId");
        User instance = new User();
        Room expResult = null;
        Room result = instance.getRoomId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoomId method, of class User.
     */
    @Test
    public void testSetRoomId() {
        System.out.println("setRoomId");
        Room roomId = null;
        User instance = new User();
        instance.setRoomId(roomId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCityId method, of class User.
     */
    @Test
    public void testGetCityId() {
        System.out.println("getCityId");
        User instance = new User();
        City expResult = null;
        City result = instance.getCityId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCityId method, of class User.
     */
    @Test
    public void testSetCityId() {
        System.out.println("setCityId");
        City cityId = null;
        User instance = new User();
        instance.setCityId(cityId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        User instance = new User();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersGamesCollection method, of class User.
     */
    @Test
    public void testGetUsersGamesCollection() {
        System.out.println("getUsersGamesCollection");
        User instance = new User();
        Collection<UserGame> expResult = null;
        Collection<UserGame> result = instance.getUserGameCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersGamesCollection method, of class User.
     */
    @Test
    public void testSetUsersGamesCollection() {
        System.out.println("setUsersGamesCollection");
        Collection<UserGame> usersGamesCollection = null;
        User instance = new User();
        instance.setUserGameCollection(usersGamesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersDegreesCollection method, of class User.
     */
    @Test
    public void testGetUsersDegreesCollection() {
        System.out.println("getUsersDegreesCollection");
        User instance = new User();
        Collection<UserDegree> expResult = null;
        Collection<UserDegree> result = instance.getUserDegreeCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersDegreesCollection method, of class User.
     */
    @Test
    public void testSetUsersDegreesCollection() {
        System.out.println("setUsersDegreesCollection");
        Collection<UserDegree> usersDegreesCollection = null;
        User instance = new User();
        instance.setUserDegreeCollection(usersDegreesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMovesCommentsCollection method, of class User.
     */
    @Test
    public void testGetMovesCommentsCollection() {
        System.out.println("getMovesCommentsCollection");
        User instance = new User();
        Collection<MoveComment> expResult = null;
        Collection<MoveComment> result = instance.getMoveCommentCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMovesCommentsCollection method, of class User.
     */
    @Test
    public void testSetMovesCommentsCollection() {
        System.out.println("setMovesCommentsCollection");
        Collection<MoveComment> movesCommentsCollection = null;
        User instance = new User();
        instance.setMoveCommentCollection(movesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamesCommentsCollection method, of class User.
     */
    @Test
    public void testGetGamesCommentsCollection() {
        System.out.println("getGamesCommentsCollection");
        User instance = new User();
        Collection<GameComment> expResult = null;
        Collection<GameComment> result = instance.getGameCommentCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamesCommentsCollection method, of class User.
     */
    @Test
    public void testSetGamesCommentsCollection() {
        System.out.println("setGamesCommentsCollection");
        Collection<GameComment> gamesCommentsCollection = null;
        User instance = new User();
        instance.setGameCommentCollection(gamesCommentsCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
