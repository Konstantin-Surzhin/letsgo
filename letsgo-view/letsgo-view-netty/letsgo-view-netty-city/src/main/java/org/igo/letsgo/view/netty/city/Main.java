/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.view.netty.city;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.resteasy.test.TestPortProvider;

/**
 *
 * @author surzhin.konstantin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NettyJaxrsServer netty = new NettyJaxrsServer();
        ResteasyDeployment deployment = null;
        netty.setDeployment(deployment);
        netty.setPort(TestPortProvider.getPort());
        netty.setRootResourcePath("");
        netty.setSecurityDomain(null);
        netty.start();
    }

}
