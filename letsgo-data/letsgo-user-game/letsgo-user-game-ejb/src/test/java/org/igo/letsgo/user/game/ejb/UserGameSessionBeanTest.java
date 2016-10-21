/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.user.game.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.ITeamRemote;
import org.igo.letsgo.remote.IUserGameRemote;
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
public class UserGameSessionBeanTest {
    
    public UserGameSessionBeanTest() {
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
     * Test of getTeamName method, of class TeamSessionBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetTeamName() throws Exception {
        System.out.println("getUserGame");
        int userId = 0;
        int gameId = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            IUserGameRemote instance = (IUserGameRemote)container.getContext().lookup("java:global/classes/UserGameSessionBean");
            String expResult = "no game";
            String result = instance.getUserGame(gameId, userId);
            assertEquals(expResult, result);
        }
    }
}
