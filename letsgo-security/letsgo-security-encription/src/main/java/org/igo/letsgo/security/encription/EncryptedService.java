/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.security.encription;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author surzhin.konstantin
 */
@Path("encrypted")
public class EncryptedService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EncryptedService
     */
    public EncryptedService() {
    }

    /**
     * Retrieves representation of an instance of org.igo.letsgo.security.encription.EncryptedService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
}
