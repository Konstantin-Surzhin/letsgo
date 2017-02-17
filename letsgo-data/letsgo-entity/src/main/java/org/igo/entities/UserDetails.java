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
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
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

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "USER_DETAILS", uniqueConstraints = {
    @UniqueConstraint(name = "uk_user_email", columnNames = {"email"})})
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

    private int id;
    private int draw;
    private String email;
    private boolean isLogin;
    private Date lastTime = Calendar.getInstance().getTime();
    private int lose;
    private int rating;
    private int staus;
    private int win;
    private int nescape;
    private League league;
    private Team team;
    private Room room;

    private Club club;
    private GoUser user;
    private String password;
    private String salt;

    private Country country;

    private Collection<UserGame> userGameCollection;
    private Collection<UserDegree> userDegreeCollection;
    private Collection<MoveComment> moveCommentCollection;
    private Collection<GameComment> gameCommentCollection;
    private Collection<UserBan> userBanCollection;

    /**
     *
     */
    public UserDetails() {
    }

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     *
     * @return
     */
    @Column(name = "draw")
    public int getDraw() {
        return draw;
    }

    /**
     *
     * @param draw
     */
    public void setDraw(int draw) {
        this.draw = draw;
    }

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    /**
     *
     * @return
     */
    @NotNull
    @Size(min = 1, max = 255)
    @Basic(optional = false)
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    @Column(name = "is_login")
    public boolean getIsLogin() {
        return isLogin;
    }

    /**
     *
     * @param isLogin
     */
    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "last_time")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastTime() {
        return new Date(lastTime.getTime());
    }

    /**
     *
     * @param lastTime
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = new Date(lastTime.getTime());
    }

    /**
     *
     * @return
     */
    @Column(name = "lose")
    public int getLose() {
        return lose;
    }

    /**
     *
     * @param lose
     */
    public void setLose(int lose) {
        this.lose = lose;
    }

    /**
     *
     * @return
     */
    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    @Column(name = "staus")
    public int getStaus() {
        return staus;
    }

    /**
     *
     * @param staus
     */
    public void setStaus(int staus) {
        this.staus = staus;
    }

    /**
     *
     * @return
     */
    @Column(name = "win")
    public int getWin() {
        return win;
    }

    /**
     *
     * @param win
     */
    public void setWin(int win) {
        this.win = win;
    }

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails")
    public Collection<UserBan> getUserBanCollection() {
        return userBanCollection;
    }

    /**
     *
     * @param userBanCollection
     */
    public void setUserBanCollection(Collection<UserBan> userBanCollection) {
        this.userBanCollection = userBanCollection;
    }

    /**
     *
     * @return
     */
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_league"), name = "league_id", referencedColumnName = "id")
    public League getLeague() {
        return league;
    }

    /**
     *
     * @param league
     */
    public void setLeague(League league) {
        this.league = league;
    }

    /**
     *
     * @return
     */
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_team"), name = "team_id", referencedColumnName = "id")
    public Team getTeam() {
        return team;
    }

    /**
     *
     * @param team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     *
     * @return
     */
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_room"), name = "room_id", referencedColumnName = "id")
    public Room getRoom() {
        return room;
    }

    /**
     *
     * @param room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + this.draw;
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + (this.isLogin ? 1 : 0);
        hash = 59 * hash + Objects.hashCode(this.lastTime);
        hash = 59 * hash + this.lose;
        hash = 59 * hash + this.rating;
        hash = 59 * hash + this.staus;
        hash = 59 * hash + this.win;
        hash = 59 * hash + this.nescape;
        hash = 59 * hash + Objects.hashCode(this.league);
        hash = 59 * hash + Objects.hashCode(this.team);
        hash = 59 * hash + Objects.hashCode(this.room);
        hash = 59 * hash + Objects.hashCode(this.club);
        hash = 59 * hash + Objects.hashCode(this.user);
        hash = 59 * hash + Objects.hashCode(this.userGameCollection);
        hash = 59 * hash + Objects.hashCode(this.userDegreeCollection);
        hash = 59 * hash + Objects.hashCode(this.moveCommentCollection);
        hash = 59 * hash + Objects.hashCode(this.gameCommentCollection);
        hash = 59 * hash + Objects.hashCode(this.userBanCollection);
        hash = 59 * hash + Objects.hashCode(this.country);
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
        final UserDetails other = (UserDetails) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "org.igo.ban.ejb.Users[ id=" + id + " ]";
    }

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails")
    public Collection<UserGame> getUserGameCollection() {
        return userGameCollection;
    }

    /**
     *
     * @param userGameCollection
     */
    public void setUserGameCollection(Collection<UserGame> userGameCollection) {
        this.userGameCollection = userGameCollection;
    }

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails")
    public Collection<UserDegree> getUserDegreeCollection() {
        return userDegreeCollection;
    }

    /**
     *
     * @param userDegreeCollection
     */
    public void setUserDegreeCollection(Collection<UserDegree> userDegreeCollection) {
        this.userDegreeCollection = userDegreeCollection;
    }

    /**
     *
     * @return
     */
    @OneToMany(mappedBy = "userDetails")
    public Collection<MoveComment> getMoveCommentCollection() {
        return moveCommentCollection;
    }

    /**
     *
     * @param moveCommentCollection
     */
    public void setMoveCommentCollection(Collection<MoveComment> moveCommentCollection) {
        this.moveCommentCollection = moveCommentCollection;
    }

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDetails")
    public Collection<GameComment> getGameCommentCollection() {
        return gameCommentCollection;
    }

    /**
     *
     * @param gameCommentCollection
     */
    public void setGameCommentCollection(Collection<GameComment> gameCommentCollection) {
        this.gameCommentCollection = gameCommentCollection;
    }

    /**
     * @return the escaped
     */
    @Column(name = "nescape")
    public int getNescape() {
        return nescape;
    }

    /**
     * @param nescape
     */
    public void setNescape(int nescape) {
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

    /**
     *
     * @return
     */
    @OneToOne(mappedBy = "userDetails")
    public GoUser getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(GoUser user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_country"), name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
