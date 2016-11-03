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

    public String getCityName(final Integer id);

    public Integer getCityId(final String name);

    public List<String> getAllCityUser(final String name);

    public List<String> getAllCityUser(final Integer id);

    public List<String> getAllCityName();
    
    //jdbc, jpa, mybatis ...
    public Boolean createCity(final String cityName, final String method, final String dbName );

}
