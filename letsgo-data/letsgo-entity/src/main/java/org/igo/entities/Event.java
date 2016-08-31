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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "events", catalog = "letsgo", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findById", query = "SELECT e FROM Event e WHERE e.id = :id"),
    @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventName = :eventName")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    private Short id;
    private String eventName;
    private Collection<Game> gamesCollection;

    public Event() {
    }

    public Event(Short id) {
        this.id = id;
    }

    public Event(Short id, String eventName) {
        this.id = id;
        this.eventName = eventName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    @Basic(optional = false)
    @Size(min = 1, max = 255)
    @Column(name = "event_name", nullable = false, length = 255, unique = true)
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @OneToMany(mappedBy = "eventId")
    @XmlTransient
    public Collection<Game> getGamesCollection() {
        return gamesCollection;
    }

    public void setGamesCollection(Collection<Game> gamesCollection) {
        this.gamesCollection = gamesCollection;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.entities.Events[ id=" + id + " ]";
    }

}
