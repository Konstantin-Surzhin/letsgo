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
package org.igo.dbunit.entities;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.dbunit.Assertion;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.igo.entities.City;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author surzhin.konstantin
 */
public class CityTest extends DBUnitConfig {

    private final CityService service = new CityService();

    public CityTest(String name) {
        super(name);
    }

    @Before
    @Override
    public void setUp() {
        try {
            super.setUp();
            beforeData = new FlatXmlDataSetBuilder()
                    .build(
                            Thread.currentThread()
                                    .getContextClassLoader()
                                    .getResourceAsStream("org/igo/dbunit/city/city-data.xml"));

            tester.setDataSet(beforeData);
            tester.onSetup();

        } catch (Exception ex) {
            
            Logger.getLogger(CityTest.class.getName()).
                    log(Level.SEVERE, ex.getLocalizedMessage());
            
            for (Throwable e : ex.getSuppressed()) {
                Logger.getLogger(DBUnitConfig.class.getName())
                        .log(Level.SEVERE, e.getLocalizedMessage());
            }
        }
    }

//    @Test
//    public void testGetAll() throws Exception {
//        List<City> city = service.getAll();
//        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
//                Thread.currentThread().getContextClassLoader()
//                .getResourceAsStream("org/igo/dbunit/city/city-data.xml"));
//
//        IDataSet actualData = tester.getConnection().createDataSet();
//        
//      
//        //Assertion.assertEquals(expectedData, actualData);
//        Assert.assertEquals(expectedData.getTable("cities").getRowCount(), city.size());
//    }
//    @Test
//    public void testIsExist() throws Exception {
//        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
//                Thread.currentThread().getContextClassLoader()
//                        .getResourceAsStream("org/igo/dbunit/city/city-data.xml"));
//        IDataSet actualData = tester.getConnection().createDataSet();
//
//        String[] s = actualData.getTableNames();
//        ITable t = actualData.getTable("cities");
//        int rc = t.getRowCount();
//        ITable et = expectedData.getTable("cities");
//        int rc1 = et.getRowCount();
//        String[] ignore = {"id"};
//        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "cities", ignore);
//    }
    @Test
    public void testSave() throws Exception {
        final City city = new City();
        city.setCityName("Москва");
        service.save(city);
        assertTrue(0 != city.getId());
    }
}
