/*
 * Copyright (C) 2016 kostya surzhin
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
 * @author kostya surzhin
 */
@Entity
@Table(name = "degree")
public class Degree implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String dergeeValue;

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (object == null) {
            return false;
        }

        if (object.getClass() != Degree.class) {
            return false;
        }

        Degree other = (Degree) object;

        if (!other.dergeeValue.equals(dergeeValue)) {
            return false;
        }

        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return dergeeValue;
    }

    /**
     * @return the dergeeValue
     */
    @Column(name = "degree_value",
            unique = true,
            nullable = false)
    public String getDergeeValue() {
        return dergeeValue;
    }

    /**
     * @param dergeeValue the dergeeValue to set
     */
    public void setDergeeValue(String dergeeValue) {
        this.dergeeValue = dergeeValue;
    }

    /**
     *
     */
    public Degree() {
    }

    /**
     *
     * @param id
     */
    public Degree(Integer id) {
        this.id = id;
    }
}
