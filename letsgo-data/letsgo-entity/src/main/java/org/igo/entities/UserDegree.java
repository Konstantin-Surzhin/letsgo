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
@Table(name = "users_degrees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDegree.findAll", query = "SELECT u FROM UserDegree u"),
    @NamedQuery(name = "UserDegree.findByAppointmentDate", query = "SELECT u FROM UserDegree u WHERE u.usersDegreesPK.appointmentDate = :appointmentDate"),
    @NamedQuery(name = "UserDegree.findByUserId", query = "SELECT u FROM UserDegree u WHERE u.usersDegreesPK.userId = :userId"),
    @NamedQuery(name = "UserDegree.findByDegreeType", query = "SELECT u FROM UserDegree u WHERE u.degreeType = :degreeType")})
public class UserDegree implements Serializable {

    private static final long serialVersionUID = 1L;
    protected UserDegreePK userDegreePK;
    private Integer degreeType;
    private User users;
    private Degree degreeId;

    public UserDegree() {
    }

    public UserDegree(UserDegreePK usersDegreesPK) {
        this.userDegreePK = usersDegreesPK;
    }

    public UserDegree(Date appointmentDate, int userId) {
        this.userDegreePK = new UserDegreePK(appointmentDate, userId);
    }
    @EmbeddedId
    public UserDegreePK getUserDegreePK() {
        return userDegreePK;
    }

    public void setUserDegreePK(UserDegreePK userDegreePK) {
        this.userDegreePK = userDegreePK;
    }

    @Column(name = "degree_type")
    public Integer getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(Integer degreeType) {
        this.degreeType = degreeType;
    }

    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    @JoinColumn(name = "degree_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    public Degree getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Degree degreeId) {
        this.degreeId = degreeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userDegreePK != null ? userDegreePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDegree)) {
            return false;
        }
        UserDegree other = (UserDegree) object;
        return !((this.userDegreePK == null && other.userDegreePK != null) || (this.userDegreePK != null && !this.userDegreePK.equals(other.userDegreePK)));
    }

    @Override
    public String toString() {
        return "org.igo.entities.UsersDegrees[ usersDegreesPK=" + userDegreePK + " ]";
    }
    
}
