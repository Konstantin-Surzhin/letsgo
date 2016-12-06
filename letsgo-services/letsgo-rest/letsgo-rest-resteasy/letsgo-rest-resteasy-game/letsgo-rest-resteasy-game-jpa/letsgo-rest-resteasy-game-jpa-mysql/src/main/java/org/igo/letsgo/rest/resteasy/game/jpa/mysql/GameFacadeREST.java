/*
 * Copyright (C) 2016 Surzhin.Konstantin
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
package org.igo.letsgo.rest.resteasy.game.jpa.mysql;

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
import org.igo.entities.Game;
import org.igo.entities.GameStatus;
import org.igo.entities.GameType;

/**
 *
 * @author Surzhin.Konstantin
 */
@Stateless
@Path("game")
public class GameFacadeREST extends AbstractFacade<Game> {

    @PersistenceContext(unitName = "gamePU")
    private EntityManager em;

    public GameFacadeREST() {
        super(Game.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Game entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Game entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Game find(@PathParam("id") Long id) {
        return super.find(id);
    }

//    @GET
//    @Path("size/{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Game> findAllBySize(@PathParam("id") Short id) {
//
//        Short.parseShort("1");
//        List<Game> gameList = new ArrayList<>();
//        GameStatus gs = new GameStatus(id);
//        GameType gt = new GameType(0);
//        gameList.add(new Game(1L, id, gs, gt));
//        gameList.add(new Game(2L, id, gs, gt));
//        gameList.add(new Game(3L, id, gs, gt));
//        gameList.add(new Game(4L, id, gs, gt));
//        gameList.add(new Game(5L, id, gs, gt));
//        gameList.add(new Game(6L, id, gs, gt));
//        gameList.add(new Game(7L, id, gs, gt));
//        gameList.add(new Game(8L, id, gs, gt));
//        return gameList;
//        // return super.find(id);
//    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Game> findAll() {
        List<Game> gameList = new ArrayList<>();
        GameStatus gs = new GameStatus(Short.valueOf("0"));
        GameType gt = new GameType(Short.valueOf("0"));

        gameList.add(new Game(1L, Short.parseShort("9"), gs, gt));
        gameList.add(new Game(2L, Short.parseShort("11"), gs, gt));
        gameList.add(new Game(3L, Short.parseShort("13"), gs, gt));
        gameList.add(new Game(4L, Short.parseShort("15"), gs, gt));
        gameList.add(new Game(5L, Short.parseShort("17"), gs, gt));
        gameList.add(new Game(6L, Short.parseShort("19"), gs, gt));
        gameList.add(new Game(7L, Short.parseShort("21"), gs, gt));
        gameList.add(new Game(8L, Short.parseShort("23"), gs, gt));
        return gameList;
        //return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Game> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
