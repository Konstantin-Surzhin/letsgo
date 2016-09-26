/*
 * Copyright (C) 2016 surzhin.konstantin.
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
package org.igo.letsgo.spring.boot.configuration;

import java.util.Arrays;
import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.igo.letsgo.spring.boot.endpoint.CityWebServiceEndpoint;
import org.igo.letsgo.spring.boot.rest.CityRestConrtoller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author surzhin.konstantin
 */
@Configuration
public class WebServiceConfiguration {

    @Autowired
    private Bus bus;

    //http://localhost:8080/services/CityWebService?wsdl
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new CityWebServiceEndpoint());
        endpoint.publish("/soap");
        //endpoint.setWsdlLocation("CityWebService.wsdl");
        return endpoint;
    }

    //http://localhost:8080/services/rest/api-docs?url=/services/rest/swagger.json
    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setServiceBeans(Arrays.<Object>asList(new CityRestConrtoller()));
        endpoint.setAddress("/rest");
        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        return endpoint.create();
    }
}
