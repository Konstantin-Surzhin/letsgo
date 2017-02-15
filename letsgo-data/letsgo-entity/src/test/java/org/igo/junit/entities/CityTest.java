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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;
import static org.hamcrest.CoreMatchers.*;
import org.igo.entities.City;
import org.igo.entities.Country;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class CityTest {

    @Parameterized.Parameter(value = 0)
    static public EntityManagerFactory emf;

    private EntityManager em;

    @Parameterized.Parameters
    public static Collection dataBaseParam() {

        final EntityManagerFactory emf0 = Persistence.createEntityManagerFactory("testGamePU_MySQL");
        final EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("testGamePU_H2");
        final Object[][] param = {{emf0}, {emf1}};

        return Arrays.asList(param);
    }

    public CityTest() {
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
        
        if (em != null) {
            final Query q = em.createQuery("DELETE FROM City");
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();
        }
    }

    @After
    public void tearDown() {
        if (em != null) {
            final Query q = em.createQuery("DELETE FROM City");
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();
            em.close();
        }
    }

    /**
     * Test of getId method, of class City.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");

        final City city = new City();
        
        city.setCityName("Не резиновая!");
        
        assertTrue(city.getId() == 0);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
        assertTrue(city.getId() != 0);
    }

    /**
     * Test of SetGetCityName method, of class City.
     */
    @Test
    public void testSetGetCityName() {
        System.out.println("setCityName");

        final City city = new City();
        final String expResult = "Москва";

        city.setCityName(expResult);

        if (em != null) {
            try {

                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                final String name = (String) em.createQuery("SELECT c.cityName FROM City c WHERE c.id=:id")
                        .setParameter("id", city.getId())
                        .getSingleResult();
                assertEquals(expResult, name);
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }

        }
    }

    /**
     * Test of SetWrongSizeCityName method, of class City.
     */
    @Test(expected = ConstraintViolationException.class)
    public void testSetTooBigCityName() {
        System.out.println("SetTooBigCityName");

        final City city = new City();
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 257; i++) {
            sb.append("А");
        }

        city.setCityName(sb.toString());

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSetTooSmallCityName() {
        System.out.println("SetTooSmallCityName");

        final City city = new City();

        city.setCityName("");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    /**
     * Test of SetNullCityName method, of class City.
     */
    @Test(expected = PersistenceException.class)
    public void testSetNullCityName() {
        System.out.println("SetNullCityName");

        final City city = new City();

        city.setCityName(null);

        try {
            if (em != null) {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.err.println(ex.getLocalizedMessage());
            throw ex;
        }
    }

    /**
     * Test of toString method, of class City.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        final City city = new City();
        final String expResult = "Москва";

        city.setCityName(expResult);

        assertEquals(expResult, city.toString());
    }

    @Test(expected = PersistenceException.class)
    public void testDulicateNameException() throws PersistenceException {
        System.out.println("DulicateNameException");

        final City city1 = new City("Москва");

        city1.setLatitude(1f);
        city1.setLongitude(1f);
        city1.setOktmo("45000000".toCharArray());

        final City city2 = new City("Москва");

        city2.setLatitude(2f);
        city2.setLongitude(2f);
        city2.setOktmo("46000000".toCharArray());

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city1);
                em.persist(city2);
                em.getTransaction().commit();
            } catch (Exception ex) {

                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testDulicateNameExceptionRule() {
        System.out.println("DulicateNameExceptionRule");
        thrown.expect(PersistenceException.class);

        final City city1 = new City("Москва");

        city1.setLatitude(1f);
        city1.setLongitude(1f);
        city1.setOktmo("45000000".toCharArray());

        final City city2 = new City("Москва");

        city2.setLatitude(2f);
        city2.setLongitude(2f);
        city2.setOktmo("46000000".toCharArray());

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city1);
                em.persist(city2);
                em.getTransaction().commit();
            } catch (Exception ex) {

                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testDulicateLatLonException() throws PersistenceException {
        System.out.println("DulicateLatLonException");

        final City city1 = new City("Москва");

        city1.setLatitude(1f);
        city1.setLongitude(1f);
        city1.setOktmo("45000000".toCharArray());

        final City city2 = new City("Санкт-Петербург");

        city2.setLatitude(1f);
        city2.setLongitude(1f);
        city2.setOktmo("40000000".toCharArray());

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city1);
                em.persist(city2);
                em.getTransaction().commit();
            } catch (Exception ex) {

                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testDulicateOktmoException() throws PersistenceException {
        System.out.println("DulicateLatLonException");

        final City city1 = new City("Москва");

        city1.setLatitude(1f);
        city1.setLongitude(1f);
        city1.setOktmo("45000000".toCharArray());

        final City city2 = new City("Санкт-Петербург");

        city2.setLatitude(2f);
        city2.setLongitude(2f);
        city2.setOktmo("45000000".toCharArray());

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city1);
                em.persist(city2);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testTooBigOktmo() throws PersistenceException {
        System.out.println("TooBigOktmo");

        final City city = new City("Москва");

        city.setLatitude(1f);
        city.setLongitude(1f);
        city.setOktmo("45000000000".toCharArray());

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testTooSmallOktmo() throws PersistenceException {
        System.out.println("TooSmallOktmo");

        final City city = new City("Москва");

        city.setLatitude(1f);
        city.setLongitude(1f);
        city.setOktmo("45".toCharArray());

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (ConstraintViolationException ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test
    public void testCityNamedQuereis() {
        System.out.println("CityNamedQuereis");

        if (em != null) {
            try {
                em.createNamedQuery("City.findAll").getResultList();

                em.createNamedQuery("City.findById")
                        .setParameter("id", 1)
                        .getResultList();

                em.createNamedQuery("City.findByCityName")
                        .setParameter("cityName", "Тула")
                        .getResultList();

            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test
    public void testCheckByCityNameNamedQuery() {
        System.out.println("checkByCityName");

        final Object cn = em.createNamedQuery("City.checkByCityName")
                .setParameter("cityName", "Тамбов")
                .getSingleResult();

        assertThat(cn, equalTo(0l));
    }

    @Test()
    public void testFindByOktmoQuery() {
        System.out.println("FindByOktmoQuery");

        final int size = em.createNamedQuery("City.findByOktmo")
                .setParameter("oktmo", "45000000".toCharArray())
                .getResultList()
                .size();

        assertThat(size, equalTo(0));
    }

    @Test
    public void testSetCountry() throws PersistenceException {
        System.out.println("SetCountry");

        final Country country = new Country();
        final City city = new City("Москва");

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("RUS");

        city.setCountry(country);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.persist(city);
                em.getTransaction().commit();
            } catch (PersistenceException ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = em.createQuery("DELETE FROM City");
                final Query q2 = em.createQuery("DELETE FROM Country");
                em.getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                em.getTransaction().commit();
            }
        }
    }
}
