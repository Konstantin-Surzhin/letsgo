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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "CLUBS",
        uniqueConstraints = {
            @UniqueConstraint(name = "uk_city_club",
                    columnNames = {"city_id", "club_name"})})
@NamedQueries({
    @NamedQuery(name = "Club.findAll", query = "SELECT c FROM Club c")
    , @NamedQuery(name = "Club.findById", query = "SELECT c FROM Club c WHERE c.id = :id")
    , @NamedQuery(name = "Club.findByClubName", query = "SELECT c FROM Club c WHERE c.clubName = :clubName")})
public class Club implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String clubName;
    private City city;
    private Country country;

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
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Column(name = "club_name")
    public String getClubName() {
        return clubName;
    }

    /**
     *
     * @param clubName
     */
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    /**
     *
     * @return
     */
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_club_city"), name = "city_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
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
        hash = 29 * hash + Objects.hashCode(this.city);
        hash = 29 * hash + Objects.hashCode(this.country);
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
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "org.igo.entities.Clubs[ id=" + id + " ]";
    }

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_club_country"), name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

}
