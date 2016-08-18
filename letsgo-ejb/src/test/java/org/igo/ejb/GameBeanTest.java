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
package org.igo.ejb;

import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import org.igo.remote.intf.IGameRemote;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author surzhin.konstantin
 */
public class GameBeanTest {

    public GameBeanTest() {
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
     * Test of getString method, of class GameBean.
     */
    @Test
    public void testGetString() throws Exception {
        System.out.println("getString");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        IGameRemote instance = (IGameRemote) container.getContext().lookup("java:global/classes/GameBean");
//        String expResult = "";
//        String result = instance.getString();
//        assertEquals(expResult, result);
//        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class GameBean.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        IGameRemote instance = (IGameRemote) container.getContext().lookup("java:global/classes/GameBean");
//        Integer expResult = null;
//        Integer result = instance.create();
//        assertEquals(expResult, result);
//        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEm method, of class GameBean.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetEm() throws Exception {
        System.out.println("getEm");
        EntityManager expResult = mock(EntityManager.class);
        
        GameBean instance = new GameBean();
        
        instance.setEm(expResult);

        EntityManager result = instance.getEm();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEm method, of class GameBean.
     */
    @Test
    public void testSetEm() throws Exception {
        System.out.println("setEm");
        EntityManager expResult = mock(EntityManager.class);
        
        GameBean instance = new GameBean();

        instance.setEm(expResult);
        EntityManager result = instance.getEm();
        assertEquals(expResult, result);
    }
}
