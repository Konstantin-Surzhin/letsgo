/*
 * Copyright (C) 2016 surzhin.konstantin
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
import java.util.Set;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
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
@Table(name = "GO_USERS", uniqueConstraints = {
    @UniqueConstraint(name = "uk_user_name", columnNames = {"user_name"})
    ,@UniqueConstraint(name = "uk_user_email", columnNames = {"email"})})
@NamedNativeQueries({
    @NamedNativeQuery(name = "GoUser.findByUserName",
            query = "SELECT id, user_name FROM GO_USERS order by user_name",
            resultSetMapping = "GoUserToWeakUser")
})
@NamedQueries({
    @NamedQuery(name = "GoUser.findAll", query = "SELECT u FROM GoUser u")
    ,@NamedQuery(name = "GoUser.findByDraw", query = "SELECT u FROM GoUser u WHERE u.draw = :draw")
    ,@NamedQuery(name = "GoUser.findByEmail", query = "SELECT u FROM GoUser u WHERE u.email = :email")
    ,@NamedQuery(name = "GoUser.findByIsLogin", query = "SELECT u FROM GoUser u WHERE u.isLogin = :isLogin")
    ,@NamedQuery(name = "GoUser.findByLastTime", query = "SELECT u FROM GoUser u WHERE u.lastTime = :lastTime")
    ,@NamedQuery(name = "GoUser.findByLose", query = "SELECT u FROM GoUser u WHERE u.lose = :lose")
    ,@NamedQuery(name = "GoUser.findByRating", query = "SELECT u FROM GoUser u WHERE u.rating = :rating")
    ,@NamedQuery(name = "GoUser.findByStaus", query = "SELECT u FROM GoUser u WHERE u.staus = :staus")
    ,@NamedQuery(name = "GoUser.findByNescape", query = "SELECT u FROM GoUser u WHERE u.nescape = :nescape")
    ,@NamedQuery(name = "GoUser.findByWin", query = "SELECT u FROM GoUser u WHERE u.win = :win")})
@SqlResultSetMapping(name = "GoUserToWeakUser", classes = {
    @ConstructorResult(targetClass = User.class,
            columns = {
                @ColumnResult(name = "id")
                ,@ColumnResult(name = "user_name")})
})

public class GoUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String userName;
    private City city;
    private UserRole role;

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
    private String password;
    private String salt;

    private Country country;

    private Set<UserGame> userGames;
    private Set<UserDegree> userDegrees;
    private Set<MoveComment> moveComments;
    private Set<GameComment> gameComments;
    private Set<UserBan> userBanSet;

    public GoUser() {
    }

    public GoUser(String userName) {
        this.userName = userName;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.userName);
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
        final GoUser other = (GoUser) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "org.igo.entities.User[ id=" + id + " ]";
    }

    /**
     *
     * @return
     */
    @NotNull
    @Size(min = 1, max = 64)
    @Basic(optional = false)
    @Column(name = "user_name", nullable = false)
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_city"), name = "city_id", referencedColumnName = "id")
    public City getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_role"), name = "role_id", referencedColumnName = "id")
    public UserRole getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(UserRole role) {
        this.role = role;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goUser")
    public Set<UserBan> getUserBans() {
        return userBanSet;
    }

    /**
     *
     * @param userBanSet
     */
    public void setUserBans(Set<UserBan> userBanSet) {
        this.userBanSet = userBanSet;
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

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goUser")
    public Set<UserGame> getUserGameSet() {
        return userGames;
    }

    /**
     *
     * @param userGames
     */
    public void setUserGameSet(Set<UserGame> userGames) {
        this.userGames = userGames;
    }

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goUser")
    public Set<UserDegree> getUserDegreeSet() {
        return userDegrees;
    }

    /**
     *
     * @param userDegrees
     */
    public void setUserDegreeSet(Set<UserDegree> userDegrees) {
        this.userDegrees = userDegrees;
    }

    /**
     *
     * @return
     */
    @OneToMany(mappedBy = "goUser")
    public Set<MoveComment> getMoveCommentSet() {
        return moveComments;
    }

    /**
     *
     * @param moveComments
     */
    public void setMoveCommentSet(Set<MoveComment> moveComments) {
        this.moveComments = moveComments;
    }

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goUser")
    public Set<GameComment> getGameCommentSet() {
        return gameComments;
    }

    /**
     *
     * @param gameComments
     */
    public void setGameCommentSet(Set<GameComment> gameComments) {
        this.gameComments= gameComments;
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

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_country"), name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
