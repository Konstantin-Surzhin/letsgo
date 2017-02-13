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
@Table(name = "TEAMS", uniqueConstraints = {
    @UniqueConstraint(name = "uk_team_name", columnNames = {"team_name"})})
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")
    ,@NamedQuery(name = "Team.findById", query = "SELECT t FROM Team t WHERE t.id = :id")
    ,@NamedQuery(name = "Team.findByTeamName", query = "SELECT t FROM Team t WHERE t.teamName = :teamName")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    private short id;
    private String teamName;
    private League league;
    private Collection<UserDetails> users;
    private City city;
    private Country country;

    /**
     *
     */
    public Team() {
    }

    /**
     *
     * @param id
     */
    public Team(short id) {
        this.id = id;
    }

    /**
     *
     * @param teamName
     */
    public Team(String teamName) {
        this.teamName = teamName;
    }

    /**
     *
     * @param id
     * @param teamName
     */
    public Team(short id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    /**
     *
     * @return id
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
     * @return teamName
     */
    @Basic(optional = false)
    @Column(name = "team_name", nullable = false)
    @Size(min = 1, max = 255)
    public String getTeamName() {
        return teamName;
    }

    /**
     *
     * @param teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     *
     * @return league
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_team_league"), name = "league_id", referencedColumnName = "id")
    public League getLeague() {
        return league;
    }

    /**
     *
     * @param league
     */
    public void setLeague(League league) {
        this.league = league;
    }

    /**
     *
     * @return
     */
    @OneToMany(mappedBy = "team")
    public Collection<UserDetails> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(Collection<UserDetails> users) {
        this.users = users;
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
        final Team other = (Team) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.teamName);
        hash = 97 * hash + Objects.hashCode(this.league);
        hash = 97 * hash + Objects.hashCode(this.users);
        hash = 97 * hash + Objects.hashCode(this.city);
        hash = 97 * hash + Objects.hashCode(this.country);
        return hash;
    }

    @Override
    public String toString() {
        return "org.igo.ban.ejb.Teams[ id=" + id + " ]";
    }

    /**
     * @return the city
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_team_city"), name = "city_id", referencedColumnName = "id")
    public City getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(final City city) {
        this.city = city;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_team_country"), name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

}
