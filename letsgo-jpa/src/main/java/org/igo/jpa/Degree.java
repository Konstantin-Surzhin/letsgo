/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pl
 */
@Entity
@Table(name = "degree", schema = "letsgo")
public class Degree implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String dergeeValue;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof Degree)) {
            return false;
        }
        Degree other = (Degree) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "jpa.Rating[ id=" + id + " ]";
    }

    /**
     * @return the dergeeValue
     */
    @Column(name = "degree_value", length = 255)
    public String getDergeeValue() {
        return dergeeValue;
    }

    /**
     * @param dergeeValue the dergeeValue to set
     */
    public void setDergeeValue(String dergeeValue) {
        this.dergeeValue = dergeeValue;
    }

    public Degree() {
    }

    public Degree(Integer id) {
        this.id = id;
    }
}
