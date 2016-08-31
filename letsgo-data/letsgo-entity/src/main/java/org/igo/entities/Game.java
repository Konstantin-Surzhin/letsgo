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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "games", catalog = "letsgo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
    @NamedQuery(name = "Game.findById", query = "SELECT g FROM Game g WHERE g.id = :id"),
    @NamedQuery(name = "Game.findByBayomeeNumber", query = "SELECT g FROM Game g WHERE g.bayomeeNumber = :bayomeeNumber"),
    @NamedQuery(name = "Game.findByBayomeeTime", query = "SELECT g FROM Game g WHERE g.bayomeeTime = :bayomeeTime"),
    @NamedQuery(name = "Game.findByGandicap", query = "SELECT g FROM Game g WHERE g.gandicap = :gandicap"),
    @NamedQuery(name = "Game.findByGameSize", query = "SELECT g FROM Game g WHERE g.gameSize = :gameSize"),
    @NamedQuery(name = "Game.findByGameStatus", query = "SELECT g FROM Game g WHERE g.gameStatus = :gameStatus"),
    @NamedQuery(name = "Game.findByGameTime", query = "SELECT g FROM Game g WHERE g.gameTime = :gameTime"),
    @NamedQuery(name = "Game.findByGameType", query = "SELECT g FROM Game g WHERE g.gameType = :gameType")})
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Short bayomeeNumber;
    private Short bayomeeTime;
    private Short gandicap;
    private int gameSize;
    private int gameStatus;
    private Short gameTime;
    private int gameType;
    private Collection<UserGame> usersGamesCollection;
    private Collection<GameComment> gamesCommentsCollection;
    private Collection<GameMove> gamesMovesCollection;
    private Collection<GameDate> gamesDatesCollection;
    private Event eventId;

    public Game() {
    }

    public Game(Long id) {
        this.id = id;
    }

    public Game(Long id, int gameSize, int gameStatus, int gameType) {
        this.id = id;
        this.gameSize = gameSize;
        this.gameStatus = gameStatus;
        this.gameType = gameType;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "bayomee_number")
    public Short getBayomeeNumber() {
        return bayomeeNumber;
    }

    public void setBayomeeNumber(Short bayomeeNumber) {
        this.bayomeeNumber = bayomeeNumber;
    }

    @Column(name = "bayomee_time")
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

    @Basic(optional = false)
    @Column(name = "game_size", nullable = false)
    public int getGameSize() {
        return gameSize;
    }

    public void setGameSize(int gameSize) {
        this.gameSize = gameSize;
    }

    @Basic(optional = false)
    @Column(name = "game_status", nullable = false)
    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Column(name = "game_time",nullable = false)
    public Short getGameTime() {
        return gameTime;
    }

    public void setGameTime(Short gameTime) {
        this.gameTime = gameTime;
    }

    @Basic(optional = false)
    @Column(name = "game_type", nullable = false)
    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    @XmlTransient
    public Collection<UserGame> getUsersGamesCollection() {
        return usersGamesCollection;
    }

    public void setUsersGamesCollection(Collection<UserGame> usersGamesCollection) {
        this.usersGamesCollection = usersGamesCollection;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gameId")
    @XmlTransient
    public Collection<GameComment> getGamesCommentsCollection() {
        return gamesCommentsCollection;
    }

    public void setGamesCommentsCollection(Collection<GameComment> gamesCommentsCollection) {
        this.gamesCommentsCollection = gamesCommentsCollection;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    @XmlTransient
    public Collection<GameMove> getGamesMovesCollection() {
        return gamesMovesCollection;
    }

    public void setGamesMovesCollection(Collection<GameMove> gamesMovesCollection) {
        this.gamesMovesCollection = gamesMovesCollection;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    @XmlTransient
    public Collection<GameDate> getGamesDatesCollection() {
        return gamesDatesCollection;
    }

    public void setGamesDatesCollection(Collection<GameDate> gamesDatesCollection) {
        this.gamesDatesCollection = gamesDatesCollection;
    }

    @JoinColumn(name = "event_id", referencedColumnName = "id")
    @ManyToOne
    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
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
        if (!(object instanceof Game)) {
            return false;
        }
        Game other = (Game) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.entities.Games[ id=" + id + " ]";
    }

}
