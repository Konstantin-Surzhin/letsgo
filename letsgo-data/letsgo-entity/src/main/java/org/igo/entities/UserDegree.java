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
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "USER_DEGREES")
@NamedQueries({
    @NamedQuery(name = "UserDegree.findAll", query = "SELECT u FROM UserDegree u")
    ,@NamedQuery(name = "UserDegree.findByAppointmentDate", query = "SELECT u FROM UserDegree u WHERE u.userDegreePK.appointmentDate = :appointmentDate")
    ,@NamedQuery(name = "UserDegree.findByUserId", query = "SELECT u FROM UserDegree u WHERE u.userDegreePK.userId = :userId")
    ,@NamedQuery(name = "UserDegree.findByDegreeType", query = "SELECT u FROM UserDegree u WHERE u.degreeType = :degreeType")})
public class UserDegree implements Serializable {

    private static final long serialVersionUID = 1L;
    protected UserDegreePK userDegreePK;
    private Integer degreeType;
    private GoUser goUser;
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
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_userDegree_goUser"), name = "gouser_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public GoUser getGoUser() {
        return goUser;
    }

    /**
     *
     * @param goUser
     */
    public void setGoUser(GoUser goUser) {
        this.goUser = goUser;
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
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.userDegreePK);
        hash = 59 * hash + Objects.hashCode(this.degreeType);
        hash = 59 * hash + Objects.hashCode(this.goUser);
        hash = 59 * hash + Objects.hashCode(this.degree);
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
        final UserDegree other = (UserDegree) obj;
        return Objects.equals(this.userDegreePK, other.userDegreePK);
    }

    @Override
    public String toString() {
        return "org.igo.entities.UsersDegrees[ usersDegreesPK=" + userDegreePK + " ]";
    }

}
