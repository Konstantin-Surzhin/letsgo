/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.view.sun.jdk.http.server.city;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.jboss.resteasy.plugins.server.sun.http.HttpContextBuilder;

/**
 *
 * @author surzhin.konstantin
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int port = 8080;
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(port), 10);
        HttpContextBuilder contextBuilder = new HttpContextBuilder();
        contextBuilder.getDeployment().getActualResourceClasses().add(SimpleResource.class);
        HttpContext context = contextBuilder.bind(httpServer);
        context.getAttributes().put("some.config.info", "42");
        httpServer.start();

        contextBuilder.cleanup();
        httpServer.stop(0);
    }

}
