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
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "USER_DETAILS", uniqueConstraints = {
    @UniqueConstraint(name = "uk_user_email", columnNames = {"email"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDetails.findAll", query = "SELECT u FROM UserDetails u")
    ,@NamedQuery(name = "UserDetails.findByDraw", query = "SELECT u FROM UserDetails u WHERE u.draw = :draw")
    ,@NamedQuery(name = "UserDetails.findByEmail", query = "SELECT u FROM UserDetails u WHERE u.email = :email")
    ,@NamedQuery(name = "UserDetails.findByIsLogin", query = "SELECT u FROM UserDetails u WHERE u.isLogin = :isLogin")
    ,@NamedQuery(name = "UserDetails.findByLastTime", query = "SELECT u FROM UserDetails u WHERE u.lastTime = :lastTime")
    ,@NamedQuery(name = "UserDetails.findByLose", query = "SELECT u FROM UserDetails u WHERE u.lose = :lose")
    ,@NamedQuery(name = "UserDetails.findByRating", query = "SELECT u FROM UserDetails u WHERE u.rating = :rating")
    ,@NamedQuery(name = "UserDetails.findByStaus", query = "SELECT u FROM UserDetails u WHERE u.staus = :staus")
    ,@NamedQuery(name = "UserDetails.findByNescape", query = "SELECT u FROM UserDetails u WHERE u.nescape = :nescape")
    ,@NamedQuery(name = "UserDetails.findByWin", query = "SELECT u FROM UserDetails u WHERE u.win = :win")})
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer draw;
    private String email;
    private Boolean isLogin;
    private Date lastTime;
    private Integer lose;
    //private String userName;
    private Integer rating;
    private Integer staus;
    private Integer win;
    private Integer nescape;
    private League league;
    private Team team;
    private Room room;
    private City city;
    private Club club;
    private GoUser user;

    private Collection<UserGame> userGameCollection;
    private Collection<UserDegree> userDegreeCollection;
    private Collection<MoveComment> moveCommentCollection;
    private Collection<GameComment> gameCommentCollection;
    private Collection<UserBan> userBanCollection;

    public UserDetails() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "email", nullable = false)
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

    @Column(name = "rating")
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
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

    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails")
    public Collection<UserBan> getUserBanCollection() {
        return userBanCollection;
    }

    public void setUserBanCollection(Collection<UserBan> userBanCollection) {
        this.userBanCollection = userBanCollection;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_league"), name = "league_id", referencedColumnName = "id")
    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_team"), name = "team_id", referencedColumnName = "id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_room"), name = "room_id", referencedColumnName = "id")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_city"), name = "city_id", referencedColumnName = "id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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
        if (!(object instanceof UserDetails)) {
            return false;
        }
        UserDetails other = (UserDetails) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.ban.ejb.Users[ id=" + id + " ]";
    }

    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails")
    public Collection<UserGame> getUserGameCollection() {
        return userGameCollection;
    }

    public void setUserGameCollection(Collection<UserGame> userGameCollection) {
        this.userGameCollection = userGameCollection;
    }

    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails")
    public Collection<UserDegree> getUserDegreeCollection() {
        return userDegreeCollection;
    }

    public void setUserDegreeCollection(Collection<UserDegree> userDegreeCollection) {
        this.userDegreeCollection = userDegreeCollection;
    }

    @XmlTransient
    @OneToMany(mappedBy = "userDetails")
    public Collection<MoveComment> getMoveCommentCollection() {
        return moveCommentCollection;
    }

    public void setMoveCommentCollection(Collection<MoveComment> moveCommentCollection) {
        this.moveCommentCollection = moveCommentCollection;
    }

    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails")
    public Collection<GameComment> getGameCommentCollection() {
        return gameCommentCollection;
    }

    public void setGameCommentCollection(Collection<GameComment> gameCommentCollection) {
        this.gameCommentCollection = gameCommentCollection;
    }

    /**
     * @return the escaped
     */
    @Column(name = "nescape")
    public Integer getNescape() {
        return nescape;
    }

    /**
     * @param nescape
     */
    public void setNescape(Integer nescape) {
        this.nescape = nescape;
    }

    /**
     * @return the club
     */
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_club"), name = "club_id", referencedColumnName = "id")
    public Club getClub() {
        return club;
    }

    /**
     * @param club the club to set
     */
    public void setClub(Club club) {
        this.club = club;
    }

    @OneToOne(mappedBy = "userDetails")
    public GoUser getUser() {
        return user;
    }

    public void setUser(GoUser user) {
        this.user = user;
    }
}
