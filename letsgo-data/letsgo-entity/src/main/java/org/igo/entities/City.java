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
import java.util.Objects;
import java.util.Set;
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
import org.igo.transfer.entities.TransferCity;
//import javax.validation.constraints.Size;

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
    ,@NamedQuery(name = "City.checkByCityName", query = "SELECT count(c) FROM City c WHERE c.cityName = :cityName")
})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private long latitude;
    private long longitude;
    private String cityName;
    private String oktmo;
    private Country country;
    private Set<UserDetails> user;
    private Set<Club> clubs;
    private Set<Team> teams;

    /**
     *
     */
    public City() {
    }

    public City(TransferCity city) {
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
    @Basic(optional = false)
    @Column(name = "id")
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
    @OneToMany(mappedBy = "city")
    public Set<UserDetails> getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(final Set<UserDetails> user) {
        this.user = user;
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
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
        hash = 29 * hash + (int) (this.latitude ^ (this.latitude >>> 32));
        hash = 29 * hash + (int) (this.longitude ^ (this.longitude >>> 32));
        hash = 29 * hash + Objects.hashCode(this.cityName);
        hash = 29 * hash + Objects.hashCode(this.oktmo);
        hash = 29 * hash + Objects.hashCode(this.country);
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + Objects.hashCode(this.clubs);
        hash = 29 * hash + Objects.hashCode(this.teams);
        return hash;
    }


    @Override
    public String toString() {
        return cityName;
    }

    /**
     * @return the cityName
     */
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    public Set<Club> getClubs() {
        return clubs;
    }

    /**
     *
     * @param clubs
     */
    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }

    /**
     * @return the oktmo
     */
    public String getOktmo() {
        return oktmo;
    }

    /**
     * @param oktmo the oktmo to set
     */
    public void setOktmo(String oktmo) {
        this.oktmo = oktmo;
    }

    /**
     * @return the teams
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    public Set<Team> getTeams() {
        return teams;
    }

    /**
     * @param teams the teams to set
     */
    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    /**
     * @return the latitude
     */
    public long getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public long getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_city_country"), name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
