/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "users_degrees", catalog = "letsgo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersDegrees.findAll", query = "SELECT u FROM UsersDegrees u"),
    @NamedQuery(name = "UsersDegrees.findByAppointmentDate", query = "SELECT u FROM UsersDegrees u WHERE u.usersDegreesPK.appointmentDate = :appointmentDate"),
    @NamedQuery(name = "UsersDegrees.findByUserId", query = "SELECT u FROM UsersDegrees u WHERE u.usersDegreesPK.userId = :userId"),
    @NamedQuery(name = "UsersDegrees.findByDegreeType", query = "SELECT u FROM UsersDegrees u WHERE u.degreeType = :degreeType")})
public class UsersDegrees implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsersDegreesPK usersDegreesPK;
    @Column(name = "degree_type")
    private Integer degreeType;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;
    @JoinColumn(name = "degree_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Degrees degreeId;

    public UsersDegrees() {
    }

    public UsersDegrees(UsersDegreesPK usersDegreesPK) {
        this.usersDegreesPK = usersDegreesPK;
    }

    public UsersDegrees(Date appointmentDate, int userId) {
        this.usersDegreesPK = new UsersDegreesPK(appointmentDate, userId);
    }

    public UsersDegreesPK getUsersDegreesPK() {
        return usersDegreesPK;
    }

    public void setUsersDegreesPK(UsersDegreesPK usersDegreesPK) {
        this.usersDegreesPK = usersDegreesPK;
    }

    public Integer getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(Integer degreeType) {
        this.degreeType = degreeType;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Degrees getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Degrees degreeId) {
        this.degreeId = degreeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersDegreesPK != null ? usersDegreesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersDegrees)) {
            return false;
        }
        UsersDegrees other = (UsersDegrees) object;
        if ((this.usersDegreesPK == null && other.usersDegreesPK != null) || (this.usersDegreesPK != null && !this.usersDegreesPK.equals(other.usersDegreesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.igo.entities.UsersDegrees[ usersDegreesPK=" + usersDegreesPK + " ]";
    }
    
}
