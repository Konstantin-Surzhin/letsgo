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

/**
 *
 * @author surzhin.konstantin
 */
@Embeddable
public class GameMovePK implements Serializable {

    private long gameId;
    private int ndx;

    public GameMovePK() {
    }

    public GameMovePK(long gameId, int ndx) {
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
    @Column(nullable = false)
    public int getNdx() {
        return ndx;
    }

    public void setNdx(int ndx) {
        this.ndx = ndx;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.gameId ^ (this.gameId >>> 32));
        hash = 97 * hash + this.ndx;
        return hash;
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
        final GameMovePK other = (GameMovePK) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        return this.ndx == other.ndx;
    }

    @Override
    public String toString() {
        return "org.igo.entities.GamesMovesPK[ gameId=" + gameId + ", ndx=" + ndx + " ]";
    }
    
}
