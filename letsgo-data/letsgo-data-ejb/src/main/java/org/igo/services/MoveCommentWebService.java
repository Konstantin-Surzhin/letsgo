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
import org.igo.ejb.MoveCommentFacade;

/**
 *
 * @author surzhin.konstantin
 */
@WebService(serviceName = "MoveCommentWebService")
@Stateless()
public class MoveCommentWebService {

    @EJB
    private MoveCommentFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "getCount")
    public int getCount() {
        return ejbRef.count();
    }
    
}
