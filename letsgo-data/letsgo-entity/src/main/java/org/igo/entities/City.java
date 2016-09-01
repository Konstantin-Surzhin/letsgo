/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    private Set<User> usersCollection;

    public City() {
    }

    public City(Integer id) {
        this.id = id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "cityId")
    public Set<User> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Set<User> usersCollection) {
        this.usersCollection = usersCollection;
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
        return "org.igo.ban.ejb.Cities[ id=" + id + " ]";
    }

    /**
     * @return the cityName
     */
     @Column(name = "city_name")
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
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
