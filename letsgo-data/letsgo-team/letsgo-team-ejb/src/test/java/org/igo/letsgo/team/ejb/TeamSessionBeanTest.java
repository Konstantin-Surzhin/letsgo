/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.team.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.ITeamRemote;
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
public class TeamSessionBeanTest {
    
    public TeamSessionBeanTest() {
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
        System.out.println("getTeamName");
        int id = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            ITeamRemote instance = (ITeamRemote)container.getContext().lookup("java:global/classes/TeamSessionBean");
            String expResult = "pleiades";
            String result = instance.getTeamName(id);
            assertEquals(expResult, result);
        }
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
