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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "LEAGUES", uniqueConstraints = {
    @UniqueConstraint(name = "uk_league_name", columnNames = {"league_name"})})
@NamedQueries({
    @NamedQuery(name = "League.findAll", query = "SELECT l FROM League l")
    ,@NamedQuery(name = "League.findById", query = "SELECT l FROM League l WHERE l.id = :id")
    ,@NamedQuery(name = "League.findByLeagueName", query = "SELECT l FROM League l WHERE l.leagueName = :leagueName")})
public class League implements Serializable {

    private static final long serialVersionUID = 1L;
    private short id;
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
    public League(short id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param leagueName
     */
    public League(short id, String leagueName) {
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
    @Size(min = 1, max = 255)
    @Column(name = "league_name", nullable = false)
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
        int hash = 5;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.leagueName);
        hash = 23 * hash + Objects.hashCode(this.teamsCollection);
        hash = 23 * hash + Objects.hashCode(this.usersCollection);
        hash = 23 * hash + Objects.hashCode(this.country);
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
        final League other = (League) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "org.igo.ban.ejb.Leagues[ id=" + id + " ]";
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_league_country"), name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
