/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;


/**
 *
 * @author surzhin.konstantin
 */
@WebService(serviceName = "GameFcadeSOAP")
public class GameFcadeSOAP {


// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    /**
     * Операция веб-службы
     * @return 
     */
    @WebMethod(operationName = "find")
    public String find() {
        //TODO write your implementation code here:
       // return ejbRef.businessMethod();
       return  "Hello SOAP World!!!";
    }
}
