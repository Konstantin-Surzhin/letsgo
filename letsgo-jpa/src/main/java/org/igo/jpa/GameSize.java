/*
 * Copyright (C) 2016 kostya surzhin
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
package org.igo.jpa;

/**
 *
 * @author kostya surzhin
 */
public enum GameSize {

    /**
     *
     */
    S9(9),
    /**
     *
     */
    S11(11),
    /**
     *
     */
    S13(13),
    /**
     *
     */
    S15(15),
    /**
     *
     */
    S17(17),
    /**
     *
     */
    S19(19),
    /**
     *
     */
    S21(21);

    private final Integer size;

    private GameSize(Integer size) {
        this.size = size;
    }
}
