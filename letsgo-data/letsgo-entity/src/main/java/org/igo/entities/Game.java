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

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "GAMES")
@NamedQueries({
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g"),
    @NamedQuery(name = "Game.findById", query = "SELECT g FROM Game g WHERE g.id = :id"),
    @NamedQuery(name = "Game.findByBayomeeNumber", query = "SELECT g FROM Game g WHERE g.bayomeeNumber = :bayomeeNumber"),
    @NamedQuery(name = "Game.findByByoYomiTime", query = "SELECT g FROM Game g WHERE g.byoYomiTime = :byoYomiTime"),
    @NamedQuery(name = "Game.findByGandicap", query = "SELECT g FROM Game g WHERE g.gandicap = :gandicap"),
    @NamedQuery(name = "Game.findByGameSize", query = "SELECT g FROM Game g WHERE g.gameSize = :gameSize"),
    @NamedQuery(name = "Game.findByGameStatus", query = "SELECT g FROM Game g WHERE g.gameStatus = :gameStatus"),
    @NamedQuery(name = "Game.findByGameTime", query = "SELECT g FROM Game g WHERE g.gameTime = :gameTime"),
    @NamedQuery(name = "Game.findByGameType", query = "SELECT g FROM Game g WHERE g.gameType = :gameType")})
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private short bayomeeNumber;
    private short byoYomiTime;
    private short gandicap;
    private short gameSize;
    private GameStatus gameStatus;
    private short gameTime;
    private GameType gameType;
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

    public Game(Long id, short gameSize, GameStatus gameStatus, GameType gameType) {
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
    public short getBayomeeNumber() {
        return bayomeeNumber;
    }

    public void setBayomeeNumber(short bayomeeNumber) {
        this.bayomeeNumber = bayomeeNumber;
    }

    @Column(name = "byo_yomi_time")
    public short getByoYomiTime() {
        return byoYomiTime;
    }

    public void setByoYomiTime(short byoYomiTime) {
        this.byoYomiTime = byoYomiTime;
    }

    public short getGandicap() {
        return gandicap;
    }

    public void setGandicap(short gandicap) {
        this.gandicap = gandicap;
    }

    @Basic(optional = false)
    @Column(name = "game_size", nullable = false)
    public short getGameSize() {
        return gameSize;
    }

    public void setGameSize(short gameSize) {
        this.gameSize = gameSize;
    }

    @Basic(optional = false)
    @JoinColumn(name = "game_status_id", referencedColumnName = "id")
    @ManyToOne
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Column(name = "game_time",nullable = false)
    public short getGameTime() {
        return gameTime;
    }

    public void setGameTime(short gameTime) {
        this.gameTime = gameTime;
    }

    @Basic(optional = false)
   // @Column(name = "game_type", nullable = false)
    @JoinColumn(name = "game_type_id", referencedColumnName = "id")
    @ManyToOne
    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    public Collection<UserGame> getUsersGamesCollection() {
        return usersGamesCollection;
    }

    public void setUsersGamesCollection(Collection<UserGame> usersGamesCollection) {
        this.usersGamesCollection = usersGamesCollection;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    public Collection<GameComment> getGamesCommentsCollection() {
        return gamesCommentsCollection;
    }

    public void setGamesCommentsCollection(Collection<GameComment> gamesCommentsCollection) {
        this.gamesCommentsCollection = gamesCommentsCollection;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    public Collection<GameMove> getGamesMovesCollection() {
        return gamesMovesCollection;
    }

    public void setGamesMovesCollection(Collection<GameMove> gamesMovesCollection) {
        this.gamesMovesCollection = gamesMovesCollection;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
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
