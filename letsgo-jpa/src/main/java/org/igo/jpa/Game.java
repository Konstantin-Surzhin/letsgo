/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pl
 */
@Entity
@Table(name = "games", schema = "letsgo")
@XmlRootElement
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private GameStatus gameStatus;
    private GameSize gameSize;
    private GameType gameType;
    private Short gameTime;
    private Byte gameGandicap;
    private Byte gameBayomeeNumber;
    private Byte gameBayomeeTime;

    private Collection<GameDate> gameDates;

    private Collection<UserGame> userGames;

    private Collection<GameMove> gameMoves;

    private List<GameComment> comments;

    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @TableGenerator(name = "game_gen", table = "id_gen",
            pkColumnName = "gen_name", valueColumnName = "gen_val")
    @GeneratedValue(generator = "game_gen")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "jpa.Game[ id=" + id + " ]";
    }

    /**
     * @return the gameStatus
     */
    @Column(name = "game_status", nullable = false)
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    /**
     * @param gameStatus the gameStatus to set
     */
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    /**
     * @return the gameSize
     */
    @Column(name = "game_size", nullable = false)
    public GameSize getGameSize() {
        return gameSize;
    }

    /**
     * @param gameSize the gameSize to set
     */
    public void setGameSize(GameSize gameSize) {
        this.gameSize = gameSize;
    }

    /**
     * @return the gameType
     */
    @Column(name = "game_type", nullable = false)
    public GameType getGameType() {
        return gameType;
    }

    /**
     * @param gameType the gameType to set
     */
    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game", fetch = FetchType.LAZY)
    public Collection<UserGame> getUserGames() {
        return userGames;
    }

    public void setUserGames(Collection<UserGame> userGames) {
        this.userGames = userGames;
    }

    /**
     * @return the gameMoves
     */
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game", fetch = FetchType.LAZY)
    public Collection<GameMove> getGameMoves() {
        return gameMoves;
    }

    /**
     * @param gameMoves the gameMoves to set
     */
    public void setGameMoves(Collection<GameMove> gameMoves) {
        this.gameMoves = gameMoves;
    }

    /**
     * @return the comments
     */
    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    public List<GameComment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<GameComment> comments) {
        this.comments = comments;
    }

    /**
     * @return the gameTime
     */
    @Column(name = "game_time")
    public Short getGameTime() {
        return gameTime;
    }

    /**
     * @param gameTime the gameTime to set
     */
    public void setGameTime(Short gameTime) {
        this.gameTime = gameTime;
    }

    /**
     * @return the gameGandicap
     */
    @Column(name = "gandicap")
    public Byte getGameGandicap() {
        return gameGandicap;
    }

    /**
     * @param gameGandicap the gameGandicap to set
     */
    public void setGameGandicap(Byte gameGandicap) {
        this.gameGandicap = gameGandicap;
    }

    /**
     * @return the gameBayomeeNumber
     */
    @Column(name = "bayomee_number")
    public Byte getGameBayomeeNumber() {
        return gameBayomeeNumber;
    }

    /**
     * @param gameBayomeeNumber the gameBayomeeNumber to set
     */
    public void setGameBayomeeNumber(Byte gameBayomeeNumber) {
        this.gameBayomeeNumber = gameBayomeeNumber;
    }

    /**
     * @return the gameBayomeeTime
     */
    @Column(name = "bayomee_time")
    public Byte getGameBayomeeTime() {
        return gameBayomeeTime;
    }

    /**
     * @param gameBayomeeTime the gameBayomeeTime to set
     */
    public void setGameBayomeeTime(Byte gameBayomeeTime) {
        this.gameBayomeeTime = gameBayomeeTime;
    }

    /**
     * @return the gameDates
     */
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game", fetch = FetchType.LAZY)
    public Collection<GameDate> getGameDates() {
        return gameDates;
    }

    public void setGameDates(Collection<GameDate> gameDates) {
        this.gameDates = gameDates;
    }
}
