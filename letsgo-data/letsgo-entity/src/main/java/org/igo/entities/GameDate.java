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
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "GAME_DATES",  uniqueConstraints = {
    @UniqueConstraint(name = "uk_gameDate_game",columnNames = {"game_date", "game_id"})})
@NamedQueries({
    @NamedQuery(name = "GameDate.findAll", query = "SELECT g FROM GameDate g"),
    @NamedQuery(name = "GameDate.findByGameId", query = "SELECT g FROM GameDate g WHERE g.gameDatePK.gameId = :gameId"),
    @NamedQuery(name = "GameDate.findByNdx", query = "SELECT g FROM GameDate g WHERE g.gameDatePK.ndx = :ndx"),
    @NamedQuery(name = "GameDate.findByGameDate", query = "SELECT g FROM GameDate g WHERE g.gameDate = :gameDate")})
public class GameDate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    protected GameDatePK gameDatePK;
    private Date gameDate = Calendar.getInstance().getTime();
    private Game game;

    /**
     *
     */
    public GameDate() {
    }

    /**
     *
     * @param gamesDatesPK
     */
    public GameDate(GameDatePK gamesDatesPK) {
        this.gameDatePK = gamesDatesPK;
    }

    /**
     *
     * @param gamesDatesPK
     * @param gameDate
     */
    public GameDate(GameDatePK gamesDatesPK, Date gameDate) {
        this.gameDatePK = gamesDatesPK;
        this.gameDate = new Date(gameDate.getTime());
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
    @Basic(optional = false)
    @Column(name = "game_date", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getGameDate() {
        return new Date(gameDate.getTime());
    }

    /**
     *
     * @param gameDate
     */
    public void setGameDate(Date gameDate) {
        this.gameDate = new Date(gameDate.getTime());
    }

    /**
     *
     * @return
     */
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_date_game"), name = "game_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.gameDatePK);
        hash = 23 * hash + Objects.hashCode(this.gameDate);
        hash = 23 * hash + Objects.hashCode(this.game);
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
        final GameDate other = (GameDate) obj;
        if (!Objects.equals(this.gameDatePK, other.gameDatePK)) {
            return false;
        }
        if (!Objects.equals(this.gameDate, other.gameDate)) {
            return false;
        }
        return Objects.equals(this.game, other.game);
    }

    @Override
    public String toString() {
        return "org.igo.entities.GamesDates[ gamesDatesPK=" + gameDatePK + " ]";
    }

}
