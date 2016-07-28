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
public class UserGamePK implements Serializable {

    private int userId;

    private long gameId;

    /**
     *
     */
    public UserGamePK() {
    }

    /**
     *
     * @param userId
     * @param gameId
     */
    public UserGamePK(int userId, long gameId) {
        this.userId = userId;
        this.gameId = gameId;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
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
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) gameId;
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
        if (!(object instanceof UserGamePK)) {
            return false;
        }
        UserGamePK other = (UserGamePK) object;
        if (this.userId != other.userId) {
            return false;
        }
        return this.gameId == other.gameId;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "jpa2.UserGamePK[ userId=" + userId + ", gameId=" + gameId + " ]";
    }

}
