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

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kostya surzhin
 */
@Embeddable
public class GameDatePK implements Serializable {

    private long gameId;
    private int ndx;

    /**
     *
     */
    public GameDatePK() {
    }

    /**
     *
     * @param gameId
     * @param ndx
     */
    public GameDatePK(long gameId, int ndx) {
        this.gameId = gameId;
        this.ndx = ndx;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "game_id", nullable = false)
    public long getGameId() {
        return gameId;
    }

    /**
     *
     * @param gameId
     */
    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "ndx", nullable = false)
    public int getNdx() {
        return ndx;
    }

    /**
     *
     * @param ndx
     */
    public void setNdx(int ndx) {
        this.ndx = ndx;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) gameId;
        hash += (int) ndx;
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameDatePK)) {
            return false;
        }
        GameDatePK other = (GameDatePK) object;
        if (this.gameId != other.gameId) {
            return false;
        }
        return this.ndx == other.ndx;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "jpa2.GameDatesPK[ gameId=" + gameId + ", ndx=" + ndx + " ]";
    }

}
