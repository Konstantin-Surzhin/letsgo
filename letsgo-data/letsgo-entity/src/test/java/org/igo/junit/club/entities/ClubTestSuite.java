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
package org.igo.junit.club.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    org.igo.junit.club.entities.ClubCascadeTest.class,
    org.igo.junit.club.entities.ClubCacheTest.class,
    org.igo.junit.club.entities.ClubLazyExceptionTest.class,
    org.igo.junit.club.entities.ClubPropertyTest.class,
    org.igo.junit.club.entities.ClubLeagueM2MTest.class,
    org.igo.junit.club.entities.ClubForeignKeyTest.class
})
public class ClubTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
