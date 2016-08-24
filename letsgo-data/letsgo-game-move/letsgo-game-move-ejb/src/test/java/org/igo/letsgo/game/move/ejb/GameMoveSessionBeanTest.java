/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.game.move.ejb;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.IGameMoveRemote;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author surzhin.konstantin
 */
public class GameMoveSessionBeanTest {

    public GameMoveSessionBeanTest() {
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

    @Test
    public void testGetGame() throws Exception {
        System.out.println("getGame");
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            IGameMoveRemote instance = (IGameMoveRemote) container.getContext().lookup("java:global/classes/GameMoveSessionBean");
            List<String> result = instance.getGameMoves();
           // assertEquals(expResult, result);
        }
    }
}
