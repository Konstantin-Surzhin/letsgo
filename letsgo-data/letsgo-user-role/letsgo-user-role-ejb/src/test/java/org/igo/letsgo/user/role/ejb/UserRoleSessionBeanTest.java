/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.user.role.ejb;

import javax.ejb.embeddable.EJBContainer;
import org.igo.letsgo.remote.IUserRoleRemote;
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
public class UserRoleSessionBeanTest {
    
    public UserRoleSessionBeanTest() {
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
     * Test of getRole method, of class UserRoleSessionBean.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetRole() throws Exception {
        System.out.println("getRole");
        int id = 0;
        try (EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer()) {
            IUserRoleRemote instance = (IUserRoleRemote)container.getContext().lookup("java:global/classes/UserRoleSessionBean");
            String expResult = "REGULAR";
            String result = instance.getRole(id);
            assertEquals(expResult, result);
        }
    }
}
