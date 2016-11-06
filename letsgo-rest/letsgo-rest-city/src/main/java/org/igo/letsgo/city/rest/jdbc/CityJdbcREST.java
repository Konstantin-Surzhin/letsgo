/*
 * Copyright (C) 2016 pl
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
package org.igo.letsgo.city.rest.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author pl
 */
@Path("jdbc")
public class CityJdbcREST {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SimpleResource
     */
    public CityJdbcREST() {
    }

    /**
     * Retrieves representation of an instance of
     * org.igo.letsgo.rest.city.CityJdbcREST
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(value = {MediaType.APPLICATION_XML})
    public City getXml() {
        City c = new City();
        c.setName("Тамбов");
        return c;
    }

    /**
     * PUT method for updating or creating an instance of CityJdbcREST
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    @POST
    @Path("city/{db}")
    @Consumes({MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_XML})
    public City create(@PathParam("db") String db, City city) {
        try {

            Connection conn = JDBCConnectionFabrica.getConnection(db);//
            if (conn == null) {
                return null;
            }

            PreparedStatement ps = conn.prepareStatement("");
            ps.setString(1, city.getName());
            ps.executeUpdate();
            ps = conn.prepareStatement("");
            ps.setString(1, city.getName());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            city.setId(id);

        } catch (SQLException ex) {
            Logger.getLogger(CityJdbcREST.class.getName()).log(Level.SEVERE, null, ex);
        }

        return city;

    }
}
