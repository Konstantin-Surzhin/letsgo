/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.game.soap;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author surzhin.konstantin
 */
@WebService(serviceName = "GameWebService")
public class GameWebService {

    @EJB(lookup = "java:global/letsgo-ear-1.0/letsgo-game-ejb-1.0/GameSessionBean!org.igo.remote.IGameRemote")
    private org.igo.letsgo.remote.IGameRemote ejbRef;
    // Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    /**
     * Операция веб-службы
     *
     * @param id
     * @return
     */
    @WebMethod(operationName = "findGame")
    public String findGame(@WebParam(name = "id") final int id) {

        //TODO write your implementation code here:
        return "find game" + ejbRef.getGame(id);
    }

}
