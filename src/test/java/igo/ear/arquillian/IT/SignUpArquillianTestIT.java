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
package igo.ear.arquillian.IT;

import java.io.File;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.container.test.api.Testable;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Arquillian.class)
public class SignUpArquillianTestIT {

    /**
     *
     * @return @throws Exception
     */
    @Deployment
    public static EnterpriseArchive createDeployment() throws Exception {
        String letsgoHome = System.getenv("LETSGO_HOME");
        String jbossHome = System.getenv("JBOSS_HOME");

        if (letsgoHome == null || letsgoHome.isEmpty()) {
            System.err.println("LETSGO_HOME is empty");
            throw new Exception("LETSGO_HOME is empty");
        }
//        if (jbossHome == null || jbossHome.isEmpty()) {
//            System.err.println("JBOSS_HOME is empty");
//            throw new Exception("JBOSS_HOME is empty");
//        }

        EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class);

        ear.addAsModule(new File(letsgoHome + "/letsgo-client/target/letsgo-client-1.0.jar"));
        ear.addAsModule(new File(letsgoHome + "/letsgo-ejb/target/letsgo-ejb-1.0.jar"));
        ear.addAsModule(new File(letsgoHome + "/letsgo-jpa/target/letsgo-jpa-1.0.jar"));
        ear.addAsModule(new File(letsgoHome + "/letsgo-remote/target/letsgo-remote-1.0.jar"));
        ear.addAsModule(new File(letsgoHome + "/letsgo-rest/target/letsgo-rest-1.0.war"));
        ear.addAsModule(new File(letsgoHome + "/letsgo-soap/target/letsgo-soap-1.0.war"));
        ear.addAsModule(new File(letsgoHome + "/letsgo-spring/target/letsgo-spring-1.0.war"));

        WebArchive war = Testable.archiveToTest(ShrinkWrap.createFromZipFile(WebArchive.class,
                new File(letsgoHome + "/letsgo-web/target/letsgo-web-1.0.war")));
        ear.addAsModule(war);
        ear.setApplicationXML(new File(letsgoHome + "/letsgo-ear/src/main/application/META-INF/application.xml"));
        ear.addAsApplicationResource(new File(letsgoHome + "/letsgo-ear/src/main/application/META-INF/jboss-app.xml"));

//        EnterpriseArchive ear = ShrinkWrap.createFromZipFile(EnterpriseArchive.class,
//                new File("/home/pl/NetBeansProjects/letsgo/letsgo-ear/target/letsgo-ear-1.0.ear"));
        System.out.println(ear.toString(true));

        return ear;
    }

    /**
     *
     */
    public SignUpArquillianTestIT() {
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
     * @throws Exception
     */
    @Test
    @RunAsClient
    public void helloLetsgo() throws Exception {
        System.out.println("OK <=========================");
    }
}
