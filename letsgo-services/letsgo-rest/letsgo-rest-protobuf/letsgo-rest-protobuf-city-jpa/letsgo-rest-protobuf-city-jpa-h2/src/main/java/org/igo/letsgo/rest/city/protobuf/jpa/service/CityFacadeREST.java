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
package org.igo.letsgo.rest.city.protobuf.jpa.service;

import java.util.ArrayList;
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
//import org.igo.letsgo.rest.city.generate.sources.CityService;

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
    @Produces(value = {"application/x-protobuf"})
    @Consumes(value = {"application/x-protobuf"})
    public CityService.City create(CityService.City city) {
        //City entity = new City();
        //entity.setCityName(city.getName());
        //  entity = super.create(entity);
        // CityService.City out = CityService.City.newBuilder(city).setId(entity.getId()).build();
        //CityService.City out = CityService.City.newBuilder(city).setId(100).setName("Перозаводск").build();

        return CityService.City.newBuilder(city).setId(100).setName("Перозаводск").build();
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
    @Produces(value = {"application/x-protobuf"})
    public CityService.City find(@PathParam("id") Integer id) {
        CityService.City c = CityService.City.newBuilder().setId(id).setName("Петрозаводск").build();
        return c;
        //return super.find(id);
    }

    @GET
    @Produces(value = {"application/x-protobuf"})
    public List<CityService.City> findAll() {

        CityService.City city1 = CityService.City.newBuilder().setId(100).setName("Перозаводск").build();
        CityService.City city2 = CityService.City.newBuilder().setId(101).setName("Рязань").build();
        List<CityService.City> list = new ArrayList<>();
        list.add(city1);
        list.add(city2);
        return list;
        //  return super.findAll();
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
