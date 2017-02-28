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
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;
import static org.hamcrest.CoreMatchers.equalTo;
import org.igo.entities.City;
import org.igo.entities.Club;
import org.igo.entities.Country;
import org.igo.entities.League;
import org.igo.entities.Team;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
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
public class ClubTest {

    public ClubTest() {
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
            final Query q = em.createQuery("DELETE FROM Club");
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();
        }
    }

    @After
    public void tearDown() {
        if (em != null) {
            final Query q = em.createQuery("DELETE FROM Club");
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();

            em.clear();
            em.getEntityManagerFactory().getCache().evictAll();
            em.close();
        }
    }

    /**
     * Test of getId method, of class City.
     */
    @Test
    public void testGetId() {
        System.out.println("GetId");

        final Club club = new Club();
        club.setClubName("Болты и гайки");
        assertTrue(club.getId() == -1);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(club);
                em.getTransaction().commit();

                assertTrue(club.getId() != -1);

                em.clear();
                em.getEntityManagerFactory().getCache().evict(Club.class, club);

                final Club clubFromDb = em.find(Club.class, club.getId());
                assertNotNull(clubFromDb);

            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }

    }

    @Test(expected = PersistenceException.class)
    public void testSetNullClubNameException() throws Exception {
        System.out.println("NullClubNameException");

        final Club club = new Club(null);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(club);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSetEmptyClubNameException() throws Exception {
        System.out.println("SetEmptyClubNameException");

        final Club club = new Club("");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(club);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = ConstraintViolationException.class)
    public void testSetTooLongClubNameException() throws Exception {
        System.out.println("SetTooLongClubNameException");

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 257; i++) {
            sb.append("А");
        }
        final Club club = new Club(sb.toString());

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(club);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test
    public void testSetClubName() {
        System.out.println("SetClubName");

        final Club club = new Club("Зубило");

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(club);
                em.getTransaction().commit();

                final int size = em.createNamedQuery("Club.findByClubName")
                        .setParameter("clubName", "Зубило")
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testPersistClubButCityNotYetAlreadyPersist() {
        System.out.println("PersistClubButCityNotYetAlreadyPersist");

        final City city = new City("Электросталь");
        final Club club = new Club("Зубило");
        club.setCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(club);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testDeleteCityButClubsAreNotYetDelete() {
        System.out.println("DeleteCityButClubsAreNotYetDelete");

        final City city = new City("Электросталь");
        final Club club = new Club("Зубило");
        club.setCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.persist(club);
                em.getTransaction().commit();

                final Query q = em.createQuery("Delete from City");

                em.getTransaction().begin();
                q.executeUpdate();
                em.getTransaction().commit();

            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = em.createQuery("Delete from Club");
                final Query q2 = em.createQuery("Delete from City");

                em.getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                em.getTransaction().commit();
            }

        }
    }

    @Test
    public void testPersistCityAndClubs() {
        System.out.println("PersistCityAndClubs");

        final City city = new City("Электросталь");
        final Club club = new Club("Зубило");
        club.setCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.persist(club);
                em.getTransaction().commit();

                final int clubsSize = em.createNamedQuery("Club.findByClubName")
                        .setParameter("clubName", "Зубило")
                        .getResultList()
                        .size();
                assertThat(clubsSize, equalTo(1));

                final int citySize = em.createNamedQuery("City.findByCityName")
                        .setParameter("cityName", "Электросталь")
                        .getResultList()
                        .size();
                assertThat(citySize, equalTo(1));

            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = em.createQuery("Delete from Club");
                final Query q2 = em.createQuery("Delete from City");

                em.getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                em.getTransaction().commit();
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testSetNameToTheSameCityException() throws Exception {
        System.out.println("SetDuplicateClubNameToTheSameCityException");

        final City city = new City("Мышкин");
        final Club club1 = new Club("Джери и Том");
        final Club club2 = new Club("Джери и Том");
        club1.setCity(city);
        club2.setCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(club1);
                em.persist(club2);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test
    public void testSetTeams() throws PersistenceException {
        System.out.println("SetTeams");

        final Club club = new Club("Кутые окуни");
        final Set<Team> teams1 = new HashSet<>();
        teams1.add(new Team("Молодежка"));
        final Set<Team> teams2 = new HashSet<>();
        teams2.add(new Team("Ветераны"));

        if (em != null) {
            try {
                club.setTeams(teams1);
                em.getTransaction().begin();
                em.persist(club);
                em.getTransaction().commit();

                club.setTeams(teams2);
                em.getTransaction().begin();
                em.persist(club);
                em.getTransaction().commit();

                final int size = em
                        .createQuery("SELECT t FROM Team t")
                        .getResultList()
                        .size();
                assertThat(size, equalTo(2));

            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q = em.createQuery("DELETE FROM Team");
                em.getTransaction().begin();
                q.executeUpdate();
                em.getTransaction().commit();
            }
        }
    }

    @Test(expected = RollbackException.class)
    public void testPersisClubButCountryNotYetPesisted() throws Exception {
        System.out.println("PersisClubButCountryNotYetPesisted");

        final Country country = new Country();
        final Club club = new Club("Микроскопы");

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("RUS");

        club.setCountry(country);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(club);
                em.getTransaction().commit();
            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = em.createQuery("DELETE FROM Club");
                final Query q2 = em.createQuery("DELETE FROM Country");
                em.getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                em.getTransaction().commit();
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testDeleteCountrButCountryClubsNotDeleteYet() throws Exception {
        System.out.println("DeleteCountrButCountryClubsNotDeleteYet");

        final Country country = new Country();
        final Club club = new Club("Москва");

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("RUS");

        club.setCountry(country);
        country.addClub(club);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.persist(club);
                em.getTransaction().commit();

                final Query q = em.createQuery("DELETE FROM Country");
                em.getTransaction().begin();
                q.executeUpdate();
                em.getTransaction().commit();

            } catch (Exception ex) {
                em.getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = em.createQuery("DELETE FROM Club");
                final Query q2 = em.createQuery("DELETE FROM Country");
                em.getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                em.getTransaction().commit();
            }
        }
    }

    @Test
    public void testSetLeagueToCity() {
        System.out.println("SetLeagueToCity");

        final League league = new League("Городская лига А");
        final Club club = new Club("Ротор");
        club.setLeague(league);
        league.addClub(club);

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
        }
    }

    @Test(expected = PersistenceException.class)
    public void testPersistCityButLeagueNotPersistYet() throws Exception {
        System.out.println("PersistCityButLeagueNotPersistYet");

        final League league = new League("Городская лига А");
        final Club club = new Club("Ротор");
        club.setLeague(league);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(club);
                em.getTransaction().commit();

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
        }
    }
}
