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
package letsgo.security.signatures.resteasy.services;

import java.net.URI;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.annotations.security.doseta.Signed;
import org.jboss.resteasy.annotations.security.doseta.Verify;

/**
 * REST Web Service
 *
 * @author surzhin.konstantin
 */
@Path("signed")
public class SignedService {

    /**
     * Creates a new instance of SignedService
     */
    public SignedService() {
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Signed(selector = "demo", domain = "packtpub.com")
    public String sign(String input) {
        return "signed: " + input;
    }

    @POST
    @Path("ram")
    @Produces(MediaType.TEXT_PLAIN)
    @Signed(selector = "demo", domain = "packtpub.com")
    public String requestRam(String numberOfGB) {
        return numberOfGB;
    }

    @POST
    @Path("sram")
    @Produces(MediaType.TEXT_PLAIN)
    @Signed(selector = "demo", domain = "packtpub.com")
    public Response requestRAM(String numberOfGB) {
        Response r = Response.seeOther(
                URI.create("/webresources/signed/" + "GB:" + numberOfGB)).build();
       
       // return URI.create("/webresources/signed/" + "GB:" + numberOfGB + ":" +  r.getStatus()).toString();
        return r;
    }

    @Verify
    @POST
    @Path("verifier")
    @Produces("text/plain")
    public String processRequestRam(String input) {
        int numberOfGbRequested = Integer.valueOf(input.split("-")[0]);
        if (numberOfGbRequested > 4) {
            return "deny";
        } else {
            return "accepted";
        }
    }
}
