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
public class GameMovesPK implements Serializable {

    private long gameId;

    private int ndx;

    public GameMovesPK() {
    }

    public GameMovesPK(long gameId, int ndx) {
        this.gameId = gameId;
        this.ndx = ndx;
    }

    @Basic(optional = false)
    @Column(name = "game_id", nullable = false)
    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    @Basic(optional = false)
    @Column(name = "ndx", nullable = false)
    public int getNdx() {
        return ndx;
    }

    public void setNdx(int ndx) {
        this.ndx = ndx;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) gameId;
        hash += (int) ndx;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameMovesPK)) {
            return false;
        }
        GameMovesPK other = (GameMovesPK) object;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.ndx != other.ndx) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa2.GameMovesPK[ gameId=" + gameId + ", ndx=" + ndx + " ]";
    }

}
