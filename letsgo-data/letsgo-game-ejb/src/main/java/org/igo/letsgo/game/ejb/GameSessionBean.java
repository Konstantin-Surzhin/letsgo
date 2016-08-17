/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.game.ejb;

import javax.ejb.Stateless;
import org.igo.remote.IGameRemote;

/**
 *
 * @author martin
 */
@Stateless
public class GameSessionBean implements IGameRemote {

    @Override
    public String getGame(int id) {
        return "Leningrad";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
