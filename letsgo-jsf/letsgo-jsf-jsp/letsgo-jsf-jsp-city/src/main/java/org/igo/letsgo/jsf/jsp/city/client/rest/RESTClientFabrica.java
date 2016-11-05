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
package org.igo.letsgo.jsf.jsp.city.client.rest;

import org.igo.letsgo.jsf.jsp.city.CityMsgInterface;

/**
 *
 * @author pl
 */
public class RESTClientFabrica {

    public static CityMsgInterface createRESTClient(String persistenceType) {
        switch (persistenceType) {
            case "jdbc":
                return new CityJDBCRESTClient();
            case "jpa":
                return new CityJPARESTClient();
            default:
                return null;
        }
    }
}
