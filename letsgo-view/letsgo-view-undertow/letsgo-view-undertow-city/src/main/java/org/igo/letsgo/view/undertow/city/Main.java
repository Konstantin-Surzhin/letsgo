/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.view.undertow.city;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

/**
 *
 * @author surzhin.konstantin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler((final HttpServerExchange exchange) -> {
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    exchange.getResponseSender().send("Hello World");
        }).build();
        server.start();
    }

    private static void JAXRSServer(int port) {
        System.out.printf("starting undertow%n");
        UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.start(Undertow.builder().addHttpListener(port, "localhost"));

//        server.deploy(new TMApplication(), "/");
//        server.deploy(new TransactionAwareResource.ServiceApp(), "eg");
    }
}
