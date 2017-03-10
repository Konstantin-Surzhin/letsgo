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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
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
    private Country country;
    private Set<Team> teams;
    private Set<Club> clubs;
    private Set<GoUser> users;
    private Set<City> cities;

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
     * @param leagueName
     */
    public League(String leagueName) {
        this.leagueName = leagueName;
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
    @Basic(optional = false)
    @GeneratedValue(/**/generator = "league_seq", strategy = GenerationType.TABLE)
    @TableGenerator(
            name = "league_seq",
            table = "hibernate_sequences",
            pkColumnName = "sequence_name",
            valueColumnName = "next_val",
            pkColumnValue = "league_seq",
            allocationSize = 10
    )
    //@SequenceGenerator(name = "league_seq", sequenceName = "league_seq", allocationSize = 1)
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
    public Collection<Team> getTeams() {
        return teams;
    }

    /**
     *
     * @param teams
     */
    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    /**
     *
     * @return
     */
    @OneToMany(mappedBy = "league")
    public Set<GoUser> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(Set<GoUser> users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.leagueName);
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
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.leagueName, other.leagueName);
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

    public void addClub(Club club) {
        if (this.clubs == null) {
            this.clubs = new HashSet<>();
        }
        this.clubs.add(club);
    }

    /**
     * @return the clubs
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_league_club"), name = "league_id", referencedColumnName = "id")
    public Set<Club> getClubs() {
        return clubs;
    }

    /**
     * @param clubs the clubs to set
     */
    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }

    /**
     * @return the cities
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "leagues_cities",
            joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "fk_league"), name = "league_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    public Set<City> getCities() {
        return cities;
    }

    /**
     * @param cities the cities to set
     */
    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

}
