/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.place.ejb;


import javax.ejb.Stateless;
import org.igo.letsgo.remote.IPlaceRemote;

/**
 *
 * @author surzhin.konstantin
 */
@Stateless
public class PlaceSessionBean  implements IPlaceRemote{

    @Override
    public String getPlaceTitle(int id) {
        return "Moskow";
    }
    
}
