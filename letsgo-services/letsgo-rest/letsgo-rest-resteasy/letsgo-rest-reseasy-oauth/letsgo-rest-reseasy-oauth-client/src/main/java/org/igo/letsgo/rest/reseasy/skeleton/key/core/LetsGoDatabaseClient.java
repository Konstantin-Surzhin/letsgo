/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.rest.reseasy.skeleton.key.core;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.skeleton.key.servlet.ServletOAuthClient;

/**
 *
 * @author Surzhin.Konstantin
 */
public class LetsGoDatabaseClient {

    public static void redirect(HttpServletRequest request, HttpServletResponse response) {
        ServletOAuthClient oAuthClient = (ServletOAuthClient) request.
                getServletContext().getAttribute(ServletOAuthClient.class.getName());
        try {
            oAuthClient.redirectRelative("gameList.jsp", request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getGameList(HttpServletRequest request) {
        ServletOAuthClient oAuthClient = (ServletOAuthClient) request.
                getServletContext().getAttribute(ServletOAuthClient.class.getName());
        ResteasyClient rsClient = new ResteasyClientBuilder().trustStore(oAuthClient.getTruststore())
                .hostnameVerification(ResteasyClientBuilder.HostnameVerificationPolicy.ANY).build();
        String urlDiscs = "https://localhost:8443//letsgo-rest-resteasy-game-jpa-mysql/webresources/game";
        try {
            String bearerToken = "Bearer" + oAuthClient.getBearerToken(request);
            Response response = rsClient.target(urlDiscs).request().
                    header(HttpHeaders.AUTHORIZATION, bearerToken).get();
            return response.readEntity(new GenericType<List<String>>() {
            });
        } finally {
            rsClient.close();
        }
    }
}
