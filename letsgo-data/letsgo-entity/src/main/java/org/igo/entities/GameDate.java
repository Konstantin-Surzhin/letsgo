/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "games_dates", catalog = "letsgo", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"game_date", "game_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameDate.findAll", query = "SELECT g FROM GameDate g"),
    @NamedQuery(name = "GameDate.findByGameId", query = "SELECT g FROM GameDate g WHERE g.gameDatePK.gameId = :gameId"),
    @NamedQuery(name = "GameDate.findByNdx", query = "SELECT g FROM GameDate g WHERE g.gameDatePK.ndx = :ndx"),
    @NamedQuery(name = "GameDate.findByGameDate", query = "SELECT g FROM GameDate g WHERE g.gameDate = :gameDate")})
public class GameDate implements Serializable {

    private static final long serialVersionUID = 1L;
    protected GameDatePK gameDatePK;
    private Date gameDate;
    private Game games;

    public GameDate() {
    }

    public GameDate(GameDatePK gamesDatesPK) {
        this.gameDatePK = gamesDatesPK;
    }

    public GameDate(GameDatePK gamesDatesPK, Date gameDate) {
        this.gameDatePK = gamesDatesPK;
        this.gameDate = gameDate;
    }

    public GameDate(long gameId, int ndx) {
        this.gameDatePK = new GameDatePK(gameId, ndx);
    }

    @EmbeddedId
    public GameDatePK getGameDatePK() {
        return gameDatePK;
    }

    public void setGameDatePK(GameDatePK gameDatePK) {
        this.gameDatePK = gameDatePK;
    }

    @Basic(optional = false)
    @Column(name = "game_date", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public Game getGames() {
        return games;
    }

    public void setGames(Game games) {
        this.games = games;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameDatePK != null ? gameDatePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameDate)) {
            return false;
        }
        GameDate other = (GameDate) object;
        return !((this.gameDatePK == null && other.gameDatePK != null) || (this.gameDatePK != null && !this.gameDatePK.equals(other.gameDatePK)));
    }

    @Override
    public String toString() {
        return "org.igo.entities.GamesDates[ gamesDatesPK=" + gameDatePK + " ]";
    }

}
