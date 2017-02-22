/*
 * Copyright (C) 2017 surzhin.konstantin
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
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;
import static org.hamcrest.CoreMatchers.equalTo;
import org.igo.entities.City;
import org.igo.entities.Country;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class CountyTest {

    public CountyTest() {
    }

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
            try {
                final Query q = em.createQuery("DELETE FROM Country");
                em.getTransaction().begin();
                q.executeUpdate();
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }

    @After
    public void tearDown() {
        if (em != null) {
            final Query q = em.createQuery("DELETE FROM Country");
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

        final Country country = new Country();
        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("RUS");

        assertTrue(country.getId() == 0);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }

        assertTrue(country.getId() != 0);
    }

    @Test(expected = PersistenceException.class)
    public void testNullCountyName() {
        System.out.println("NullCountyName");

        final Country country = new Country();

        country.setCountryName(null);
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("RUS");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testTooBigCountyName() {
        System.out.println("TooBigCountyName");

        final Country country = new Country();
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 257; i++) {
            sb.append("Р");
        }
        country.setCountryName(sb.toString());
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("RUS");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testTooSmallCountyName() {
        System.out.println("TooSmallCountyName");

        final Country country = new Country();

        country.setCountryName("");
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("RUS");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testSetNullAlpha2() {
        System.out.println("NullAlpha2");

        final Country country = new Country();

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2(null);
        country.setCountryCodeAlpha3("RUS");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSetEmtyAlpha2() {
        System.out.println("EmtyAlpha2");

        final Country country = new Country();

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("");
        country.setCountryCodeAlpha3("RUS");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testTooBigAlpha2() {
        System.out.println("TooBigAlpha2");

        final Country country = new Country();

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RUS");
        country.setCountryCodeAlpha3("RUS");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testNullAlpha3() {
        System.out.println("NullAlpha3");

        final Country country = new Country();

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3(null);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSetEmtyAlpha3() {
        System.out.println("EmtyAlpha3");

        final Country country = new Country();

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testTooBigAlpha3() {
        System.out.println("TooBigAlpha3");

        final Country country = new Country();

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RUS");
        country.setCountryCodeAlpha3("RUSSIA");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test
    public void testCountryNamedQuery() {
        System.out.println("CountryNamedQuery");

        if (em != null) {
            try {
                em.createNamedQuery("Country.findAll")
                        .getResultList();

                em.createNamedQuery("Country.findById")
                        .setParameter("id", (short) 1)
                        .getResultList();

                em.createNamedQuery("Country.findByCountryName")
                        .setParameter("countryName", "Россия")
                        .getResultList();

                em.createNamedQuery("Country.findByCountryAlpha2")
                        .setParameter("alpha2", "RU")
                        .getResultList();

                em.createNamedQuery("Country.findByCountryAlpha3")
                        .setParameter("alpha3", "RUS3")
                        .getResultList();

                em.createNamedQuery("Country.checkByCountryName")
                        .setParameter("countryName", "Россия")
                        .getSingleResult();

            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test
    public void testSetCities() {
        System.out.println("SetCities");

        final Country country = new Country("Россия", "RU", "RUS");
        final City city1 = new City("Москва");

        city1.setLatitude(1);
        city1.setLongitude(1);

        final City city2 = new City("Тула");

        city1.setLatitude(2);
        city1.setLongitude(3);
   
        final Set<City> citeis = new HashSet<>();

        citeis.add(city1);
        citeis.add(city2);

        city1.setCountry(country);
        city2.setCountry(country);

        country.setCities(citeis);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();

                final int size = em.createNamedQuery("City.findByCountryId")
                        .setParameter("countryId", country.getId())
                        .getResultList().size();

                assertThat(size, equalTo(2));

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

    @Test
    public void teastSetCountryBlobs() {
        System.out.println("CountryBlobs");

        final Country country = new Country("Россия", "RU", "RUS");
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1024; i++) {
            sb.append("B");
        }
        country.setBanner(sb.toString());
        country.setNationalEmblem(sb.toString());

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();
                em.clear();

                final String banner = em.createQuery("SELECT c.banner FROM Country c where c.id =:id", String.class)
                        .setParameter("id", country.getId())
                        .getSingleResult();

                assertThat(banner.length(), equalTo(1024));
                
                final String nationalEmblem = em.createQuery("SELECT c.nationalEmblem FROM Country c where c.id =:id", String.class)
                        .setParameter("id", country.getId())
                        .getSingleResult();
                
                assertThat(nationalEmblem.length(), equalTo(1024));

            } catch (PersistenceException ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }
}
