/*
 * Copyright (C) 2016 kostya
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
package org.igo.letsgo.rest.resteasy.user.detail.jpa.mysql.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kostya
 */
public class ETagJUnitTest {

    /**
     *
     */
    public ETagJUnitTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    /**
     *
     * @throws InterruptedException
     */
    @Test
    public void testETag() throws InterruptedException {
        final Client client = ClientBuilder.newClient();
        final WebTarget webTarget = client.target("http://localhost:8080/letsgo-rest-resteasy-user-detail-jpa-mysql/webresources/v1/gouser");

        Response head = webTarget.request().get();
        EntityTag eTag = head.getEntityTag();
        System.out.println(head.getStatus() + "\t" + eTag);
        assertEquals(200, head.getStatus());
        Thread.sleep(1000);

        Response head1 = webTarget.request().header("If-None-Match", eTag).get();
        System.out.println(head1.getStatus() + "\t" + head1.getEntityTag());
        assertEquals(304, head1.getStatus());
    }
}
