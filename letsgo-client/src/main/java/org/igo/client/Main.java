package org.igo.client;

import org.igo.letsgo.client.GameFcadeSOAP;
import org.igo.letsgo.client.GameFcadeSOAP_Service;


/**
 * Enterprise Application Client main class.
 *
 */
public class Main {

    public static void main( String[] args ) {
        GameFcadeSOAP_Service gs = new GameFcadeSOAP_Service();
        GameFcadeSOAP port = gs.getGameFcadeSOAPPort();
       
        System.out.println( port.find() );
    }
}
