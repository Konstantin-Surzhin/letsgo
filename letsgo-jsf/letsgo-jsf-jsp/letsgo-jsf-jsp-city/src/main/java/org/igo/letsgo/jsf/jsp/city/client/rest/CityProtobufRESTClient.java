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
package org.igo.letsgo.jsf.jsp.city.client.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.igo.letsgo.jsf.jsp.city.entity.City;
import org.igo.letsgo.rest.city.generate.sources.CityService;
/**
 *
 * @author surzhin.konstantin
 */
public class CityProtobufRESTClient implements CityRestClientInterface {

    public CityProtobufRESTClient() {
    }

    @Override
    public City sendCity(String url, String msgMediaType, String persistenceType, String dbName, City city) {
//       final ResteasyClient client = new ResteasyClientBuilder().build();
        final String t = url + "-protobuf-" + persistenceType + "-" + dbName + "/webresources/" + "city/1";
//        final ResteasyWebTarget target = client.target(t);
        final CityService.City c = CityService.City.newBuilder().setName(city.getCityName()).build();
        final Entity e = Entity.entity(city, msgMediaType);
//        final CityService.City pc = target.request().post(e, CityService.City.class);
//        city.setId(pc.getId());
//        return city;

        Client client = ClientBuilder.newClient();
        client.register(ProtobufMessageBodyReader.class);
        client.register(ProtobufMessageBodyWriter.class);

        WebTarget target = client.target(t);

        Response response = target.request().get();
        System.out.println(response.getClass().getName());
        CityService.City value = response.readEntity(CityService.City.class);
        response.close();  // You should close connections!    }
        city.setCityName(value.getName());
        city.setId(value.getId());
        return city;
    }

    @Override
    public City recieveCity(String msgContentType, String dbMetod, String dbName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
