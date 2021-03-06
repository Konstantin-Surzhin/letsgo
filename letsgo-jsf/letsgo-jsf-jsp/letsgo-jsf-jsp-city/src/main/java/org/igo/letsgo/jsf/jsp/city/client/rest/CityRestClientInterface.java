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

import org.igo.letsgo.jsf.jsp.city.entity.City;

/**
 *
 * @author pl
 */
public interface CityRestClientInterface {

    public City sendCity(String url, String msgMediaType, String persistenceType, String dbName, City city);

    public City recieveCity(String msgContentType, String dbMetod, String dbName);
}
