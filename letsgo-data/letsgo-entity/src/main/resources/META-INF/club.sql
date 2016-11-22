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
 * Created: 08.11.2016
 */

CREATE TABLE clubs
(
    id INTEGER NOT NULL AUTO_INCREMENT,
    city_id INTEGER NOT NULL,
    club_name CHARACTER CHARACTER SET utf8 COLLATE utf8_unicode_ci,
    CONSTRAINT uk_city_club UNIQUE (city_id, club_name),
    PRIMARY KEY (id),
    CONSTRAINT fk_club_city FOREIGN KEY (city_id) REFERENCES cities(id)
) ENGINE=InnoDB CHARACTER SET utf8 COLLATE utf8_unicode_ci;