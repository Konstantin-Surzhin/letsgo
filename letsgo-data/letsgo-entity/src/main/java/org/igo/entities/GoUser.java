/*
 * Copyright (C) 2016 surzhin.konstantin
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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "GO_USERS", uniqueConstraints = {
    @UniqueConstraint(name = "uk_user_name", columnNames = {"user_name"})})
@NamedNativeQueries({
    @NamedNativeQuery(name = "GoUser.findByUserName", 
            query = "SELECT id, user_name FROM GO_USERS", 
            resultSetMapping = "GoUserToWeakUser")
     })
@SqlResultSetMapping(name="GoUserToWeakUser", classes = {
    @ConstructorResult(targetClass = User.class, 
    columns = {@ColumnResult(name="id"), @ColumnResult(name="user_name")})
})
public class GoUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String userName;
    private String password;
    private String salt;
    private UserDetails userDetails;
    private UserRole role;

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof GoUser)) {
            return false;
        }
        GoUser other = (GoUser) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.entities.User[ id=" + id + " ]";
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return the userDetails
     */
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_details"), name = "user_detail_id", referencedColumnName = "id")
    public UserDetails getUserDetails() {
        return userDetails;
    }

    /**
     * @param userDetails the userDetails to set
     */
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    /**
     *
     * @return
     */
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_role"), name = "role_id", referencedColumnName = "id")
    public UserRole getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     *
     * @return
     */
    @NotNull
    @Size(min = 1, max = 64)
    @Basic(optional = false)
    @Column(name = "user_name", nullable = false)
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
}
