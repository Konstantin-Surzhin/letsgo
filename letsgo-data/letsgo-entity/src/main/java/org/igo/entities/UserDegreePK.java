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
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author surzhin.konstantin
 */
@Embeddable
public class UserDegreePK implements Serializable {

    private static final long serialVersionUID = -4018991903865846151L;

    private Date appointmentDate = Calendar.getInstance().getTime();
    private int userId;

    /**
     *
     */
    public UserDegreePK() {
    }

    /**
     *
     * @param appointmentDate
     * @param userId
     */
    public UserDegreePK(Date appointmentDate, int userId) {
        this.appointmentDate = new Date(appointmentDate.getTime());
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
        return new Date(appointmentDate.getTime());
    }

    /**
     *
     * @param appointmentDate
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = new Date(appointmentDate.getTime());
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.appointmentDate);
        hash = 41 * hash + this.userId;
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
        final UserDegreePK other = (UserDegreePK) obj;
        if (this.userId != other.userId) {
            return false;
        }
        return Objects.equals(this.appointmentDate, other.appointmentDate);
    }

    @Override
    public String toString() {
        return "org.igo.entities.UsersDegreesPK[ appointmentDate=" + appointmentDate + ", userId=" + userId + " ]";
    }

}
