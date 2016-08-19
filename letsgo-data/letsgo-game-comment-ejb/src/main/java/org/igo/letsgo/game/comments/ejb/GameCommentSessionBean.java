/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.game.comments.ejb;

import javax.ejb.Stateless;
import org.igo.letsgo.remote.IGameCommentRemote;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class GameCommentSessionBean implements IGameCommentRemote {

    @Override
    public String getGameComment(int gameId, int commentId) {
        return "hothing to comment";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
