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
package org.igo.dbunit.entities;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.igo.entities.City;

/**
 *
 * @author surzhin.konstantin
 */
class CityService {
    private EntityManager em = Persistence.createEntityManagerFactory("testGamePU_MySQL").createEntityManager();
 
    public void save(City city){
        em.getTransaction().begin();
        em.persist(city);
        em.getTransaction().commit();
    }
 
    public void delete(City city) {
        em.getTransaction().begin();
        em.remove(city);
        em.getTransaction().commit();
    }
 
    public City get(int id) {
        return em.find(City.class, id);
    }
 
    public void update(City city) {
        em.getTransaction().begin();
        em.merge(city);
        em.getTransaction().commit();
    }
 
    public List<City> getAll() {
        TypedQuery<City> namedQuery = em.createNamedQuery("City.findAll",City.class);
         return namedQuery.getResultList();
    }
}
