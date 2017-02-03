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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "LEAGUES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "League.findAll", query = "SELECT l FROM League l"),
    @NamedQuery(name = "League.findById", query = "SELECT l FROM League l WHERE l.id = :id"),
    @NamedQuery(name = "League.findByLeagueName", query = "SELECT l FROM League l WHERE l.leagueName = :leagueName")})
public class League implements Serializable {

    private static final long serialVersionUID = 1L;
    private Short id;
    private String leagueName;
    private Collection<Team> teamsCollection;
    private Collection<UserDetails> usersCollection;
    private Country country;

    /**
     *
     */
    public League() {
    }

    /**
     *
     * @param id
     */
    public League(Short id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param leagueName
     */
    public League(Short id, String leagueName) {
        this.id = id;
        this.leagueName = leagueName;
    }

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    public Short getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "league_name",nullable = false, unique = true)
    public String getLeagueName() {
        return leagueName;
    }

    /**
     *
     * @param leagueName
     */
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    /**
     *
     * @return
     */
    @OneToMany(mappedBy = "league")
    @XmlTransient
    public Collection<Team> getTeamsCollection() {
        return teamsCollection;
    }

    /**
     *
     * @param teamsCollection
     */
    public void setTeamsCollection(Collection<Team> teamsCollection) {
        this.teamsCollection = teamsCollection;
    }

    /**
     *
     * @return
     */
    @OneToMany(mappedBy = "league")
    @XmlTransient
    public Collection<UserDetails> getUsersCollection() {
        return usersCollection;
    }

    /**
     *
     * @param usersCollection
     */
    public void setUsersCollection(Collection<UserDetails> usersCollection) {
        this.usersCollection = usersCollection;
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
        if (!(object instanceof League)) {
            return false;
        }
        League other = (League) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.ban.ejb.Leagues[ id=" + id + " ]";
    }

    @ManyToOne
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
