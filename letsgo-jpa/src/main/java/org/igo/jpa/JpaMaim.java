/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pl
 */
public class JpaMaim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa1PU");
        EntityManager em = emf.createEntityManager();
        User u = new User();
        u.setName("test");
        u.setEmail("letsgo@server.ru");
        u.setLastTime(new Date(System.currentTimeMillis()));

        EntityTransaction t = em.getTransaction();

        t.begin();
        em.persist(u);

        em.flush();
        t.commit();
        em.close();
        emf.close();
    }

}
