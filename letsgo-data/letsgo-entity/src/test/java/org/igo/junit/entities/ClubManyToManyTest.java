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
import org.igo.entities.Club;
import org.igo.entities.League;
import static org.igo.junit.entities.CityCacheTest.emf;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class ClubManyToManyTest {

    public ClubManyToManyTest() {
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

    @Before
    public void setUp() {
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDownClass() {
        if (emf != null) {
            emf.close();
        }
    }

    @Test
    public void testSetLeagueToClub() {
        System.out.println("SetLeagueToClub");

        final League league = new League("Городская лига А");
        final Set<League> leagues = new HashSet<>();
        leagues.add(league);

        final Club club = new Club("Ротор");
        league.addClub(club);

        club.setLeagues(leagues);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(league);
                em.persist(club);
                em.getTransaction().commit();
                final int clubSize = em
                        .createQuery("SELECT c FROM Club c")
                        .getResultList()
                        .size();
                assertThat(clubSize, equalTo(1));

                final int leagueSize = em
                        .createQuery("SELECT l FROM League l")
                        .getResultList()
                        .size();
                assertThat(leagueSize, equalTo(1));

            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = em.createQuery("DELETE FROM Club");
                final Query q2 = em.createQuery("DELETE FROM League");
                em.getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                em.getTransaction().commit();
            }
        } else {
            fail("EntityManager null");
        }
    }

    @Test
    public void testDeleFromClub() {
        System.out.println("DeleFromClub");

        final League league = new League("Городская лига А");
        final Set<League> leagues = new HashSet<>();
        leagues.add(league);

        final Club club = new Club("Ротор");
        league.addClub(club);

        club.setLeagues(leagues);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(league);
                em.persist(club);
                em.getTransaction().commit();
                int clubSize = em
                        .createQuery("SELECT c FROM Club c")
                        .getResultList()
                        .size();
                assertThat(clubSize, equalTo(1));

                int leagueSize = em
                        .createQuery("SELECT l FROM League l")
                        .getResultList()
                        .size();
                assertThat(leagueSize, equalTo(1));

                final Query q1 = em.createQuery("DELETE FROM Club");

                em.getTransaction().begin();
                q1.executeUpdate();
                em.getTransaction().commit();

                clubSize = em
                        .createQuery("SELECT c FROM Club c")
                        .getResultList()
                        .size();
                assertThat(clubSize, equalTo(0));

                leagueSize = em
                        .createQuery("SELECT l FROM League l")
                        .getResultList()
                        .size();
                assertThat(leagueSize, equalTo(1));

            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = em.createQuery("DELETE FROM Club");
                final Query q2 = em.createQuery("DELETE FROM League");
                em.getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                em.getTransaction().commit();
            }
        } else {
            fail("EntityManager null");
        }
    }

    @Test
    public void testDeleFromLeague() {
        System.out.println("DeleFromClub");

        final League league = new League("Городская лига А");
        final Set<League> leagues = new HashSet<>();
        leagues.add(league);

        final Club club = new Club("Ротор");
        league.addClub(club);

        club.setLeagues(leagues);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(league);
                em.persist(club);
                em.getTransaction().commit();
                int clubSize = em
                        .createQuery("SELECT c FROM Club c")
                        .getResultList()
                        .size();
                assertThat(clubSize, equalTo(1));

                int leagueSize = em
                        .createQuery("SELECT l FROM League l")
                        .getResultList()
                        .size();
                assertThat(leagueSize, equalTo(1));

                final Query q1 = em.createQuery("DELETE FROM League");

                em.getTransaction().begin();
                q1.executeUpdate();
                em.getTransaction().commit();

                clubSize = em
                        .createQuery("SELECT c FROM Club c")
                        .getResultList()
                        .size();
                assertThat(clubSize, equalTo(1));

                leagueSize = em
                        .createQuery("SELECT l FROM League l")
                        .getResultList()
                        .size();
                assertThat(leagueSize, equalTo(0));

            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = em.createQuery("DELETE FROM Club");
                final Query q2 = em.createQuery("DELETE FROM League");
                em.getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                em.getTransaction().commit();
            }
        } else {
            fail("EntityManager null");
        }
    }
}
