/*
 * Copyright (C) 2016 Surzhin.Konstantin
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
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Surzhin.Konstantin
 */
@Entity
@Table(name = "GAME_STATUS")
public class GameStatus implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private short id;
    private String statusName;
    private List<Game> games;

    /**
     *
     */
    public GameStatus() {
    }

    /**
     *
     * @param id
     */
    public GameStatus(short id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public short getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(short id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.games);
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.statusName);
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
        final GameStatus other = (GameStatus) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "org.igo.entities.GameStatus[ id=" + id + " ]";
    }

    /**
     * @return the statusName
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * @param statusName the statusName to set
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    /**
     * @return the games
     */
    @OneToMany(mappedBy = "gameStatus")
    public List<Game> getGames() {
        return games;
    }

    /**
     * @param games the games to set
     */
    public void setGames(List<Game> games) {
        this.games = games;
    }

}
