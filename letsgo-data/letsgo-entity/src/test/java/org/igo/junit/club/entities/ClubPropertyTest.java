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
package org.igo.junit.club.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;
import static org.hamcrest.CoreMatchers.equalTo;
import org.igo.entities.City;
import org.igo.entities.Club;
import org.igo.entities.Country;
import org.igo.entities.Team;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class ClubPropertyTest extends BaseClubParametrezedTest {

    public ClubPropertyTest() {
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

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();

                assertTrue(club.getId() != -1);

                getEntityManager().clear();
                getEntityManager().getEntityManagerFactory().getCache().evict(Club.class, club);

                final Club clubFromDb = getEntityManager().find(Club.class, club.getId());
                assertNotNull(clubFromDb);

            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }

    }

    @Test(expected = PersistenceException.class)
    public void testSetNullClubNameException() throws Exception {
        System.out.println("NullClubNameException");

        final Club club = new Club(null);

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();
            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testSetEmptyClubNameException() throws Exception {
        System.out.println("SetEmptyClubNameException");

        final Club club = new Club("");

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();
            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testSetTooLongClubNameException() throws Exception {
        System.out.println("SetTooLongClubNameException");

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 257; i++) {
            sb.append("А");
        }
        final Club club = new Club(sb.toString());

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();
            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test
    public void testSetClubName() {
        System.out.println("SetClubName");

        final Club club = new Club("Зубило");

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();

                final int size = getEntityManager().createNamedQuery("Club.findByClubName")
                        .setParameter("clubName", "Зубило")
                        .getResultList()
                        .size();
                assertThat(size, equalTo(1));

            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    

    @Test
    public void testPersistCityAndClubs() {
        System.out.println("PersistCityAndClubs");

        final City city = new City("Электросталь");
        final Club club = new Club("Зубило");
        club.setCity(city);

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(city);
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();

                final int clubsSize = getEntityManager().createNamedQuery("Club.findByClubName")
                        .setParameter("clubName", "Зубило")
                        .getResultList()
                        .size();
                assertThat(clubsSize, equalTo(1));

                final int citySize = getEntityManager().createNamedQuery("City.findByCityName")
                        .setParameter("cityName", "Электросталь")
                        .getResultList()
                        .size();
                assertThat(citySize, equalTo(1));

            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = getEntityManager().createQuery("Delete from Club");
                final Query q2 = getEntityManager().createQuery("Delete from City");

                getEntityManager().getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                getEntityManager().getTransaction().commit();
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

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club1);
                getEntityManager().persist(club2);
                getEntityManager().getTransaction().commit();
            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
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

        if (getEntityManager() != null) {
            try {
                club.setTeams(teams1);
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();

                club.setTeams(teams2);
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();

                final int size = getEntityManager()
                        .createQuery("SELECT t FROM Team t")
                        .getResultList()
                        .size();
                assertThat(size, equalTo(2));

            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q = getEntityManager().createQuery("DELETE FROM Team");
                getEntityManager().getTransaction().begin();
                q.executeUpdate();
                getEntityManager().getTransaction().commit();
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testDeleteClubButTeamsNotDeleteYet() throws PersistenceException {
        System.out.println("DeleteClubButTeamsNotDeleteYet");

        final Club club = new Club("Кутые окуни");
        final Set<Team> teams = new HashSet<>();
        teams.add(new Team("Молодежка"));
        teams.add(new Team("Ветераны"));

        if (getEntityManager() != null) {
            try {
                club.setTeams(teams);
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();

                getEntityManager().createQuery("DELETE FROM Club").executeUpdate();

            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q = getEntityManager().createQuery("DELETE FROM Team");
                getEntityManager().getTransaction().begin();
                q.executeUpdate();
                getEntityManager().getTransaction().commit();
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testPersisClubButCountryNotYetPesisted() throws Exception {
        System.out.println("PersisClubButCountryNotYetPesisted");

        final Country country = new Country();
        final Club club = new Club("Микроскопы");

        country.setCountryName("Россия");
        country.setCountryCodeAlpha2("RU");
        country.setCountryCodeAlpha3("RUS");

        club.setCountry(country);

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();
            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = getEntityManager().createQuery("DELETE FROM Club");
                final Query q2 = getEntityManager().createQuery("DELETE FROM Country");
                getEntityManager().getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                getEntityManager().getTransaction().commit();
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

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(country);
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();

                final Query q = getEntityManager().createQuery("DELETE FROM Country");
                getEntityManager().getTransaction().begin();
                q.executeUpdate();
                getEntityManager().getTransaction().commit();

            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = getEntityManager().createQuery("DELETE FROM Club");
                final Query q2 = getEntityManager().createQuery("DELETE FROM Country");
                getEntityManager().getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                getEntityManager().getTransaction().commit();
            }
        }
    }

    @Test
    public void testAddTeam() throws PersistenceException {
        System.out.println("AddTeam");

        final Club club = new Club("Торпедо");
        final Team team = new Team("Ветераны");

        team.setClub(club);
        club.addTeam(team);

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();
                final int teamSize = getEntityManager()
                        .createQuery("SELECT t FROM Team t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(teamSize, equalTo(1));
                final int ClubSize = getEntityManager()
                        .createQuery("SELECT t FROM Club t")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(ClubSize, equalTo(1));

            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q = getEntityManager().createQuery("DELETE FROM Team");
                getEntityManager().getTransaction().begin();
                q.executeUpdate();
                getEntityManager().getTransaction().commit();
            }
        }
    }
}
