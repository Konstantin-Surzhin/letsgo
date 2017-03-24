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

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import static org.hamcrest.CoreMatchers.equalTo;
import org.igo.entities.City;
import org.igo.entities.Club;
import org.igo.entities.Country;
import org.igo.entities.GoUser;
import org.igo.entities.Team;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class CityCascadeTest extends BaseCityParametrezedTest {

    public CityCascadeTest() {
    }

    @Test
    public void testSetCountryToCityAndPersistByCascade() {
        System.out.println("SetCountryToCityAndPersistByCascade");

        final Country country = new Country("Россия", "RU", "RUS");
        final City city = new City("Москва");

        city.setCountry(country);
        country.addCity(city);

        final EntityManager entityManager = this.getEntityManager();

        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                final int countryListSize = entityManager
                        .createQuery("SELECT c FROM Country c")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList().size();
                assertEquals(countryListSize, 1);

                final int cityFromDb = entityManager.createQuery("SELECT c FROM City c where c.country.id =:countryId")
                        .setParameter("countryId", country.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList().size();
                assertEquals(cityFromDb, 1);

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw ex;
            } finally {
                deleteFromTable(entityManager, "City");
                deleteFromTable(entityManager, "Country");
            }
        }
    }

    @Test
    public void testSetClubsToCityAndPersistByCascade() throws PersistenceException {
        System.out.println("SetClubsToCityAndPersistByCascade");

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
                final int size = entityManager
                        .createQuery("SELECT c FROM Club c WHERE c.city.id =:cityId")
                        .setParameter("cityId", city.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(2));

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    this.rollbackTransaction(entityManager);
                }
                throw ex;
            } finally {
                deleteFromTable(entityManager, "Club");
            }
        }
    }

    @Test
    public void testAddClubsToCityAndPersistByCascade() throws PersistenceException {
        System.out.println("AddClubsToCityAndPersistByCascade");

        final City city = new City("Москва");
        final Club club1 = new Club("Зубило");
        final Club club2 = new Club("Шайба");

        club1.setCity(city);
        city.addClub(club1);

        club2.setCity(city);
        city.addClub(club2);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
                final int size = entityManager
                        .createQuery("SELECT c FROM Club c WHERE c.city.id =:cityId")
                        .setParameter("cityId", city.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(2));

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    this.rollbackTransaction(entityManager);
                }
                throw ex;
            } finally {
                deleteFromTable(entityManager, "Club");
            }
        }
    }

    @Test
    public void testSetTeamsToCityAndPersistByCascade() throws PersistenceException {
        System.out.println("SetTeamsToCityAndPersistByCascade");

        final Set<Team> teams = new HashSet<>();
        final City city = new City("Москва");
        final Team team1 = new Team("Ветераны");
        final Team team2 = new Team("Молодежь");

        teams.add(team1);
        teams.add(team2);
        team1.setCity(city);
        team2.setCity(city);

        city.setTeams(teams);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
                final int size = entityManager
                        .createQuery("SELECT t FROM Team t WHERE t.city.id =:cityId")
                        .setParameter("cityId", city.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(2));

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    this.rollbackTransaction(entityManager);
                }
                throw ex;
            } finally {
                deleteFromTable(entityManager, "Team");
            }
        }
    }

    @Test
    public void testAddTeamsToCityPersistByCascade() throws PersistenceException {
        System.out.println("AddTeamsToCityPersistByCascade");

        final City city = new City("Москва");
        final Team team1 = new Team("Ветераны");
        final Team team2 = new Team("Молодежь");

        team1.setCity(city);
        team2.setCity(city);

        city.addTeam(team1);
        city.addTeam(team2);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
                final int size = entityManager
                        .createQuery("SELECT t FROM Team t WHERE t.city.id =:cityId")
                        .setParameter("cityId", city.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(2));

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    this.rollbackTransaction(entityManager);
                }
                throw ex;
            } finally {
                deleteFromTable(entityManager, "Team");
            }
        }
    }

    @Test
    public void testSetUsersToCityAndPersistByCascade() throws PersistenceException {
        System.out.println("SetUsersToCityAndPersistByCascade");

        final City city = new City("Москва");
        final Set<GoUser> users = new HashSet<>();
        final GoUser user1 = new GoUser("AlphaGo", "AlphaGo@letsgo.ru");
        final GoUser user2 = new GoUser("AlphaZen", "AlphaZen@letsgo.ru");

        user1.setCity(city);
        user2.setCity(city);

        users.add(user1);
        users.add(user2);

        city.setUsers(users);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
                final int size = entityManager
                        .createQuery("SELECT u FROM GoUser u WHERE u.city.id =:cityId")
                        .setParameter("cityId", city.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(2));

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    this.rollbackTransaction(entityManager);
                }
                throw ex;
            } finally {
                deleteFromTable(entityManager, "GoUser");
            }
        }
    }

    @Test
    public void testAddUsersToCityAndPersistByCascad() throws PersistenceException {
        System.out.println("AddUsersToCityAndPersistByCascad");

        final City city = new City("Москва");
        final GoUser user1 = new GoUser("AlphaGo", "AlphaGo@letsgo.ru");
        final GoUser user2 = new GoUser("AlphaZen", "AlphaZen@letsgo.ru");

        user1.setCity(city);
        user2.setCity(city);

        city.addUser(user1);
        city.addUser(user2);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
                final int size = entityManager
                        .createQuery("SELECT u FROM GoUser u WHERE u.city.id =:cityId")
                        .setParameter("cityId", city.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(2));

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    this.rollbackTransaction(entityManager);
                }
                throw ex;
            } finally {
                deleteFromTable(entityManager, "GoUser");
            }
        }
    }
}
