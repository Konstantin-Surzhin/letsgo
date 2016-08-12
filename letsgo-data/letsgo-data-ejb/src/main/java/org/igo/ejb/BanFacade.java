/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.ejb;

import org.igo.letsgo.data.remote.IBanRemote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.igo.entities.Ban;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class BanFacade extends AbstractFacade<Ban> implements IBanRemote{

    @PersistenceContext(unitName = "gamePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BanFacade() {
        super(Ban.class);
    }
    
}
