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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import static org.hamcrest.CoreMatchers.equalTo;
import org.igo.entities.City;
import org.igo.entities.League;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class CityLeagueM2MTest extends BaseCityParametrezedTest {

    public CityLeagueM2MTest() {
    }

    @Test
    public void testAddLeagueToCityAndPersistByCascade() throws PersistenceException {
        System.out.println("AddLeagueToCityAndPersistByCascade");

        final City city1 = new City("Москва", 1.0f, 1.0f);
        final League league1 = new League("Лига белой розы");
        final League league2 = new League("Лига черной розы");

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {

                entityManager.getTransaction().begin();
                entityManager.persist(city1);
                entityManager.persist(league1);
                entityManager.persist(league2);
                city1.addLeague(league1);
                city1.addLeague(league2);
                league1.addCity(city1);
                entityManager.getTransaction().commit();

                final int citySize = entityManager
                        .createQuery("SELECT c FROM City c ")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(citySize, equalTo(1));

                final int leagueSize = entityManager
                        .createQuery("SELECT l FROM League l")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(leagueSize, equalTo(2));

                final int leagueCitySize = entityManager
                        .createNativeQuery("SELECT * FROM letsgo.leagues_cities")
                        .setHint("org.hibernate.readOnly", true)
                        .getResultList()
                        .size();
                assertThat(leagueCitySize, equalTo(2));

            } catch (Exception ex) {
                this.rollbackTransaction(entityManager);
                throw ex;
            } finally {
                deleteFromTable(entityManager, "League");
            }
        }
    }
}
