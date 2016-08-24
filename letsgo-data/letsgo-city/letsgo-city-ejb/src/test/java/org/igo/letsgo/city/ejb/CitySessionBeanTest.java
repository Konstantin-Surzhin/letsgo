/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.city.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.ICityRemote;
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
public class CitySessionBeanTest {
    
    public CitySessionBeanTest() {
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
     * Test of getCity method, of class CitySessionBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetCity() throws Exception {
        System.out.println("getCity");
        int id = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            ICityRemote instance = (ICityRemote)container.getContext().lookup("java:global/classes/CitySessionBean");
            String expResult = "Moskow";
            String result = instance.getCity(id);
            assertEquals(expResult, result);
        }
    }
    
}
