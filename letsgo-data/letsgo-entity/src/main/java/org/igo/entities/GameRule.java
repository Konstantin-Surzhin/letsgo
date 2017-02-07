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
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "GAME_RULES", uniqueConstraints = {
    @UniqueConstraint(name = "uk_game_rule_name",
            columnNames = {"game_rule_name"})})
public class GameRule implements Serializable {

    private static final long serialVersionUID = 1L;
    private short id;
    private String gameRuleName;

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        int hash = 5;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.gameRuleName);
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
        final GameRule other = (GameRule) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "org.igo.entities.GameRule[ id=" + id + " ]";
    }

    /**
     * @return the gameRuleName
     */
    @Column(name = "game_rule_name", length = 255)
    public String getGameRuleName() {
        return gameRuleName;
    }

    /**
     * @param gameRuleName the gameRuleName to set
     */
    public void setGameRuleName(String gameRuleName) {
        this.gameRuleName = gameRuleName;
    }
}
