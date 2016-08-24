/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.sql.Timestamp;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
public class CitiesTest {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CitiesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("testGamePU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    /**
     * Test of getId method, of class City.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        City city = new City();

        Integer result = city.getId();
        city.setCityName("Москва");
        assertNull(result);

        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();

        result = city.getId();
        assertNotNull(result);
    }

    /**
     * Test of getCityName method, of class City.
     */
    @Test
    public void testGetCityName() {
        System.out.println("getCityName");
        String expResult = "Ленинград";

        City city = new City();

        city.setCityName(expResult);

        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();

        Integer id = city.getId();

        em.getTransaction().begin();
        City c = em.find(City.class, id);
        em.getTransaction().commit();

        String result = c.getCityName();

        assertEquals(expResult, result);
    }

    /**
     * Test of setCityName method, of class City.
     */
    @Test
    public void testSetCityName() {
        System.out.println("setCityName");
        String cityName = "";
        City city = new City();
        city.setCityName(cityName);
    }

    /**
     * Test of getUsersCollection method, of class City.
     */
    @Test
    public void testGetUsersCollection() {
        System.out.println("getUsersCollection");
        City instance = new City();
        Collection<Users> expResult = null;
        Collection<Users> result = instance.getUsersCollection();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUsersCollection method, of class City.
     */
    @Test
    public void testSetUsersCollection() {
        System.out.println("setUsersCollection");
        Collection<Users> usersCollection = null;
        City instance = new City();
        instance.setUsersCollection(usersCollection);

    }

    /**
     * Test of hashCode method, of class City.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        City instance = new City();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of equals method, of class City.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        City instance = new City();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of toString method, of class City.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        City instance = new City();
        String expResult = "org.igo.ban.ejb.Cities[ id=null ]";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getVersion method, of class City.
     */
    @Test
    public void testGetVersion() {
        System.out.println("getVersion");
        City instance = new City();
        Timestamp expResult = null;
        Timestamp result = instance.getVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setVersion method, of class City.
     */
    @Test
    public void testSetVersion() {
        System.out.println("setVersion");
        Timestamp version = null;
        City instance = new City();
        instance.setVersion(version);
        // TODO review the generated test code and remove the default call to fail.

    }

}
