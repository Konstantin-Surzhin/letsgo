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
package igo.user.mockito;

import igo.user.User;
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
    
    /**
     *
     */
    public UserTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
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
        Long expResult = 1L;
        instance.setId(expResult);
        
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        User instance = new User();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User();
        String expResult = "Tom";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNikname method, of class User.
     */
    @Test
    public void testGetNikname() {
        System.out.println("getNikname");
        User instance = new User();
        String  expResult= "Don";
        instance.setNickName(expResult);
        String result = instance.getNickName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNikname method, of class User.
     */
    @Test
    public void testSetNikname() {
        System.out.println("setNikname");
        String nikname = "";
        User instance = new User();
        instance.setNickName(nikname);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
