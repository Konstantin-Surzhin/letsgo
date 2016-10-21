/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.user.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.IPlaceRemote;
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
public class UserSessionBeanTest {
    
    public UserSessionBeanTest() {
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
            IPlaceRemote instance = (IPlaceRemote) container.getContext().lookup("java:global/classes/UserSessionBean");
            String expResult = "surzhin.konstantin";
            String result = instance.getPlaceTitle(id);
            assertEquals(expResult, result);
        }
    }
}
