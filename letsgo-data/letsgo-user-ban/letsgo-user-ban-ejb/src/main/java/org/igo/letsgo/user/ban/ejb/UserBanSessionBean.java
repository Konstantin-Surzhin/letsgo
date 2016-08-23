/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.user.ban.ejb;

import org.igo.letsgo.remote.IUserBanRemote;
import javax.ejb.Stateless;

/**
 *
 * @author martin
 */
@Stateless
public class UserBanSessionBean implements IUserBanRemote {

    @Override
    public String getBan(final int id) {
        return "no ban";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
