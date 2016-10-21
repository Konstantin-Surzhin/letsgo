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
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByDraw", query = "SELECT u FROM User u WHERE u.draw = :draw"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByIsLogin", query = "SELECT u FROM User u WHERE u.isLogin = :isLogin"),
    @NamedQuery(name = "User.findByLastTime", query = "SELECT u FROM User u WHERE u.lastTime = :lastTime"),
    @NamedQuery(name = "User.findByLose", query = "SELECT u FROM User u WHERE u.lose = :lose"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByRating", query = "SELECT u FROM User u WHERE u.rating = :rating"),
    @NamedQuery(name = "User.findBySalt", query = "SELECT u FROM User u WHERE u.salt = :salt"),
    @NamedQuery(name = "User.findByStaus", query = "SELECT u FROM User u WHERE u.staus = :staus"),
    @NamedQuery(name = "User.findByWin", query = "SELECT u FROM User u WHERE u.win = :win")})
public class User implements Serializable {

    private Collection<UserGame> userGameCollection;
    private Collection<UserDegree> userDegreeCollection;
    private Collection<MoveComment> moveCommentCollection;
    private Collection<GameComment> gameCommentCollection;
    private Collection<UserBan> userBanCollection;

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer draw;
    private String email;
    private Boolean isLogin;
    private Date lastTime;
    private Integer lose;
    private String name;
    private String password;
    private Integer rating;
    private String salt;
    private Integer staus;
    private Integer win;

    private League leagueId;
    private UserRole roleId;
    private Team teamId;
    private Room roomId;
    private City cityId;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String email, Date lastTime, String name) {
        this.id = id;
        this.email = email;
        this.lastTime = lastTime;
        this.name = name;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "draw")
    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @NotNull
    @Size(min = 1, max = 255)
    @Basic(optional = false)
    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "is_login")
    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }

    @Basic(optional = false)
    @Column(name = "last_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    @Column(name = "lose")
    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    @NotNull
    @Size(min = 1, max = 64)
    @Basic(optional = false)
    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 8, max = 128)
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Column(name = "salt", length = 128)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Column(name = "staus")
    public Integer getStaus() {
        return staus;
    }

    public void setStaus(Integer staus) {
        this.staus = staus;
    }

    @Column(name = "win")
    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    @XmlTransient
    public Collection<UserBan> getUserBanCollection() {
        return userBanCollection;
    }

    public void setUserBanCollection(Collection<UserBan> userBanCollection) {
        this.userBanCollection = userBanCollection;
    }

    @JoinColumn(name = "league_id", referencedColumnName = "id")
    @ManyToOne
    public League getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(League leagueId) {
        this.leagueId = leagueId;
    }

    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @ManyToOne
    public UserRole getRoleId() {
        return roleId;
    }

    public void setRoleId(UserRole roleId) {
        this.roleId = roleId;
    }

    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @ManyToOne
    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }

    @JoinColumn(name = "room_id", referencedColumnName = "id")
    @ManyToOne
    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.ban.ejb.Users[ id=" + id + " ]";
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    @XmlTransient
    public Collection<UserGame> getUserGameCollection() {
        return userGameCollection;
    }

    public void setUserGameCollection(Collection<UserGame> userGameCollection) {
        this.userGameCollection = userGameCollection;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    @XmlTransient
    public Collection<UserDegree> getUserDegreeCollection() {
        return userDegreeCollection;
    }

    public void setUserDegreeCollection(Collection<UserDegree> userDegreeCollection) {
        this.userDegreeCollection = userDegreeCollection;
    }

    @OneToMany(mappedBy = "userId")
    @XmlTransient
    public Collection<MoveComment> getMoveCommentCollection() {
        return moveCommentCollection;
    }

    public void setMoveCommentCollection(Collection<MoveComment> moveCommentCollection) {
        this.moveCommentCollection = moveCommentCollection;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    @XmlTransient
    public Collection<GameComment> getGameCommentCollection() {
        return gameCommentCollection;
    }

    public void setGameCommentCollection(Collection<GameComment> gameCommentCollection) {
        this.gameCommentCollection = gameCommentCollection;
    }

}
