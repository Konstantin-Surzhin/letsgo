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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "users_games", catalog = "letsgo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersGames.findAll", query = "SELECT u FROM UsersGames u"),
    @NamedQuery(name = "UsersGames.findByGameId", query = "SELECT u FROM UsersGames u WHERE u.usersGamesPK.gameId = :gameId"),
    @NamedQuery(name = "UsersGames.findByUserId", query = "SELECT u FROM UsersGames u WHERE u.usersGamesPK.userId = :userId"),
    @NamedQuery(name = "UsersGames.findByColor", query = "SELECT u FROM UsersGames u WHERE u.color = :color")})
public class UsersGames implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsersGamesPK usersGamesPK;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int color;
    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Game games;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public UsersGames() {
    }

    public UsersGames(UsersGamesPK usersGamesPK) {
        this.usersGamesPK = usersGamesPK;
    }

    public UsersGames(UsersGamesPK usersGamesPK, int color) {
        this.usersGamesPK = usersGamesPK;
        this.color = color;
    }

    public UsersGames(long gameId, int userId) {
        this.usersGamesPK = new UsersGamesPK(gameId, userId);
    }

    public UsersGamesPK getUsersGamesPK() {
        return usersGamesPK;
    }

    public void setUsersGamesPK(UsersGamesPK usersGamesPK) {
        this.usersGamesPK = usersGamesPK;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Game getGames() {
        return games;
    }

    public void setGames(Game games) {
        this.games = games;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersGamesPK != null ? usersGamesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersGames)) {
            return false;
        }
        UsersGames other = (UsersGames) object;
        if ((this.usersGamesPK == null && other.usersGamesPK != null) || (this.usersGamesPK != null && !this.usersGamesPK.equals(other.usersGamesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.igo.entities.UsersGames[ usersGamesPK=" + usersGamesPK + " ]";
    }
    
}
