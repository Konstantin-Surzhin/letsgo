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
     * Тест метод getId, класса GoUser.
     */
//    @Test
//    public void testGetId() {
//        System.out.println("getId");
//        GoUser instance = new GoUser();
//        Integer expResult = null;
//        Integer result = instance.getGoUser();
//        assertEquals(result, expResult);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод setId, класса GoUser.
     */
//    @Test
//    public void testSetId() {
//        System.out.println("setId");
//        Integer id = null;
//        GoUser instance = new GoUser();
//        instance.setId(id);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод getDraw, класса GoUser.
     */
    @Test
    public void testGetDraw() {
        System.out.println("getDraw");
        GoUser instance = new GoUser();
        Integer expResult = null;
        Integer result = instance.getDraw();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setDraw, класса GoUser.
     */
    @Test
    public void testSetDraw() {
        System.out.println("setDraw");
        Integer draw = null;
        GoUser instance = new GoUser();
        instance.setDraw(draw);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getEmail, класса GoUser.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        GoUser instance = new GoUser();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setEmail, класса GoUser.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        GoUser instance = new GoUser();
        instance.setEmail(email);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getIsLogin, класса GoUser.
     */
    @Test
    public void testGetIsLogin() {
        System.out.println("getIsLogin");
        GoUser instance = new GoUser();
        Boolean expResult = null;
        Boolean result = instance.getIsLogin();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setIsLogin, класса GoUser.
     */
    @Test
    public void testSetIsLogin() {
        System.out.println("setIsLogin");
        Boolean isLogin = null;
        GoUser instance = new GoUser();
        instance.setIsLogin(isLogin);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getLastTime, класса GoUser.
     */
    @Test
    public void testGetLastTime() {
        System.out.println("getLastTime");
        GoUser instance = new GoUser();
        Date expResult = null;
        Date result = instance.getLastTime();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setLastTime, класса GoUser.
     */
    @Test
    public void testSetLastTime() {
        System.out.println("setLastTime");
        Date lastTime = null;
        GoUser instance = new GoUser();
        instance.setLastTime(lastTime);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getLose, класса GoUser.
     */
    @Test
    public void testGetLose() {
        System.out.println("getLose");
        GoUser instance = new GoUser();
        Integer expResult = null;
        Integer result = instance.getLose();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setLose, класса GoUser.
     */
    @Test
    public void testSetLose() {
        System.out.println("setLose");
        Integer lose = null;
        GoUser instance = new GoUser();
        instance.setLose(lose);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getName, класса GoUser.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
//        GoUser instance = new GoUser();
//        String expResult = "";
//        String result = instance.getUserName();
//        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setName, класса GoUser.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
//        String name = "";
//        GoUser instance = new GoUser();
//        instance.setUserName(name);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getPassword, класса GoUser.
     */
//    @Test
//    public void testGetPassword() {
//        System.out.println("getPassword");
//        GoUser instance = new GoUser();
//        String expResult = "";
//        String result = instance.getPassword();
//        assertEquals(result, expResult);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод setPassword, класса GoUser.
     */
//    @Test
//    public void testSetPassword() {
//        System.out.println("setPassword");
//        String password = "";
//        GoUser instance = new GoUser();
//        instance.setPassword(password);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод getRating, класса GoUser.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        GoUser instance = new GoUser();
        Integer expResult = null;
        Integer result = instance.getRating();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setRating, класса GoUser.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        Integer rating = null;
        GoUser instance = new GoUser();
        instance.setRating(rating);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getSalt, класса GoUser.
     */
//    @Test
//    public void testGetSalt() {
//        System.out.println("getSalt");
//        GoUser instance = new GoUser();
//        String expResult = "";
//        String result = instance.getSalt();
//        assertEquals(result, expResult);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод setSalt, класса GoUser.
     */
//    @Test
//    public void testSetSalt() {
//        System.out.println("setSalt");
//        String salt = "";
//        GoUser instance = new GoUser();
//        instance.setSalt(salt);
//        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
//        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
//    }

    /**
     * Тест метод getStaus, класса GoUser.
     */
    @Test
    public void testGetStaus() {
        System.out.println("getStaus");
        GoUser instance = new GoUser();
        Integer expResult = null;
        Integer result = instance.getStaus();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setStaus, класса GoUser.
     */
    @Test
    public void testSetStaus() {
        System.out.println("setStaus");
        Integer staus = null;
        GoUser instance = new GoUser();
        instance.setStaus(staus);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getWin, класса GoUser.
     */
    @Test
    public void testGetWin() {
        System.out.println("getWin");
        GoUser instance = new GoUser();
        Integer expResult = null;
        Integer result = instance.getWin();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setWin, класса GoUser.
     */
    @Test
    public void testSetWin() {
        System.out.println("setWin");
        Integer win = null;
        GoUser instance = new GoUser();
        instance.setWin(win);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getUserBanSet, класса GoUser.
     */
    @Test
    public void testGetUserBanSet() {
        System.out.println("getUserBanSet");
        GoUser instance = new GoUser();
        Set expResult = null;
        Set result = instance.getUserBans();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setUserBanSet, класса GoUser.
     */
    @Test
    public void testSetUserBanSet() {
        System.out.println("setUserBanSet");
        Set<UserBan> userBanSet = null;
        GoUser instance = new GoUser();
        instance.setUserBans(userBanSet);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getLeagueId, класса GoUser.
     */
    @Test
    public void testGetLeagueId() {
        System.out.println("getLeagueId");
        GoUser instance = new GoUser();
        League expResult = null;
        //League result = instance.getLeague();
        //assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setLeagueId, класса GoUser.
     */
    @Test
    public void testSetLeagueId() {
        System.out.println("setLeagueId");
        League leagueId = null;
        GoUser instance = new GoUser();
        //instance.setLeague(leagueId);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getRoleId, класса GoUser.
     */
    @Test
    public void testGetRoleId() {
        System.out.println("getRoleId");
//        GoUser instance = new GoUser();
//        UserRole expResult = null;
//        UserRole result = instance.getRoleId();
//        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setRoleId, класса GoUser.
     */
    @Test
    public void testSetRoleId() {
        System.out.println("setRoleId");
//        UserRole roleId = null;
//        GoUser instance = new GoUser();
//        instance.setRoleId(roleId);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getTeamId, класса GoUser.
     */
    @Test
    public void testGetTeamId() {
        System.out.println("getTeamId");
        GoUser instance = new GoUser();
        Team expResult = null;
        Team result = instance.getTeam();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setTeamId, класса GoUser.
     */
    @Test
    public void testSetTeamId() {
        System.out.println("setTeamId");
        Team teamId = null;
        GoUser instance = new GoUser();
        instance.setTeam(teamId);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getRoomId, класса GoUser.
     */
    @Test
    public void testGetRoomId() {
        System.out.println("getRoomId");
        GoUser instance = new GoUser();
        Room expResult = null;
        Room result = instance.getRoom();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setRoomId, класса GoUser.
     */
    @Test
    public void testSetRoomId() {
        System.out.println("setRoomId");
        Room roomId = null;
        GoUser instance = new GoUser();
        instance.setRoom(roomId);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод hashCode, класса GoUser.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GoUser instance = new GoUser();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод equals, класса GoUser.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        GoUser instance = new GoUser();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод toString, класса GoUser.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GoUser instance = new GoUser();
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getUserGameSet, класса GoUser.
     */
    @Test
    public void testGetUserGameSet() {
        System.out.println("getUserGameSet");
        GoUser instance = new GoUser();
        Set expResult = null;
        Set result = instance.getUserGameSet();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setUserGameSet, класса GoUser.
     */
    @Test
    public void testSetUserGameSet() {
        System.out.println("setUserGameSet");
        Set<UserGame> userGameSet = null;
        GoUser instance = new GoUser();
        instance.setUserGameSet(userGameSet);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getUserDegreeSet, класса GoUser.
     */
    @Test
    public void testGetUserDegreeSet() {
        System.out.println("getUserDegreeSet");
        GoUser instance = new GoUser();
        Set expResult = null;
        Set result = instance.getUserDegreeSet();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setUserDegreeSet, класса GoUser.
     */
    @Test
    public void testSetUserDegreeSet() {
        System.out.println("setUserDegreeSet");
        Set<UserDegree> userDegreeSet = null;
        GoUser instance = new GoUser();
        instance.setUserDegreeSet(userDegreeSet);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getMoveCommentSet, класса GoUser.
     */
    @Test
    public void testGetMoveCommentSet() {
        System.out.println("getMoveCommentSet");
        GoUser instance = new GoUser();
        Set expResult = null;
        Set result = instance.getMoveCommentSet();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setMoveCommentSet, класса GoUser.
     */
    @Test
    public void testSetMoveCommentSet() {
        System.out.println("setMoveCommentSet");
        Set<MoveComment> moveCommentSet = null;
        GoUser instance = new GoUser();
        instance.setMoveCommentSet(moveCommentSet);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getGameCommentSet, класса GoUser.
     */
    @Test
    public void testGetGameCommentSet() {
        System.out.println("getGameCommentSet");
        GoUser instance = new GoUser();
        Set expResult = null;
        Set result = instance.getGameCommentSet();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setGameCommentSet, класса GoUser.
     */
    @Test
    public void testSetGameCommentSet() {
        System.out.println("setGameCommentSet");
        Set<GameComment> gameCommentSet = null;
        GoUser instance = new GoUser();
        instance.setGameCommentSet(gameCommentSet);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }
    
}
