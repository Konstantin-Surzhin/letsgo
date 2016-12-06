/*
 * Copyright (C) 2016 Surzhin.Konstantin
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
package org.igo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author surzhin.konstantin
 */
@Embeddable
public class GameDatePK implements Serializable {

    private static final long serialVersionUID = 1L;
    private long gameId;
    private int ndx;

    public GameDatePK() {
    }

    public GameDatePK(final long gameId, final int ndx) {
        this.gameId = gameId;
        this.ndx = ndx;
    }

    @Basic(optional = false)
    @Column(name = "game_id", nullable = false)
    public long getGameId() {
        return gameId;
    }

    public void setGameId(final long gameId) {
        this.gameId = gameId;
    }

    @Basic(optional = false)
    @Column(nullable = false)
    public int getNdx() {
        return ndx;
    }

    public void setNdx(final int ndx) {
        this.ndx = ndx;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameDatePK other = (GameDatePK) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        return this.ndx == other.ndx;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.gameId ^ (this.gameId >>> 32));
        hash = 41 * hash + this.ndx;
        return hash;
    }

    @Override
    public String toString() {
        return "org.igo.entities.GamesDatesPK[ gameId=" + gameId + ", ndx=" + ndx + " ]";
    }

}
