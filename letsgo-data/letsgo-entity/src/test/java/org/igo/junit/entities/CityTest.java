/*
 * Copyright (C) 2016 surzhin.konstantin
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
import static org.hamcrest.CoreMatchers.*;
import org.igo.entities.City;
import org.igo.entities.Club;
import org.igo.entities.Country;
import org.igo.entities.GoUser;
import org.igo.entities.Team;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class CityTest {

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

    public CityTest() {
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

    /**
     * Test of getId method, of class City.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");

        final City city = new City();

        city.setCityName("Не резиновая!");

        assertTrue(city.getId() == -1);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
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

        if (em != null) {
            try {

                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                final String name = (String) em.createQuery("SELECT c.cityName FROM City c WHERE c.id=:id")
                        .setParameter("id", city.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getSingleResult();
                assertEquals(expResult, name);

            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
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

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
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

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.out.println(ex.getLocalizedMessage());
                for (Throwable t : ex.getSuppressed()) {
                    System.out.println("Suppressed: ------->>> " + t.getLocalizedMessage());
                }
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

        try {
            if (em != null) {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println(ex.getLocalizedMessage());
            throw ex;
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

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city1);
                em.persist(city2);
                em.getTransaction().commit();
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
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

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city1);
                em.persist(city2);
                em.getTransaction().commit();
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
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

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city1);
                em.persist(city2);
                em.getTransaction().commit();
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
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

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
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

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
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

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
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

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test
    public void testCityNamedQuereis() {
        System.out.println("CityNamedQuereis");

        if (em != null) {
            try {
                em.createNamedQuery("City.findAll")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList();

                em.createNamedQuery("City.findById")
                        .setHint("org.hibernate.readOnly", true)
                        .setParameter("id", 1)
                        .getResultList();

                em.createNamedQuery("City.findByCityName")
                        .setHint("org.hibernate.readOnly", true)
                        .setParameter("cityName", "Тула")
                        .getResultList();

            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test
    public void testCheckByCityNameNamedQuery() {
        System.out.println("checkByCityName");

        final Object cn = em.createNamedQuery("City.checkByCityName")
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

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(country);
                em.persist(city);
                em.getTransaction().commit();
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

    @Test(expected = RollbackException.class)
    public void testCountryForignKeyPersist() throws Exception {
        System.out.println("CountryForignKeyPersist");

        final Country country = new Country();
        final City city = new City("Москва");

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("RUS");

        city.setCountry(country);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
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

    @Test(expected = PersistenceException.class)
    public void testCountryForignKeyDelete() throws Exception {
        System.out.println("CountryForignKeyDelete");

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
                em.persist(country);
                em.persist(city);
                em.getTransaction().commit();

                final Query q = em.createQuery("DELETE FROM Country");
                em.getTransaction().begin();
                q.executeUpdate();
                em.getTransaction().commit();

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
    public void testSetClubsNotNullNotSame() {
        System.out.println("SetClubsNotNullNotSame");

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
    public void testSetTeamsNotNullNotSame() {
        System.out.println("SetTeamsNotNullNotSame");

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

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
                final int size = em
                        .createQuery("SELECT c FROM Club c")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

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
    public void testAddClubs() throws PersistenceException {
        System.out.println("AddClubs");

        final City city = new City("Москва");
        final Club club = new Club("Зубило");

        club.setCity(city);
        city.addClub(club);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
                final int size = em
                        .createQuery("SELECT c FROM Club c")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

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
    public void testSetTeams() throws PersistenceException {
        System.out.println("SetTeam");

        final Set<Team> teams = new HashSet<>();
        final City city = new City("Москва");
        final Team team = new Team("Ветераны");

        teams.add(team);

        city.setTeams(teams);
        team.setCity(city);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
                final int size = em
                        .createQuery("SELECT t FROM Team t")
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

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
    public void testAddTeam() throws PersistenceException {
        System.out.println("AddTeam");

        final City city = new City("Москва");
        final Team team = new Team("Ветераны");

        team.setCity(city);
        city.addTeam(team);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
                final int size = em
                        .createQuery("SELECT t FROM Team t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

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

        if (em != null) {
            try {
                city.setTeams(teams1);
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                city.setTeams(teams2);
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                final int size = em
                        .createQuery("SELECT t FROM Team t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(2));

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
    public void testSetUsers() throws PersistenceException {
        System.out.println("SetUsers");

        final City city = new City("Москва");
        final Set<GoUser> users = new HashSet<>();
        users.add(new GoUser("AlphaGo", "AlphaGo@letsgo.ru"));
        city.setUsers(users);

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
                final int size = em
                        .createQuery("SELECT t FROM GoUser t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

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
    public void testAddUserInotCity() throws PersistenceException {
        System.out.println("AddUserInotCity");

        final City city = new City("Москва");
        city.addUser(new GoUser("AlphaGo", "AlphaGo@letsgo.ru"));

        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();
                final int size = em
                        .createQuery("SELECT t FROM GoUser t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

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
    public void testAddExistUserInotCity() throws PersistenceException {
        System.out.println("AddExistUserInotCity");

        final City city = new City("Москва");
        if (em != null) {
            try {
                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                final GoUser alphaGo = new GoUser("AlphaGo", "AlphaGo@letsgo.ru");
                final GoUser alphaZen = new GoUser("AlphaZen", "AlphaZen@letsgo.ru");

                em.getTransaction().begin();
                em.persist(alphaGo);
                em.persist(alphaZen);
                em.getTransaction().commit();
                final int goUserSize = em
                        .createQuery("SELECT t FROM GoUser t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(goUserSize, equalTo(2));

                city.addUser(alphaGo);
                city.addUser(alphaZen);

                alphaGo.setCity(city);
                alphaZen.setCity(city);

                em.getTransaction().begin();
                em.persist(city);
                em.getTransaction().commit();

                final int goUserFromCitySize = em
                        .createQuery("SELECT g FROM GoUser g WHERE g.city.id =  :cityId")
                        .setHint("org.hibernate.readOnly", true)
                        .setParameter("cityId", city.getId())
                        .getResultList()
                        .size();
                assertThat(goUserFromCitySize, equalTo(2));

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
