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
package org.igo.entities;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
public class DataBaseCreateJUnitTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public DataBaseCreateJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
      //  emf = Persistence.createEntityManagerFactory("testGamePU_MySQL");
        emf = Persistence.createEntityManagerFactory("testGamePU_H2");
        
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDownClass() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void citiesTableExist() {
        System.out.println("cities table");
        Query q = em.createNativeQuery("SELECT count(TABLE_NAME)  cn  FROM  information_schema.TABLES WHERE TABLE_NAME='CITIES' AND TABLE_SCHEMA='LETSGO'");
        BigInteger cn = (BigInteger) q.getSingleResult();
        List l = q.getResultList();
        l.stream().forEach((o) -> {
            System.out.println(o);
        }); //  BigInteger result = BigInteger.valueOf(1);
        // assertEquals("cities table does not exist", result, cn);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void degreeTableExist() {
        System.out.println("degree table");
        Query q = em.createNativeQuery("SELECT count(TABLE_NAME)  cn  FROM  information_schema.TABLES WHERE TABLE_NAME='DEGREES' AND TABLE_SCHEMA='LETSGO'");
        BigInteger cn = (BigInteger) q.getSingleResult();
        BigInteger result = BigInteger.valueOf(1);
        assertEquals("degrees table does not exist",result, cn);
    }

    @Test
    public void eventTableExist() {
        System.out.println("event table");
        Query q = em.
                createNativeQuery("SELECT count(TABLE_NAME)  cn  FROM  information_schema.TABLES WHERE TABLE_NAME='event'  AND TABLE_SCHEMA='letsgo'");
        BigInteger cn = (BigInteger) q.getSingleResult();
        BigInteger result = BigInteger.valueOf(1);
        assertEquals("event table does not exist", result, cn);
    }
}
