/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.remote;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author surzhin.konstantin
 */
@Remote
public interface ICityRemote {

    /**
     *
     * @param id
     * @return
     */
    public String getCityName(final Integer id);

    /**
     *
     * @param name
     * @return
     */
    public Integer getCityId(final String name);

    /**
     *
     * @param name
     * @return
     */
    public List<String> getAllCityUser(final String name);

    /**
     *
     * @param id
     * @return
     */
    public List<String> getAllCityUser(final Integer id);

    /**
     *
     * @return
     */
    public List<String> getAllCityName();
    
    //jdbc, jpa, mybatis ...

    /**
     *
     * @param cityName
     * @param method
     * @param dbName
     * @return
     */
    public Boolean createCity(final String cityName, final String method, final String dbName );

}
