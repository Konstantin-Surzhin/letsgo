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

create table user_details (
    id integer not null auto_increment,
    draw integer,
    email varchar(255) not null,
    is_login bit,
    last_time datetime not null,
    lose integer,
    user_name varchar(64) not null,
    nescape integer,
    password varchar(128) not null,
    rating integer,
    salt varchar(128),
    staus integer,
    win integer,
    city_id integer,
    club_id integer,
    league_id smallint,
    role_id smallint,
    room_id smallint,
    team_id smallint,
CONSTRAINT uk_user_email unique (email),
CONSTRAINT uk_user_name unique (user_name),
PRIMARY KEY (id),
CONSTRAINT fk_user_city FOREIGN KEY (city_id) REFERENCES CITIES(id),
CONSTRAINT fk_user_club FOREIGN KEY (club_id) references CLUBS (id),
CONSTRAINT fk_user_league FOREIGN KEY (league_id) references LEAGUES (id),
CONSTRAINT fk_user_role FOREIGN KEY (role_id) references USER_ROLES (id),
CONSTRAINT fk_user_room  FOREIGN KEY (room_id) references ROOMS (id),
CONSTRAINT fk_user_team FOREIGN KEY (team_id) references TEAMS (id)
 )ENGINE=InnoDB CHARSET=utf8 COLLATE=utf8_unicode_ci 