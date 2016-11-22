/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "LEAGUES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "League.findAll", query = "SELECT l FROM League l"),
    @NamedQuery(name = "League.findById", query = "SELECT l FROM League l WHERE l.id = :id"),
    @NamedQuery(name = "League.findByLeagueName", query = "SELECT l FROM League l WHERE l.leagueName = :leagueName")})
public class League implements Serializable {

    private static final long serialVersionUID = 1L;
    private Short id;
    private String leagueName;
    private Collection<Team> teamsCollection;
    private Collection<UserDetails> usersCollection;

    public League() {
    }

    public League(Short id) {
        this.id = id;
    }

    public League(Short id, String leagueName) {
        this.id = id;
        this.leagueName = leagueName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "league_name",nullable = false, unique = true)
    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    @OneToMany(mappedBy = "leagueId")
    @XmlTransient
    public Collection<Team> getTeamsCollection() {
        return teamsCollection;
    }

    public void setTeamsCollection(Collection<Team> teamsCollection) {
        this.teamsCollection = teamsCollection;
    }

    @OneToMany(mappedBy = "league")
    @XmlTransient
    public Collection<UserDetails> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<UserDetails> usersCollection) {
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
        if (!(object instanceof League)) {
            return false;
        }
        League other = (League) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.ban.ejb.Leagues[ id=" + id + " ]";
    }

}
