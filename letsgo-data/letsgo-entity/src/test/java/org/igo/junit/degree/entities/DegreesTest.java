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
package org.igo.junit.degree.entities;

import java.util.Collection;
import org.igo.entities.Degree;
import org.igo.entities.UserDegree;
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
public class DegreesTest {
    
    public DegreesTest() {
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
     * Test of getId method, of class Degree.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Degree instance = new Degree();
        Byte expResult = null;
        Byte result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Degree.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Byte id = null;
        Degree instance = new Degree();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDegreeValue method, of class Degree.
     */
    @Test
    public void testGetDegreeValue() {
        System.out.println("getDegreeValue");
        Degree instance = new Degree();
        String expResult = "";
        String result = instance.getDegreeValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDegreeValue method, of class Degree.
     */
    @Test
    public void testSetDegreeValue() {
        System.out.println("setDegreeValue");
        String degreeValue = "";
        Degree instance = new Degree();
        instance.setDegreeValue(degreeValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersDegreesCollection method, of class Degree.
     */
    @Test
    public void testGetUsersDegreesCollection() {
        System.out.println("getUsersDegreesCollection");
        Degree instance = new Degree();
        Collection<UserDegree> expResult = null;
        Collection<UserDegree> result = instance.getUsersDegreesCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsersDegreesCollection method, of class Degree.
     */
    @Test
    public void testSetUsersDegreesCollection() {
        System.out.println("setUsersDegreesCollection");
        Collection<UserDegree> usersDegreesCollection = null;
        Degree instance = new Degree();
        instance.setUsersDegreesCollection(usersDegreesCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Degree.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Degree instance = new Degree();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Degree.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Degree instance = new Degree();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Degree.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Degree instance = new Degree();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
