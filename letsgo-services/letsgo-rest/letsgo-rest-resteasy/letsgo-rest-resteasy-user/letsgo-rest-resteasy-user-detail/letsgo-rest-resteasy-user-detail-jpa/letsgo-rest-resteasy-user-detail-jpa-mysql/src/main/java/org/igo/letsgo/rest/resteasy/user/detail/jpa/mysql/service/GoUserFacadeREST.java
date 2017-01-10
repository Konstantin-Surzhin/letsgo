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
//import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import org.igo.entities.GoUser;
import org.igo.entities.User;
import org.jboss.resteasy.annotations.GZIP;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
@Path("v1/gouser")
public class GoUserFacadeREST extends AbstractFacade<GoUser> {

    @PersistenceContext(unitName = "gamePU")

    // @Context private ExecutionContext ctx;
    private EntityManager em;

    // @Context private ExecutionContext ctx;
    /**
     *
     */
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

    /**
     *
     * @param id
     * @param secContext
     * @return
     */
    @GET
    @GZIP
    @Path("{id}")
    @RolesAllowed({"gouser", "administrator"})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    public Response find(@PathParam("id") final Integer id,
            @Context final SecurityContext secContext) {

        if (!secContext.isSecure()) {
            final String e = "<html><title>error</title><body><h1>HTTP conection forbidden</body></h1></html>";
            final ResponseBuilder builder = Response.status(Response.Status.METHOD_NOT_ALLOWED).type(MediaType.TEXT_HTML);
            final Response response = builder.header("title", "error").entity(e).build();
            throw new WebApplicationException(response);
        }

        final GoUser user = super.find(id);
        if (user == null) {
            final String e = "<html><title>error</title><body><h1>Resource is not found</body></h1></html>";
            final ResponseBuilder builder = Response.status(Response.Status.NOT_FOUND).type(MediaType.TEXT_HTML);
            final Response response = builder.header("title", "error").entity(e).build();
            throw new WebApplicationException(response);
        }

        final String principalName = secContext.getUserPrincipal().getName();
        if (!principalName.equals(user.getUserName())) {
            final String e = "<html><title>error</title><body><h1>Prohibition of unauthorized access.</body></h1></html>";
            final ResponseBuilder builder = Response.status(Response.Status.UNAUTHORIZED).type(MediaType.TEXT_HTML);
            final Response response = builder.header("title", "error").entity(e).build();
            throw new WebApplicationException(response);
        }

        return Response.ok().build();
    }

    /**
     *
     * @param uriInfo
     * @param sent
     * @param request
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @GET
    @GZIP
    //@Asynchronous
    @RolesAllowed({"gouser", "administrator"})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findAllUser(@Context final UriInfo uriInfo,
            @HeaderParam("If-None-Match") String sent,
            @Context final Request request,
            @QueryParam("page") @DefaultValue("2") int pageNumber,
            @QueryParam("limit") @DefaultValue("10") int pageSize) {

        final TypedQuery<User> goUsersQuery = em.createNamedQuery("GoUser.findByUserName", User.class);

        final URI uri = uriInfo.getAbsolutePath();

        final List<User> list = goUsersQuery
                .setFirstResult((pageNumber-1)* pageSize)
                .setMaxResults(pageSize)
                .getResultList();

        list.forEach(user -> {
            user.setUri(uri);
        });

        Response response;

        final EntityTag et = new EntityTag(String.valueOf(list.hashCode()));

        final CacheControl cc = new CacheControl();

        cc.setMaxAge(1200);

        final Response.ResponseBuilder responseBuilder = request.evaluatePreconditions(et);

        if (responseBuilder != null) {
            response = responseBuilder.cacheControl(cc).tag(et).build();
        } else {

            final GenericEntity<List<User>> entity
                    = new GenericEntity<List<User>>(list) {
            };

            response = Response.ok()
                    .entity(entity)
                    .cacheControl(cc)
                    .tag(et)
                    .link(uri, "users")
                    .contentLocation(uri)
                    .build();
        }
        return response;
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
    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
