/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.game.date.ejb;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.IGameDatesRemote;
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
public class GameDateSessionBeanTest {
    
    public GameDateSessionBeanTest() {
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
     * Test of getGameDates method, of class GameDateSessionBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetGameDates() throws Exception {
        System.out.println("getGameDates");
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            IGameDatesRemote instance = (IGameDatesRemote)container.getContext().lookup("java:global/classes/GameDateSessionBean");
            List<String> expResult = null;
            List<String> result = instance.getGameDates();
            assertEquals(expResult, result);
        }
    }
}
