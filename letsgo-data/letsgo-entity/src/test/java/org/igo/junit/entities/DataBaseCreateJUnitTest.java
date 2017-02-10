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
package org.igo.junit.entities;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class DataBaseCreateJUnitTest {

    @Parameterized.Parameter(value = 0)
    public EntityManagerFactory emf;
    @Parameterized.Parameter(value = 1)
    public String informationSchemaName;
    @Parameterized.Parameter(value = 2)
    public String tableName;
    @Parameterized.Parameter(value = 3)
    public String rdbmsName;

    @Parameterized.Parameters
    public static Collection dataBaseParam() {
        final EntityManagerFactory emf0 = Persistence.createEntityManagerFactory("testGamePU_MySQL");
        final EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("testGamePU_H2");

        final String _informationSchemaName = "information_schema";
        final String[] table = {"cities", "DEGREES", "EVENTS",
            "GAMES", "GAME_COMMENS", "GANE_DATES", "GAME_MOVES",
            "GAME_RULES", "LEADUES", "MOVE_COMMENTS", "PLACES", "ROOMS",
            "TEAMS", "USERS", "USER_BANS", "USER_DEGREES", "USER_GAME",
            "USER_ROLES, countries"
        };
        final Object[][] param = {{emf0, _informationSchemaName, table[0],  "MySql"},
        {emf1, _informationSchemaName.toUpperCase(), table[1], "H2"}};

        return Arrays.asList(param);
    }

    public DataBaseCreateJUnitTest() {
    }

    @Test
    public void ifTableExist() {
        System.out.println(rdbmsName + " : " + tableName + ":check table exist.");

        final EntityManager em = emf.createEntityManager();
        final Query q = em.createNativeQuery("SELECT count(TABLE_NAME) cn  FROM "
                + informationSchemaName
                + ".TABLES WHERE TABLE_NAME=:TABLE_NAME AND TABLE_SCHEMA='letsgo'");
        q.setParameter("TABLE_NAME", tableName);

        final BigInteger cn = (BigInteger) q.getSingleResult();
        em.close();

        final BigInteger result = BigInteger.valueOf(1);

        assertEquals(rdbmsName + " : " + tableName + " does not exist", result, cn);
    }

}
