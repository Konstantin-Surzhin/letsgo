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
package org.igo.letsgo.spring.data.crud;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author surzhin.konstantin
 * @param <T>
 */
@Repository
public class JpaFacade<T extends Entity> implements DaoInterface<T> {

    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> entityClass;

    /**
     * @param entityManager the entityManager to set
     */
    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public JpaFacade(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(final T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void edit(final T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(final T entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public T find(final Object id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<T> findRange(final int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = entityManager.createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @Override
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(entityManager.getCriteriaBuilder().count(rt));
        javax.persistence.Query q = entityManager.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public T find(String sql) {
        throw new RuntimeException("You need use \"find(final Object id)\" instead.");
    }

    @Override
    public void executeQuery(String sql) {
        throw new UnsupportedOperationException("Not supported."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> getList(String sql) {
        throw new RuntimeException("You need use \"findAll()\"  or \"findRange(final int[] range)\" instead.");
    }
}
