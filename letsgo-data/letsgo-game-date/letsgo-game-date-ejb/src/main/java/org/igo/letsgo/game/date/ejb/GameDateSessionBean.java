/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.game.date.ejb;

import org.igo.letsgo.remote.IGameDatesRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class GameDateSessionBean implements IGameDatesRemote {

    @Override
    public List<String> getGameDates() {
        List<String> list = new ArrayList<>();
        list.add("5 марта 1965");
        list.add("6 марта 1965");
        return list;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
