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
package java.org.igo.entities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
@Suite.SuiteClasses({org.igo.junit.entities.GameDatePKTest.class,
    org.igo.junit.entities.GameCommentTest.class,
    org.igo.junit.entities.GameDateTest.class,
    org.igo.junit.entities.GameMovePKTest.class,
    org.igo.junit.entities.MoveCommentTest.class,
    org.igo.junit.entities.PlaceTest.class,
    org.igo.junit.entities.TeamTest.class,
    org.igo.junit.entities.CitiesTest.class,
    org.igo.junit.entities.EntitiesSuite.class,
    org.igo.junit.entities.UserDegreePKTest.class,
    org.igo.junit.entities.UserGameTest.class,
    org.igo.junit.entities.DegreesTest.class,
    org.igo.junit.entities.UserBanTest.class,
    org.igo.junit.entities.EventsTest.class,
    org.igo.junit.entities.UserTest.class,
    org.igo.junit.entities.RoomTest.class,
    org.igo.junit.entities.UserDegreeTest.class,
    org.igo.junit.entities.UserRoleTest.class,
    org.igo.junit.entities.LeagueTest.class,
    org.igo.junit.entities.GameTest.class,
    org.igo.junit.entities.GameRuleTest.class,
    org.igo.junit.entities.UserGamePKTest.class,
    org.igo.junit.entities.GameMoveTest.class})
public class LetsgoEntityTestSuite {

    static public EntityManagerFactory emf;

    @BeforeClass
    public static void setUpClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("testGamePU_H2");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        if (emf != null) {
            emf.close();
        }
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
