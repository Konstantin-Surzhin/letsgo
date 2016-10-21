/*
 * Copyright (C) 2016 Pivotal Software, Inc.
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
package org.igo.letsgo.spring.boot.rest;

import javax.ws.rs.core.Response;
import org.igo.letsgo.spring.boot.rest.services.Resource;

/**
 *
 * @author surzhin.konstantin
 */
public class CityRestConrtoller implements Resource {

    @Override
    public Response getCity() {
        return Response.ok("Северная столица", "text/plain; charset=UTF-8").build();
    }

    @Override
    public Response getCitynamename(String name) {
        return Response.ok("1", "text/plain; charset=UTF-8").build();
    }

    @Override
    public Response getCityid(Integer id) {
        return Response.ok("Москва", "text/plain; charset=UTF-8").build();
    }
}
