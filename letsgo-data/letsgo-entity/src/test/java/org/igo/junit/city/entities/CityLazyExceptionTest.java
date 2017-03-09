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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class CityLazyExceptionTest extends BaseCityParametrezedTest {

    public CityLazyExceptionTest() {
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

        final EntityManager entityManafer = this.getEntityManager();
        if (entityManafer != null) {
            try {
                entityManafer.getTransaction().begin();
                entityManafer.persist(city);
                entityManafer.getTransaction().commit();

                entityManafer.clear();
                entityManafer.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = entityManafer.find(City.class, city.getId());
                entityManafer.clear();

                final String name = cityFromDb.getClubs().iterator().next().getClubName();
                System.out.println(name);

            } catch (Exception ex) {
                if (entityManafer.getTransaction().isActive()) {
                    entityManafer.getTransaction().rollback();
                }
                throw ex;
            } finally {
                final Query q = entityManafer.createQuery("DELETE FROM Club");
                entityManafer.getTransaction().begin();
                q.executeUpdate();
                entityManafer.getTransaction().commit();
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

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                entityManager.clear();
                entityManager.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = entityManager.find(City.class, city.getId());
                final String name = cityFromDb.getClubs().iterator().next().getClubName();
                System.out.println(name);

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw ex;
            } finally {
                entityManager.getTransaction().begin();
                entityManager.createQuery("DELETE FROM Club").executeUpdate();
                entityManager.getTransaction().commit();
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

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                entityManager.clear();
                entityManager.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = entityManager.find(City.class, city.getId());
                entityManager.clear();

                final String name = cityFromDb.getTeams().iterator().next().getTeamName();
                System.out.println(name);

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw ex;
            } finally {
                final Query q = entityManager.createQuery("DELETE FROM Team");
                entityManager.getTransaction().begin();
                q.executeUpdate();
                entityManager.getTransaction().commit();
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

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                entityManager.clear();
                entityManager.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = entityManager.find(City.class, city.getId());
                final String name = cityFromDb.getTeams().iterator().next().getTeamName();
                System.out.println(name);

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw ex;
            } finally {
                entityManager.getTransaction().begin();
                entityManager.createQuery("DELETE FROM Team").executeUpdate();
                entityManager.getTransaction().commit();
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

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(country);
                entityManager.getTransaction().commit();

                entityManager.clear();
                entityManager.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = entityManager.find(City.class, city.getId());
                entityManager.clear();

                final String name = cityFromDb.getCountry().getCountryName();
                System.out.println(name);

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw ex;
            } finally {
                entityManager.getTransaction().begin();
                entityManager.createQuery("DELETE FROM City").executeUpdate();
                entityManager.createQuery("DELETE FROM Country").executeUpdate();
                entityManager.getTransaction().commit();
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

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(country);
                entityManager.getTransaction().commit();

                entityManager.clear();
                entityManager.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = entityManager.find(City.class, city.getId());
                final String name = cityFromDb.getCountry().getCountryName();
                System.out.println(name);

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw ex;
            } finally {
                entityManager.getTransaction().begin();
                entityManager.createQuery("DELETE FROM City").executeUpdate();
                entityManager.createQuery("DELETE FROM Country").executeUpdate();
                entityManager.getTransaction().commit();
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

        final EntityManager entityManager = this.getEntityManager();

        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                entityManager.clear();
                entityManager.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = entityManager.find(City.class, city.getId());
                entityManager.clear();

                final String name = cityFromDb.getUsers().iterator().next().getUserName();
                System.out.println(name);

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw ex;
            } finally {
                entityManager.getTransaction().begin();
                entityManager.createQuery("DELETE FROM GoUser").executeUpdate();
                entityManager.getTransaction().commit();
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

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                entityManager.clear();
                entityManager.getEntityManagerFactory().getCache().evictAll();

                final City cityFromDb = entityManager.find(City.class, city.getId());
                final String name = cityFromDb.getUsers().iterator().next().getUserName();
                System.out.println(name);

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw ex;
            } finally {
                entityManager.getTransaction().begin();
                entityManager.createQuery("DELETE FROM GoUser").executeUpdate();
                entityManager.getTransaction().commit();
            }
        }
    }
}
