/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.lesgo.game.client;

import javax.xml.ws.WebServiceRef;


/**
 *
 * @author surzhin.konstantin
 */
public class GameMain {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameWebService_Service service = new GameWebService_Service();
        System.out.println(service.getGameWebServicePort().findGame(0));
    }
    
}
