/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByDraw", query = "SELECT u FROM Users u WHERE u.draw = :draw"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByIsLogin", query = "SELECT u FROM Users u WHERE u.isLogin = :isLogin"),
    @NamedQuery(name = "Users.findByLastTime", query = "SELECT u FROM Users u WHERE u.lastTime = :lastTime"),
    @NamedQuery(name = "Users.findByLose", query = "SELECT u FROM Users u WHERE u.lose = :lose"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByRating", query = "SELECT u FROM Users u WHERE u.rating = :rating"),
    @NamedQuery(name = "Users.findBySalt", query = "SELECT u FROM Users u WHERE u.salt = :salt"),
    @NamedQuery(name = "Users.findByStaus", query = "SELECT u FROM Users u WHERE u.staus = :staus"),
    @NamedQuery(name = "Users.findByWin", query = "SELECT u FROM Users u WHERE u.win = :win")})
public class Users implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<UsersGames> usersGamesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<UsersDegrees> usersDegreesCollection;
    @OneToMany(mappedBy = "userId")
    private Collection<MovesComments> movesCommentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<GamesComments> gamesCommentsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "draw")
    private Integer draw;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Column(name = "is_login")
    private Boolean isLogin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTime;
    @Column(name = "lose")
    private Integer lose;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Size(max = 128)
    @Column(name = "password")
    private String password;
    @Column(name = "rating")
    private Integer rating;
    @Size(max = 128)
    @Column(name = "salt")
    private String salt;
    @Column(name = "staus")
    private Integer staus;
    @Column(name = "win")
    private Integer win;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<UsersBans> usersBansCollection;
    @JoinColumn(name = "league_id", referencedColumnName = "id")
    @ManyToOne
    private Leagues leagueId;
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne
    private Userroles roleId;
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @ManyToOne
    private Teams teamId;
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    @ManyToOne
    private Rooms roomId;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne
    private City cityId;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String email, Date lastTime, String name) {
        this.id = id;
        this.email = email;
        this.lastTime = lastTime;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getStaus() {
        return staus;
    }

    public void setStaus(Integer staus) {
        this.staus = staus;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    @XmlTransient
    public Collection<UsersBans> getUsersBansCollection() {
        return usersBansCollection;
    }

    public void setUsersBansCollection(Collection<UsersBans> usersBansCollection) {
        this.usersBansCollection = usersBansCollection;
    }

    public Leagues getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Leagues leagueId) {
        this.leagueId = leagueId;
    }

    public Userroles getRoleId() {
        return roleId;
    }

    public void setRoleId(Userroles roleId) {
        this.roleId = roleId;
    }

    public Teams getTeamId() {
        return teamId;
    }

    public void setTeamId(Teams teamId) {
        this.teamId = teamId;
    }

    public Rooms getRoomId() {
        return roomId;
    }

    public void setRoomId(Rooms roomId) {
        this.roomId = roomId;
    }

    public City getCityId() {
        return cityId;
    }

    public void setCityId(City cityId) {
        this.cityId = cityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.ban.ejb.Users[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<UsersGames> getUsersGamesCollection() {
        return usersGamesCollection;
    }

    public void setUsersGamesCollection(Collection<UsersGames> usersGamesCollection) {
        this.usersGamesCollection = usersGamesCollection;
    }

    @XmlTransient
    public Collection<UsersDegrees> getUsersDegreesCollection() {
        return usersDegreesCollection;
    }

    public void setUsersDegreesCollection(Collection<UsersDegrees> usersDegreesCollection) {
        this.usersDegreesCollection = usersDegreesCollection;
    }

    @XmlTransient
    public Collection<MovesComments> getMovesCommentsCollection() {
        return movesCommentsCollection;
    }

    public void setMovesCommentsCollection(Collection<MovesComments> movesCommentsCollection) {
        this.movesCommentsCollection = movesCommentsCollection;
    }

    @XmlTransient
    public Collection<GamesComments> getGamesCommentsCollection() {
        return gamesCommentsCollection;
    }

    public void setGamesCommentsCollection(Collection<GamesComments> gamesCommentsCollection) {
        this.gamesCommentsCollection = gamesCommentsCollection;
    }
    
}
