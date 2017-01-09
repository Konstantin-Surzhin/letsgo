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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "USER_BANS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserBan.findAll", query = "SELECT u FROM UserBan u")
    ,
    @NamedQuery(name = "UserBan.findById", query = "SELECT u FROM UserBan u WHERE u.id = :id")
    ,
    @NamedQuery(name = "UserBan.findByComment", query = "SELECT u FROM UserBan u WHERE u.comment = :comment")
    ,
    @NamedQuery(name = "UserBan.findByDuration", query = "SELECT u FROM UserBan u WHERE u.duration = :duration")
    ,
    @NamedQuery(name = "UserBan.findByStartDate", query = "SELECT u FROM UserBan u WHERE u.startDate = :startDate")})
public class UserBan implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String comment;
    private short duration;
    private Date startDate = Calendar.getInstance().getTime();
    private UserDetails userDetails;

    /**
     *
     */
    public UserBan() {
    }

    /**
     *
     * @param id
     */
    public UserBan(Long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param comment
     * @param duration
     * @param startDate
     */
    public UserBan(Long id, String comment, short duration, Date startDate) {
        this.id = id;
        this.comment = comment;
        this.duration = duration;
        this.startDate = new Date(startDate.getTime());
    }

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "comment", nullable = false, unique = true)
    @Size(min = 1, max = 255)
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "duration", nullable = false)
    public short getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(short duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getStartDate() {
        return new Date(startDate.getTime());
    }

    /**
     *
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = new Date(startDate.getTime());
    }

    /**
     *
     * @return
     */
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_userBan_userDetails"), name = "user_details_id", referencedColumnName = "id")
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBan)) {
            return false;
        }
        UserBan other = (UserBan) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.ban.ejb.UsersBans[ id=" + id + " ]";
    }

}
