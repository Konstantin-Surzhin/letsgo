/*
 * Copyright (C) 2016 surzhin.konstantin
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
package org.igo.letsgo.rest.pure.lightweight.user.registration;

import javax.xml.ws.http.HTTPException;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;


/**
 *
 * @author surzhin.konstantin
 */
public class UserRegistrationHttpsHandler implements HttpHandler {

    private final IService service;

    public UserRegistrationHttpsHandler(final IService service) {
        this.service = service;
    }

    @Override
    public void handle(final HttpExchange ex) {
        // Implement a simple routing table.
        final String verb = ex.getRequestMethod().toUpperCase();
        switch (verb) {
            case "GET":
                service.doGet(ex);
                break;
            case "POST":
                service.doPost(ex);
                break;
            case "PUT":
                service.doPut(ex);
                break;
            case "DELETE":
                service.doDelete(ex);
                break;
            default:
                throw new HTTPException(405);
        }
    }
}
