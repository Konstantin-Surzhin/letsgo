/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.view.tjws.city;

import org.jboss.resteasy.plugins.server.tjws.TJWSEmbeddedJaxrsServer;



/**
 *
 * @author surzhin.konstantin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      final TJWSEmbeddedJaxrsServer tjws = new TJWSEmbeddedJaxrsServer();
      tjws.setPort(8081);

      tjws.start();
//      org.jboss.resteasy.plugins.server.servlet.SpringBeanProcessor processor = new SpringBeanProcessor(tjws.getDeployment().getRegistry(), tjws.getDeployment().getFactory();
//      ConfigurableBeanFactory factory = new XmlBeanFactory(...);
//      factory.addBeanPostProcessor(processor);
    }
    
}
