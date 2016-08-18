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
import org.igo.remote.IGameRemote;

/**
 * REST Web Service
 *
 * @author surzhin.konstantin
 */
@Path("game")
@Stateless
public class GameWebService {

    private IGameRemote game;

    /**
     * Creates a new instance of BanResource
     */
    public GameWebService() {
    }

    /**
     * Retrieves representation of an instance of org.igo.rest.GameWebService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll() {
        StringBuilder sb = new StringBuilder();
        try {
          sb.append(getGame().getGame(1));
        } catch (Exception ex) {
            sb.setLength(0); 
            sb.append("no ejb");
        }
        return sb.toString();
    }

    /**
     * @return the game
     */
    public IGameRemote getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    @EJB(lookup = "java:global/letsgo-ear-1.0/letsgo-game-ejb-1.0/GameSessionBean!org.igo.remote.IGameRemote")
    public void setGame(IGameRemote game) {
        this.game = game;
    }
    
        /**
     * PUT method for updating or creating an instance of PlaceWebService
     *
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void putGame(String content) {
    }
}
