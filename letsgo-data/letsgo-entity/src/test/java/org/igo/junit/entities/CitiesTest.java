/*
 * Copyright (C) 2016 surzhin.konstantin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.igo.junit.entities;

import java.util.Arrays;
import java.util.Collection;
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
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class CitiesTest {

    @Parameterized.Parameter(value = 0)
    static public EntityManagerFactory emf;

    @Parameterized.Parameters
    public static Collection dataBaseParam() {
        EntityManagerFactory emf0 = null;
        EntityManagerFactory emf1 = null;

        if (LetsgoEntityTestSuite.emf0 == null) {
            emf0 = Persistence.createEntityManagerFactory("testGamePU_MySQL");
        }
        if (LetsgoEntityTestSuite.emf1 == null) {
            emf1 = Persistence.createEntityManagerFactory("testGamePU_H2");
        }
        Object[][]param = {{emf0}, {emf1}};

        return Arrays.asList(param);
    }

    private EntityManager em;

    public CitiesTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
        if (emf != null) {
            emf.close();
        }

    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
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
