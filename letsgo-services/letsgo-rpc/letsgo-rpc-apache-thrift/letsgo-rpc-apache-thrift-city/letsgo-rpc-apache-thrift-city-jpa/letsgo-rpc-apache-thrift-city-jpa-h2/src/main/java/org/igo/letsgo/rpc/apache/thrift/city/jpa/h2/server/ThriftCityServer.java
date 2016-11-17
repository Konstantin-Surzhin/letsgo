/*
 * Copyright (C) 2016 surzhin.konstantin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.igo.letsgo.rpc.apache.thrift.city.jpa.h2.server;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author surzhin.konstantin
 */
public class ThriftCityServer {

    /**
     *
     */
    public static CityManager handler;

    /**
     *
     */
    public static CityService.Processor processor;

    /**
     *
     * @param processor
     */
    public static void myserver(CityService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(8080);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            server.serve();
        } catch (TTransportException ex) {
            Logger.getLogger(ThriftCityServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        handler = new  CityManager();
        processor = new CityService.Processor(handler);
        Runnable server = () -> {
            myserver(processor);
        };
        new Thread(server).start();
    }

}
