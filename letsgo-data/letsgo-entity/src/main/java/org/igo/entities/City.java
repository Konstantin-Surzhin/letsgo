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
import javax.persistence.Version;
import javax.validation.constraints.Size;
import org.igo.transfer.entities.TransferCity;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "CITIES", uniqueConstraints = {
    @UniqueConstraint(name = "uk_city_name", columnNames = {"city_name"})
    ,@UniqueConstraint(name = "uk_lat_lon", columnNames = {"latitude", "longitude"})
})
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
    ,@NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id")
    ,@NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName")
    ,@NamedQuery(name = "City.findByCountryId", query = "SELECT c FROM City c WHERE c.country.id = :countryId")
    ,@NamedQuery(name = "City.checkByCityName", query = "SELECT count(c) FROM City c WHERE c.cityName = :cityName")
})

public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id = -1;
    private short version;
    private float latitude; //широта
    private float longitude; //долгота
    private String cityName;
    private Country country;
    private Set<GoUser> users;
    private Set<Club> clubs;
    private Set<Team> teams;
    private Set<League> leagues;

    /**
     *
     */
    public City() {
    }

    public City(final String cityName) {
        this.cityName = cityName;
    }

    public City(final TransferCity city) {
        this.latitude = city.getLatitude();
        this.longitude = city.getLongitude();
        this.cityName = city.getCityName();
    }

    public City(String cityName, float latitude, float longitude) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     *
     * @return
     */
    @Id
    @TableGenerator(
            name = "CITY_SEQ",
            table = "HIBERNATE_SEQUENCES",
            pkColumnName = "sequence_name",
            valueColumnName = "next_val",
            pkColumnValue = "city",
            allocationSize = 10
    )
    @GeneratedValue(generator = "CITY_SEQ", strategy = GenerationType.TABLE)
    public int getId() {
        return this.id;
    }

    /**
     *
     * @param id
     */
    public final void setId(final Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @OneToMany(mappedBy = "city",
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    public Set<GoUser> getUsers() {
        return this.users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(final Set<GoUser> users) {
        this.users = users;
    }

    /**
     *
     * @param user
     */
    public void addUser(final GoUser user) {
        if (this.users == null) {
            this.users = new HashSet<>();
        }
        this.users.add(user);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.cityName);
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
        final City other = (City) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.cityName, other.cityName);
    }

    @Override
    public String toString() {
        return cityName;
    }

    /**
     * @return the cityName
     */
    @Size(min = 1, max = 255)
    @Column(length = 255, name = "city_name", nullable = false)
    public String getCityName() {
        return this.cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    /**
     *
     * @return
     */
    @OneToMany(mappedBy = "city",
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    public Set<Club> getClubs() {
        return this.clubs;
    }

    /**
     *
     * @param clubs
     */
    public void setClubs(final Set<Club> clubs) {
        this.clubs = clubs;
    }

    public float getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(final float latitude) {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException(latitude + " :latitude too mast bee -90 < x < 90");
        }

        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public float getLongitude() {
        return this.longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(final float longitude) {
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException(longitude + " :longitude too mast bee -90 < x < 90");
        }
        this.longitude = longitude;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_city_country"), name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country;
    }

    public void addClub(final Club club) {
        if (this.clubs == null) {
            this.clubs = new HashSet<>();
        }
        this.clubs.add(club);
    }

    public void addTeam(final Team team) {
        if (this.teams == null) {
            this.teams = new HashSet<>();
        }
        this.teams.add(team);
    }

    /**
     * @return the teams
     */
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
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
     * @return the version
     */
    @Version
    public short getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(short version) {
        this.version = version;
    }

    /**
     * @return the leagues
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinTable(name = "LEAGUES_CITIES",
            joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "fk_city"), name = "city_id"),
            inverseJoinColumns = @JoinColumn(name = "league_id")
    )
    public Set<League> getLeagues() {
        return leagues;
    }

    /**
     * @param leagues the leagues to set
     */
    public void setLeagues(final Set<League> leagues) {
        this.leagues = leagues;
    }

    public void addLeague(final League league) {
        if (this.leagues == null) {
            this.leagues = new HashSet<>();
        }
        this.leagues.add(league);
    }

    public void removeLeague(League league) {
        if (this.leagues != null) {
            boolean b = this.leagues.remove(league);
        }
    }
}
