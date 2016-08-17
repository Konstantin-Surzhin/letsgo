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
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kostya surzhin
 */
@XmlRootElement
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByIslogin", query = "SELECT u FROM User u WHERE u.islogin = :islogin"),
    @NamedQuery(name = "User.findByLastTime", query = "SELECT u FROM User u WHERE u.lastTime = :lastTime"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findBySalt", query = "SELECT u FROM User u WHERE u.salt = :salt")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Boolean isLogin;

    private String email;

    private Date lastTime;

    private String password;

    private String salt;

    private Integer lose;

    private Integer draw;

    private Integer win;

    private Integer rating;
    
    private Role role;

    private Collection<UserDegree> userDegrees;

    private Collection<UserGame> userGames;

    private UserStatus status;

    private List<Ban> bans;

    private Room defaultRoom;

    private Team team;
    
    private League league;
    
    private City city;
    /**
     *
     */
    public User() {
    }

    /**
     *
     * @param id
     */
    public User(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param lastTime
     */
    public User(Integer id, Date lastTime) {
        this.id = id;
        this.lastTime = lastTime;
    }

    /**
     *
     * @return
     */
    @Id
    @Basic(optional = false)
//    @Column(name = "id", nullable = false)
//    @TableGenerator(name = "user_gen", table = "id_gen",
//            pkColumnName = "gen_name", valueColumnName = "gen_val")
//    @GeneratedValue(generator = "user_gen")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Column(name = "name", length = 64, nullable = false, unique = true)
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    @Column(name = "is_login")
    public Boolean getIslogin() {
        return isLogin;
    }

    /**
     *
     * @param islogin
     */
    public void setIslogin(Boolean islogin) {
        this.isLogin = islogin;
    }

    /**
     *
     * @return
     */
    @Column(name = "password", length = 128)
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    @Column(name = "salt", length = 128)
    public String getSalt() {
        return salt;
    }

    /**
     *
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "jpa.User[ id=" + id + " ]";
    }

    /**
     * @return the email
     */
    @Basic(optional = false)
    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the lastTime
     */
    @Basic(optional = false)
    @Column(name = "last_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * @param lastTime the lastTime to set
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * @return the lose
     */
    @Column(name = "lose")
    public Integer getLose() {
        return lose;
    }

    /**
     * @param lose the lose to set
     */
    public void setLose(Integer lose) {
        this.lose = lose;
    }

    /**
     * @return the win
     */
    @Column(name = "win")
    public Integer getWin() {
        return win;
    }

    /**
     * @param win the win to set
     */
    public void setWin(Integer win) {
        this.win = win;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users", fetch = FetchType.LAZY)
    public Collection<UserDegree> getUserDegrees() {
        return userDegrees;
    }

    /**
     *
     * @param userDegrees
     */
    public void setUserDegrees(Collection<UserDegree> userDegrees) {
        this.userDegrees = userDegrees;
    }

    /**
     * @return the userGames
     */
    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    public Collection<UserGame> getUserGames() {
        return userGames;
    }

    /**
     * @param userGames the userGames to set
     */
    public void setUserGames(Collection<UserGame> userGames) {
        this.userGames = userGames;
    }

    /**
     * @return the draw
     */
    @Column(name = "draw")
    public Integer getDraw() {
        return draw;
    }

    /**
     * @param draw the draw to set
     */
    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    /**
     * @return the rating
     */
    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * @return the status
     */
    @Enumerated
    @Column(name = "staus")
    public UserStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(UserStatus status) {
        this.status = status;
    }

    /**
     * @return the bans
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public List<Ban> getBans() {
        return bans;
    }

    /**
     * @param bans the bans to set
     */
    public void setBans(List<Ban> bans) {
        this.bans = bans;
    }

    /**
     * @return the defaultRoom
     */
    @ManyToOne
    @JoinColumn(name = "room_id")
    public Room getDefaultRoom() {
        return defaultRoom;
    }

    /**
     * @param defaultRoom the defaultRoom to set
     */
    public void setDefaultRoom(Room defaultRoom) {
        this.defaultRoom = defaultRoom;
    }

    /**
     * @return the defaultTeam
     */
    @ManyToOne
    @JoinColumn(name = "team_id")
    public Team getTeam() {
        return team;
    }

    /**
     * @param team the defaultTeam to set
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     * @return the role
     */
    @OneToOne
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @OneToOne
    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    /**
     * @return the city
     */
    @ManyToOne
    public City getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(City city) {
        this.city = city;
    }
}
