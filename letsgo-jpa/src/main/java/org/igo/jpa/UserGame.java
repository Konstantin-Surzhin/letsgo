/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

import java.io.Serializable;
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
 * @author pl
 */
@Entity
@Table(name = "user_game", catalog = "letsgo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserGame.findAll", query = "SELECT u FROM UserGame u"),
    @NamedQuery(name = "UserGame.findByUserId", query = "SELECT u FROM UserGame u WHERE u.userGamePK.userId = :userId"),
    @NamedQuery(name = "UserGame.findByGameId", query = "SELECT u FROM UserGame u WHERE u.userGamePK.gameId = :gameId"),
    @NamedQuery(name = "UserGame.findByColor", query = "SELECT u FROM UserGame u WHERE u.color = :color")})
public class UserGame implements Serializable {

    private static final long serialVersionUID = 1L;
    protected UserGamePK userGamePK;
    private UserColor color;
    private Game game;
    private User user;

    public UserGame() {
    }

    public UserGame(UserGamePK userGamePK) {
        this.userGamePK = userGamePK;
    }

    public UserGame(int userId, long gameId) {
        this.userGamePK = new UserGamePK(userId, gameId);
    }

    @EmbeddedId
    public UserGamePK getUserGamePK() {
        return userGamePK;
    }

    public void setUserGamePK(UserGamePK userGamePK) {
        this.userGamePK = userGamePK;
    }

    @Column(name = "color", nullable = false)
    public UserColor getColor() {
        return color;
    }

    public void setColor(UserColor color) {
        this.color = color;
    }

    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "jpa2.UserGame[ userGamePK=" + userGamePK + " ]";
    }

}
