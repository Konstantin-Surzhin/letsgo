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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author surzhin.konstantin
 * @param <T>
 */
@Repository
public class JdbcFacade<T extends Entity> implements DaoInterface<T> {

    private DataSource dataSource;

    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(DataSource dataSource) {
        try {
            Context ctx = new InitialContext();
            this.dataSource = (DataSource) ctx.lookup("java:/jboss/datasources/MySQLDS");
        } catch (NamingException ex) {
            Logger.getLogger(JdbcFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
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
