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
package igo.user.mockrunner;

import com.mockrunner.mock.web.WebMockObjectFactory;
import com.mockrunner.servlet.ServletTestModule;
import igo.user.SignUpVerification;
import org.igo.UserManagerBeanRemote;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 *
 * @author surzhin.konstantin
 */
public class SignUpMockrunnerTest {

    private ServletTestModule tester;
    private WebMockObjectFactory factory;

    @Before
    public void setup() {
        factory = new WebMockObjectFactory();
        tester = new ServletTestModule(factory);
    }

    @Test
    public void testProcessRequestUMBean1() throws Exception {
        System.out.println("user manager Bean is null");

        String name = "user";
        String passwd = "passwd";
        String rpasswd = passwd;

        tester.addRequestParameter("name", name);
        tester.addRequestParameter("passwd", passwd);
        tester.addRequestParameter("rpasswd", rpasswd);

        // instantiate the servlet
        tester.createServlet(SignUpVerification.class);

        // call doPost
        tester.doPost();
        String out = tester.getOutput();

        assertEquals("user manager is null", out);

        assertEquals(500, factory.getMockResponse().getStatusCode());
    }

    @Test
    public void testProcessRequestUMBean2() throws Exception {
        System.out.println("user manager Bean is not null");

        String name = "user";
        String passwd = "passwd";
        String rpasswd = passwd;

        tester.addRequestParameter("name", name);
        tester.addRequestParameter("passwd", passwd);
        tester.addRequestParameter("rpasswd", rpasswd);

        // instantiate the servlet
        SignUpVerification srv = (SignUpVerification) tester.createServlet(SignUpVerification.class);

        //TODO: MockEJB
        UserManagerBeanRemote userManagerBean = mock(UserManagerBeanRemote.class);

        srv.setUserManagerBean(userManagerBean);

        // call doPost
        tester.doPost();
        String out = tester.getOutput();

        assertTrue(out.contains("User id"));

        assertEquals(200, factory.getMockResponse().getStatusCode());
    }

    @Test
    public void testProcessRequestPasswdRPasswdNotEquals() throws Exception {
        System.out.println("passwd and rpasswd not equals");

        String name = "user";

        tester.addRequestParameter("name", name);
        tester.addRequestParameter("passwd", "passwd");
        tester.addRequestParameter("rpasswd", "rpasswd");

        // instantiate the servlet
        SignUpVerification srv = (SignUpVerification) tester.createServlet(SignUpVerification.class);

        //TODO: MockEJB
        UserManagerBeanRemote userManagerBean = mock(UserManagerBeanRemote.class);

        srv.setUserManagerBean(userManagerBean);

        // call doPost
        tester.doPost();
        String out = tester.getOutput();

        assertEquals("A password mismatch has been detected", out);

        assertEquals(400, factory.getMockResponse().getStatusCode());
    }

}
