/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author surzhin.konstantin
 */
@Embeddable
public class UsersGamesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "game_id", nullable = false)
    private long gameId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id", nullable = false)
    private int userId;

    public UsersGamesPK() {
    }

    public UsersGamesPK(long gameId, int userId) {
        this.gameId = gameId;
        this.userId = userId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) gameId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersGamesPK)) {
            return false;
        }
        UsersGamesPK other = (UsersGamesPK) object;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.igo.entities.UsersGamesPK[ gameId=" + gameId + ", userId=" + userId + " ]";
    }
    
}
