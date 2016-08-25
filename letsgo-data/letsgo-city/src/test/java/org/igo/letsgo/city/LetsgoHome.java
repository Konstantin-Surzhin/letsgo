/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.city;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
/**
 *
 * @author surzhin.konstantin
 */
public class LetsgoHome {

    public LetsgoHome() {
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
    public void LetsgoHome() {
        System.out.println("LetsgoHome");
        String letsgoHome = System.getenv("LETSGO_HOME");
        assertNotNull("You need to set LETSGO_HOME env to prodject home path." , letsgoHome);
    }
        @Test
    public void JBossHome() {
//        System.out.println("JBossHome");
//        String letsgoHome = System.getenv("JBOSS_HOME");
//        assertNotNull("You need to set JBOSS_HOME env to jboss or wildfly home path." , letsgoHome);
    }
}
