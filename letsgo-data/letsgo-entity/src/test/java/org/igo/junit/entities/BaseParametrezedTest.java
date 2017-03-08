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
import javax.persistence.criteria.CriteriaBuilder;
import org.igo.entities.Club;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
public class BaseParametrezedTest {

    private EntityManager entityManager;

    @Parameterized.Parameter(value = 0)
    static public EntityManagerFactory entityManagerFactory;

    @Parameterized.Parameters
    public static Collection dataBaseParam() {
        final EntityManagerFactory emf0 = Persistence.createEntityManagerFactory("testGamePU_MySQL");
        final EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("testPU_PostgreSQL");
        final EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("testGamePU_H2");
        final Object[][] param = {{emf0}, {emf1}, {emf2}};
        return Arrays.asList(param);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Before
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();

        if (entityManager != null) {
            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM City").executeUpdate();
            entityManager.getTransaction().commit();
        }
    }

    @After
    public void tearDown() {
        if (entityManager != null) {

            entityManager.getTransaction().begin();
            entityManager.createQuery("DELETE FROM City").executeUpdate();
            entityManager.getTransaction().commit();

            entityManager.clear();
            entityManager.getEntityManagerFactory().getCache().evictAll();
            entityManager.close();
        }
    }

    /**
     * @return the em
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * @param entityManager the em to set
     */
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void deleteFromTable(EntityManager entityManager, String tableName) {
        entityManager.getTransaction().begin();

        final String query = "DELETE FROM " + tableName;
        entityManager.createQuery(query).executeUpdate();
        entityManager.getTransaction().commit();
    }

    public void rollbackTransaction(EntityManager entityManager) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }
}
