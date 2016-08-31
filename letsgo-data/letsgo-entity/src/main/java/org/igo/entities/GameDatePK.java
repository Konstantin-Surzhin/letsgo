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
public class GameDatePK implements Serializable {


    private long gameId;
    private int ndx;

    public GameDatePK() {
    }

    public GameDatePK(long gameId, int ndx) {
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
        int hash = 0;
        hash += (int) gameId;
        hash += (int) ndx;
        return hash;
    }

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

    @Override
    public String toString() {
        return "org.igo.entities.GamesDatesPK[ gameId=" + gameId + ", ndx=" + ndx + " ]";
    }
    
}
