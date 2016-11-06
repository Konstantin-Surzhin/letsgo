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
package org.igo.letsgo.city.rest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pl
 */
class JDBCConnectionFabrica {

    static Connection getConnection(String db) {
        try {
            switch (db) {
                case "h2":
                    return DriverManager.getConnection("");
                default:
                    return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnectionFabrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
