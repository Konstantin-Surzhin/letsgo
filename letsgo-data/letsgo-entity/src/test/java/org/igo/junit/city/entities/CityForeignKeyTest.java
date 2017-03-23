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
import javax.persistence.Query;
import org.igo.entities.City;
import org.igo.entities.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class CityForeignKeyTest extends BaseCityParametrezedTest {

    public CityForeignKeyTest() {
    }

    @Test(expected = PersistenceException.class)
    public void testCountryForignKeyDelete() throws Exception {
        System.out.println("CountryForignKeyDelete");

        final Country country = new Country("Россия", "RU", "RUS");
        final City city = new City("Москва");

        city.setCountry(country);
        country.addCity(city);

        final EntityManager entityManager = this.getEntityManager();

        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(country);
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                final Query q = entityManager.createQuery("DELETE FROM Country");

                entityManager.getTransaction().begin();
                q.executeUpdate();
                entityManager.getTransaction().commit();

            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                throw ex;
            } finally {

                final Query q1 = entityManager.createQuery("DELETE FROM City");
                final Query q2 = entityManager.createQuery("DELETE FROM Country");

                entityManager.getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                entityManager.getTransaction().commit();
            }
        }
    }
}
