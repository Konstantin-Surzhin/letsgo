/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.ban.ws;

import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import org.igo.letsgo.data.remote.IBanRemote;
//import org.igo.ejb.BanFacade;

/**
 *
 * @author surzhin.konstantin
 */
@WebService(serviceName = "BanWebService")
@Stateless()
public class BanWebService {

    @EJB
    private IBanRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "getCount")
    public int getCount() {
        return ejbRef.count();
    }
    
}
