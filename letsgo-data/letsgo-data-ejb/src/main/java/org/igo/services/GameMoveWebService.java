/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.services;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import org.igo.ejb.GameMoveFacade;

/**
 *
 * @author surzhin.konstantin
 */
@WebService(serviceName = "GameMoveWebService")
@Stateless()
public class GameMoveWebService {

    @EJB
    private GameMoveFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "getCount")
    public int getCount() {
        return ejbRef.count();
    }
    
}
