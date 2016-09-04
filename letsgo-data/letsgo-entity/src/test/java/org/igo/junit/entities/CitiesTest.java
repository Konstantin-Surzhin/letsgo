/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.junit.entities;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.igo.entities.City;
import org.igo.entities.User;
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

    static private EntityManagerFactory emf;

    private EntityManager em;

    public CitiesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        if (LetsgoEntityTestSuite.emf == null) {
            emf = Persistence.createEntityManagerFactory("testGamePU_H2");
        }
    }

    @AfterClass
    public static void tearDownClass() {
        if (emf != null) {
            emf.close();
        }
    }

    @Before
    public void setUp() {
        if (emf != null) {
            em = emf.createEntityManager();
        } else {
            em = LetsgoEntityTestSuite.emf.createEntityManager();
        }

    }

    @After
    public void tearDown() {
        if (em != null) {
            em.close();
        }

    }

    /**
     * Test of getId method, of class City.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        City city = new City();

        Integer result = city.getId();

        assertNull(result);

        city.setCityName("Не резиновая!");

        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();

        result = city.getId();
        assertNotNull(result);
    }

    /**
     * Test of getCityNameResourseBandle method, of class City.
     */
    @Test
    public void testGetCityName() {
        System.out.println("getCityName");
        String expResult = "Москва";

        City city = new City();
        city.setCityName(expResult);

        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();

        Query q = em.createNativeQuery("select city_name from LETSGO.CITIES WHERE id=:id");

        q.setParameter("id", city.getId());

        String name = (String) q.getSingleResult();
        assertEquals(expResult, name);
    }

    /**
     * Test of setCityName method, of class City.
     */
    @Test
    public void testSetCityName() {
        System.out.println("setCityName");
        String cityName = "";
        City city = new City();
        // city.setCityName(cityName);
    }

    /**
     * Test of getUsersCollection method, of class City.
     */
    @Test
    public void testGetUsersCollection() {
        System.out.println("getUsers");
        City instance = new City();
        Set<User> expResult = null;
        Set<User> result = instance.getUserCollection();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUsersCollection method, of class City.
     */
    @Test
    public void testSetUsersCollection() {
        System.out.println("setUsers");
        Set<User> users = null;
        City instance = new City();
        instance.setUserCollection(users);

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
}
