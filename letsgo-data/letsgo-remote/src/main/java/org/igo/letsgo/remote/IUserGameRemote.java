/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.remote;

import javax.ejb.Remote;

/**
 *
 * @author surzhin.konstantin
 */
@Remote
public interface IUserGameRemote {

    String getUserGame(final int userId, final int gameId);
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
