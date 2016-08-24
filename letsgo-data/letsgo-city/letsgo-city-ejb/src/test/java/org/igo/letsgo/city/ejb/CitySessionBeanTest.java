/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.city.ejb;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
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

    private EJBContainer container;

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
        Properties properties = new Properties();
        properties.setProperty(EJBContainer.MODULES, "letsgo-city-ejb");
        properties.put(EJBContainer.PROVIDER, "tomee-embedded");
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
    }

    @After
    public void tearDown() {
        container.close();
    }

    /**
     * Test of getCity method, of class CitySessionBean.
     *
     *
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        try {
            ICityRemote instance = (ICityRemote) container.getContext().lookup("java:global/letsgo-city-ejb/CitySessionBean!org.igo.letsgo.remote.ICityRemote");
            String expResult = "Moskow";
            String result = instance.getCity(0);
            assertEquals(expResult, result);
        } catch (NamingException ex) {
            System.out.println(ex.getExplanation());
        }
    }
}
