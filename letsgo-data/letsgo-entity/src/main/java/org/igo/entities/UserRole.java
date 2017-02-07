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
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "USER_ROLES", uniqueConstraints = {
    @UniqueConstraint(name = "uk_user_name", columnNames = {"user_name"})})
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u")
    ,@NamedQuery(name = "UserRole.findById", query = "SELECT u FROM UserRole u WHERE u.id = :id")
    ,@NamedQuery(name = "UserRole.findByUsername", query = "SELECT u FROM UserRole u WHERE u.userName = :username")
    ,@NamedQuery(name = "UserRole.findByUserrole", query = "SELECT u FROM UserRole u WHERE u.userRole = :userrole")})
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private short id;
    private String userName;
    private String userRole;
    private Collection<GoUser> userCollection;

    /**
     *
     */
    public UserRole() {
    }

    /**
     *
     * @param id
     */
    public UserRole(short id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param username
     * @param userrole
     */
    public UserRole(short id, String username, String userrole) {
        this.id = id;
        this.userName = username;
        this.userRole = userrole;
    }

    /**
     *
     * @return
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @Id
    public short getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(short id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "user_name", nullable = false, length = 255)
    @Size(min = 1, max = 255)
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    @Size(min = 1, max = 255)
    @Basic(optional = false)
    @Column(name = "userrole", nullable = false)
    public String getUserRole() {
        return userRole;
    }

    /**
     *
     * @param userRole
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     *
     * @return
     */
    @OneToMany(mappedBy = "role")
    public Collection<GoUser> getUserCollection() {
        return userCollection;
    }

    /**
     *
     * @param userCollection
     */
    public void setUserCollection(Collection<GoUser> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.userName);
        hash = 97 * hash + Objects.hashCode(this.userRole);
        hash = 97 * hash + Objects.hashCode(this.userCollection);
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
        final UserRole other = (UserRole) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "org.igo.ban.ejb.Userroles[ id=" + id + " ]";
    }

}
