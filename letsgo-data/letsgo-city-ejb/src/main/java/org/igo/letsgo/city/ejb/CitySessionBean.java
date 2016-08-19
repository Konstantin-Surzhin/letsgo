/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.city.ejb;

import javax.ejb.Stateless;
import org.igo.letsgo.remote.ICityRemote;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class CitySessionBean implements ICityRemote {

    @Override
    public String getCity(int id) {
        return "Moskow";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
