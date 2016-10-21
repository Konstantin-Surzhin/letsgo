/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.move.comment.ejb;

import org.igo.letsgo.remote.IMoveCommentRemote;
import javax.ejb.Stateless;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class MoveCommentSessionBean implements IMoveCommentRemote {

    @Override
    public String getMoveComment(int gameId, int moveId, int commentId) {
        return "no comment";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
