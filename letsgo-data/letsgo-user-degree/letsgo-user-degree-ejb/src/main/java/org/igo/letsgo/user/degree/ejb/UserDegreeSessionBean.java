/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.user.degree.ejb;

import org.igo.letsgo.remote.IUserDegreeRemote;
import javax.ejb.Stateless;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class UserDegreeSessionBean implements IUserDegreeRemote {

    @Override
    public String getUserDegree(final int userId) {
        return "31k";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
