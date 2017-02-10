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
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
            ,@UniqueConstraint(name = "uk_country_banner", columnNames = {"banner"})
            ,@UniqueConstraint(name = "uk_country_national_emblem", columnNames = {"national_emblem"})
        })
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String countryName;
    private String countryCodeAlpha2;
    private String countryCodeAlpha3;
    private String banner;
    private String nationalEmblem;
    private Set<UserDetails> user;
    private Set<City> cities;
    private Set<Club> clubs;
    private Set<Team> teams;
    private Set<League> leagues;

    /**
     * @return the user
     */
    @OneToMany(mappedBy = "country")
    public Set<UserDetails> getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Set<UserDetails> user) {
        this.user = user;
    }

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
    @OneToMany(mappedBy = "country")
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
     * @return the teams
     */
    @OneToMany(mappedBy = "country")
    public Set<Team> getTeams() {
        return teams;
    }

    /**
     * @param teams the teams to set
     */
    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        hash = 89 * hash + Objects.hashCode(this.user);
        hash = 89 * hash + Objects.hashCode(this.cities);
        hash = 89 * hash + Objects.hashCode(this.clubs);
        hash = 89 * hash + Objects.hashCode(this.teams);
        hash = 89 * hash + Objects.hashCode(this.leagues);
        return hash;
    }

    /**
     * @return the countryName
     */
    @Basic(optional = false)
    @Column(name = "country_name", nullable = false)
    @Size(min = 1, max = 255)
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
    @Column(name = "national_emblem")
    public String getNationalEmblem() {
        return nationalEmblem;
    }

    /**
     * @param nationalEmblem the nationalEmblem to set
     */
    public void setNationalEmblem(String nationalEmblem) {
        this.nationalEmblem = nationalEmblem;
    }

    /**
     * @return the leagues
     */
    @OneToMany(mappedBy = "country")
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
