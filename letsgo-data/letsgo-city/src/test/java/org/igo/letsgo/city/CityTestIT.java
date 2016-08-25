/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.city;

import java.io.File;
import javax.ejb.EJB;
import org.igo.letsgo.remote.ICityRemote;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Arquillian.class)
public class CityTestIT {

    private static String letsgoHome;
    private static String jbossHome;

    public CityTestIT() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
//        letsgoHome = System.getenv("LETSGO_HOME");
//        jbossHome = System.getenv("JBOSS_HOME");
////        if (letsgoHome == null || letsgoHome.isEmpty()) {
////            System.err.println("LETSGO_HOME is empty");
////            throw new Exception("LETSGO_HOME is empty");
////        }
////        if (jbossHome == null || jbossHome.isEmpty()) {
////            System.err.println("JBOSS_HOME is empty");
////            throw new Exception("JBOSS_HOME is empty");
////        }
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

    @Deployment
    @OverProtocol("Servlet 3.0")
    public static EnterpriseArchive createTestArchive() {
        JavaArchive testLibraryHelper = ShrinkWrap.create(JavaArchive.class, "test-library.jar")
                .addClass(CityTestIT.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        EnterpriseArchive ear = ShrinkWrap.createFromZipFile(EnterpriseArchive.class, new File("d:/letsgo/letsgo-data/letsgo-city/letsgo-city-ear/target/letsgo-city-ear-1.0.ear"))
                .addAsLibrary(testLibraryHelper);

        System.out.println(ear.toString(true));
        return ear;
    }

    @EJB(lookup = "java:global/letsgo-city-ear-1.0/letsgo-city-ejb-1.0/CitySessionBean!org.igo.letsgo.remote.ICityRemote")
    private ICityRemote city;

    @Test
    public void testCityNotNull() {
        System.out.println("City is not null");
        assertNotNull("Ups! City is null", city);
    }

    @Test
    public void testGetCity() {
        System.out.println("test get City");
        assertEquals("Ups! City is not Moskow", "Moskow", city.getCity(0));
        System.out.println(city.getCity(0));
    }
}
