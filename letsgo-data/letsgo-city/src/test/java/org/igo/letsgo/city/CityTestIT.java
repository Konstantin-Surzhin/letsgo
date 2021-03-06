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

    /**
     *
     */
    public CityTestIT() {
    }

    /**
     *
     * @throws Exception
     */
    @BeforeClass
    public static void setUpClass() throws Exception {

    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     * @return
     */
    @Deployment
    @OverProtocol("Servlet 3.0")
    public static EnterpriseArchive createTestArchive() {
     
        String letsgoHome = System.getenv("LETSGO_HOME");
        JavaArchive testLibraryHelper = ShrinkWrap.create(JavaArchive.class, "test-library.jar")
                .addClass(CityTestIT.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        String file = letsgoHome + "/letsgo-data/letsgo-city/letsgo-city-ear/target/letsgo-city-ear-1.0.ear";
        EnterpriseArchive ear = ShrinkWrap.createFromZipFile(EnterpriseArchive.class, new File(file))
                .addAsLibrary(testLibraryHelper);

        System.out.println(ear.toString(true));
        return ear;
    }

    @EJB(lookup = "java:global/letsgo-city-ear-1.0/letsgo-city-ejb-1.0/CitySessionBean!org.igo.letsgo.remote.ICityRemote")
    private ICityRemote city;

    /**
     *
     */
    @Test
    public void testCityNotNull() {
        System.out.println("City is not null: ");
        assertNotNull("Ups! City is null", city);
    }

    /**
     *
     */
    @Test
    public void testGetCity() {
        System.out.println("test get City");
        assertEquals("Ups! City is not Moskow", "Moskow", city.getCityName(0));
        System.out.println(city.getCityName(0));
    }
}
