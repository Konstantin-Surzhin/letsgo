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
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author surzhin.konstantin
 * @param <T>
 */
@Repository
public class JdbcTemplateFacade<T extends Entity> implements DaoInterface<T> {

    private JdbcTemplate jdbcTemplate;
    private final Class<T> entityClass;

    public JdbcTemplateFacade(final Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    public void init(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int count() {
        throw new RuntimeException("You need use \"executeQuery(String sql)\" instead.");
    }

    @Override
    public void create(T entity) {
        throw new RuntimeException("You need use \"executeQuery(String sql)\" instead.");
    }

    @Override
    public void edit(T entity) {
        throw new RuntimeException("You need use \"executeQuery(String sql)\" instead.");
    }

    @Override
    public T find(Object id) {
        throw new RuntimeException("You need use \"find(String sql)\" instead.");
    }

    @Override
    public List<T> findAll() throws RuntimeException {
        throw new RuntimeException("You need use \"getList(String sql)\" instead.");
    }

    @Override
    public List<T> findRange(int[] range) throws RuntimeException {
        throw new RuntimeException("You need use \"getList(String sql)\" instead.");
    }

    @Override
    public void remove(T entity) throws RuntimeException {
        throw new RuntimeException("You need use \"executeQuery(String sql)\" instead.");
    }

    @Override
    public T find(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void executeQuery(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> getList(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
