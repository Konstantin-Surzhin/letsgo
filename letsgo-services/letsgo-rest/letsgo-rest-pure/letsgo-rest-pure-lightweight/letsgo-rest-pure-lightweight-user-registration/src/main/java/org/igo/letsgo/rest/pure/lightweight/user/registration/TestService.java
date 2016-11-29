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

import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

/**
 *
 * @author surzhin.konstantin
 */
public class TestService
        implements IService {

    @Override
    public void doGet(final HttpExchange e) {
        respond2Client(e, "doGet");
    }

    @Override
    public void doPost(final HttpExchange e) {
        respond2Client(e, "doPost");
    }

    @Override
    public void doPut(final HttpExchange e) {
        respond2Client(e, "doPut");
    }

    @Override
    public void doDelete(final HttpExchange e) {
        respond2Client(e, "doDelete");
    }

    private void respond2Client(final HttpExchange ex, String response) {
        try {
            ex.sendResponseHeaders(200, 0); // 0 == as many bytes as there are
            try (final OutputStream out = ex.getResponseBody()) {
                out.write(response.getBytes());
                // effectively ends session
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
