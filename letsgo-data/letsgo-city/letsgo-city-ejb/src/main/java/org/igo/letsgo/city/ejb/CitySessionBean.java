/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.city.ejb;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.igo.entities.City;
import org.igo.entities.GoUser;
import org.igo.letsgo.remote.ICityRemote;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class CitySessionBean implements ICityRemote {

    private static final Logger LOGGER = Logger.getLogger(CitySessionBean.class.getCanonicalName());
    private EntityManager entityManager;

    /**
     *
     * @param id
     * @return
     */
    @Override
    public String getCityName(final Integer id) {
        return getEntityManager()
                .find(City.class, id)
                .getCityName();
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Integer getCityId(final String name) {
        try {
            return getEntityManager()
                    .createNamedQuery("City.findByCityName", City.class)
                    .setParameter("cityName", name)
                    .getSingleResult()
                    .getId();
        } catch (Exception ex) {
            LOGGER.info(ex.getLocalizedMessage());
            throw ex;
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
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     *
     * @return
     */
    @Override
    public List<String> getAllCityName() {
        return getEntityManager()
                .createNamedQuery("City.findAll", City.class)
                .getResultList()
                .stream()
                .map(City::getCityName)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public List<String> getAllCityUser(final String name) {
        try {
            final Integer id = getEntityManager()
                    .createNamedQuery("City.findByCityName", City.class)
                    .setParameter("cityName", name)
                    .getSingleResult().getId();

            return getEntityManager()
                    .find(City.class, id)
                    .getUsers()
                    .stream()
                    .map(GoUser::getUserName)
                    .sorted()
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            LOGGER.info(ex.getLocalizedMessage());
            throw ex;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<String> getAllCityUser(final Integer id) {
        return getEntityManager()
                .find(City.class, id)
                .getUsers()
                .stream()
                .map(GoUser::getUserName)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     *
     * @param cityName
     * @param method
     * @param dbName
     * @return
     */
    @Override
    public Boolean createCity(final String cityName, final String method, final String dbName) {
        final City city = new City(cityName);
        boolean ret = true;
        switch (method) {
            case "JPA":
                try {
                    entityManager.persist(city);
                } catch (Exception ex) {
                    LOGGER.info(ex.getLocalizedMessage());
                    throw ex;
                }
                break;
            case "JDBC":
            default:
                ret = false;
        }
        return ret;
    }
}
