/*
 * Copyright (C) 2016 pl
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
package org.mysql.utf8.dialect;

import org.hibernate.dialect.MySQLInnoDBDialect;

/**
 *
 * @author pl
 */
public class MysqlUTF8Dialect extends MySQLInnoDBDialect{

    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB CHARSET=utf8 COLLATE=utf8_unicode_ci ";
    }
    
    
}
