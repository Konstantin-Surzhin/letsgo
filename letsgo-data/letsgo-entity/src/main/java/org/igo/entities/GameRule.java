/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "game_rules", catalog = "letsgo", schema = "")
public class GameRule implements Serializable {

    private static final long serialVersionUID = 1L;
    private Short id;
    private String gameRuleName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Short getId() {
        return id;
    }

    public void setId(Short id) {
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
        if (!(object instanceof GameRule)) {
            return false;
        }
        GameRule other = (GameRule) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "org.igo.entities.GameRule[ id=" + id + " ]";
    }

    /**
     * @return the gameRuleName
     */
    @Column(name = "game_rule_name", unique = true, length = 255)
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
