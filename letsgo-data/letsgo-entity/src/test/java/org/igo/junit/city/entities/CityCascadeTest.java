/*
 * Copyright (C) 2017 surzhin konstantin
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
package org.igo.junit.city.entities;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.igo.entities.City;
import org.igo.entities.Country;
import static org.igo.junit.city.entities.BaseParametrezedTest.emf;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class CityCascadeTest extends BaseParametrezedTest {

    private EntityManager em;

    public CityCascadeTest() {
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

    @Test
    public void testCountryCascadePersist() {
        System.out.println("CountryCascadePersist");

        final Country country = new Country();
        final City city = new City("Москва");

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("RUS");

        city.setCountry(country);
        country.addCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
                
              final int countryListSize = em
                      .createQuery("SELECT c FROM Country c")
                      .setHint("org.hibernate.readOnly", true)
                      .getResultList().size();
              assertEquals(countryListSize, 1);
                
               final int cityFromDb = em.createQuery("SELECT c FROM City c where c.country.id =:countryId")
                       .setParameter("countryId", country.getId())
                       .setHint("org.hibernate.readOnly", true)
                       .getResultList().size();
              assertEquals(cityFromDb, 1);
                
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
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
