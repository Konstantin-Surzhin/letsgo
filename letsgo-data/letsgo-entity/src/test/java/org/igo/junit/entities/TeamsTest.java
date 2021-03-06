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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import static org.hamcrest.CoreMatchers.equalTo;
import org.igo.entities.City;
import org.igo.entities.Team;
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
public class TeamsTest {

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

    public TeamsTest() {
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

    @Test
    public void testFetchTeam() throws PersistenceException {
        System.out.println("FetchTeam");

        final City city = new City("Москва");
        Team t1 = new Team("Зубило-дети");
        t1.setCity(city);
        Team t2 = new Team("Зубило-молодежка");
        t2.setCity(city);
        Team t3 = new Team("Зубило-взрослые");
        t3.setCity(city);
        Team t4 = new Team("Зубило-ветераны");
        t4.setCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                em.getTransaction().begin();
                em.persist(t1);
                em.persist(t2);
                em.persist(t3);
                em.persist(t4);
                em.getTransaction().commit();

                final TypedQuery<Team> q = em.createNamedQuery("Team.findTeamsByCityId", Team.class);
                final List<Team> t = q.setParameter("cityId", city.getId()).getResultList();
                assertThat(t.size(),equalTo(4));
            } catch (Throwable ex) {
                em.getTransaction().rollback();
                System.out.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q = em.createQuery("DELETE FROM Team");
                em.getTransaction().begin();
                q.executeUpdate();
                em.getTransaction().commit();
            }
        }
    }
}
