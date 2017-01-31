/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.security.encription;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.security.PemUtils;
import org.jboss.resteasy.security.smime.EnvelopedInput;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author surzhin.konstantin
 */
public class EncryptedServiceTest {

    public EncryptedServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEncryptedGet() throws Exception {
        // LOADING THE CERTIFICATE
        final X509Certificate myX509Certificate
                = PemUtils.decodeCertificate(
                        Thread.currentThread().getContextClassLoader()
                                .getResourceAsStream("democert.pem"));
        // LOADING THE KEY
        final PrivateKey myPrivateKey = PemUtils.decodePrivateKey(Thread
                .currentThread().getContextClassLoader()
                .getResourceAsStream("demokey.pem"));
        // CREATING A CLIENT FOR THE WEB SERVICE
        final Client client = new ResteasyClientBuilder().build();
        final WebTarget target = client.target(
                "http://localhost:8080/letsgo-security-encription/webresources/encrypted"
        );
        // RETRIEVING THE RESULT OF METHOD EXECUTION
        final EnvelopedInput<?> input = target.request().
                get(EnvelopedInput.class);
        Assert.assertEquals("Hello world",
                input.getEntity(String.class,
                        myPrivateKey, myX509Certificate));
        client.close();
    }
}
