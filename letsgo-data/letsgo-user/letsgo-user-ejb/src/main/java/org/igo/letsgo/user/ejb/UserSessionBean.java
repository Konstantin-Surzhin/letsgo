/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.user.ejb;

import org.igo.letsgo.remote.IUserRemote;
import javax.ejb.Stateless;

/**
 *
 *  @author surzhin.konstantin
 */
@Stateless
public class UserSessionBean implements IUserRemote {

    @Override
    public String getUserName(final int id) {
        return "surzhin.konstantin";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
