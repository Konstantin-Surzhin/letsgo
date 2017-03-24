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

import javax.persistence.EntityManager;
import org.igo.entities.City;
import org.igo.entities.Club;
import org.igo.entities.Country;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class ClubCascadeTest extends BaseClubParametrezedTest {

    @Test
    public void testSetCountryToClubAndPersistByCascade() {
        System.out.println("SetCountryToClubAndPersistByCascade");

        final Country country = new Country("Россия", "RU", "RUS");
        final Club club = new Club("Рога и копыта");

        club.setCountry(country);
        country.addClub(club);

        final EntityManager entityManager = this.getEntityManager();

        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(club);
                entityManager.getTransaction().commit();

                final int countryListSize = entityManager
                        .createQuery("SELECT c FROM Country c")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList().size();
                assertEquals(countryListSize, 1);

                final int clubFromDb = entityManager.createQuery("SELECT c FROM Club c where c.country.id =:countryId")
                        .setParameter("countryId", country.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList().size();
                assertEquals(clubFromDb, 1);

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw ex;
            } finally {
                deleteFromTable(entityManager, "Club");
                deleteFromTable(entityManager, "Country");
            }
        }
    }
    
    @Test
    public void testSetCityToClubAndPersistByCascade() {
        System.out.println("SetCityToClubAndPersistByCascade");

        final City city = new City("Москва");
        final Club club = new Club("Рога и копыта");

        club.setCity(city);
        city.addClub(club);

        final EntityManager entityManager = this.getEntityManager();

        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(club);
                entityManager.getTransaction().commit();

                final int countryListSize = entityManager
                        .createQuery("SELECT c FROM City c")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList().size();
                assertEquals(countryListSize, 1);

                final int clubFromDb = entityManager.createQuery("SELECT c FROM Club c where c.city.id =:cityId")
                        .setParameter("cityId", city.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList().size();
                assertEquals(clubFromDb, 1);

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw ex;
            } finally {
                deleteFromTable(entityManager, "Club");
                deleteFromTable(entityManager, "City");
            }
        }
    }
}
