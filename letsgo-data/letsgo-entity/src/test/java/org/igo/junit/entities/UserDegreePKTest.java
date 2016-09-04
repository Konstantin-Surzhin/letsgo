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

import java.util.Date;
import org.igo.entities.UserDegreePK;
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
public class UserDegreePKTest {
    
    public UserDegreePKTest() {
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
     * Test of getAppointmentDate method, of class UserDegreePK.
     */
    @Test
    public void testGetAppointmentDate() {
        System.out.println("getAppointmentDate");
        UserDegreePK instance = new UserDegreePK();
        Date expResult = null;
        Date result = instance.getAppointmentDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppointmentDate method, of class UserDegreePK.
     */
    @Test
    public void testSetAppointmentDate() {
        System.out.println("setAppointmentDate");
        Date appointmentDate = null;
        UserDegreePK instance = new UserDegreePK();
        instance.setAppointmentDate(appointmentDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserId method, of class UserDegreePK.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        UserDegreePK instance = new UserDegreePK();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class UserDegreePK.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int userId = 0;
        UserDegreePK instance = new UserDegreePK();
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UserDegreePK.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserDegreePK instance = new UserDegreePK();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UserDegreePK.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UserDegreePK instance = new UserDegreePK();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UserDegreePK.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        UserDegreePK instance = new UserDegreePK();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
