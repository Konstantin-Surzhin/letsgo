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
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
    @NamedQuery(name = "Game.findAll", query = "SELECT g FROM Game g")
    ,@NamedQuery(name = "Game.findById", query = "SELECT g FROM Game g WHERE g.id = :id")
    ,@NamedQuery(name = "Game.findByBayomeeNumber", query = "SELECT g FROM Game g WHERE g.bayomeeNumber = :bayomeeNumber")
    ,@NamedQuery(name = "Game.findByByoYomiTime", query = "SELECT g FROM Game g WHERE g.byoYomiTime = :byoYomiTime")
    ,@NamedQuery(name = "Game.findByGandicap", query = "SELECT g FROM Game g WHERE g.gandicap = :gandicap")
    ,@NamedQuery(name = "Game.findByGameSize", query = "SELECT g FROM Game g WHERE g.gameSize = :gameSize")
    ,@NamedQuery(name = "Game.findByGameStatus", query = "SELECT g FROM Game g WHERE g.gameStatus = :gameStatus")
    ,@NamedQuery(name = "Game.findByGameTime", query = "SELECT g FROM Game g WHERE g.gameTime = :gameTime")
    ,@NamedQuery(name = "Game.findByGameType", query = "SELECT g FROM Game g WHERE g.gameType = :gameType")})
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
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

    /**
     *
     */
    public Game() {
    }

    /**
     *
     * @param id
     */
    public Game(long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param gameSize
     * @param gameStatus
     * @param gameType
     */
    public Game(long id, short gameSize, GameStatus gameStatus, GameType gameType) {
        this.id = id;
        this.gameSize = gameSize;
        this.gameStatus = gameStatus;
        this.gameType = gameType;
    }

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Column(name = "bayomee_number")
    public short getBayomeeNumber() {
        return bayomeeNumber;
    }

    /**
     *
     * @param bayomeeNumber
     */
    public void setBayomeeNumber(short bayomeeNumber) {
        this.bayomeeNumber = bayomeeNumber;
    }

    /**
     *
     * @return
     */
    @Column(name = "byo_yomi_time")
    public short getByoYomiTime() {
        return byoYomiTime;
    }

    /**
     *
     * @param byoYomiTime
     */
    public void setByoYomiTime(short byoYomiTime) {
        this.byoYomiTime = byoYomiTime;
    }

    /**
     *
     * @return
     */
    public short getGandicap() {
        return gandicap;
    }

    /**
     *
     * @param gandicap
     */
    public void setGandicap(short gandicap) {
        this.gandicap = gandicap;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "game_size", nullable = false)
    public short getGameSize() {
        return gameSize;
    }

    /**
     *
     * @param gameSize
     */
    public void setGameSize(short gameSize) {
        this.gameSize = gameSize;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_game_status"), name = "status_id", referencedColumnName = "id")
    @ManyToOne
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    /**
     *
     * @param gameStatus
     */
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     *
     * @return
     */
    @Column(name = "game_time", nullable = false)
    public short getGameTime() {
        return gameTime;
    }

    /**
     *
     * @param gameTime
     */
    public void setGameTime(short gameTime) {
        this.gameTime = gameTime;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_game_type"), name = "type_id", referencedColumnName = "id")
    @ManyToOne
    public GameType getGameType() {
        return gameType;
    }

    /**
     *
     * @param gameType
     */
    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    public Collection<UserGame> getUsersGamesCollection() {
        return usersGamesCollection;
    }

    /**
     *
     * @param usersGamesCollection
     */
    public void setUsersGamesCollection(Collection<UserGame> usersGamesCollection) {
        this.usersGamesCollection = usersGamesCollection;
    }

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    public Collection<GameComment> getGamesCommentsCollection() {
        return gamesCommentsCollection;
    }

    /**
     *
     * @param gamesCommentsCollection
     */
    public void setGamesCommentsCollection(Collection<GameComment> gamesCommentsCollection) {
        this.gamesCommentsCollection = gamesCommentsCollection;
    }

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "games")
    public Collection<GameMove> getGamesMovesCollection() {
        return gamesMovesCollection;
    }

    /**
     *
     * @param gamesMovesCollection
     */
    public void setGamesMovesCollection(Collection<GameMove> gamesMovesCollection) {
        this.gamesMovesCollection = gamesMovesCollection;
    }

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    public Collection<GameDate> getGamesDatesCollection() {
        return gamesDatesCollection;
    }

    /**
     *
     * @param gamesDatesCollection
     */
    public void setGamesDatesCollection(Collection<GameDate> gamesDatesCollection) {
        this.gamesDatesCollection = gamesDatesCollection;
    }

    /**
     *
     * @return
     */
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_game_event"), name = "event_id", referencedColumnName = "id")
    @ManyToOne
    public Event getEventId() {
        return eventId;
    }

    /**
     *
     * @param eventId
     */
    public void setEventId(Event eventId) {
        this.eventId = eventId;
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
        final Game other = (Game) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + this.bayomeeNumber;
        hash = 79 * hash + this.byoYomiTime;
        hash = 79 * hash + this.gandicap;
        hash = 79 * hash + this.gameSize;
        hash = 79 * hash + Objects.hashCode(this.gameStatus);
        hash = 79 * hash + this.gameTime;
        hash = 79 * hash + Objects.hashCode(this.gameType);
        hash = 79 * hash + Objects.hashCode(this.usersGamesCollection);
        hash = 79 * hash + Objects.hashCode(this.gamesCommentsCollection);
        hash = 79 * hash + Objects.hashCode(this.gamesMovesCollection);
        hash = 79 * hash + Objects.hashCode(this.gamesDatesCollection);
        hash = 79 * hash + Objects.hashCode(this.eventId);
        return hash;
    }

    @Override
    public String toString() {
        return "org.igo.entities.Games[ id=" + id + " ]";
    }

}
