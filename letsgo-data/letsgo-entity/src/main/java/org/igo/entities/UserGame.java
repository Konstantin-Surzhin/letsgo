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
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "USER_GAMES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserGame.findAll", query = "SELECT u FROM UserGame u")
    ,@NamedQuery(name = "UserGame.findByGameId", query = "SELECT u FROM UserGame u WHERE u.userGamePK.gameId = :gameId")
    ,@NamedQuery(name = "UserGame.findByUserId", query = "SELECT u FROM UserGame u WHERE u.userGamePK.userId = :userId")
    ,@NamedQuery(name = "UserGame.findByColor", query = "SELECT u FROM UserGame u WHERE u.color = :color")})
public class UserGame implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    protected UserGamePK userGamePK;
    private int color;
    private Game games;
    private GoUser goUser;

    /**
     *
     */
    public UserGame() {
    }

    /**
     *
     * @param usersGamesPK
     */
    public UserGame(UserGamePK usersGamesPK) {
        this.userGamePK = usersGamesPK;
    }

    /**
     *
     * @param usersGamesPK
     * @param color
     */
    public UserGame(UserGamePK usersGamesPK, int color) {
        this.userGamePK = usersGamesPK;
        this.color = color;
    }

    /**
     *
     * @param gameId
     * @param userId
     */
    public UserGame(long gameId, int userId) {
        this.userGamePK = new UserGamePK(gameId, userId);
    }

    /**
     *
     * @return
     */
    @EmbeddedId
    public UserGamePK getUserGamePK() {
        return userGamePK;
    }

    /**
     *
     * @param userGamePK
     */
    public void setUserGamePK(UserGamePK userGamePK) {
        this.userGamePK = userGamePK;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(nullable = false)
    public int getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     *
     * @return
     */
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_game"), name = "game_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public Game getGames() {
        return games;
    }

    /**
     *
     * @param games
     */
    public void setGames(Game games) {
        this.games = games;
    }

    /**
     *
     * @return
     */
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_userGame_goUser"),name = "user_details_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public GoUser getGoUser() {
        return goUser;
    }

    /**
     *
     * @param goUser
     */
    public void setGoUser(GoUser goUser) {
        this.goUser = goUser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.userGamePK);
        hash = 83 * hash + this.color;
        hash = 83 * hash + Objects.hashCode(this.games);
        hash = 83 * hash + Objects.hashCode(this.goUser);
        return hash;
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
        final UserGame other = (UserGame) obj;
        return Objects.equals(this.userGamePK, other.userGamePK);
    }

    @Override
    public String toString() {
        return "org.igo.entities.UsersGames[ usersGamesPK=" + userGamePK + " ]";
    }

}
