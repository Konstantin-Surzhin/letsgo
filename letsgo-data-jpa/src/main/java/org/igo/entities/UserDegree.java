/*
 * Copyright (C) 2016 kostya surzhin
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

/**
 *
 * @author kostya surzhin
 */
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
 * @author kostya surzhin
 */
@XmlRootElement
@Entity
@Table(name = "users_degrees")
@NamedQueries({
    @NamedQuery(name = "UserDegree.findAll", query = "SELECT u FROM UserDegree u")})
public class UserDegree implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    protected UserDegreePK userDegreePK;
    private Degree degeeId;
    private User users;
    private DegreeType degreeType;

    /**
     *
     */
    public UserDegree() {
    }

    /**
     *
     * @param userRatingPK
     */
    public UserDegree(UserDegreePK userRatingPK) {
        this.userDegreePK = userRatingPK;
    }

    /**
     *
     * @param userId
     * @param appointmentDate
     */
    public UserDegree(int userId, Date appointmentDate) {
        this.userDegreePK = new UserDegreePK(userId, appointmentDate);
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
    @JoinColumn(name = "degree_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    public Degree getDegeeId() {
        return degeeId;
    }

    /**
     *
     * @param degeeId
     */
    public void setDegeeId(Degree degeeId) {
        this.degeeId = degeeId;
    }

    /**
     *
     * @return
     */
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    public User getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(User users) {
        this.users = users;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userDegreePK != null ? userDegreePK.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDegree)) {
            return false;
        }
        UserDegree other = (UserDegree) object;
        return !((this.userDegreePK == null && other.userDegreePK != null) || (this.userDegreePK != null && !this.userDegreePK.equals(other.userDegreePK)));
    }

    /**
     *
     * @return
     */
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
