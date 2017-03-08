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

import org.igo.junit.entities.BaseParametrezedTest;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.igo.entities.City;
import org.igo.entities.Country;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import static org.igo.junit.entities.BaseParametrezedTest.entityManagerFactory;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class CityCascadeTest extends BaseParametrezedTest {

    

    public CityCascadeTest() {
    }

    @AfterClass
    public static void tearDownClass() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Test
    public void testCountryCascadePersist() {
        System.out.println("CountryCascadePersist");

        final Country country = new Country("Россия","RU","RUS");
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
