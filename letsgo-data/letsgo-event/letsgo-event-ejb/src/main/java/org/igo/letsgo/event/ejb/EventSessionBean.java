/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.event.ejb;

import javax.ejb.Stateless;
import org.igo.letsgo.remote.IEventRemote;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class EventSessionBean implements IEventRemote {

    /**
     *
     * @param id
     * @return
     */
    @Override
    public String getEvent(int id) {
        return "Russian championship";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
