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

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dbunit.DBTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.ext.mysql.MySqlMetadataHandler;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;

/**
 *
 * @author surzhin.konstantin
 */
public class DBUnitConfig extends DBTestCase {

    private Properties prop = new Properties();

    protected IDatabaseTester tester;
    protected IDataSet beforeData;

    @Before
    @Override
    public void setUp() {
        try {
            tester = new MySqlTester(
                    prop.getProperty("db.driver"),
                    prop.getProperty("db.url"),
                    prop.getProperty("db.username"),
                    prop.getProperty("db.password"),
                    prop.getProperty("db.schema"));
            
        } catch (ClassNotFoundException ex) {
            
            Logger.getLogger(DBUnitConfig.class.getName())
                    .log(Level.SEVERE, ex.getLocalizedMessage());
            
            for (Throwable e : ex.getSuppressed()){
               Logger.getLogger(DBUnitConfig.class.getName())
                    .log(Level.SEVERE, e.getLocalizedMessage()); 
            }
        }
    }

    public DBUnitConfig(String name) {
        super(name);
        try {
            prop.load(Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("db.config.properties"));
        } catch (IOException ex) {
            Logger.getLogger(DBUnitConfig.class.getName())
                    .log(Level.SEVERE, ex.getLocalizedMessage());
        }
//        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, prop.getProperty("db.driver"));
//        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, prop.getProperty("db.url"));
//        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, prop.getProperty("db.username"));
//        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, prop.getProperty("db.password"));
//        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_SCHEMA, "letsgo");
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return beforeData;
    }
}
