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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "DEGREES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Degree.findAll", query = "SELECT d FROM Degree d"),
    @NamedQuery(name = "Degree.findById", query = "SELECT d FROM Degree d WHERE d.id = :id"),
    @NamedQuery(name = "Degree.findByDegreeValue", query = "SELECT d FROM Degree d WHERE d.degreeValue = :degreeValue")})
public class Degree implements Serializable {

    private static final long serialVersionUID = 1L;
    private Byte id;
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
    public Degree(Byte id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param degreeValue
     */
    public Degree(Byte id, String degreeValue) {
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
    @Column(name = "degree_value", nullable = false, length = 255, unique = true)
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
    @XmlTransient
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Degree)) {
            return false;
        }
        Degree other = (Degree) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.entities.Degrees[ id=" + id + " ]";
    }
    
}
