/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pl
 */
@XmlRootElement
@Entity
@Table(name = "game_moves", catalog = "letsgo", schema = "")
@NamedQueries({
    @NamedQuery(name = "GameMove.findAll", query = "SELECT g FROM GameMove g"),
    @NamedQuery(name = "GameMove.findByX", query = "SELECT g FROM GameMove g WHERE g.x = :x"),
    @NamedQuery(name = "GameMove.findByY", query = "SELECT g FROM GameMove g WHERE g.y = :y"),
    @NamedQuery(name = "GameMove.findByGameId", query = "SELECT g FROM GameMove g WHERE g.gameMovesPK.gameId = :gameId"),
    @NamedQuery(name = "GameMove.findByNdx", query = "SELECT g FROM GameMove g WHERE g.gameMovesPK.ndx = :ndx")})
public class GameMove implements Serializable {

    private static final long serialVersionUID = 1L;
    protected GameMovesPK gameMovesPK;
    private Character x;
    private Character y;
    private Game game;
    private List<MoveComment> comments;

    public GameMove() {
    }

    public GameMove(GameMovesPK gameMovesPK) {
        this.gameMovesPK = gameMovesPK;
    }

    public GameMove(long gameId, int ndx) {
        this.gameMovesPK = new GameMovesPK(gameId, ndx);
    }

    @EmbeddedId
    public GameMovesPK getGameMovesPK() {
        return gameMovesPK;
    }

    public void setGameMovesPK(GameMovesPK gameMovesPK) {
        this.gameMovesPK = gameMovesPK;
    }

    @Column(name = "x",nullable = false)
    public Character getX() {
        return x;
    }

    public void setX(Character x) {
        this.x = x;
    }

    @Column(name = "y",nullable = false)
    public Character getY() {
        return y;
    }

    public void setY(Character y) {
        this.y = y;
    }

    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameMovesPK != null ? gameMovesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameMove)) {
            return false;
        }
        GameMove other = (GameMove) object;
        return !((this.gameMovesPK == null && other.gameMovesPK != null) || (this.gameMovesPK != null && !this.gameMovesPK.equals(other.gameMovesPK)));
    }

    @Override
    public String toString() {
        return "jpa2.GameMoves[ gameMovesPK=" + gameMovesPK + " ]";
    }

    /**
     * @return the comments
     */
    @OneToMany(mappedBy = "move", fetch = FetchType.LAZY)
    public List<MoveComment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<MoveComment> comments) {
        this.comments = comments;
    }

}
