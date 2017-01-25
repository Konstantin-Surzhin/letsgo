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
package org.igo.letsgo.security.resteasy.skeleton.key.client;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.jboss.resteasy.skeleton.key.EnvUtil;
import org.jboss.resteasy.skeleton.key.servlet.ServletOAuthClient;

/**
 * Web application lifecycle listener.
 *
 * @author surzhin.konstantin
 */
public class Loader implements ServletContextListener {

    private final ServletOAuthClient oauthClient = new ServletOAuthClient();

    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        final String truststoreKSPath  = EnvUtil.replace("${jboss.server.config.dir}/clienttruststore.ts");
        final String truststoreKSPassword = "changeit";
        try {
            final KeyStore truststoreKS = loadKeyStore(truststoreKSPath, truststoreKSPassword);

            oauthClient.setTruststore(truststoreKS);
            oauthClient.setClientId("third-party");
            oauthClient.setPassword("changeit");
            oauthClient.setAuthUrl("https://localhost:8443/oauth-server/login.jsp");
            oauthClient.setCodeUrl("https://localhost:8443/oauth-server/j_oauth_resolve_access_code");
            oauthClient.start();
            sce.getServletContext().setAttribute(ServletOAuthClient.class.getName(), oauthClient);
        } catch (Exception ex) {
            Logger.getLogger(Loader.class.getName()).log(Level.SEVERE, ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
        oauthClient.stop();
    }

    private static KeyStore loadKeyStore(final String filename, final String password)
            throws Exception {
        final KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        final File keyStoreFile = new File(filename);
        try (final FileInputStream keyStoreStream = new FileInputStream(keyStoreFile)) {
            keyStore.load(keyStoreStream, password.toCharArray());
        }
        return keyStore;
    }
}
