/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author pl
 */
@Embeddable
public class UserGamePK implements Serializable {

    private int userId;

    private long gameId;

    public UserGamePK() {
    }

    public UserGamePK(int userId, long gameId) {
        this.userId = userId;
        this.gameId = gameId;
    }

    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic(optional = false)
    @Column(name = "game_id", nullable = false)
    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) gameId;
        return hash;
    }

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

    @Override
    public String toString() {
        return "jpa2.UserGamePK[ userId=" + userId + ", gameId=" + gameId + " ]";
    }

}
