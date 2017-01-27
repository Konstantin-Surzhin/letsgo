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
package letsgo.security.signatures.resteasy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.security.doseta.DosetaKeyRepository;
import org.jboss.resteasy.security.doseta.Verification;
import org.jboss.resteasy.security.doseta.Verifier;
import org.junit.Assert;

/**
 *
 * @author surzhin.konstantin
 */
public class SignedServiceTest {

    public SignedServiceTest() {
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
    public void testVerification() {
// Keys repository
        final DosetaKeyRepository repository = new DosetaKeyRepository();
        repository.setKeyStorePath("demo.jks");
        repository.setKeyStorePassword("changeit");
        repository.start();
// Building the client
        final ResteasyClient client = new ResteasyClientBuilder().build();
        final Verifier verifier = new Verifier();
        final Verification verification = verifier.addNew();
        verification.setRepository(repository);
        final WebTarget target = client
                .target("http://localhost:8080/signatures/webresources/signed");
        final Invocation.Builder request = target.request();
        request.property(Verifier.class.getName(), verifier);
// Invocation to RESTful web service
        final Response response = request.post(Entity.text("LetsGo"));
// Status 200 OK
        Assert.assertEquals(200, response.getStatus());
        System.out.println(response.readEntity(String.class));
        response.close();
        client.close();
    }
}
