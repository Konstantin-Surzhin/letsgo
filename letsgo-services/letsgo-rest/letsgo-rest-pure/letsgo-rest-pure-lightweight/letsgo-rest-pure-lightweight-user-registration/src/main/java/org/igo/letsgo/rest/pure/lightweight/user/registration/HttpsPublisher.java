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

import java.net.InetSocketAddress;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.security.SecureRandom;
import com.sun.net.httpserver.HttpsServer;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsParameters;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;


/**
 *
 * @author surzhin.konstantin
 */
public class HttpsPublisher {

    private static final int DEFAULT_PORT = 3443;
    private static final int BACK_LOG = 12;
    private static final String KEY_STORE = "test.keystore";
    private IService serviceInstance;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java HttpsPublisher <service> <path>");
            return;
        }

        new HttpsPublisher().init(
                args[0], // service name
                args[1]); // URI
    }

    private void init(final String serviceName, final String uri) {
        try {
            final Class serviceClass = Class.forName(serviceName);
            serviceInstance = (IService) serviceClass.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
        final HttpsServer server = getHttpsServer(uri, DEFAULT_PORT);
        if (server != null) {
            server.createContext(uri);
            System.out.println("Server listening on port " + DEFAULT_PORT);
            server.start();
        } else {
            throw new RuntimeException("Cannot create server instance.");
        }
    }

    private HttpsServer getHttpsServer(final String uri, final int port) {
        HttpsServer server = null;
        try {
            final InetSocketAddress inet = new InetSocketAddress(port);
            server = HttpsServer.create(inet, BACK_LOG);
            final SSLContext sslCtx = SSLContext.getInstance("TLS");
            
            // password for keystore
            final char[] password = "qubits".toCharArray();
            final KeyStore ks = KeyStore.getInstance("JKS");
            final FileInputStream fis = new FileInputStream(KEY_STORE);
            ks.load(fis, password);
            
            final KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(ks, password);
            
            final TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(ks); // same as keystore
            sslCtx.init(kmf.getKeyManagers(),
                    tmf.getTrustManagers(),
                    new SecureRandom());
            
            // Create SSL engine and configure HTTPS to use it.
            final SSLEngine eng = sslCtx.createSSLEngine();
            server.setHttpsConfigurator(new HttpsConfigurator(sslCtx) {
                @Override
                public void configure(HttpsParameters parms) {
                    parms.setCipherSuites(eng.getEnabledCipherSuites());
                    parms.setProtocols(eng.getEnabledProtocols());
                }
            });
            server.setExecutor(null); // use default, hence single-threaded
            server.createContext(uri, new UserRegistrationHttpsHandler(this.serviceInstance));
        } catch (IOException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException e) {
            throw new RuntimeException(e);
        }
        return server;
    }
}
