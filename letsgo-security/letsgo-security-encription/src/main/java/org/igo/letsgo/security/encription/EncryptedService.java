/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.security.encription;

import java.io.InputStream;
import java.security.cert.X509Certificate;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.security.PemUtils;
import org.jboss.resteasy.security.smime.EnvelopedOutput;

/**
 * REST Web Service
 *
 * @author surzhin.konstantin
 */
@Path("encrypted")
public class EncryptedService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EncryptedService
     */
    public EncryptedService() {
    }

    /**
     * Retrieves representation of an instance of
     * org.igo.letsgo.security.encription.EncryptedService
     *
     * @return an instance of java.lang.String
     * @throws java.lang.Exception
     */
    @GET
    public EnvelopedOutput getText() throws Exception {
        final InputStream certPem = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("democert.pem");
        final X509Certificate myX509Certificate = PemUtils.
                decodeCertificate(certPem);
        final EnvelopedOutput output = new EnvelopedOutput("Hello world", MediaType.TEXT_PLAIN);
        output.setCertificate(myX509Certificate);
        return output;
    }
}
