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

import javax.ws.rs.core.MediaType;
import org.igo.letsgo.jsf.jsp.city.entity.City;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import javax.ws.rs.client.Entity;

/**
 *
 * @author pl
 */
public class CityRESTClient implements CityRestClientInterface {

    @Override
    public City sendCity(final String url, final String sgMediaType,
            final String persistenceType, final String dbName, final City city) {
        final ResteasyClient client = new ResteasyClientBuilder().build();
        final String t = url + "-" + persistenceType + "-" + dbName + "/webresources/" + "city";
        final ResteasyWebTarget target = client.target(t);
        final Entity e = Entity.entity(city, sgMediaType);
        return target.request().post(e, City.class);
    }

    @Override
    public City recieveCity(String msgContentType, String dbMetod, String dbName) {
//        Client client1 = ClientBuilder.newClient();
//        Client client2 = ClientBuilder.newBuilder().build();
//        WebTarget target1 = client1.target("http://localhost:8080/letsgo-rest-city/webresources");
//        Response response = target1.request().get();
//                    String value = response.readEntity(String.class);
//            response.close();  // You should close connections!    }\

        ResteasyClient client3 = new ResteasyClientBuilder().build();
        ResteasyWebTarget target2 = client3.target("http://localhost:8080/letsgo-rest-city/webresources/simple");

        City c = target2.request(MediaType.APPLICATION_XML).get(City.class);

        return c;

    }
}
