/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pl
 */
@Embeddable
public class UserDegreePK implements Serializable {

    private int userId;
    private Date appointmentDate;

    public UserDegreePK() {
    }

    public UserDegreePK(int userId, Date appointmentDate) {
        this.userId = userId;
        this.appointmentDate = appointmentDate;
    }

    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic(optional = false)
    @Column(name = "appointment_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (appointmentDate != null ? appointmentDate.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "jpa2.UserRatingPK[ userId=" + userId + ", appointmentDate=" + appointmentDate + " ]";
    }

}
