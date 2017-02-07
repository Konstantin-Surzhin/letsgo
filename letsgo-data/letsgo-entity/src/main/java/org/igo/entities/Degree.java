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
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "DEGREES", uniqueConstraints = {
    @UniqueConstraint(name = "uk_degree_value", columnNames = {"degree_value"})})
@NamedQueries({
    @NamedQuery(name = "Degree.findAll", query = "SELECT d FROM Degree d")
    ,@NamedQuery(name = "Degree.findById", query = "SELECT d FROM Degree d WHERE d.id = :id")
    ,@NamedQuery(name = "Degree.findByDegreeValue", query = "SELECT d FROM Degree d WHERE d.degreeValue = :degreeValue")})
public class Degree implements Serializable {

    private static final long serialVersionUID = 1L;
    private byte id;
    private String degreeValue;
    private Collection<UserDegree> usersDegreesCollection;

    /**
     *
     */
    public Degree() {
    }

    /**
     *
     * @param id
     */
    public Degree(byte id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param degreeValue
     */
    public Degree(byte id, String degreeValue) {
        this.id = id;
        this.degreeValue = degreeValue;
    }

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    public Byte getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Byte id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "degree_value", nullable = false, length = 255)
    public String getDegreeValue() {
        return degreeValue;
    }

    /**
     *
     * @param degreeValue
     */
    public void setDegreeValue(String degreeValue) {
        this.degreeValue = degreeValue;
    }

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "degree")
    public Collection<UserDegree> getUsersDegreesCollection() {
        return usersDegreesCollection;
    }

    /**
     *
     * @param usersDegreesCollection
     */
    public void setUsersDegreesCollection(Collection<UserDegree> usersDegreesCollection) {
        this.usersDegreesCollection = usersDegreesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.degreeValue);
        hash = 61 * hash + Objects.hashCode(this.usersDegreesCollection);
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
        final Degree other = (Degree) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "org.igo.entities.Degrees[ id=" + id + " ]";
    }

}
