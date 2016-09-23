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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.igo.letsgo.spring.boot.domain.City;
import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author surzhin.konstantin
 */
@RestController
@RequestMapping("/webapi")
@Api(value = "/webapi", description = "Sample JAX-RS service with Swagger documentation")
public class CityRestController {

    @ApiOperation(
            value = "Get operation with Response and @Default value",
            notes = "Get operation with Response and @Default value",
            response = String.class,
            responseContainer = "List"
    )
    @GetMapping(value = "/city")
    @Produces(MediaType.APPLICATION_JSON)
    public String city() {

        JSONObject jObj = new JSONObject();
        jObj.put("1", new City(1, "Москва"));
        return jObj.toString();
    }
}