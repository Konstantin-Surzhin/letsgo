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
public class UserGamePK implements Serializable {

    private static final long serialVersionUID = 3519446188121448911L;

    private long gameId;
    private int userId;

    /**
     *
     */
    public UserGamePK() {
    }

    /**
     *
     * @param gameId
     * @param userId
     */
    public UserGamePK(long gameId, int userId) {
        this.gameId = gameId;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserGamePK other = (UserGamePK) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        return this.userId == other.userId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (this.gameId ^ (this.gameId >>> 32));
        hash = 29 * hash + this.userId;
        return hash;
    }

    @Override
    public String toString() {
        return "org.igo.entities.UsersGamesPK[ gameId=" + gameId + ", userId=" + userId + " ]";
    }
    
}
