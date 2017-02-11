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
/**
 * Author:  surzhin.konstantin
 * Created: 22.11.2016
 */

SHOW CREATE TABLE CITIES;
CREATE TABLE `CITIES` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL,
  `oktmo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country_id` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_city_name` (`city_name`),
  UNIQUE KEY `uk_lat_lon` (`latitude`,`longitude`),
  UNIQUE KEY `uk_oktmo` (`oktmo`),
  KEY `fk_city_country` (`country_id`),
  CONSTRAINT `fk_city_country` FOREIGN KEY (`country_id`) REFERENCES `COUNTRIES` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci