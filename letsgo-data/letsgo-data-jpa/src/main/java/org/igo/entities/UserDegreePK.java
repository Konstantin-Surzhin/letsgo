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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kostya surzhin
 */
@Embeddable
public class UserDegreePK implements Serializable {

    private int userId;
    private Date appointmentDate;

    /**
     *
     */
    public UserDegreePK() {
    }

    /**
     *
     * @param userId
     * @param appointmentDate
     */
    public UserDegreePK(int userId, Date appointmentDate) {
        this.userId = userId;
        this.appointmentDate = appointmentDate;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "appointment_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     *
     * @param appointmentDate
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (appointmentDate != null ? appointmentDate.hashCode() : 0);
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
        if (!(object instanceof UserDegreePK)) {
            return false;
        }
        UserDegreePK other = (UserDegreePK) object;
        if (this.userId != other.userId) {
            return false;
        }
        return !((this.appointmentDate == null && other.appointmentDate != null) || (this.appointmentDate != null && !this.appointmentDate.equals(other.appointmentDate)));
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "jpa2.UserRatingPK[ userId=" + userId + ", appointmentDate=" + appointmentDate + " ]";
    }

}
