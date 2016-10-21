/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.game.comments.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.IGameCommentRemote;
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
public class GameCommentSessionBeanTest {
    
    public GameCommentSessionBeanTest() {
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
     * Test of getGameComment method, of class GameCommentSessionBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetGameComment() throws Exception {
        System.out.println("getGameComment");
        int gameId = 0;
        int commentId = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            IGameCommentRemote instance = (IGameCommentRemote)container.getContext().lookup("java:global/classes/GameCommentSessionBean");
            String expResult = "";
            String result = instance.getGameComment(gameId, commentId);
            assertEquals(expResult, result);
        }
    }
}
