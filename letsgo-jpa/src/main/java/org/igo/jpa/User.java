/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pl
 */
@Entity
@Table(name = "users", schema = "letsgo")
@XmlRootElement
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

    private Collection<UserDegree> userDegrees;

    private Collection<UserGame> userGames;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, Date lastTime) {
        this.id = id;
        this.lastTime = lastTime;
    }

    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    @TableGenerator(name = "user_gen", table = "id_gen",
            pkColumnName = "gen_name", valueColumnName = "gen_val")
    @GeneratedValue(generator = "user_gen")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 64, nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "is_login")
    public Boolean getIslogin() {
        return isLogin;
    }

    public void setIslogin(Boolean islogin) {
        this.isLogin = islogin;
    }

    @Column(name = "password", length = 128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "salt", length = 128)
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    @XmlTransient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users", fetch = FetchType.LAZY)
    public Collection<UserDegree> getUserDegrees() {
        return userDegrees;
    }

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
    @Column(name="draw")
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
    @Column(name="rating")
    public Integer getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
