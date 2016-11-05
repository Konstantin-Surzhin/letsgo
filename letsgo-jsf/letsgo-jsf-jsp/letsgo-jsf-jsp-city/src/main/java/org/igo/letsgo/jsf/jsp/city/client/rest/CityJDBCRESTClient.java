/*
 * Copyright (C) 2016 pl
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
package org.igo.letsgo.jsf.jsp.city.client.rest;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import org.igo.letsgo.jsf.jsp.city.CityMsgInterface;
import org.igo.letsgo.jsf.jsp.city.entity.City;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

/**
 *
 * @author pl
 */
public class CityJDBCRESTClient implements CityMsgInterface{

    @Override
    public City sendCity(String msgContentType, String dbMetod, String dbName, City city) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/letsgo-rest-city/webresources/jdbc/city");

        Entity e = Entity.entity(city, MediaType.APPLICATION_XML);
        return target.request().post(e, City.class);    }

    @Override
    public City recieveCity(String msgContentType, String dbMetod, String dbName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
