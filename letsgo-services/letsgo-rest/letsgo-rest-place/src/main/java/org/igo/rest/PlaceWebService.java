/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.igo.letsgo.remote.IPlaceRemote;

/**
 * REST Web Service
 *
 * @author surzhin.konstantin
 */
@Path("place")
@Stateless
public class PlaceWebService {

    private IPlaceRemote place;

    /**
     * Creates a new instance of BanResource
     */
    public PlaceWebService() {
    }

    /**
     * Retrieves representation of an instance of org.igo.rest.PlaceWebService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll() {
        StringBuilder sb = new StringBuilder();
        try {
          sb.append(getPlace().getPlaceTitle(1));
        } catch (Exception ex) {
            sb.setLength(0); 
            sb.append("no ejb");
        }
        return sb.toString();
    }

    /**
     * PUT method for updating or creating an instance of PlaceWebService
     *
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void putPlace(String content) {
    }

    /**
     * @return the place
     */
    public IPlaceRemote getPlace() {
        return place;
    }

    /**
     * @param place the place to set
     */
    @EJB(lookup = "java:global/letsgo-ear-1.0/letsgo-place-ejb-1.0/PlacesFacade!org.igo.remote.IPlaceRemote")
    public void setPlace(IPlaceRemote place) {
        this.place = place;
    }
}
