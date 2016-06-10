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
package org.igo;

import org.igo.letsgo.jpa.GoGame;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class GameBean implements IGameRemote, IGameLocal {
// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")

    private EntityManager em;
    
    @Override
    public String getString() {
        return "Hello EJB World!";
    }

    @Override
    public Integer create() {
        GoGame game = new GoGame();
        getEm().persist(game);
        getEm().flush();
        return game.getId();
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    @PersistenceContext
    public void setEm(EntityManager em) {
        this.em = em;
    }

}
