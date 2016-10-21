/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.league.ejb;

import org.igo.letsgo.remote.ILeagueRemote;
import javax.ejb.Stateless;

/**
 *
 * @author martin
 */
@Stateless
public class LeagueSessionBean implements ILeagueRemote {

    @Override
    public String getLeague(int id) {
        return "Ivy League";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
