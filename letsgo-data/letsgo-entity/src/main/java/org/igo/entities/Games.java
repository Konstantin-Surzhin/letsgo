/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(catalog = "letsgo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Games.findAll", query = "SELECT g FROM Games g"),
    @NamedQuery(name = "Games.findById", query = "SELECT g FROM Games g WHERE g.id = :id"),
    @NamedQuery(name = "Games.findByBayomeeNumber", query = "SELECT g FROM Games g WHERE g.bayomeeNumber = :bayomeeNumber"),
    @NamedQuery(name = "Games.findByBayomeeTime", query = "SELECT g FROM Games g WHERE g.bayomeeTime = :bayomeeTime"),
    @NamedQuery(name = "Games.findByGandicap", query = "SELECT g FROM Games g WHERE g.gandicap = :gandicap"),
    @NamedQuery(name = "Games.findByGameSize", query = "SELECT g FROM Games g WHERE g.gameSize = :gameSize"),
    @NamedQuery(name = "Games.findByGameStatus", query = "SELECT g FROM Games g WHERE g.gameStatus = :gameStatus"),
    @NamedQuery(name = "Games.findByGameTime", query = "SELECT g FROM Games g WHERE g.gameTime = :gameTime"),
    @NamedQuery(name = "Games.findByGameType", query = "SELECT g FROM Games g WHERE g.gameType = :gameType")})
public class Games implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Column(name = "bayomee_number")
    private Short bayomeeNumber;
    @Column(name = "bayomee_time")
    private Short bayomeeTime;
    private Short gandicap;
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_size", nullable = false)
    private int gameSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_status", nullable = false)
    private int gameStatus;
    @Column(name = "game_time")
    private Short gameTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "game_type", nullable = false)
    private int gameType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    private Collection<UsersGames> usersGamesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameId")
    private Collection<GamesComments> gamesCommentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    private Collection<GamesMoves> gamesMovesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    private Collection<GamesDates> gamesDatesCollection;
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    @ManyToOne
    private Events eventId;

    public Games() {
    }

    public Games(Long id) {
        this.id = id;
    }

    public Games(Long id, int gameSize, int gameStatus, int gameType) {
        this.id = id;
        this.gameSize = gameSize;
        this.gameStatus = gameStatus;
        this.gameType = gameType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getBayomeeNumber() {
        return bayomeeNumber;
    }

    public void setBayomeeNumber(Short bayomeeNumber) {
        this.bayomeeNumber = bayomeeNumber;
    }

    public Short getBayomeeTime() {
        return bayomeeTime;
    }

    public void setBayomeeTime(Short bayomeeTime) {
        this.bayomeeTime = bayomeeTime;
    }

    public Short getGandicap() {
        return gandicap;
    }

    public void setGandicap(Short gandicap) {
        this.gandicap = gandicap;
    }

    public int getGameSize() {
        return gameSize;
    }

    public void setGameSize(int gameSize) {
        this.gameSize = gameSize;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Short getGameTime() {
        return gameTime;
    }

    public void setGameTime(Short gameTime) {
        this.gameTime = gameTime;
    }

    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    @XmlTransient
    public Collection<UsersGames> getUsersGamesCollection() {
        return usersGamesCollection;
    }

    public void setUsersGamesCollection(Collection<UsersGames> usersGamesCollection) {
        this.usersGamesCollection = usersGamesCollection;
    }

    @XmlTransient
    public Collection<GamesComments> getGamesCommentsCollection() {
        return gamesCommentsCollection;
    }

    public void setGamesCommentsCollection(Collection<GamesComments> gamesCommentsCollection) {
        this.gamesCommentsCollection = gamesCommentsCollection;
    }

    @XmlTransient
    public Collection<GamesMoves> getGamesMovesCollection() {
        return gamesMovesCollection;
    }

    public void setGamesMovesCollection(Collection<GamesMoves> gamesMovesCollection) {
        this.gamesMovesCollection = gamesMovesCollection;
    }

    @XmlTransient
    public Collection<GamesDates> getGamesDatesCollection() {
        return gamesDatesCollection;
    }

    public void setGamesDatesCollection(Collection<GamesDates> gamesDatesCollection) {
        this.gamesDatesCollection = gamesDatesCollection;
    }

    public Events getEventId() {
        return eventId;
    }

    public void setEventId(Events eventId) {
        this.eventId = eventId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Games)) {
            return false;
        }
        Games other = (Games) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.igo.entities.Games[ id=" + id + " ]";
    }
    
}
