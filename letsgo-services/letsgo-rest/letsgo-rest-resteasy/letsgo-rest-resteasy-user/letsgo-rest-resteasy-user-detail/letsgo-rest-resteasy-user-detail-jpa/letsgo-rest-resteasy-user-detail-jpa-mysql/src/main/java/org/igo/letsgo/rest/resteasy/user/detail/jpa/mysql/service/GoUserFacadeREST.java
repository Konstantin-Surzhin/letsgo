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
package org.igo.letsgo.rest.resteasy.user.detail.jpa.mysql.service;

import java.net.URI;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.igo.entities.GoUser;
import org.igo.entities.User;
import org.jboss.resteasy.annotations.GZIP;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
@Path("v1/gouser")
public class GoUserFacadeREST extends AbstractFacade<GoUser> {

    @PersistenceContext(unitName = "gamePU")
    private EntityManager em;

    public GoUserFacadeREST() {
        super(GoUser.class);
    }
//
//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(GoUser entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @RolesAllowed({"gouser", "administrator"})
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Response edit(@Context final SecurityContext secContext, @PathParam("id") final Integer id, final GoUser entity) {
//        final String name = secContext.getUserPrincipal().getName();
//        final TypedQuery<GoUser> gousers = em.createNamedQuery("GoUser.findByUserName", GoUser.class);
//        gousers.setParameter("userName", name);
//
//        try {
//            final GoUser user = gousers.getSingleResult();
//            if (!user.getId().equals(id)) {
//                throw new WebApplicationException(Response.Status.FORBIDDEN);
//            } else {
//                super.edit(entity);
//            }
//        } catch (Exception e) {
//            return Response.status(Response.Status.FORBIDDEN).entity(e.getMessage()).build();
//        }
//
//        return Response.ok(entity).build();
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Integer id) {
//        super.remove(super.find(id));
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public GoUser find(@PathParam("id") Integer id) {
//
//        return super.find(id);
//    }

    @GET
    @GZIP
    @RolesAllowed({"gouser", "administrator"})
    @Produces({"application/vnd.lets.go.igo.v1+xml;charset=UTF-8;v=1", "application/vnd.lets.go.igo.v1+json;charset=UTF-8;v=1"})
    public Response findAllUser(@Context final UriInfo uriInfo) {

        TypedQuery<User> goUsersQuery = em.createNamedQuery("GoUser.findByUserName", User.class);
        URI uri = uriInfo.getAbsolutePath();
        
        List<User> list = goUsersQuery.getResultList();
        
        list.forEach((User user) -> {
            user.setUri(uri);
        });
        
        GenericEntity<List<User>> entity
                = new GenericEntity<List<User>>(list) {
        };
        return Response.ok().entity(entity).link(uri, "self").contentLocation(uri).build();
    }

//    @GET
//    @Path("{id}/games")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Game> findAllUserGame(@PathParam("id") Integer id) {
//        List<Game> list = new ArrayList<>();
//        return list;
//    }
//
//    @GET
//    @Path("{id}/club")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Club findUserClub(@PathParam("id") Integer id) {
//        Club club = new Club();
//        return club;
//    }
//
//    @GET
//    @Path("{id}/degree")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Degree findUserDegree(@PathParam("id") Integer id) {
//        Degree degree = new Degree();
//        return degree;
//    }
//
//    @GET
//    @Path("{id}/game_comment")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public GameComment findUserGameComment(@PathParam("id") Integer id) {
//        GameComment gameComment = new GameComment();
//        return gameComment;
//    }
//
//    @GET
//    @Path("{id}/move_comment")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public MoveComment findUserMoveComment(@PathParam("id") Integer id) {
//        MoveComment moveComment = new MoveComment();
//        return moveComment;
//    }
//
//    @GET
//    @Path("{id}/room")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Room findUserRoom(@PathParam("id") Integer id) {
//        Room room = new Room();
//        return room;
//    }
//
//    @GET
//    @Path("{id}/team")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Team findTeam(@PathParam("id") Integer id) {
//        Team team = new Team();
//        return team;
//    }
//
//    @GET
//    @Path("{id}/user-ban")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<UserBan> findUserBan(@PathParam("id") Integer id) {
//        List<UserBan> userBanList = new ArrayList<>();
//        return userBanList;
//    }
//
//    @GET
//    @Path("{id}/user-details")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public UserDetails findUserDetails(@PathParam("id") Integer id) {
//        UserDetails userDetails = new UserDetails();
//        return userDetails;
//    }
//
//    @GET
//    @Path("{id}/games/{gid}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Game findUserGame(@PathParam("id") Integer id, @PathParam("gid") Integer gid) {
//        Game game = new Game();
//        return game;
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<GoUser> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
//    @GET
//    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String countREST() {
//        return String.valueOf(super.count());
//    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
