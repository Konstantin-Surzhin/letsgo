/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.event.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.IEventRemote;
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
public class EventSessionBeanTest {
    
    public EventSessionBeanTest() {
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
     * Test of getEvent method, of class EventSessionBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetEvent() throws Exception {
        System.out.println("getEvent");
        int id = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            IEventRemote instance = (IEventRemote)container.getContext().lookup("java:global/classes/EventSessionBean");
            String expResult = "";
            String result = instance.getEvent(id);
            assertEquals(expResult, result);
        }
    }
    
}
