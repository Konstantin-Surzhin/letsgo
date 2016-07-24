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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kostya surzhin
 */
@XmlRootElement
@Entity
@Table(name = "game_dates", catalog = "letsgo", schema = "",
        uniqueConstraints = @UniqueConstraint(columnNames = {"game_date", "game_id"}))
@NamedQueries({
    @NamedQuery(name = "GameDate.findAll", query = "SELECT g FROM GameDate g"),
    @NamedQuery(name = "GameDate.findByGameId", query = "SELECT g FROM GameDate g WHERE g.gameDatePK.gameId = :gameId"),
    @NamedQuery(name = "GameDate.findByGameDate", query = "SELECT g FROM GameDate g WHERE g.gameDate = :gameDate"),
    @NamedQuery(name = "GameDate.findByNdx", query = "SELECT g FROM GameDate g WHERE g.gameDatePK.ndx = :ndx")})
public class GameDate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    protected GameDatePK gameDatePK;
    private Date gameDate;
    private Game game;

    /**
     *
     */
    public GameDate() {
    }

    /**
     *
     * @param gameDatesPK
     */
    public GameDate(GameDatePK gameDatesPK) {
        this.gameDatePK = gameDatesPK;
    }

    /**
     *
     * @param gameId
     * @param ndx
     */
    public GameDate(long gameId, int ndx) {
        this.gameDatePK = new GameDatePK(gameId, ndx);
    }

    /**
     *
     * @return
     */
    @EmbeddedId
    public GameDatePK getGameDatePK() {
        return gameDatePK;
    }

    /**
     *
     * @param gameDatePK
     */
    public void setGameDatePK(GameDatePK gameDatePK) {
        this.gameDatePK = gameDatePK;
    }

    /**
     *
     * @return
     */
    @Column(name = "game_date", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getGameDate() {
        return gameDate;
    }

    /**
     *
     * @param gameDate
     */
    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    /**
     *
     * @return
     */
    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public Game getGame() {
        return game;
    }

    /**
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameDatePK != null ? gameDatePK.hashCode() : 0);
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
        if (!(object instanceof GameDate)) {
            return false;
        }
        GameDate other = (GameDate) object;
        return !((this.gameDatePK == null && other.gameDatePK != null) || (this.gameDatePK != null && !this.gameDatePK.equals(other.gameDatePK)));
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "jpa2.GameDates[ gameDatesPK=" + gameDatePK + " ]";
    }

}
