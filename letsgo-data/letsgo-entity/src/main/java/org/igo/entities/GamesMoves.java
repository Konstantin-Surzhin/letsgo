/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "games_moves", catalog = "letsgo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GamesMoves.findAll", query = "SELECT g FROM GamesMoves g"),
    @NamedQuery(name = "GamesMoves.findByGameId", query = "SELECT g FROM GamesMoves g WHERE g.gamesMovesPK.gameId = :gameId"),
    @NamedQuery(name = "GamesMoves.findByNdx", query = "SELECT g FROM GamesMoves g WHERE g.gamesMovesPK.ndx = :ndx"),
    @NamedQuery(name = "GamesMoves.findByX", query = "SELECT g FROM GamesMoves g WHERE g.x = :x"),
    @NamedQuery(name = "GamesMoves.findByY", query = "SELECT g FROM GamesMoves g WHERE g.y = :y")})
public class GamesMoves implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GamesMovesPK gamesMovesPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Character x;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Character y;
    @OneToMany(mappedBy = "gamesMoves")
    private Collection<MovesComments> movesCommentsCollection;
    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Games games;

    public GamesMoves() {
    }

    public GamesMoves(GamesMovesPK gamesMovesPK) {
        this.gamesMovesPK = gamesMovesPK;
    }

    public GamesMoves(GamesMovesPK gamesMovesPK, Character x, Character y) {
        this.gamesMovesPK = gamesMovesPK;
        this.x = x;
        this.y = y;
    }

    public GamesMoves(long gameId, int ndx) {
        this.gamesMovesPK = new GamesMovesPK(gameId, ndx);
    }

    public GamesMovesPK getGamesMovesPK() {
        return gamesMovesPK;
    }

    public void setGamesMovesPK(GamesMovesPK gamesMovesPK) {
        this.gamesMovesPK = gamesMovesPK;
    }

    public Character getX() {
        return x;
    }

    public void setX(Character x) {
        this.x = x;
    }

    public Character getY() {
        return y;
    }

    public void setY(Character y) {
        this.y = y;
    }

    @XmlTransient
    public Collection<MovesComments> getMovesCommentsCollection() {
        return movesCommentsCollection;
    }

    public void setMovesCommentsCollection(Collection<MovesComments> movesCommentsCollection) {
        this.movesCommentsCollection = movesCommentsCollection;
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
        hash += (gamesMovesPK != null ? gamesMovesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GamesMoves)) {
            return false;
        }
        GamesMoves other = (GamesMoves) object;
        if ((this.gamesMovesPK == null && other.gamesMovesPK != null) || (this.gamesMovesPK != null && !this.gamesMovesPK.equals(other.gamesMovesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.igo.entities.GamesMoves[ gamesMovesPK=" + gamesMovesPK + " ]";
    }
    
}
