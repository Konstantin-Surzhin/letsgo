/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.place.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.IUserRemote;
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
public class PlaceSessionBeanTest {

    public PlaceSessionBeanTest() {
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
     * Test of getPlaceTitle method, of class PlacesFacade.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testGetPlaceTitle() throws Exception {
        System.out.println("getPlaceTitle");
        int id = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            IUserRemote instance = (IUserRemote) container.getContext().lookup("java:global/classes/PlaceSessionBean");
            String expResult = "Moskow";
            String result = instance.getUserName(id);
            assertEquals(expResult, result);
        }
    }
}
