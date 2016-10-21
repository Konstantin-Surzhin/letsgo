/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.rest.degree;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 * webresources
 * @author surzhin.konstantin
 */
@Path("degree")
public class DegreeRESTService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public DegreeRESTService() {
    }

    /**
     * Retrieves representation of an instance of org.igo.letsgo.rest.degree.DegreeRESTService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        //TODO return proper representation object
        return "no xml";
    }

    /**
     * PUT method for updating or creating an instance of DegreeRESTService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
