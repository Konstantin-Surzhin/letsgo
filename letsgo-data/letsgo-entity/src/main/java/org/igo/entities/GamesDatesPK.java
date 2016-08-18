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
public class GamesDatesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "game_id", nullable = false)
    private long gameId;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int ndx;

    public GamesDatesPK() {
    }

    public GamesDatesPK(long gameId, int ndx) {
        this.gameId = gameId;
        this.ndx = ndx;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

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
        if (!(object instanceof GamesDatesPK)) {
            return false;
        }
        GamesDatesPK other = (GamesDatesPK) object;
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
        return "org.igo.entities.GamesDatesPK[ gameId=" + gameId + ", ndx=" + ndx + " ]";
    }
    
}
