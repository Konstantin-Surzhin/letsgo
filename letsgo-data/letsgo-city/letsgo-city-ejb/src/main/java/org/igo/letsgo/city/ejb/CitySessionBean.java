/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.city.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.igo.entities.City;
import org.igo.letsgo.remote.ICityRemote;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class CitySessionBean implements ICityRemote {

    
    private EntityManager entityManager;

    @Override
    public String getCityName(final Integer id) {
        City city = getEntityManager().find(City.class, id);
        return city.getCityName();
    }

    @Override
    public Integer getCityId(final String name) {
        Integer id = null;
        TypedQuery<City> q = getEntityManager().createNamedQuery("City.findByCityName", City.class);
        q.setParameter("cityName", name);

        try {
            id = q.getSingleResult().getId();
        } catch (Exception ex) {
            ex.getLocalizedMessage();
        }
        return id;
    }

    /**
     * @return the em
     */
    
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * @param entityManager the em to set
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
}
