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
package org.igo.client.service.request;

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
public class ClientServiceRrequestTest {

    public ClientServiceRrequestTest() {
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
    public void unitFacadeTest() {
        System.out.println("Unit Facade Test");
        final City response = new City();
        final UnitInterface<City> ufc = new UnitFacade(response);
        assertEquals("city", ufc.getPath());

        final City city = ufc.getUnit();
        assertEquals(response, city);
    }

    @Test
    public void MessageWrappingTypeFacadeTest() {
        System.out.println(" Service Type Facade Test");
        final City response = new City();
        final UnitInterface<City> ufc = new UnitFacade(response);
        final MessageWrappingTypeInterface<City> mwf = new MessageWrappingTypeFcade(ufc, "xml");
        assertEquals("xml-city", mwf.getPath());

        final City city = mwf.getUnit();
        assertEquals(response, city);
    }

    @Test
    public void serviceTypeFacadeTest() {
        System.out.println(" Service Type Facade Test");
        final City response = new City();
        final UnitInterface<City> ufc = new UnitFacade(response);
        final MessageWrappingTypeInterface<City> mwf = new MessageWrappingTypeFcade(ufc, "xml");
        final ServiceTypeInterface<City> stf = new ServiceTypeFacade("REST", mwf);
        assertEquals("rest-xml-city", stf.getPath());

        final City city = stf.getUnit();
        assertEquals(response, city);
    }

    @Test
    public void serviceImplementationTypeFacade() {
        System.out.println("Service Implementation Type Facade Test");
        final City response = new City();
        final UnitInterface<City> ufc = new UnitFacade(response);
        final MessageWrappingTypeInterface<City> mwf = new MessageWrappingTypeFcade(ufc, "xml");
        final ServiceTypeInterface<City> stf = new ServiceTypeFacade("REST", mwf);
        final ServiceImplementationTypeInterface<City> sitf = new ServiceImplementationTypeFacade(stf, "RestEasy");
        assertEquals("--resteasy-rest-xml-city", sitf.getPath());

        final City city = stf.getUnit();
        assertEquals(response, city);
    }

    @Test
    public void dataBaseServiceImplementationTypeFacadeTest() {
        System.out.println("Data Base Service Implementation Type Facade Test");
        final City response = new City();
        final UnitInterface<City> ufc = new UnitFacade(response);
        final MessageWrappingTypeInterface<City> mwf = new MessageWrappingTypeFcade(ufc, "xml");
        final ServiceTypeInterface<City> stf = new ServiceTypeFacade("REST", mwf);
        final ServiceImplementationTypeInterface<City> sitf = new ServiceImplementationTypeFacade(stf, "RestEasy");

        sitf.setDatase("mysql");
        sitf.setDataBaseAccessType("jpa");

        assertEquals("mysql-jpa-resteasy-rest-xml-city", sitf.getPath());

        final City city = stf.getUnit();
        assertEquals(response, city);
    }
}
