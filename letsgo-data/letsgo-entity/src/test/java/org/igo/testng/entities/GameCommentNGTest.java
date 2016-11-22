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
import org.igo.entities.Game;
import org.igo.entities.GameComment;
import org.igo.entities.UserDetails;
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
public class GameCommentNGTest {
    
    public GameCommentNGTest() {
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
     * Тест метод getId, класса GameComment.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        GameComment instance = new GameComment();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setId, класса GameComment.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        GameComment instance = new GameComment();
        instance.setId(id);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getComment, класса GameComment.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        GameComment instance = new GameComment();
        String expResult = "";
        String result = instance.getComment();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setComment, класса GameComment.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        GameComment instance = new GameComment();
        instance.setComment(comment);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getPostDateTime, класса GameComment.
     */
    @Test
    public void testGetPostDateTime() {
        System.out.println("getPostDateTime");
        GameComment instance = new GameComment();
        Date expResult = null;
        Date result = instance.getPostDateTime();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setPostDateTime, класса GameComment.
     */
    @Test
    public void testSetPostDateTime() {
        System.out.println("setPostDateTime");
        Date postDateTime = null;
        GameComment instance = new GameComment();
        instance.setPostDateTime(postDateTime);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getGameId, класса GameComment.
     */
    @Test
    public void testGetGameId() {
        System.out.println("getGameId");
        GameComment instance = new GameComment();
        Game expResult = null;
        Game result = instance.getGame();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setGameId, класса GameComment.
     */
    @Test
    public void testSetGameId() {
        System.out.println("setGameId");
        Game gameId = null;
        GameComment instance = new GameComment();
        instance.setGame(gameId);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getGameCommentCollection, класса GameComment.
     */
    @Test
    public void testGetGameCommentCollection() {
        System.out.println("getGameCommentCollection");
        GameComment instance = new GameComment();
        Collection expResult = null;
        Collection result = instance.getGameCommentCollection();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setGameCommentCollection, класса GameComment.
     */
    @Test
    public void testSetGameCommentCollection() {
        System.out.println("setGameCommentCollection");
        Collection<GameComment> gameCommentCollection = null;
        GameComment instance = new GameComment();
        instance.setGameCommentCollection(gameCommentCollection);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getInReplayToId, класса GameComment.
     */
    @Test
    public void testGetInReplayToId() {
        System.out.println("getInReplayToId");
        GameComment instance = new GameComment();
        GameComment expResult = null;
        GameComment result = instance.getInReplayToId();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setInReplayToId, класса GameComment.
     */
    @Test
    public void testSetInReplayToId() {
        System.out.println("setInReplayToId");
        GameComment inReplayToId = null;
        GameComment instance = new GameComment();
        instance.setInReplayToId(inReplayToId);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getUserId, класса GameComment.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        GameComment instance = new GameComment();
        UserDetails expResult = null;
        UserDetails result = instance.getUserDetails();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setUserId, класса GameComment.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
//        UserDetails userId = null;
//        GameComment instance = new GameComment();
//        instance.sesetUserserId);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод hashCode, класса GameComment.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GameComment instance = new GameComment();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод equals, класса GameComment.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        GameComment instance = new GameComment();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод toString, класса GameComment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GameComment instance = new GameComment();
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }
    
}
