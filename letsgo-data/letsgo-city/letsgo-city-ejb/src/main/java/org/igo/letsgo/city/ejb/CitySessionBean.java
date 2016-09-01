/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.city.ejb;

import com.sun.istack.internal.logging.Logger;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.igo.entities.City;
import org.igo.entities.User;
import org.igo.letsgo.remote.ICityRemote;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class CitySessionBean implements ICityRemote {

    Logger logger = Logger.getLogger(CitySessionBean.class);
    private EntityManager entityManager;

    @Override
    public String getCityName(final Integer id) {
        City city = getEntityManager().find(City.class, id);
        return city.getCityName();
    }

    @Override
    public Integer getCityId(final String name) {

        TypedQuery<City> q = getEntityManager().createNamedQuery("City.findByCityName", City.class);
        q.setParameter("cityName", name);

        try {
            return q.getSingleResult().getId();
        } catch (Exception ex) {
            return -1; //id not found
        }
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

    @Override
    public List<String> getAllCityName(String name) {
        TypedQuery<City> q = getEntityManager().createNamedQuery("City.findAll", City.class);
        List<City> names = q.getResultList();

        List<String> listCityName = names.stream()
                .map(c -> c.getCityName())
                .sorted()
                .collect(Collectors.toList());
        return listCityName;
    }

    @Override
    public List<String> getAllCityUser(final String name) {

        TypedQuery<City> q = getEntityManager().createNamedQuery("City.findByCityName", City.class);
        q.setParameter("cityName", name);

        try {
            Integer id = q.getSingleResult().getId();
            City city = getEntityManager().find(City.class, id);
            Set<User> users = city.getUserCollection();
            List<String> listUsersName = users.stream()
                    .map(c -> c.getName())
                    .sorted()
                    .collect(Collectors.toList());
            return listUsersName;
        } catch (Exception ex) {
            ex.getLocalizedMessage();
            return null;
        }
    }

    @Override
    public List<String> getAllCityUser(final Integer id) {
        City city = getEntityManager().find(City.class, id);
        Set<User> users = city.getUserCollection();
        List<String> listUsersName = users.stream()
                .map(c -> c.getName())
                .sorted()
                .collect(Collectors.toList());
        return listUsersName;
    }
}
