/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.room.ejb;

import org.igo.letsgo.remote.IRoomRemote;
import javax.ejb.Stateless;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class RoomSessionBean implements IRoomRemote {

    @Override
    public String getRoom(int id) {
        return "Moscow room";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
