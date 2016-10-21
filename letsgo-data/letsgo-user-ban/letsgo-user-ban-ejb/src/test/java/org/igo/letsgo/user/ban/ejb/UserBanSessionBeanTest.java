/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.user.ban.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.IUserBanRemote;
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
public class UserBanSessionBeanTest {
    
    public UserBanSessionBeanTest() {
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
     * Test of getBan method, of class UserBanSessionBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetBan() throws Exception {
        System.out.println("getBan");
        int id = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            IUserBanRemote instance = (IUserBanRemote)container.getContext().lookup("java:global/classes/UserBanSessionBean");
            String expResult = "no ban";
            String result = instance.getBan(id);
            assertEquals(expResult, result);
        }
    }
}
