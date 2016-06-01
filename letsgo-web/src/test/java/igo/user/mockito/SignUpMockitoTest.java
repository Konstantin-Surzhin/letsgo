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
package igo.user.mockito;

import igo.user.SignUp;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.igo.UserManagerBeanRemote;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.*;

/**
 *
 * @author surzhin.konstantin
 */
public class SignUpMockitoTest {

    public SignUpMockitoTest() {
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

    /**
     * Test of processRequest method, of class SignUp. User manager Bean is
     * null.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testProcessRequestUMBean1() throws Exception {
        System.out.println("user manager Bean is null");

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        try (PrintWriter writer = new PrintWriter(out)) {

            String name = "user";
            String passwd = "passwd";
            String rpasswd = passwd;

            Mockito.when(request.getParameter("name")).thenReturn(name);
            Mockito.when(request.getParameter("passwd")).thenReturn(passwd);
            Mockito.when(request.getParameter("rpasswd")).thenReturn(rpasswd);

            Mockito.when(response.getWriter()).thenReturn(writer);

            SignUp instance = new SignUp();

            instance.doPost(request, response);
        }
        assertEquals("user manager is null", out.toString());
    }

    /**
     * Test of processRequest method, of class SignUp. User manager Bean is not
     * null.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testProcessRequestUMBean2() throws Exception {
        System.out.println("user manager Bean is not null");

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (PrintWriter writer = new PrintWriter(out)) {

            String name = "user";
            String passwd = "passwd";
            String rpasswd = passwd;

            Mockito.when(request.getParameter("name")).thenReturn(name);
            Mockito.when(request.getParameter("passwd")).thenReturn(passwd);
            Mockito.when(request.getParameter("rpasswd")).thenReturn(rpasswd);

            Mockito.when(response.getWriter()).thenReturn(writer);

            SignUp instance = new SignUp();

            UserManagerBeanRemote userManagerBean = Mockito.mock(UserManagerBeanRemote.class);
            instance.setUserManagerBean(userManagerBean);
            
            instance.doPost(request, response);

            verify(userManagerBean, times(1)).create(name, passwd, rpasswd);
        }

        assertTrue(out.toString().contains("User id: "));
    }

    @Test
    public void testProcessRequestName1() throws Exception {
        System.out.println("name is null");

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (PrintWriter writer = new PrintWriter(out)) {
            Mockito.when(response.getWriter()).thenReturn(writer);
            SignUp instance = new SignUp();
            instance.doPost(request, response);
        }
        assertEquals("name is null", out.toString());
    }

    @Test
    public void testProcessRequestName2() throws Exception {
        System.out.println("name is empty");

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (PrintWriter writer = new PrintWriter(out)) {
            Mockito.when(response.getWriter()).thenReturn(writer);
            Mockito.when(request.getParameter("name")).thenReturn("");
            SignUp instance = new SignUp();
            instance.doPost(request, response);
        }

        assertEquals("name is empty", out.toString());
    }

    @Test
    public void testProcessRequestPasswd1() throws Exception {
        System.out.println("passwd is null");

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (PrintWriter writer = new PrintWriter(out)) {
            Mockito.when(response.getWriter()).thenReturn(writer);
            Mockito.when(request.getParameter("name")).thenReturn("user");
            SignUp instance = new SignUp();
            instance.doPost(request, response);
        }
        assertEquals("passwd is null", out.toString());
    }

    @Test
    public void testProcessRequestPasswd2() throws Exception {
        System.out.println("passwd is empty");

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (PrintWriter writer = new PrintWriter(out)) {
            Mockito.when(response.getWriter()).thenReturn(writer);
            Mockito.when(request.getParameter("name")).thenReturn("user");
            Mockito.when(request.getParameter("passwd")).thenReturn("");
            SignUp instance = new SignUp();
            instance.doPost(request, response);
        }

        assertEquals("passwd is empty", out.toString());
    }

    @Test
    public void testProcessRequestRPasswd1() throws Exception {
        System.out.println("rpasswd is null");

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (PrintWriter writer = new PrintWriter(out)) {
            Mockito.when(response.getWriter()).thenReturn(writer);
            Mockito.when(request.getParameter("name")).thenReturn("user");
            Mockito.when(request.getParameter("passwd")).thenReturn("passwd");
            SignUp instance = new SignUp();
            instance.doPost(request, response);
        }
        assertEquals("rpasswd is null", out.toString());
    }

    @Test
    public void testProcessRequestRPasswd2() throws Exception {
        System.out.println("rpasswd is empty");

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (PrintWriter writer = new PrintWriter(out)) {
            Mockito.when(response.getWriter()).thenReturn(writer);
            Mockito.when(request.getParameter("name")).thenReturn("user");
            Mockito.when(request.getParameter("passwd")).thenReturn("passwd");
            Mockito.when(request.getParameter("rpasswd")).thenReturn("");
            SignUp instance = new SignUp();
            instance.doPost(request, response);
        }

        assertEquals("rpasswd is empty", out.toString());
    }

    @Test
    public void testProcessRequestPasswdRPasswdNotEquals() throws Exception {
        System.out.println("passwd and rpasswd not equals");

        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (PrintWriter writer = new PrintWriter(out)) {
            Mockito.when(response.getWriter()).thenReturn(writer);
            Mockito.when(request.getParameter("name")).thenReturn("user");
            Mockito.when(request.getParameter("passwd")).thenReturn("passwd");
            Mockito.when(request.getParameter("rpasswd")).thenReturn("rpasswd");
            SignUp instance = new SignUp();
            instance.doPost(request, response);
        }

        assertEquals("A password mismatch has been detected", out.toString());
    }
}
