/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.rest.city.protobuf.jpa.service;

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
import org.igo.letsgo.rest.city.entity.City;
import org.igo.letsgo.rest.city.generate.sources.CityService;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
@Path("city")
public class CityFacadeREST extends AbstractFacade<City> {

    @PersistenceContext(unitName = "org.igo.letsgo.rest.city.protobuf.jpa.PU")
    private EntityManager em;

    public CityFacadeREST() {
        super(City.class);
    }

    @POST
    @Override
    @Produces(value = {"application/x-protobuf"})
    @Consumes(value = {"application/x-protobuf"})
    public void create(City entity) {
        CityService.City ss = CityService.City.newBuilder().build();
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Produces(value = {"application/x-protobuf"})
    @Consumes(value = {"application/x-protobuf"})
    public void edit(@PathParam("id") Integer id, City entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Consumes(value = {"application/x-protobuf"})
    public City find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(value = {"application/x-protobuf"})
    public List<City> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(value = {"application/x-protobuf"})
    public List<City> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
