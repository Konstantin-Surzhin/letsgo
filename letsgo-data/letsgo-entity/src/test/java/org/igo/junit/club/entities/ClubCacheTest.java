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

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import static org.hamcrest.CoreMatchers.equalTo;
import org.igo.entities.Club;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author surzhin.konstantin
 */
@RunWith(Parameterized.class)
public class ClubCacheTest extends BaseClubParametrezedTest {
    
    public ClubCacheTest() {
    }
    
   @Test
    public void testClubInCache() {
        System.out.println("ClubInCache");

        final Club club = new Club("Дыхание камней");
        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(club);
                entityManager.getTransaction().commit();

                assertTrue("Объекта в L1 кеше нет", entityManager.contains(club));
                entityManager.clear();
                assertFalse("Объекта в L1 кеше", entityManager.contains(club));

                final Club nuvoClub = entityManager.find(Club.class, club.getId());
                final Cache cache = entityManager.getEntityManagerFactory().getCache();

                entityManager.merge(nuvoClub);
                assertTrue("Объекта в L1 кеше нет", entityManager.contains(nuvoClub));
                assertTrue("Объекта в L2 кеше нет", cache.contains(Club.class, nuvoClub.getId()));

                cache.evict(Club.class, club.getId());
                assertFalse(cache.contains(Club.class, club.getId()));

            } catch (Exception ex) {
                entityManager.getTransaction().rollback();
                throw ex;
            }
        }
    } 
    
    @Test
    public void testUpdateClubWithNativSQLClubInCache() {
        System.out.println("UpdateClubWithNativSQLClubInCache");

        final Club club = new Club("Сердце камня");

        final EntityManager entityManager = this.getEntityManager();
        if (entityManager != null) {

            final Cache cache = entityManager.getEntityManagerFactory().getCache();

            try {
                entityManager.getTransaction().begin();
                entityManager.persist(club);
                entityManager.getTransaction().commit();

                entityManager.getTransaction().begin();
                final int number = entityManager
                        .createQuery("UPDATE Club c SET c.clubName =:clubName WHERE c.id = :id")
                        .setParameter("clubName", "Душа камня")
                        .setParameter("id", club.getId())
                        .executeUpdate();
                entityManager.getTransaction().commit();

                assertThat(number, equalTo(1));

                final String clubFromDbTadle = entityManager
                        .createQuery("SELECT c.clubName From Club c WHERE c.id=:id", String.class)
                        .setParameter("id", club.getId())
                        .setHint("org.hibernate.readOnly", true)
                        .getSingleResult();
                assertThat(clubFromDbTadle, equalTo("Душа камня"));

                assertTrue(entityManager.contains(club));

                final Club clubFromCahe = entityManager.find(Club.class, club.getId());

                assertThat(clubFromCahe.getClubName(), equalTo("Сердце камня"));

                entityManager.refresh(clubFromCahe);
                assertThat(club.getClubName(), equalTo("Душа камня"));
                assertThat(clubFromCahe.getClubName(), equalTo("Душа камня"));

                cache.evict(Club.class, club.getId());
                assertFalse(cache.contains(Club.class, club.getId()));
            } catch (Exception ex) {
                entityManager.getTransaction().rollback();
                throw ex;
            }
        }
    }
}
