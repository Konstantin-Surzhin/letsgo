/*
 * Copyright (C) 2017 surzhin.konstantin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.igo.letsgo.security.resteasy.skeleton.key.client;

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
 * @author surzhin.konstantin
 */
public class LetsGoGameDatabaseClient {

    public static void redirect(final HttpServletRequest request, final HttpServletResponse response) {
        final ServletOAuthClient oAuthClient = (ServletOAuthClient) request.getServletContext().getAttribute(ServletOAuthClient.class.getName());
        try {
            oAuthClient.redirectRelative("gameList.jsp", request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getGames(HttpServletRequest request) {
        final ServletOAuthClient oAuthClient = (ServletOAuthClient) request.
                getServletContext().getAttribute(
                        ServletOAuthClient.class.getName());
        final ResteasyClient rsClient = new ResteasyClientBuilder().trustStore(oAuthClient.getTruststore())
                .hostnameVerification(ResteasyClientBuilder.HostnameVerificationPolicy.ANY).build();
        final String urlGames = "https://localhost:8443/webresources/games";

        final String bearerToken = "Bearer" + oAuthClient.getBearerToken(request);
        final Response response = rsClient.target(urlGames).request().header(HttpHeaders.AUTHORIZATION, bearerToken).get();
        return response.readEntity(new GenericType<List<String>>() {
        });
    }
}
