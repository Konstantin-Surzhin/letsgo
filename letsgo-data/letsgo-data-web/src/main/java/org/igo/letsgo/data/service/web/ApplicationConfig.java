/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.data.service.web;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author surzhin.konstantin
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.igo.letsgo.data.service.web.BanFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.CityFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.DegreeFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.EventFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.GameCommentFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.GameDateFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.GameFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.GameMoveFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.LeagueFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.MoveCommentFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.PlaceFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.RoleFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.RoomFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.TeamFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.UserDegreeFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.UserFacadeREST.class);
        resources.add(org.igo.letsgo.data.service.web.UserGameFacadeREST.class);
    }
    
}
