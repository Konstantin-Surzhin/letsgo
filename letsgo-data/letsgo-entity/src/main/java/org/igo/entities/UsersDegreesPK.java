/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author surzhin.konstantin
 */
@Embeddable
public class UsersDegreesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "appointment_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id", nullable = false)
    private int userId;

    public UsersDegreesPK() {
    }

    public UsersDegreesPK(Date appointmentDate, int userId) {
        this.appointmentDate = appointmentDate;
        this.userId = userId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentDate != null ? appointmentDate.hashCode() : 0);
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersDegreesPK)) {
            return false;
        }
        UsersDegreesPK other = (UsersDegreesPK) object;
        if ((this.appointmentDate == null && other.appointmentDate != null) || (this.appointmentDate != null && !this.appointmentDate.equals(other.appointmentDate))) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.igo.entities.UsersDegreesPK[ appointmentDate=" + appointmentDate + ", userId=" + userId + " ]";
    }
    
}
