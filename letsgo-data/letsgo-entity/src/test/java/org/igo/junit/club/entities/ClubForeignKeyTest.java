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

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.igo.entities.City;
import org.igo.entities.Club;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author surzhin.konstantin
 */
public class ClubForeignKeyTest extends BaseClubParametrezedTest{
    
    public ClubForeignKeyTest() {
    }
    
    @Test(expected = PersistenceException.class)
    public void testPersistClubButCityNotYetAlreadyPersist () {
        System.out.println("PersistClubButCityNotYetAlreadyPersist");

        final City city = new City("Электросталь");
        final Club club = new Club("Зубило");
        club.setCity(city);

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();
            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            }
        }
    }

    @Test(expected = PersistenceException.class)
    public void testDeleteCityButClubsAreNotYetDelete() {
        System.out.println("DeleteCityButClubsAreNotYetDelete");

        final City city = new City("Электросталь");
        final Club club = new Club("Зубило");
        club.setCity(city);

        if (getEntityManager() != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(city);
                getEntityManager().persist(club);
                getEntityManager().getTransaction().commit();

                final Query q = getEntityManager().createQuery("Delete from City");

                getEntityManager().getTransaction().begin();
                q.executeUpdate();
                getEntityManager().getTransaction().commit();

            } catch (Exception ex) {
                getEntityManager().getTransaction().rollback();
                System.err.println(ex.getLocalizedMessage());
                throw ex;
            } finally {
                final Query q1 = getEntityManager().createQuery("Delete from Club");
                final Query q2 = getEntityManager().createQuery("Delete from City");

                getEntityManager().getTransaction().begin();
                q1.executeUpdate();
                q2.executeUpdate();
                getEntityManager().getTransaction().commit();
            }

        }
    }
}
