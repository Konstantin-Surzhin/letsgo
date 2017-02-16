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
import java.util.Arrays;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
    ,@UniqueConstraint(name = "uk_oktmo", columnNames = {"oktmo"})
})
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
    ,@NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id")
    ,@NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName")
    ,@NamedQuery(name = "City.findByOktmo", query = "SELECT c FROM City c WHERE c.oktmo = :oktmo")
    ,@NamedQuery(name = "City.findByCountryId", query = "SELECT c FROM City c WHERE c.country.id = :countryId")
    ,@NamedQuery(name = "City.checkByCityName", query = "SELECT count(c) FROM City c WHERE c.cityName = :cityName")
})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private float latitude; //широта
    private float longitude; //долгота
    private String cityName;
    private char[] oktmo;
    private Country country;
    //private Set<UserDetails> users;
    private Set<Club> clubs;
    private Set<Team> teams;

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
        this.oktmo = city.getOktmo();
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
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
//    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
//    public Set<UserDetails> getUsers() {
//        if (this.users != null) {
//            return new HashSet<>(this.users);
//        } else {
//            return new HashSet<>();
//        }
//    }
//    /**
//     *
//     * @param users
//     */
//    public void setUsers(final Set<UserDetails> users) {
//        if (users != null) {
//            this.users = new HashSet<>(users);
//        } else {
//            this.users = new HashSet<>();
//        }
//    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final City other = (City) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Float.floatToIntBits(this.latitude);
        hash = 29 * hash + Float.floatToIntBits(this.longitude);
        hash = 29 * hash + Objects.hashCode(this.cityName);
        hash = 29 * hash + Arrays.hashCode(this.oktmo);
        return hash;
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
        return cityName;
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
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "city")
    public Set<Club> getClubs() {
        if (this.clubs != null) {
            return new HashSet<>(this.clubs);
        } else {
            return new HashSet<>();
        }
    }

    /**
     *
     * @param clubs
     */
    public void setClubs(final Set<Club> clubs) {
        this.clubs = new HashSet<>(clubs);
    }

    /**
     * @return the oktmo
     */
    @Size(min = 8, max = 8)
    @Column(columnDefinition = "CHAR(8)")
    public char[] getOktmo() {
        return oktmo;
    }

    /**
     * @param oktmo the oktmo to set
     */
    public void setOktmo(final char[] oktmo) {
        this.oktmo = oktmo;
    }

    public float getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(final float latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public float getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(final float longitude) {
        this.longitude = longitude;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_city_country"), name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(final Country country) {
        this.country = country; //todo: clone
    }

    public void addClub(final Club club) {
        if (this.clubs == null) {
            this.clubs = new HashSet<>();
        }
        this.clubs.add(club); //todo: clone
    }

    public void addTeam(final Team team) {
        if (this.getTeams() == null) {
            this.setTeams(new HashSet<>());
        }
        this.getTeams().add(team); //todo: clone
    }

    /**
     * @return the teams
     */
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    public Set<Team> getTeams() {
        if (this.teams != null) {
            return new HashSet<>(this.teams);
        } else {
            return new HashSet<>();
        }
    }

    /**
     * @param teams the teams to set
     */
    public void setTeams(Set<Team> teams) {
        this.teams = new HashSet<>(teams);
    }
}
