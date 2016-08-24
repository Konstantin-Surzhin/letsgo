/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(catalog = "letsgo", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"degree_value"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Degrees.findAll", query = "SELECT d FROM Degrees d"),
    @NamedQuery(name = "Degrees.findById", query = "SELECT d FROM Degrees d WHERE d.id = :id"),
    @NamedQuery(name = "Degrees.findByDegreeValue", query = "SELECT d FROM Degrees d WHERE d.degreeValue = :degreeValue")})
public class Degrees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Byte id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "degree_value", nullable = false, length = 255)
    private String degreeValue;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "degreeId")
    private Collection<UsersDegrees> usersDegreesCollection;

    public Degrees() {
    }

    public Degrees(Byte id) {
        this.id = id;
    }

    public Degrees(Byte id, String degreeValue) {
        this.id = id;
        this.degreeValue = degreeValue;
    }

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getDegreeValue() {
        return degreeValue;
    }

    public void setDegreeValue(String degreeValue) {
        this.degreeValue = degreeValue;
    }

    @XmlTransient
    public Collection<UsersDegrees> getUsersDegreesCollection() {
        return usersDegreesCollection;
    }

    public void setUsersDegreesCollection(Collection<UsersDegrees> usersDegreesCollection) {
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
        if (!(object instanceof Degrees)) {
            return false;
        }
        Degrees other = (Degrees) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.entities.Degrees[ id=" + id + " ]";
    }
    
}
