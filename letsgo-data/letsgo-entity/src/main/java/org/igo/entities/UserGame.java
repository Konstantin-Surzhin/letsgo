/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "UserGame.findAll", query = "SELECT u FROM UserGame u"),
    @NamedQuery(name = "UserGame.findByGameId", query = "SELECT u FROM UserGame u WHERE u.userGamePK.gameId = :gameId"),
    @NamedQuery(name = "UserGame.findByUserId", query = "SELECT u FROM UserGame u WHERE u.userGamePK.userId = :userId"),
    @NamedQuery(name = "UserGame.findByColor", query = "SELECT u FROM UserGame u WHERE u.color = :color")})
public class UserGame implements Serializable {

    private static final long serialVersionUID = 1L;
    protected UserGamePK userGamePK;
    private int color;
    private Game games;
    private User users;

    public UserGame() {
    }

    public UserGame(UserGamePK usersGamesPK) {
        this.userGamePK = usersGamesPK;
    }

    public UserGame(UserGamePK usersGamesPK, int color) {
        this.userGamePK = usersGamesPK;
        this.color = color;
    }

    public UserGame(long gameId, int userId) {
        this.userGamePK = new UserGamePK(gameId, userId);
    }

    @EmbeddedId
    public UserGamePK getUserGamePK() {
        return userGamePK;
    }

    public void setUserGamePK(UserGamePK userGamePK) {
        this.userGamePK = userGamePK;
    }

    @Basic(optional = false)
    @Column(nullable = false)
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public Game getGames() {
        return games;
    }

    public void setGames(Game games) {
        this.games = games;
    }

    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGamePK != null ? userGamePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserGame)) {
            return false;
        }
        UserGame other = (UserGame) object;
        return !((this.userGamePK == null && other.userGamePK != null) || (this.userGamePK != null && !this.userGamePK.equals(other.userGamePK)));
    }

    @Override
    public String toString() {
        return "org.igo.entities.UsersGames[ usersGamesPK=" + userGamePK + " ]";
    }

}
