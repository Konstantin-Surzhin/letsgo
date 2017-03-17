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
package org.igo.junit.city.entities;

import org.igo.junit.entities.BaseParametrezedTest;
import org.junit.After;
import org.junit.Before;

/**
 *
 * @author surzhin.konstantin
 */
public class BaseCityParametrezedTest extends BaseParametrezedTest {

    @Before
    @Override
    public void setUp() {
        super.setUp();
        if (getEntityManager() != null) {
            
            deleteFromTable(getEntityManager(), "City");
        }
    }

    @After
    public void tearDown() {
        if (getEntityManager() != null) {

            deleteFromTable(getEntityManager(), "City");

            getEntityManager().clear();
            getEntityManager().getEntityManagerFactory().getCache().evictAll();
            getEntityManager().close();
        }
    }

}
