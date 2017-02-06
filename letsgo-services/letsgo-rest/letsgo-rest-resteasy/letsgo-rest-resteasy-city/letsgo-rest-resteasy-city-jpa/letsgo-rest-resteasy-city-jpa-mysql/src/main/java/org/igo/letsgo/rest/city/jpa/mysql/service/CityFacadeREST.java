/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.rest.city.jpa.mysql.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.igo.entities.City;


import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
@Path("city")
public class CityFacadeREST extends AbstractFacade<City> {

    @PersistenceContext(unitName = "gamePU")
    private EntityManager em;

    /**
     *
     */
    public CityFacadeREST() {
        super(City.class);
    }

    /**
     *
     * @param entity
     * @return
     */
    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public City create(City entity) {
        return super.create(entity);
    }

    /**
     *
     * @param id
     * @param entity
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, City entity) {
        super.edit(entity);
    }

    /**
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @AddLinks
    @LinkResource
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public City find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    /**
     *
     * @return
     */
    @GET
    @AddLinks
    @LinkResource(value = City.class)
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<City> findAll() {
        return super.findAll();
    }

    /**
     *
     * @param from
     * @param to
     * @return
     */
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<City> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /**
     *
     * @return
     */
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
