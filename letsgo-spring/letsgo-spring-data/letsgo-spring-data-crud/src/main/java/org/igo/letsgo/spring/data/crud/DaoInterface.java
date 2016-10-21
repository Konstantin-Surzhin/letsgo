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
import org.springframework.stereotype.Repository;

/**
 *
 * @author surzhin.konstantin
 * @param <T>
 */
@Repository
public interface DaoInterface<T extends Entity> {

    int count();

    void create(T entity);

    void edit(T entity);

    void remove(T entity);

    void executeQuery(String sql);

    T find(Object id);

    T find(String sql);

    List<T> findAll();

    List<T> findRange(int[] range);

    List<T> getList(String sql);
}
