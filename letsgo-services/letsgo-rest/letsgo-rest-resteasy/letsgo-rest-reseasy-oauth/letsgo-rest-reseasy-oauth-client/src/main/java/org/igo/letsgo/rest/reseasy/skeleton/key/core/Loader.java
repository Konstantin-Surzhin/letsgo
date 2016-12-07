/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.rest.reseasy.skeleton.key.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyStore;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.resteasy.skeleton.key.EnvUtil;
import org.jboss.resteasy.skeleton.key.servlet.ServletOAuthClient;

/**
 *
 * @author Surzhin.Konstantin
 */
public class Loader extends HttpServlet implements ServletContextListener {

    private ServletOAuthClient oauthClient;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Loader</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Loader at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final String truststoreKSPassword = "changeit";
        String truststoreKSPath = "${jboss.server.config.dir}/clienttruststore.ts";
        truststoreKSPath = EnvUtil.replace(truststoreKSPath);
        try {
            final KeyStore truststoreKS = loadKeyStore(truststoreKSPath, truststoreKSPassword);
            oauthClient = new ServletOAuthClient();
            oauthClient.setTruststore(truststoreKS);
            oauthClient.setClientId("third-party");
            oauthClient.setPassword("changeit");
            oauthClient.setAuthUrl("https://localhost:8443/oauth-server/login.jsp");
            oauthClient.setCodeUrl("https://localhost:8443/oauth-server/j_oauth_resolve_access_code");
            oauthClient.start();
            sce.getServletContext().setAttribute(ServletOAuthClient.class.getName(), oauthClient);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
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
