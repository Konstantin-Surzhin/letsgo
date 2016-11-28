/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.user.role.ejb;

import javax.ejb.Stateless;
import org.igo.letsgo.remote.IUserRoleRemote;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class UserRoleSessionBean implements IUserRoleRemote {

    @Override
    public String getRole(int id) {
        return "REGULAR";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
