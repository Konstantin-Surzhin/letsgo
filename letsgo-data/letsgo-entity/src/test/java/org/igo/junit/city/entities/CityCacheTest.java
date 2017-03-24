/*
 * Copyright (C) 2017 pl
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

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import static org.hamcrest.CoreMatchers.equalTo;
import org.igo.entities.City;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author pl
 */
@RunWith(Parameterized.class)
public class CityCacheTest extends BaseCityParametrezedTest {

    public CityCacheTest() {
    }

    @Test
    public void testCityInCache() {
        System.out.println("CityInCache");

        final City city = new City("Москва");
        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                assertTrue("Объекта в L1 кеше нет", entityManager.contains(city));
                entityManager.clear();
                assertFalse("Объекта в L1 кеше", entityManager.contains(city));

                final City nuvoCity = entityManager.find(City.class, city.getId());
                final Cache cache = entityManager.getEntityManagerFactory().getCache();

                entityManager.merge(nuvoCity);
                assertTrue("Объекта в L1 кеше нет", entityManager.contains(nuvoCity));
                assertTrue("Объекта в L2 кеше нет", cache.contains(City.class, nuvoCity.getId()));

                cache.evict(City.class, city.getId());
                assertFalse(cache.contains(City.class, city.getId()));

            } catch (Exception ex) {
                entityManager.getTransaction().rollback();
                throw ex;
            }
        }
    }

    @Test
    public void testUpdateCityWithNativSQLCityInCache() {
        System.out.println("UpdateCityWithNativSQLCityInCache");

        final City city = new City("Москва");

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {

            final Cache cache = entityManager.getEntityManagerFactory().getCache();

            try {
                entityManager.getTransaction().begin();
                entityManager.persist(city);
                entityManager.getTransaction().commit();

                entityManager.getTransaction().begin();
                final int number = entityManager
                        .createQuery("UPDATE City c SET c.cityName =:cityName WHERE c.id = :id")
                        .setParameter("cityName", "Новая Москва")
                        .setParameter("id", city.getId())
                        .executeUpdate();
                entityManager.getTransaction().commit();

                assertThat(number, equalTo(1));

                final String cityFromDbTadle = entityManager
                        .createQuery("SELECT c.cityName From City c WHERE c.id=:id", String.class)
                        .setParameter("id", city.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getSingleResult();
                assertThat(cityFromDbTadle, equalTo("Новая Москва"));

                assertTrue(entityManager.contains(city));

                final City cityFromCahe = entityManager.find(City.class, city.getId());

                assertThat(cityFromCahe.getCityName(), equalTo("Москва"));

                entityManager.refresh(cityFromCahe);
                assertThat(city.getCityName(), equalTo("Новая Москва"));
                assertThat(cityFromCahe.getCityName(), equalTo("Новая Москва"));

                cache.evict(City.class, city.getId());
                assertFalse(cache.contains(City.class, city.getId()));
            } catch (Exception ex) {
                entityManager.getTransaction().rollback();
                throw ex;
            }
        }
    }
}
