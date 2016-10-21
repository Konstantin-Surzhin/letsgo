/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.move.comment.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.IMoveCommentRemote;
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
public class MoveCommentSessionBeanTest {
    
    public MoveCommentSessionBeanTest() {
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
     * Test of getMoveComment method, of class MoveCommentSessionBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMoveComment() throws Exception {
        System.out.println("getMoveComment");
        int gameId = 0;
        int moveId = 0;
        int commentId = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            IMoveCommentRemote instance = (IMoveCommentRemote)container.getContext().lookup("java:global/classes/MoveCommentSessionBean");
            String expResult = "";
            String result = instance.getMoveComment(gameId, moveId, commentId);
            assertEquals(expResult, result);
        }
    }
}
