/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.rest.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import org.igo.IGameRemote;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
@javax.ws.rs.ApplicationPath("webapi")
@Path("game")
public class GameFacadeREST extends Application {

    @EJB(beanInterface = IGameRemote.class)
    private IGameRemote ejbRef;

    @GET
    @Path("{id}")
    @Produces({MediaType.TEXT_PLAIN})
    public String find(@PathParam("id") Integer id) {

        if (ejbRef != null) {
            return "OK";
        }

        return "NULL";
    }
}
