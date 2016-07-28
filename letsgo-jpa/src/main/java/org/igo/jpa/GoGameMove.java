/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Table;

/**
 *
 * @author surzhin.konstantin
 */
@Embeddable
@Table(name = "go_game_moves",
        catalog = "letsgo", 
        schema = "" )
public class GoGameMove implements Serializable {

    private static final long serialVersionUID = 1L;

    private Character x;
    private Character y;

    /**
     * @return the y
     */
    public Character getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(Character y) {
        this.y = y;
    }

    /**
     * @return the x
     */
    public Character getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(Character x) {
        this.x = x;
    }
}
