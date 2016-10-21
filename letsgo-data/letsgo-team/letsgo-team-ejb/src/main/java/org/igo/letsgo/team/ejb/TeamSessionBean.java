/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.team.ejb;

import org.igo.letsgo.remote.ITeamRemote;
import javax.ejb.Stateless;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class TeamSessionBean implements ITeamRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String getTeamName(final int id) {
        return "pleiades";
    }

}
