/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

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
 * @author pl
 */
@Entity
@Table(name = "user_degree", catalog = "letsgo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDegree.findAll", query = "SELECT u FROM UserDegree u")})
public class UserDegree implements Serializable {

    private static final long serialVersionUID = 1L;

    protected UserDegreePK userDegreePK;
    private Degree degeeId;
    private User users;
    private DegreeType degreeType;

    public UserDegree() {
    }

    public UserDegree(UserDegreePK userRatingPK) {
        this.userDegreePK = userRatingPK;
    }

    public UserDegree(int userId, Date appointmentDate) {
        this.userDegreePK = new UserDegreePK(userId, appointmentDate);
    }

    @EmbeddedId
    public UserDegreePK getUserDegreePK() {
        return userDegreePK;
    }

    public void setUserDegreePK(UserDegreePK userDegreePK) {
        this.userDegreePK = userDegreePK;
    }

    @JoinColumn(name = "degree_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    public Degree getDegeeId() {
        return degeeId;
    }

    public void setDegeeId(Degree degeeId) {
        this.degeeId = degeeId;
    }

    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
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
        return "jpa2.UserRating[ userRatingPK=" + userDegreePK + " ]";
    }

    /**
     * @return the degreeType
     */
    @Column(name = "degree_type")
    public DegreeType getDegreeType() {
        return degreeType;
    }

    /**
     * @param degreeType the degreeType to set
     */
    public void setDegreeType(DegreeType degreeType) {
        this.degreeType = degreeType;
    }

}
