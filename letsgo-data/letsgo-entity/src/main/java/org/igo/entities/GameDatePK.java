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
