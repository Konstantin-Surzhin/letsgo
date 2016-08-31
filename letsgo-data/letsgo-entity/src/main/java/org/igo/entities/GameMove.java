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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "games_moves")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameMove.findAll", query = "SELECT g FROM GameMove g"),
    @NamedQuery(name = "GameMove.findByGameId", query = "SELECT g FROM GameMove g WHERE g.gameMovePK.gameId = :gameId"),
    @NamedQuery(name = "GameMove.findByNdx", query = "SELECT g FROM GameMove g WHERE g.gameMovePK.ndx = :ndx"),
    @NamedQuery(name = "GameMove.findByX", query = "SELECT g FROM GameMove g WHERE g.x = :x"),
    @NamedQuery(name = "GameMove.findByY", query = "SELECT g FROM GameMove g WHERE g.y = :y")})
public class GameMove implements Serializable {

    private static final long serialVersionUID = 1L;
    protected GameMovePK gameMovePK;
    private Character x;
     private Character y;
    private Collection<MoveComment> movesCommentsCollection;
    private Game games;

    public GameMove() {
    }

    public GameMove(GameMovePK gamesMovesPK) {
        this.gameMovePK = gamesMovesPK;
    }

    public GameMove(GameMovePK gamesMovesPK, Character x, Character y) {
        this.gameMovePK = gamesMovesPK;
        this.x = x;
        this.y = y;
    }

    public GameMove(long gameId, int ndx) {
        this.gameMovePK = new GameMovePK(gameId, ndx);
    }
    @EmbeddedId
    public GameMovePK getGameMovePK() {
        return gameMovePK;
    }

    public void setGameMovePK(GameMovePK gameMovePK) {
        this.gameMovePK = gameMovePK;
    }

    @Basic(optional = false)
    @Column(nullable = false)
    public Character getX() {
        return x;
    }

    public void setX(Character x) {
        this.x = x;
    }

    @Basic(optional = false)
    @Column(nullable = false)
    public Character getY() {
        return y;
    }

    public void setY(Character y) {
        this.y = y;
    }

    @OneToMany(mappedBy = "gamesMoves")
    @XmlTransient
    public Collection<MoveComment> getMovesCommentsCollection() {
        return movesCommentsCollection;
    }

    public void setMovesCommentsCollection(Collection<MoveComment> movesCommentsCollection) {
        this.movesCommentsCollection = movesCommentsCollection;
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
        hash += (gameMovePK != null ? gameMovePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameMove)) {
            return false;
        }
        GameMove other = (GameMove) object;
        return !((this.gameMovePK == null && other.gameMovePK != null) || (this.gameMovePK != null && !this.gameMovePK.equals(other.gameMovePK)));
    }

    @Override
    public String toString() {
        return "org.igo.entities.GamesMoves[ gamesMovesPK=" + gameMovePK + " ]";
    }
    
}
