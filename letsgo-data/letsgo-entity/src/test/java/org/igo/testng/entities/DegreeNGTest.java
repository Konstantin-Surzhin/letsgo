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
import org.igo.entities.Degree;
import org.igo.entities.UserDegree;
import static org.testng.Assert.*;

/**
 *
 * @author pl
 */
public class DegreeNGTest {
    
    public DegreeNGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Тест метод getId, класса Degree.
     */
    @org.testng.annotations.Test
    public void testGetId() {
        System.out.println("getId");
        Degree instance = new Degree();
        Byte expResult = null;
        Byte result = instance.getId();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setId, класса Degree.
     */
    @org.testng.annotations.Test
    public void testSetId() {
        System.out.println("setId");
        Byte id = null;
        Degree instance = new Degree();
        instance.setId(id);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getDegreeValue, класса Degree.
     */
    @org.testng.annotations.Test
    public void testGetDegreeValue() {
        System.out.println("getDegreeValue");
        Degree instance = new Degree();
        String expResult = "";
        String result = instance.getDegreeValue();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setDegreeValue, класса Degree.
     */
    @org.testng.annotations.Test
    public void testSetDegreeValue() {
        System.out.println("setDegreeValue");
        String degreeValue = "";
        Degree instance = new Degree();
        instance.setDegreeValue(degreeValue);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод getUsersDegreesCollection, класса Degree.
     */
    @org.testng.annotations.Test
    public void testGetUsersDegreesCollection() {
        System.out.println("getUsersDegreesCollection");
        Degree instance = new Degree();
        Collection expResult = null;
        Collection result = instance.getUsersDegreesCollection();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод setUsersDegreesCollection, класса Degree.
     */
    @org.testng.annotations.Test
    public void testSetUsersDegreesCollection() {
        System.out.println("setUsersDegreesCollection");
        Collection<UserDegree> usersDegreesCollection = null;
        Degree instance = new Degree();
        instance.setUsersDegreesCollection(usersDegreesCollection);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод hashCode, класса Degree.
     */
    @org.testng.annotations.Test
    public void testHashCode() {
        System.out.println("hashCode");
        Degree instance = new Degree();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод equals, класса Degree.
     */
    @org.testng.annotations.Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Degree instance = new Degree();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }

    /**
     * Тест метод toString, класса Degree.
     */
    @org.testng.annotations.Test
    public void testToString() {
        System.out.println("toString");
        Degree instance = new Degree();
        String expResult = "";
        String result = instance.toString();
        assertEquals(result, expResult);
        // Просмотр списка задач TODO для сгенерированного кода теста и удаление вызова по умолчанию для случаев сбоя.
        fail("\u042d\u0442\u043e\u0442 \u0442\u0435\u0441\u0442 \u044f\u0432\u043b\u044f\u0435\u0442\u0441\u044f \u043f\u0440\u043e\u0442\u043e\u0442\u0438\u043f\u043e\u043c.");
    }
    
}
