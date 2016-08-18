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
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "GamesDates.findAll", query = "SELECT g FROM GamesDates g"),
    @NamedQuery(name = "GamesDates.findByGameId", query = "SELECT g FROM GamesDates g WHERE g.gamesDatesPK.gameId = :gameId"),
    @NamedQuery(name = "GamesDates.findByNdx", query = "SELECT g FROM GamesDates g WHERE g.gamesDatesPK.ndx = :ndx"),
    @NamedQuery(name = "GamesDates.findByGameDate", query = "SELECT g FROM GamesDates g WHERE g.gameDate = :gameDate")})
public class GamesDates implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GamesDatesPK gamesDatesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date gameDate;
    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Games games;

    public GamesDates() {
    }

    public GamesDates(GamesDatesPK gamesDatesPK) {
        this.gamesDatesPK = gamesDatesPK;
    }

    public GamesDates(GamesDatesPK gamesDatesPK, Date gameDate) {
        this.gamesDatesPK = gamesDatesPK;
        this.gameDate = gameDate;
    }

    public GamesDates(long gameId, int ndx) {
        this.gamesDatesPK = new GamesDatesPK(gameId, ndx);
    }

    public GamesDatesPK getGamesDatesPK() {
        return gamesDatesPK;
    }

    public void setGamesDatesPK(GamesDatesPK gamesDatesPK) {
        this.gamesDatesPK = gamesDatesPK;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gamesDatesPK != null ? gamesDatesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GamesDates)) {
            return false;
        }
        GamesDates other = (GamesDates) object;
        if ((this.gamesDatesPK == null && other.gamesDatesPK != null) || (this.gamesDatesPK != null && !this.gamesDatesPK.equals(other.gamesDatesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.igo.entities.GamesDates[ gamesDatesPK=" + gamesDatesPK + " ]";
    }
    
}
