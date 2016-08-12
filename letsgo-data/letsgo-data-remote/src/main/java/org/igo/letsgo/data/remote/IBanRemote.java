/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.data.remote;

import javax.ejb.Remote;

/**
 *
 * @author surzhin.konstantin
 */
@Remote
public interface IBanRemote {

    public int count();
}
