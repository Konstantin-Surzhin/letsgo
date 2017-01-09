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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
@Table(name = "USER_DEGREES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDegree.findAll", query = "SELECT u FROM UserDegree u")
    ,@NamedQuery(name = "UserDegree.findByAppointmentDate", query = "SELECT u FROM UserDegree u WHERE u.userDegreePK.appointmentDate = :appointmentDate")
    ,@NamedQuery(name = "UserDegree.findByUserId", query = "SELECT u FROM UserDegree u WHERE u.userDegreePK.userId = :userId")
    ,@NamedQuery(name = "UserDegree.findByDegreeType", query = "SELECT u FROM UserDegree u WHERE u.degreeType = :degreeType")})
public class UserDegree implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    protected UserDegreePK userDegreePK;
    private Integer degreeType;
    private UserDetails userDetails;
    private Degree degree;

    /**
     *
     */
    public UserDegree() {
    }

    /**
     *
     * @param usersDegreesPK
     */
    public UserDegree(UserDegreePK usersDegreesPK) {
        this.userDegreePK = usersDegreesPK;
    }

    /**
     *
     * @param appointmentDate
     * @param userId
     */
    public UserDegree(Date appointmentDate, int userId) {
        this.userDegreePK = new UserDegreePK(appointmentDate, userId);
    }

    /**
     *
     * @return
     */
    @EmbeddedId
    public UserDegreePK getUserDegreePK() {
        return userDegreePK;
    }

    /**
     *
     * @param userDegreePK
     */
    public void setUserDegreePK(UserDegreePK userDegreePK) {
        this.userDegreePK = userDegreePK;
    }

    /**
     *
     * @return
     */
    @Column(name = "degree_type")
    public Integer getDegreeType() {
        return degreeType;
    }

    /**
     *
     * @param degreeType
     */
    public void setDegreeType(Integer degreeType) {
        this.degreeType = degreeType;
    }

    /**
     *
     * @return
     */
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_userDegree_userDetails"), name = "user_details_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public UserDetails getUserDetails() {
        return userDetails;
    }

    /**
     *
     * @param userDetails
     */
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    /**
     *
     * @return
     */
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_degree_degree"), name = "degree_id", referencedColumnName = "id", nullable = false)

    public Degree getDegree() {
        return degree;
    }

    /**
     *
     * @param degree
     */
    public void setDegree(Degree degree) {
        this.degree = degree;
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
