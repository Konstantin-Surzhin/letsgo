/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.game.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.IGameRemote;
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
public class GameSessionBeanTest {
    
    public GameSessionBeanTest() {
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
     * Test of getGame method, of class GameSessionBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetGame() throws Exception {
        System.out.println("getGame");
        int id = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            IGameRemote instance = (IGameRemote)container.getContext().lookup("java:global/classes/GameSessionBean");
            String expResult = "Leningrad";
            String result = instance.getGame(id);
            assertEquals(expResult, result);
        }
    }
}
