/*
 * Copyright (C) 2016 kostya surzhin
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
 * @author kostya surzhin
 */
@XmlRootElement
@Entity
@Table(name = "game_moves")
@NamedQueries({
    @NamedQuery(name = "GameMove.findAll", query = "SELECT g FROM GameMove g"),
    @NamedQuery(name = "GameMove.findByX", query = "SELECT g FROM GameMove g WHERE g.x = :x"),
    @NamedQuery(name = "GameMove.findByY", query = "SELECT g FROM GameMove g WHERE g.y = :y"),
    @NamedQuery(name = "GameMove.findByGameId", query = "SELECT g FROM GameMove g WHERE g.gameMovesPK.gameId = :gameId"),
    @NamedQuery(name = "GameMove.findByNdx", query = "SELECT g FROM GameMove g WHERE g.gameMovesPK.ndx = :ndx")})
public class GameMove implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    protected GameMovesPK gameMovesPK;
    private Character x;
    private Character y;
    private Game game;
    private List<MoveComment> comments;

    /**
     *
     */
    public GameMove() {
    }

    /**
     *
     * @param gameMovesPK
     */
    public GameMove(GameMovesPK gameMovesPK) {
        this.gameMovesPK = gameMovesPK;
    }

    /**
     *
     * @param gameId
     * @param ndx
     */
    public GameMove(long gameId, int ndx) {
        this.gameMovesPK = new GameMovesPK(gameId, ndx);
    }

    /**
     *
     * @return
     */
    @EmbeddedId
    public GameMovesPK getGameMovesPK() {
        return gameMovesPK;
    }

    /**
     *
     * @param gameMovesPK
     */
    public void setGameMovesPK(GameMovesPK gameMovesPK) {
        this.gameMovesPK = gameMovesPK;
    }

    /**
     *
     * @return
     */
    @Column(name = "x", nullable = false)
    public Character getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(Character x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    @Column(name = "y", nullable = false)
    public Character getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(Character y) {
        this.y = y;
    }

    /**
     *
     * @return
     */
    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public Game getGame() {
        return game;
    }

    /**
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameMovesPK != null ? gameMovesPK.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameMove)) {
            return false;
        }
        GameMove other = (GameMove) object;
        return !((this.gameMovesPK == null && other.gameMovesPK != null) || (this.gameMovesPK != null && !this.gameMovesPK.equals(other.gameMovesPK)));
    }

    /**
     *
     * @return
     */
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
