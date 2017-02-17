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
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
            query = "SELECT id, user_name FROM GO_USERS order by user_name",
            resultSetMapping = "GoUserToWeakUser")
})
@SqlResultSetMapping(name = "GoUserToWeakUser", classes = {
    @ConstructorResult(targetClass = User.class,
            columns = {
                @ColumnResult(name = "id")
                ,@ColumnResult(name = "user_name")})
})
public class GoUser implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String userName;
    private City city;
    private UserRole role;

    private UserDetails userDetails;

    public GoUser() {
    }

    public GoUser(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.userName);
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
        final GoUser other = (GoUser) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "org.igo.entities.User[ id=" + id + " ]";
    }

    /**
     * @return the userDetails
     */
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
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

    /**
     *
     * @return
     */
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_city"), name = "city_id", referencedColumnName = "id")
    public City getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(City city) {
        this.city = city;
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
}
