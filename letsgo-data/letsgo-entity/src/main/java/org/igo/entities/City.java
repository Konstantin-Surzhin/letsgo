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
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "cities")
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id"),
    @NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName")
})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    //TODO: make i18n
    //private Map<String, String> cityNameMap;
    private String cityName;

    private Set<User> userCollection;

    public City() {
    }

    public City(final Integer id) {
        this.id = id;
    }

    public City(final String cityName) {
       this.cityName= cityName;
    }

//    public City(Integer id, Map<String, String> cityNameMap) {
//        this.id = id;
//        this.cityNameMap = cityName;
//    }
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "cityId")
    public Set<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(final Set<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return cityName;
    }

    /**
     * @return the cityName
     */
    @Size(min = 1,max = 255)
    @Column(length = 255, name = "city_name", nullable = false, unique = true )
    //@Column(length = 255, name = "city_name", nullable = false, unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET utf-8 COLLATE utf8_unicode_ci" )
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
     * @return the cityNameMap
     */
//    @ElementCollection
//    @JoinTable(name = "city_name", joinColumns = @JoinColumn(name = "id"))
//    @MapKeyColumn(name = "locale")
//    @Column(name = "city_name", unique = true)
//    public Map<String, String> getCityNameMap() {
//        return cityNameMap;
//    }
    /**
     * @param cityNameMap the cityNameMap to set
     */
//    public void setCityNameMap(Map<String, String> cityNameMap) {
//        this.cityNameMap = cityNameMap;
//    }
}
