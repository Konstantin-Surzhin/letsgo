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
package org.igo.junit.city.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.LazyInitializationException;
import org.igo.entities.City;
import org.igo.entities.Club;
import org.igo.entities.Country;
import org.igo.entities.GoUser;
import org.igo.entities.Team;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class CityLazyExceptionTest extends BaseParametrezedTest {

    private EntityManager em;

    public CityLazyExceptionTest() {
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

            em.clear();
            em.getEntityManagerFactory().getCache().evictAll();
            em.close();
        }
    }

    @Test(expected = LazyInitializationException.class)
    public void testClubLazyInitializationException() throws Exception {
        System.out.println("ClubLazyInitializationException");

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
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
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

    @Test
    public void testClubLazyInitialization() {
        System.out.println("ClubLazyInitialization");

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
                final String name = cityFromDb.getClubs().iterator().next().getClubName();
                System.out.println(name);

            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
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

    @Test(expected = LazyInitializationException.class)
    public void testTeamLazyInitializationException() throws Exception {
        System.out.println("TeamLazyInitializationException");

        final Set<Team> teams = new HashSet<>();
        final City city = new City("Москва");
        final Team team1 = new Team("Спартак");
        final Team team2 = new Team("ЦСКА");

        teams.add(team1);
        teams.add(team2);

        city.setTeams(teams);
        team1.setCity(city);
        team2.setCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                em.clear();
                em.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = em.find(City.class, city.getId());
                em.clear();

                final String name = cityFromDb.getTeams().iterator().next().getTeamName();
                System.out.println(name);

            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
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

    @Test
    public void testTeamLazyInitialization() {
        System.out.println("TeamLazyInitialization");

        final Set<Team> teams = new HashSet<>();
        final City city = new City("Москва");
        final Team team1 = new Team("Спартак");
        final Team team2 = new Team("ЦСКА");

        teams.add(team1);
        teams.add(team2);

        city.setTeams(teams);
        team1.setCity(city);
        team2.setCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                em.clear();
                em.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = em.find(City.class, city.getId());
                final String name = cityFromDb.getTeams().iterator().next().getTeamName();
                System.out.println(name);

            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
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

    @Test(expected = LazyInitializationException.class)
    public void testCountryLazyInitializationException() throws Exception {
        System.out.println("CountryLazyInitializationException");

        final Set<City> cities = new HashSet<>();
        final Country country = new Country("Россия", "RU", "RUS");
        final City city = new City("Москва");

        cities.add(city);

        country.setCities(cities);
        city.setCountry(country);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();

                em.clear();
                em.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = em.find(City.class, city.getId());
                em.clear();

                final String name = cityFromDb.getCountry().getCountryName();
                System.out.println(name);

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

    @Test
    public void testCountryLazyInitialization() {
        System.out.println("CountryLazyInitialization");

        final Set<City> cities = new HashSet<>();
        final Country country = new Country("Россия", "RU", "RUS");
        final City city = new City("Москва");

        cities.add(city);

        country.setCities(cities);
        city.setCountry(country);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.getTransaction().commit();

                em.clear();
                em.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = em.find(City.class, city.getId());
                final String name = cityFromDb.getCountry().getCountryName();
                System.out.println(name);

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

    @Test(expected = LazyInitializationException.class)
    public void testUsersLazyInitializationException() throws Exception {
        System.out.println("UsersLazyInitializationException");

        final City city = new City("Москва");
        final Set<GoUser> users = new HashSet();
        final GoUser user = new GoUser("Вася", "pupkin@letsgo.ru");

        users.add(user);
        city.setUsers(users);
        user.setCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                em.clear();
                em.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = em.find(City.class, city.getId());
                em.clear();

                final String name = cityFromDb.getUsers().iterator().next().getUserName();
                System.out.println(name);

            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q = em.createQuery("DELETE FROM GoUser");
                em.getTransaction().begin();
                q.executeUpdate();
                em.getTransaction().commit();
            }
        }
    }

    @Test
    public void testUsersLazyInitialization() {
        System.out.println("UsersLazyInitializatio");

        final City city = new City("Москва");
        final Set<GoUser> users = new HashSet();
        final GoUser user = new GoUser("Вася", "pupkin@letsgo.ru");

        users.add(user);
        city.setUsers(users);
        user.setCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                em.clear();
                em.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = em.find(City.class, city.getId());
                final String name = cityFromDb.getUsers().iterator().next().getUserName();
                System.out.println(name);

            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q = em.createQuery("DELETE FROM GoUser");
                em.getTransaction().begin();
                q.executeUpdate();
                em.getTransaction().commit();
            }
        }
    }
}
