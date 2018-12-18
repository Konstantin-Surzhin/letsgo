/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.place.ejb;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.igo.letsgo.remote.IPlaceRemote;
import org.igo.letsgo.remote.IUserRemote;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author surzhin.konstantin
 */
public class PlaceSessionBeanTest {

    private static EJBContainer ejbContainer;
    private static Context ctx;

    public PlaceSessionBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        ejbContainer = EJBContainer.createEJBContainer();
        System.out.println("Opening the container");
        ctx = ejbContainer.getContext();
    }

    @AfterClass
    public static void tearDownClass() {
        ejbContainer.close();
        System.out.println("Closing the container");
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

        IPlaceRemote instance = (IPlaceRemote) ctx.lookup("java:global/classes/IPlaceRemote");
        String expResult = "Moskow";
        String result = instance.getPlaceTitle(id);
        assertEquals(expResult, result);
        
    }
}
