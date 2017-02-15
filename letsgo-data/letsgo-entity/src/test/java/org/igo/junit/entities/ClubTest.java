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
package org.igo.junit.entities;

import java.util.Arrays;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.igo.entities.City;
import org.igo.entities.Club;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class ClubTest {

    public ClubTest() {
    }

    @Parameterized.Parameter(value = 0)
    static public EntityManagerFactory emf;

    private EntityManager em;

    @Parameterized.Parameters
    public static Collection dataBaseParam() {

        final EntityManagerFactory emf0 = Persistence.createEntityManagerFactory("testGamePU_MySQL");
        final EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("testGamePU_H2");
        final Object[][] param = {{emf0}, {emf1}};

        return Arrays.asList(param);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
        if (emf != null) {
            emf.close();
        }
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        if (em != null) {
            final Query q = em.createQuery("DELETE FROM Club");
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();
        }
    }

    @After
    public void tearDown() {
        if (em != null) {
            final Query q = em.createQuery("DELETE FROM Club");
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();
            em.close();
        }
    }

    /**
     * Test of getId method, of class City.
     */
    @Test
    public void testGetId() {
        System.out.println("GetId");

        final Club club = new Club();
        club.setClubName("Болты и гайки");
        assertTrue(club.getId() == 0);

        if (em != null) {
            em.getTransaction().begin();
            em.persist(club);
            em.getTransaction().commit();
        }
        assertTrue(club.getId() != 0);
    }

    @Test(expected = PersistenceException.class)
    public void testDuplicateNameException() throws PersistenceException {
        System.out.println("DuplicateNameException");
        
        final City city = new City("Лабытнанги");
        
        final Club club1 = new Club();
        club1.setCity(city);
        club1.setClubName("Шайбы и шплинты");
        final Club club2 = new Club();
        club2.setClubName("Шайбы и шплинты");
        club2.setCity(city);
      
        if (em != null) {
            em.getTransaction().begin();
            em.persist(club1);
            em.persist(club2);
            em.getTransaction().commit();
        }

    }
}
