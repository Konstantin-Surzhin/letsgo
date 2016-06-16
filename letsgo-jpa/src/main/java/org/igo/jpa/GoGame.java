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
package org.igo.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "go_game", catalog = "letsgo", schema = "")
@NamedQueries({
    @NamedQuery(name = "GoGame.findAll", query = "SELECT g FROM GoGame g"),
    @NamedQuery(name = "GoGame.findById", query = "SELECT g FROM GoGame g WHERE g.id = :id")})
public class GoGame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne
    private GoGameDetail goGameDetail;

    @ElementCollection
    @CollectionTable(
            name = "go_game_moves",
            joinColumns = @JoinColumn(name = "game_id")
    )
    @OrderColumn(name = "ndx")
    private List<GoGameMove> goGameMoves;

    public GoGame() {
    }

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
        if (object == null) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        GoGame other = (GoGame) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.GoGame[ id=" + id + " ]";
    }

    /**
     * @return the goGameDetail
     */
    public GoGameDetail getGoGameDetail() {
        return goGameDetail;
    }

    /**
     * @param goGameDetail the goGameDetail to set
     */
    public void setGoGameDetail(GoGameDetail goGameDetail) {
        this.goGameDetail = goGameDetail;
    }

    /**
     * @return the goGameMoves
     */
    public List<GoGameMove> getGoGameMoves() {
        return goGameMoves;
    }

    /**
     * @param goGameMoves the goGameMoves to set
     */
    public void setGoGameMoves(List<GoGameMove> goGameMoves) {
        this.goGameMoves = goGameMoves;
    }
}

