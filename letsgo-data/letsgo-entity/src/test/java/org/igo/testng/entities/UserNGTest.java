/*
 * Copyright (C) 2016 pl
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
package org.igo.testng.entities;

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
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author pl
 */
public class UserNGTest {
    
    public UserNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Тест метод getId, класса UserDetails.
     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        UserDetails instance = new UserDetails();
//        Integer expResult = null;
//        Integer result = instance.getGoUser();
//        assertEquals(result, expResult);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод setId, класса UserDetails.
     */
//    @Test
//    public void testSetId() {
//        System.out.println("setId");
//        Integer id = null;
//        UserDetails instance = new UserDetails();
//        instance.setId(id);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод getDraw, класса UserDetails.
     */
    @Test
    public void testGetDraw() {
        System.out.println("getDraw");
        UserDetails instance = new UserDetails();
        Integer expResult = null;
        Integer result = instance.getDraw();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setDraw, класса UserDetails.
     */
    @Test
    public void testSetDraw() {
        System.out.println("setDraw");
        Integer draw = null;
        UserDetails instance = new UserDetails();
        instance.setDraw(draw);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getEmail, класса UserDetails.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        UserDetails instance = new UserDetails();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setEmail, класса UserDetails.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        UserDetails instance = new UserDetails();
        instance.setEmail(email);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getIsLogin, класса UserDetails.
     */
    @Test
    public void testGetIsLogin() {
        System.out.println("getIsLogin");
        UserDetails instance = new UserDetails();
        Boolean expResult = null;
        Boolean result = instance.getIsLogin();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setIsLogin, класса UserDetails.
     */
    @Test
    public void testSetIsLogin() {
        System.out.println("setIsLogin");
        Boolean isLogin = null;
        UserDetails instance = new UserDetails();
        instance.setIsLogin(isLogin);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getLastTime, класса UserDetails.
     */
    @Test
    public void testGetLastTime() {
        System.out.println("getLastTime");
        UserDetails instance = new UserDetails();
        Date expResult = null;
        Date result = instance.getLastTime();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setLastTime, класса UserDetails.
     */
    @Test
    public void testSetLastTime() {
        System.out.println("setLastTime");
        Date lastTime = null;
        UserDetails instance = new UserDetails();
        instance.setLastTime(lastTime);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getLose, класса UserDetails.
     */
    @Test
    public void testGetLose() {
        System.out.println("getLose");
        UserDetails instance = new UserDetails();
        Integer expResult = null;
        Integer result = instance.getLose();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setLose, класса UserDetails.
     */
    @Test
    public void testSetLose() {
        System.out.println("setLose");
        Integer lose = null;
        UserDetails instance = new UserDetails();
        instance.setLose(lose);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getName, класса UserDetails.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
//        UserDetails instance = new UserDetails();
//        String expResult = "";
//        String result = instance.getUserName();
//        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setName, класса UserDetails.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
//        String name = "";
//        UserDetails instance = new UserDetails();
//        instance.setUserName(name);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getPassword, класса UserDetails.
     */
//    @Test
//    public void testGetPassword() {
//        System.out.println("getPassword");
//        UserDetails instance = new UserDetails();
//        String expResult = "";
//        String result = instance.getPassword();
//        assertEquals(result, expResult);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод setPassword, класса UserDetails.
     */
//    @Test
//    public void testSetPassword() {
//        System.out.println("setPassword");
//        String password = "";
//        UserDetails instance = new UserDetails();
//        instance.setPassword(password);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод getRating, класса UserDetails.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        UserDetails instance = new UserDetails();
        Integer expResult = null;
        Integer result = instance.getRating();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setRating, класса UserDetails.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        Integer rating = null;
        UserDetails instance = new UserDetails();
        instance.setRating(rating);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getSalt, класса UserDetails.
     */
//    @Test
//    public void testGetSalt() {
//        System.out.println("getSalt");
//        UserDetails instance = new UserDetails();
//        String expResult = "";
//        String result = instance.getSalt();
//        assertEquals(result, expResult);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод setSalt, класса UserDetails.
     */
//    @Test
//    public void testSetSalt() {
//        System.out.println("setSalt");
//        String salt = "";
//        UserDetails instance = new UserDetails();
//        instance.setSalt(salt);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод getStaus, класса UserDetails.
     */
    @Test
    public void testGetStaus() {
        System.out.println("getStaus");
        UserDetails instance = new UserDetails();
        Integer expResult = null;
        Integer result = instance.getStaus();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setStaus, класса UserDetails.
     */
    @Test
    public void testSetStaus() {
        System.out.println("setStaus");
        Integer staus = null;
        UserDetails instance = new UserDetails();
        instance.setStaus(staus);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getWin, класса UserDetails.
     */
    @Test
    public void testGetWin() {
        System.out.println("getWin");
        UserDetails instance = new UserDetails();
        Integer expResult = null;
        Integer result = instance.getWin();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setWin, класса UserDetails.
     */
    @Test
    public void testSetWin() {
        System.out.println("setWin");
        Integer win = null;
        UserDetails instance = new UserDetails();
        instance.setWin(win);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getUserBanCollection, класса UserDetails.
     */
    @Test
    public void testGetUserBanCollection() {
        System.out.println("getUserBanCollection");
        UserDetails instance = new UserDetails();
        Collection expResult = null;
        Collection result = instance.getUserBanCollection();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setUserBanCollection, класса UserDetails.
     */
    @Test
    public void testSetUserBanCollection() {
        System.out.println("setUserBanCollection");
        Collection<UserBan> userBanCollection = null;
        UserDetails instance = new UserDetails();
        instance.setUserBanCollection(userBanCollection);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getLeagueId, класса UserDetails.
     */
    @Test
    public void testGetLeagueId() {
        System.out.println("getLeagueId");
        UserDetails instance = new UserDetails();
        League expResult = null;
        //League result = instance.getLeague();
        //assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setLeagueId, класса UserDetails.
     */
    @Test
    public void testSetLeagueId() {
        System.out.println("setLeagueId");
        League leagueId = null;
        UserDetails instance = new UserDetails();
        //instance.setLeague(leagueId);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getRoleId, класса UserDetails.
     */
    @Test
    public void testGetRoleId() {
        System.out.println("getRoleId");
//        UserDetails instance = new UserDetails();
//        UserRole expResult = null;
//        UserRole result = instance.getRoleId();
//        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setRoleId, класса UserDetails.
     */
    @Test
    public void testSetRoleId() {
        System.out.println("setRoleId");
//        UserRole roleId = null;
//        UserDetails instance = new UserDetails();
//        instance.setRoleId(roleId);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getTeamId, класса UserDetails.
     */
    @Test
    public void testGetTeamId() {
        System.out.println("getTeamId");
        UserDetails instance = new UserDetails();
        Team expResult = null;
        Team result = instance.getTeam();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setTeamId, класса UserDetails.
     */
    @Test
    public void testSetTeamId() {
        System.out.println("setTeamId");
        Team teamId = null;
        UserDetails instance = new UserDetails();
        instance.setTeam(teamId);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getRoomId, класса UserDetails.
     */
    @Test
    public void testGetRoomId() {
        System.out.println("getRoomId");
        UserDetails instance = new UserDetails();
        Room expResult = null;
        Room result = instance.getRoom();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setRoomId, класса UserDetails.
     */
    @Test
    public void testSetRoomId() {
        System.out.println("setRoomId");
        Room roomId = null;
        UserDetails instance = new UserDetails();
        instance.setRoom(roomId);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод hashCode, класса UserDetails.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserDetails instance = new UserDetails();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод equals, класса UserDetails.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UserDetails instance = new UserDetails();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод toString, класса UserDetails.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserDetails instance = new UserDetails();
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getUserGameCollection, класса UserDetails.
     */
    @Test
    public void testGetUserGameCollection() {
        System.out.println("getUserGameCollection");
        UserDetails instance = new UserDetails();
        Collection expResult = null;
        Collection result = instance.getUserGameCollection();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setUserGameCollection, класса UserDetails.
     */
    @Test
    public void testSetUserGameCollection() {
        System.out.println("setUserGameCollection");
        Collection<UserGame> userGameCollection = null;
        UserDetails instance = new UserDetails();
        instance.setUserGameCollection(userGameCollection);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getUserDegreeCollection, класса UserDetails.
     */
    @Test
    public void testGetUserDegreeCollection() {
        System.out.println("getUserDegreeCollection");
        UserDetails instance = new UserDetails();
        Collection expResult = null;
        Collection result = instance.getUserDegreeCollection();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setUserDegreeCollection, класса UserDetails.
     */
    @Test
    public void testSetUserDegreeCollection() {
        System.out.println("setUserDegreeCollection");
        Collection<UserDegree> userDegreeCollection = null;
        UserDetails instance = new UserDetails();
        instance.setUserDegreeCollection(userDegreeCollection);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getMoveCommentCollection, класса UserDetails.
     */
    @Test
    public void testGetMoveCommentCollection() {
        System.out.println("getMoveCommentCollection");
        UserDetails instance = new UserDetails();
        Collection expResult = null;
        Collection result = instance.getMoveCommentCollection();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setMoveCommentCollection, класса UserDetails.
     */
    @Test
    public void testSetMoveCommentCollection() {
        System.out.println("setMoveCommentCollection");
        Collection<MoveComment> moveCommentCollection = null;
        UserDetails instance = new UserDetails();
        instance.setMoveCommentCollection(moveCommentCollection);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getGameCommentCollection, класса UserDetails.
     */
    @Test
    public void testGetGameCommentCollection() {
        System.out.println("getGameCommentCollection");
        UserDetails instance = new UserDetails();
        Collection expResult = null;
        Collection result = instance.getGameCommentCollection();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setGameCommentCollection, класса UserDetails.
     */
    @Test
    public void testSetGameCommentCollection() {
        System.out.println("setGameCommentCollection");
        Collection<GameComment> gameCommentCollection = null;
        UserDetails instance = new UserDetails();
        instance.setGameCommentCollection(gameCommentCollection);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }
    
}
