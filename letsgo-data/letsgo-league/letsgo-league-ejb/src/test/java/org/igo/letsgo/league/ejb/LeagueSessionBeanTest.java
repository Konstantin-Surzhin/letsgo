/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.league.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.ILeagueRemote;
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
public class LeagueSessionBeanTest {
    
    public LeagueSessionBeanTest() {
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
     * Test of getLeague method, of class LeagueSessionBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetLeague() throws Exception {
        System.out.println("getLeague");
        int id = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            ILeagueRemote instance = (ILeagueRemote)container.getContext().lookup("java:global/classes/LeagueSessionBean");
            String expResult = "";
            String result = instance.getLeague(id);
            assertEquals(expResult, result);
        }
    }
}
