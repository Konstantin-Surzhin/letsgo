/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.igo.entities.MovesComments;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class MovesCommentsFacade extends AbstractFacade<MovesComments> {

    @PersistenceContext(unitName = "gamePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovesCommentsFacade() {
        super(MovesComments.class);
    }
    
}
