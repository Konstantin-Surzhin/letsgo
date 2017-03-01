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
@Table(name = "CLUBS",
        uniqueConstraints = {
            @UniqueConstraint(name = "uk_club_city",
                    columnNames = {"club_name", "city_id"})})
@NamedQueries({
    @NamedQuery(name = "Club.findAll", query = "SELECT c FROM Club c")
    ,@NamedQuery(name = "Club.findById", query = "SELECT c FROM Club c WHERE c.id = :id")
    ,@NamedQuery(name = "Club.findByClubName", query = "SELECT c FROM Club c WHERE c.clubName = :clubName")
    ,@NamedQuery(name = "Club.findClubsByCityId", query = "SELECT t FROM Team t WHERE t.city.id = :cityId")
})
public class Club implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id = -1;
    private String clubName;
    private City city;
    private Country country;
    private Set<League> leagues;
    private Set<Team> teams;

    /**
     *
     */
    public Club() {
    }

    /**
     *
     * @param id
     */
    public Club(int id) {
        this.id = id;
    }

    /**
     *
     * @param clubName
     */
    public Club(final String clubName) {
        this.clubName = clubName;
    }

    /**
     *
     * @return
     */
    @Id
    @Basic(optional = false)
    @GeneratedValue(/**/generator = "club_seq", strategy = GenerationType.TABLE)
    @TableGenerator(
            name = "club_seq",
            table="hibernate_sequences",
            pkColumnName = "sequence_name",
            valueColumnName = "next_val",
            pkColumnValue = "club_seq",
            allocationSize = 10
    )
    //@SequenceGenerator(name = "club_seq", sequenceName = "club_seq", allocationSize = 1)
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Size(min = 1, max = 255)
    @Column(name = "club_name", nullable = false)
    public String getClubName() {
        return clubName;
    }

    /**
     *
     * @param clubName
     */
    public void setClubName(final String clubName) {
        this.clubName = clubName;
    }

    /**
     *
     * @return
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_club_city"), name = "city_id", referencedColumnName = "id")
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.clubName);
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
        final Club other = (Club) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.clubName, other.clubName);
    }

    @Override
    public String toString() {
        return "org.igo.entities.Clubs[ id=" + id + " ]";
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_club_country"), name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void addTeam(final Team team) {
        if (this.teams == null) {
            this.teams = new HashSet<>();
        }
        this.teams.add(team); //todo: clone
    }

    /**
     * @return the teams
     */
    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    public Set<Team> getTeams() {
        return this.teams;

    }

    /**
     * @param teams the teams to set
     */
    public void setTeams(final Set<Team> teams) {
        this.teams = teams;
    }

    /**
     * @return the leagues
     */
    @ManyToMany(mappedBy = "clubs", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    public Set<League> getLeagues() {
        return leagues;
    }

    /**
     * @param leagues the leagues to set
     */
    public void setLeagues(Set<League> leagues) {
        this.leagues = leagues;
    }
}
