/*
 * Copyright (C) 2017 pl
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
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.igo.entities.City;
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
 * @author pl
 */
@RunWith(Parameterized.class)
public class OptimisticLockTest {

    public OptimisticLockTest() {
    }

    @Parameterized.Parameter(value = 0)
    static public EntityManagerFactory emf;

    private EntityManager em;

    @Parameterized.Parameters
    public static Collection dataBaseParam() {

        final EntityManagerFactory emf0 = Persistence.createEntityManagerFactory("testGamePU_MySQL");
        final EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("testPU_PostgreSQL");
        final EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("testGamePU_H2");

        final Object[][] param = {{emf0}, {emf1}, {emf2}};

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

    @Test(expected = javax.persistence.OptimisticLockException.class)
    public void testCityOptimisticLock() {
        System.out.println("CityOptimisticLock");
        final City city = new City("Москва");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                em.clear();
                em.getEntityManagerFactory().getCache().evictAll();

                assertFalse("Объект city в L1 кеше", em.contains(city));
                assertFalse("Объект city в L2 кеше", em.getEntityManagerFactory()
                        .getCache()
                        .contains(City.class, city.getId()));

                final City cityFromDb = em.find(City.class, city.getId());
                cityFromDb.setLatitude(81);

                em.getTransaction().begin();
                em.persist(cityFromDb);
                em.getTransaction().commit();

                city.setLatitude(89);

                final City nuvoCity = em.merge(city);
                System.out.println(nuvoCity.getCityName());

            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }
}
