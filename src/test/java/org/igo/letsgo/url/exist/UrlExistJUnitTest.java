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
package org.igo.letsgo.url.exist;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author surzhin.konstantin
 */
public class UrlExistJUnitTest {

    public UrlExistJUnitTest() {
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
    public void urlExistTest() {
        System.out.println("Is URL Exist?");
        try {
            String dest = "http://localhost:8080/letsgo.jsp"; //http://10.245.8.186:8000/PF
            URL url = new URL("http://10.245.8.186:8000/PF");
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(5000);
            conn.connect();

            InputStream resp = conn.getInputStream();
            resp.close();
//            InputStream resp = (InputStream) obj;
//            byte[] b = new byte[256];
//            int n = resp.read(b);
//            while (n != -1) {
//                System.out.print(new String(b, 0, n));
//                n = resp.read(b);
//            }
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
    }
}
