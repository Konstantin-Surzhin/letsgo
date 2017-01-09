/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.remote;

import javax.ejb.Remote;

/**
 *
 * @author surzhin.konstantin
 */
@Remote
public interface IUserRemote {

    /**
     *
     * @param id
     * @return
     */
    public String getUserName(final int id);
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
