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
package org.igo.letsgo.rpc.apache.thrift.city.jpa.h2.client;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.igo.letsgo.rpc.apache.thrift.city.jpa.h2.server.CityService;

/**
 *
 * @author surzhin.konstantin
 */
public class ThriftCityClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (TTransport transport = new TSocket("localhost", 8080)) {
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            CityService.Client client = new CityService.Client(protocol);

            System.out.println(client.addCity("Тула"));
        } catch (TException ex) {
            Logger.getLogger(ThriftCityClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
