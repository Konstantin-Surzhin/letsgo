/*
 * Copyright (C) 2016 surzhin konstantin
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

import org.igo.junit.entities.BaseParametrezedTest;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import static org.hamcrest.CoreMatchers.*;
import org.igo.entities.City;
import org.igo.entities.Club;
import org.igo.entities.Country;
import org.igo.entities.GoUser;
import org.igo.entities.Team;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin konstantin
 */
@RunWith(Parameterized.class)
public class CityPropertyTest extends BaseParametrezedTest {

    public CityPropertyTest() {
    }

    /**
     * Test of getId method, of class City.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");

        final City city = new City("Не резиновая!");

        assertTrue(city.getId() == -1);
        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
        assertTrue(city.getId() != -1);
    }

    /**
     * Test of SetGetCityName method, of class City.
     */
    @Test
    public void testSetGetCityName() {
        System.out.println("setCityName");

        final City city = new City();
        final String expResult = "Москва";

        city.setCityName(expResult);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {

                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                final String name = entityManager
                        .createQuery("SELECT c.cityName FROM City c WHERE c.id=:id",String.class)
                        .setParameter("id", city.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getSingleResult();
                assertEquals(expResult, name);

            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
    }

    /**
     * Test of SetWrongSizeCityName method, of class City.
     */
    @Test(expected = RollbackException.class)
    //@Test(expected = ConstraintViolationException.class)
    public void testSetTooLongCityName() {
        System.out.println("SetTooLongCityName");

        final City city = new City();
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 257; i++) {
            sb.append("А");
        }

        city.setCityName(sb.toString());

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
    }

    @Test(expected = RollbackException.class)
    //@Test(expected = ConstraintViolationException.class)
    public void testSetTooSmallCityName() {
        System.out.println("SetTooSmallCityName");

        final City city = new City();

        city.setCityName("");

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
    }

    /**
     * Test of SetNullCityName method, of class City.
     */
    @Test(expected = PersistenceException.class)
    public void testSetNullCityName() {
        System.out.println("SetNullCityName");

        final City city = new City();

        city.setCityName(null);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
    }

    /**
     * Test of toString method, of class City.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        final City city = new City();
        final String expResult = "Москва";

        city.setCityName(expResult);

        assertEquals(expResult, city.toString());
    }

    @Test(expected = PersistenceException.class)
    public void testDulicateNameException() throws PersistenceException {
        System.out.println("DulicateNameException");

        final City city1 = new City("Москва");

        city1.setLatitude(1f);
        city1.setLongitude(1f);

        final City city2 = new City("Москва");

        city2.setLatitude(2f);
        city2.setLongitude(2f);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city1);
                entityManager.persist(city2);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testDulicateNameExceptionRule() {
        System.out.println("DulicateNameExceptionRule");
        thrown.expect(PersistenceException.class);

        final City city1 = new City("Москва");

        city1.setLatitude(1f);
        city1.setLongitude(1f);

        final City city2 = new City("Москва");

        city2.setLatitude(2f);
        city2.setLongitude(2f);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city1);
                entityManager.persist(city2);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testDulicateLatLonException() throws PersistenceException {
        System.out.println("DulicateLatLonException");

        final City city1 = new City("Москва");

        city1.setLatitude(1f);
        city1.setLongitude(1f);

        final City city2 = new City("Санкт-Петербург");

        city2.setLatitude(1f);
        city2.setLongitude(1f);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city1);
                entityManager.persist(city2);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLatitudeTooSmall() throws PersistenceException {
        System.out.println("LatitudeTooSmall");

        final City city = new City("Москва");

        city.setLatitude(-91f);
        city.setLongitude(1f);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLatitudeTooBig() throws PersistenceException {
        System.out.println("LatitudeTooBig");

        final City city = new City("Москва");

        city.setLatitude(91f);
        city.setLongitude(1f);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongitudeTooSmall() throws PersistenceException {
        System.out.println("LatitudeTooSmall");

        final City city = new City("Москва");

        city.setLatitude(1f);
        city.setLongitude(-181f);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLongitudeTooBig() throws PersistenceException {
        System.out.println("LatitudeTooSmall");

        final City city = new City("Москва");

        city.setLatitude(1f);
        city.setLongitude(181f);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            }
        }
    }

    @Test
    public void testCityNamedQuereis() {
        System.out.println("CityNamedQuereis");

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {

            entityManager.createNamedQuery("City.findAll")
                    .setHint("org.hibernate.readOnly", true)
                    .getResultList();

            entityManager.createNamedQuery("City.findById")
                    .setHint("org.hibernate.readOnly", true)
                    .setParameter("id", 1)
                    .getResultList();

            entityManager.createNamedQuery("City.findByCityName")
                    .setHint("org.hibernate.readOnly", true)
                    .setParameter("cityName", "Тула")
                    .getResultList();
        }
    }

    @Test
    public void testCheckByCityNameNamedQuery() {
        System.out.println("checkByCityName");

        final EntityManager entityManager = this.getEntityManager();

        final Object cn = entityManager.createNamedQuery("City.checkByCityName")
                .setHint("org.hibernate.readOnly", true)
                .setParameter("cityName", "Тамбов")
                .getSingleResult();

        assertThat(cn, equalTo(0l));
    }

    @Test
    public void testSetCountry() {
        System.out.println("SetCountry");

        final Country country = new Country();
        final City city = new City("Москва");

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("RUS");

        city.setCountry(country);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(country);
                entityManager.persist(city);
                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            } finally {
                this.deleteFromTable(entityManager, "City");
                this.deleteFromTable(entityManager, "Country");
            }
        }
    }

    @Test
    public void testSetClubsNotNullIsSame() {
        System.out.println("SetClubsNotNullIsSame");

        final Set<Club> clubs1 = new HashSet<>();
        final City city = new City("Москва");
        final Club club = new Club("Зубило");

        clubs1.add(club);
        city.setClubs(clubs1);

        final Set<Club> clubs2 = city.getClubs();

        assertNotNull(clubs2);
        assertSame(clubs1, clubs2);
    }

    @Test
    public void testSetTeamsNotNullIsSame() {
        System.out.println("SetTeamsNotNullIsSame");

        final Set<Team> teams1 = new HashSet<>();
        final City city = new City("Москва");
        final Team club = new Team("Зубило-дети");

        teams1.add(club);
        city.setTeams(teams1);

        final Set<Team> teams2 = city.getTeams();

        assertNotNull(teams2);
        assertSame(teams1, teams2);
    }

    @Test
    public void testSetClubs() throws PersistenceException {
        System.out.println("SetClubs");

        final Set<Club> clubs = new HashSet<>();
        final City city = new City("Москва");
        final Club club = new Club("Зубило");

        clubs.add(club);

        city.setClubs(clubs);
        club.setCity(city);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
                final int size = entityManager
                        .createQuery("SELECT c FROM Club c")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            } finally {
                deleteFromTable(entityManager, "Club");
            }
        }
    }

    @Test
    public void testAddClubs() throws PersistenceException {
        System.out.println("AddClubs");

        final City city = new City("Москва");
        final Club club = new Club("Зубило");

        club.setCity(city);
        city.addClub(club);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
                final int size = entityManager
                        .createQuery("SELECT c FROM Club c")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            } finally {
                deleteFromTable(entityManager, "Club");
            }
        }
    }

    @Test
    public void testSetTeams() throws PersistenceException {
        System.out.println("SetTeam");

        final Set<Team> teams = new HashSet<>();
        final City city = new City("Москва");
        final Team team = new Team("Ветераны");

        teams.add(team);

        city.setTeams(teams);
        team.setCity(city);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
                final int size = entityManager
                        .createQuery("SELECT t FROM Team t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            } finally {
                deleteFromTable(entityManager, "Team");
            }
        }
    }

    @Test
    public void testAddTeamToCity() throws PersistenceException {
        System.out.println("AddTeamTtCity");

        final City city = new City("Москва");
        final Team team = new Team("Ветераны");

        team.setCity(city);
        city.addTeam(team);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
                final int size = entityManager
                        .createQuery("SELECT t FROM Team t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            } finally {
                deleteFromTable(entityManager, "Team");
            }
        }
    }

    @Test
    public void testSetTwoTeams() throws PersistenceException {
        System.out.println("SetTwoTeams");

        final City city = new City("Москва");
        Set<Team> teams1 = new HashSet<>();
        Set<Team> teams2 = new HashSet<>();

        final Team team1 = new Team("Молодежь");
        final Team team2 = new Team("Ветераны");

        team1.setCity(city);
        teams1.add(team1);

        team2.setCity(city);
        teams2.add(team2);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                city.setTeams(teams1);
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                city.setTeams(teams2);
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                final int size = entityManager
                        .createQuery("SELECT t FROM Team t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(2));

            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            } finally {
                deleteFromTable(entityManager, "Team");
            }
        }
    }

    @Test
    public void testSetUsers() throws PersistenceException {
        System.out.println("SetUsers");

        final City city = new City("Москва");
        final Set<GoUser> users = new HashSet<>();
        users.add(new GoUser("AlphaGo", "AlphaGo@letsgo.ru"));
        city.setUsers(users);

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
                final int size = entityManager
                        .createQuery("SELECT t FROM GoUser t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            } finally {
                deleteFromTable(entityManager, "GoUser");
            }
        }
    }

    @Test
    public void testAddUserInotCity() throws PersistenceException {
        System.out.println("AddUserInotCity");

        final City city = new City("Москва");
        city.addUser(new GoUser("AlphaGo", "AlphaGo@letsgo.ru"));

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();
                final int size = entityManager
                        .createQuery("SELECT t FROM GoUser t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            } finally {
                deleteFromTable(entityManager, "GoUser");
            }
        }
    }

    @Test
    public void testAddExistUserInotCity() throws PersistenceException {
        System.out.println("AddExistUserInotCity");

        final City city = new City("Москва");

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                final GoUser alphaGo = new GoUser("AlphaGo", "AlphaGo@letsgo.ru");
                final GoUser alphaZen = new GoUser("AlphaZen", "AlphaZen@letsgo.ru");

                entityManager.getTransaction().begin();
                entityManager.persist(alphaGo);
                entityManager.persist(alphaZen);
                entityManager.getTransaction().commit();
                final int goUserSize = entityManager
                        .createQuery("SELECT t FROM GoUser t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(goUserSize, equalTo(2));

                city.addUser(alphaGo);
                city.addUser(alphaZen);

                alphaGo.setCity(city);
                alphaZen.setCity(city);

                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                final int goUserFromCitySize = entityManager
                        .createQuery("SELECT g FROM GoUser g WHERE g.city.id =:cityId")
                        .setHint("org.hibernate.readOnly", true)
                        .setParameter("cityId", city.getId())
                        .getResultList()
                        .size();
                assertThat(goUserFromCitySize, equalTo(2));

            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            } finally {
                deleteFromTable(entityManager, "GoUser");
            }
        }
    }

}
