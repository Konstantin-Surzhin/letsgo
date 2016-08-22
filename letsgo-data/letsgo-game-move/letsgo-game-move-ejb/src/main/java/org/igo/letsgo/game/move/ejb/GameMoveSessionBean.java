/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.game.move.ejb;

import org.igo.letsgo.remote.IGameMoveRemote;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class GameMoveSessionBean implements IGameMoveRemote {

    @Override
    public List<String> getGameMoves() {
        List<String> list = new ArrayList<>();
        list.add("1,1");
        list.add("1,2");
        return list;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
