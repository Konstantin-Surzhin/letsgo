/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.user.degree.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.IUserDegreeRemote;
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
public class UserDegreeSessionBeanTest {
    
    public UserDegreeSessionBeanTest() {
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
     * Test of getUserDegree method, of class UserDegreeSessionBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetUserDegree() throws Exception {
        System.out.println("getUserDegree");
        int userId = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            IUserDegreeRemote instance = (IUserDegreeRemote)container.getContext().lookup("java:global/classes/UserDegreeSessionBean");
            String expResult = "31k";
            String result = instance.getUserDegree(userId);
            assertEquals(expResult, result);
        }
    }
}
