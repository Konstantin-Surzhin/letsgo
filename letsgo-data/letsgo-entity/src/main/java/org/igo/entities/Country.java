/*
 * Copyright (C) 2017 surzhin.konstantin
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "COUNTRIES",
        uniqueConstraints = {
            @UniqueConstraint(name = "uk_country_name", columnNames = {"country_name"})
            ,@UniqueConstraint(name = "uk_country_alpha2", columnNames = {"country_alpha2"})
            ,@UniqueConstraint(name = "uk_country_alpha3", columnNames = {"country_alpha3"})
        })
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
    ,@NamedQuery(name = "Country.findById", query = "SELECT c FROM Country c WHERE c.id = :id")
    ,@NamedQuery(name = "Country.findByCountryName", query = "SELECT c FROM Country c WHERE c.countryName = :countryName")
    ,@NamedQuery(name = "Country.findByCountryAlpha2", query = "SELECT c FROM Country c WHERE c.countryCodeAlpha2 = :alpha2")
    ,@NamedQuery(name = "Country.findByCountryAlpha3", query = "SELECT c FROM Country c WHERE c.countryCodeAlpha3 = :alpha3")
    ,@NamedQuery(name = "Country.checkByCountryName", query = "SELECT count(c) FROM Country c WHERE c.countryName = :countryName")
})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    private short id;
    private String countryName;
    private String countryCodeAlpha2;
    private String countryCodeAlpha3;
    private String banner;
    private String nationalEmblem;
//    private Set<UserDetails> user;
    private Set<City> cities;
//    private Set<Club> clubs;
//    private Set<Team> teams;
//    private Set<League> leagues;

    public Country() {

    }

    public Country(String countryName, String countryCodeAlpha2, String countryCodeAlpha3) {
        this.countryName = countryName;
        this.countryCodeAlpha2 = countryCodeAlpha2;
        this.countryCodeAlpha3 = countryCodeAlpha3;
    }

    /**
     * @return the user
     */
//    @OneToMany(mappedBy = "country")
//    public Set<UserDetails> getUser() {
//        return user;
//    }
    /**
     * @param user the user to set
     */
//    public void setUser(Set<UserDetails> user) {
//        this.user = user;
//    }
    /**
     * @return the cities
     */
    @OneToMany(mappedBy = "country", cascade = CascadeType.PERSIST)
    public Set<City> getCities() {
        return cities;
    }

    /**
     * @param cities the cities to set
     */
    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    /**
     * @return the clubs
     */
//    @OneToMany(mappedBy = "country")
//    public Set<Club> getClubs() {
//        return clubs;
//    }
    /**
     * @param clubs the clubs to set
     */
//    public void setClubs(Set<Club> clubs) {
//        this.clubs = clubs;
//    }
    /**
     * @return the teams
     */
//    @OneToMany(mappedBy = "country")
//    public Set<Team> getTeams() {
//        return teams;
//    }
    /**
     * @param teams the teams to set
     * @return
     */
//    public void setTeams(Set<Team> teams) {
//        this.teams = teams;
//    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
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
        final Country other = (Country) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.countryName);
        hash = 89 * hash + Objects.hashCode(this.countryCodeAlpha2);
        hash = 89 * hash + Objects.hashCode(this.countryCodeAlpha3);
        hash = 89 * hash + Objects.hashCode(this.banner);
        hash = 89 * hash + Objects.hashCode(this.nationalEmblem);
        return hash;
    }

    /**
     * @return the countryName
     */
    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "country_name", nullable = false, length = 255)
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the countryCodeAlpha2
     */
    @Size(min = 2, max = 2)
    @Column(name = "country_alpha2", nullable = false, length = 2)
    public String getCountryCodeAlpha2() {
        return countryCodeAlpha2;
    }

    /**
     * @param countryCodeAlpha2 the countryCodeAlpha2 to set
     */
    public void setCountryCodeAlpha2(String countryCodeAlpha2) {
        this.countryCodeAlpha2 = countryCodeAlpha2;
    }

    /**
     * @return the countryCodeAlpha3
     */
    @Size(min = 3, max = 3)
    @Column(name = "country_alpha3", nullable = false, length = 3)
    public String getCountryCodeAlpha3() {
        return countryCodeAlpha3;
    }

    /**
     * @param countryCodeAlpha3 the countryCodeAlpha3 to set
     */
    public void setCountryCodeAlpha3(String countryCodeAlpha3) {
        this.countryCodeAlpha3 = countryCodeAlpha3;
    }

    /**
     * @return the banner
     */
    @Lob
    @Column(columnDefinition = "BLOB", length = 512)
    public String getBanner() {
        return banner;
    }

    /**
     * @param banner the banner to set
     */
    public void setBanner(String banner) {
        this.banner = banner;
    }

    /**
     * @return the nationalEmblem
     */
    @Lob
    @Column(name = "national_emblem", columnDefinition = "BLOB", length = 512)
    public String getNationalEmblem() {
        return nationalEmblem;
    }

    /**
     * @param nationalEmblem the nationalEmblem to set
     */
    public void setNationalEmblem(String nationalEmblem) {
        this.nationalEmblem = nationalEmblem;
    }

    public void addCity(City city) {
        if (this.cities == null) {
            this.cities = new HashSet<>();
        }
        this.cities.add(city);
    }

    /**
     * @return the leagues
     */
//    @OneToMany(mappedBy = "country")
//    public Set<League> getLeagues() {
//        return leagues;
//    }
    /**
     * @param leagues the leagues to set
     */
//    public void setLeagues(Set<League> leagues) {
//        this.leagues = leagues;
//    }
}
