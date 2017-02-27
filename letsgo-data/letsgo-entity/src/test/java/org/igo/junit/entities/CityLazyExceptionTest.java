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
import javax.persistence.Query;
import static org.hamcrest.CoreMatchers.equalTo;
import org.hibernate.LazyInitializationException;
import org.igo.entities.City;
import org.igo.entities.Club;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
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
public class CityLazyExceptionTest {

    public CityLazyExceptionTest() {
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

    @Test(expected = LazyInitializationException.class)
    public void testLazyInitializationException() throws Exception {
        System.out.println("SetClubs");

        final Set<Club> clubs = new HashSet<>();
        final City city = new City("Москва");
        final Club club1 = new Club("Зубило");
        final Club club2 = new Club("Шайба");

        clubs.add(club1);
        clubs.add(club2);

        city.setClubs(clubs);
        club1.setCity(city);
        club2.setCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                em.clear();
                em.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = em.find(City.class, city.getId());
                em.clear();

                final String name = cityFromDb.getClubs().iterator().next().getClubName();
                System.out.println(name);

            } catch (Exception ex) {
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q = em.createQuery("DELETE FROM Club");
                em.getTransaction().begin();
                q.executeUpdate();
                em.getTransaction().commit();
            }
        }

    }
}
