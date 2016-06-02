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
package igo.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.igo.UserManagerBeanRemote;

/**
 *
 * @author surzhin.konstantin
 */
@WebServlet(name = "SignUpVerification", urlPatterns = {"/verification"})
public class SignUpVerification extends HttpServlet {

    private UserManagerBeanRemote userManagerBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String name = parametrCheck("name", request, response, out);
        if (name == null) {
            return;
        }
        String passwd = parametrCheck("passwd", request, response, out);
        if (passwd == null) {
            return;
        }
        String rPasswd = parametrCheck("rpasswd", request, response, out);
        if (rPasswd == null) {
            return;
        }

        if (!passwd.equals(rPasswd)) {
            out.print("A password mismatch has been detected");
            response.setStatus(400);
            return;
        }

        if (userManagerBean == null) {
            out.print("user manager is null");
            response.setStatus(500);
        } else {
            String userId = userManagerBean.create(name, passwd, rPasswd);
            if (userId.equals("-1")) {
                out.print("user " + name + " exist");
            } else {
                HttpSession ss = request.getSession();
                ss.setAttribute("name", name);
                response.sendRedirect("/user/" + userId);
            }
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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
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

    /**
     * @return the userManagerBean
     */
    public UserManagerBeanRemote getUserManagerBean() {
        return userManagerBean;
    }

    /**
     * @param userManagerBean the userManagerBean to set
     */
    @EJB
    public void setUserManagerBean(UserManagerBeanRemote userManagerBean) {
        this.userManagerBean = userManagerBean;
    }

    private String parametrCheck(String name,
            HttpServletRequest request,
            HttpServletResponse response,
            PrintWriter out) {
        String param = request.getParameter(name);

        if (param == null) {
            out.print(name + " is null");
        } else if (param.isEmpty()) {
            out.print(name + " is empty");
            param = null;
        }
        if (param == null) {
            response.setStatus(400);
        }
        return param;
    }
}
