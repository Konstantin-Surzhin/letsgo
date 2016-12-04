/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.monitoring.jvm.utils;

import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import sun.jvmstat.monitor.Monitor;
import sun.jvmstat.monitor.MonitorException;
import sun.jvmstat.monitor.MonitoredHost;
import sun.jvmstat.monitor.MonitoredVm;
import sun.jvmstat.monitor.VmIdentifier;

/**
 * REST Web Service
 *
 * @author pl
 */
@Path("vm")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of
     * org.igo.letsgo.monitoring.jvm.utils.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        final StringBuilder sb = new StringBuilder();
        try {
            final MonitoredHost host = MonitoredHost.getMonitoredHost("localhost");
            for (Integer vmId : host.activeVms()) {
                final MonitoredVm vm = host.getMonitoredVm(new VmIdentifier(Integer.toString(vmId)));
                final Object cm = vm.findByName("sun.rt.javaCommand").getValue();
                sb.append(vmId).append(" : ").append(cm).append("\n");
            }
        } catch (MonitorException | URISyntaxException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
    /**
     * Retrieves representation of an instance of
     * org.igo.letsgo.monitoring.jvm.utils.GenericResource
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml(@PathParam("id") Integer id) {
        final StringBuilder sb = new StringBuilder();
        
        try {
            final MonitoredHost host = MonitoredHost.getMonitoredHost("localhost");
            final MonitoredVm vm = host.getMonitoredVm(new VmIdentifier(Integer.toString(id)));
            
            for (Monitor monitor : vm.findByPattern(".*")) {
                sb.append(monitor.getName()).append(" = ").append(monitor.getValue()).append("\n");
            }
        } catch (MonitorException | URISyntaxException ex) {
            Logger.getLogger(GenericResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
