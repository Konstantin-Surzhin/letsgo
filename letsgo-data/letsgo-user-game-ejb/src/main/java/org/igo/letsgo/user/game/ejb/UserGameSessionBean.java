/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.user.game.ejb;

import org.igo.letsgo.remote.IUserGameRemote;
import javax.ejb.Stateless;

/**
 *
 * @author martin
 */
@Stateless
public class UserGameSessionBean implements IUserGameRemote {

    @Override
    public String getUserGame(final int userId, final int gameId ) {
        
        return "no game";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
