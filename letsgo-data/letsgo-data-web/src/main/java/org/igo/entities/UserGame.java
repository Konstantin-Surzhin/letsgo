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
package org.igo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kostya surzhin
 */
@XmlRootElement
@Entity
@Table(name = "users_games")
@NamedQueries({
    @NamedQuery(name = "UserGame.findAll", query = "SELECT u FROM UserGame u"),
    @NamedQuery(name = "UserGame.findByUserId", query = "SELECT u FROM UserGame u WHERE u.userGamePK.userId = :userId"),
    @NamedQuery(name = "UserGame.findByGameId", query = "SELECT u FROM UserGame u WHERE u.userGamePK.gameId = :gameId"),
    @NamedQuery(name = "UserGame.findByColor", query = "SELECT u FROM UserGame u WHERE u.color = :color")})
public class UserGame implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    protected UserGamePK userGamePK;
    private UserColor color;
    private Game game;
    private User user;

    /**
     *
     */
    public UserGame() {
    }

    /**
     *
     * @param userGamePK
     */
    public UserGame(UserGamePK userGamePK) {
        this.userGamePK = userGamePK;
    }

    /**
     *
     * @param userId
     * @param gameId
     */
    public UserGame(int userId, long gameId) {
        this.userGamePK = new UserGamePK(userId, gameId);
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
    @Enumerated
    @Column(name = "color", nullable = false)
    public UserColor getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(UserColor color) {
        this.color = color;
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
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGamePK != null ? userGamePK.hashCode() : 0);
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
        if (!(object instanceof UserGame)) {
            return false;
        }
        UserGame other = (UserGame) object;
        return !((this.userGamePK == null && other.userGamePK != null) || (this.userGamePK != null && !this.userGamePK.equals(other.userGamePK)));
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "jpa2.UserGame[ userGamePK=" + userGamePK + " ]";
    }

}
