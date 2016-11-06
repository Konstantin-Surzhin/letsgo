/*
 * Copyright (C) 2016 pl
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
package org.igo.letsgo.jsf.jsp.city.tech.method;

import org.igo.letsgo.jsf.jsp.city.CityRestClientInterface;
import org.igo.letsgo.jsf.jsp.city.client.rest.CityRESTClient;

/**
 *
 * @author pl
 */
public class CityMsgFabrica {

    public static CityRestClientInterface createMsgManager(String serviceType, String persistenceType ) {
        CityRestClientInterface cmi = null;
        
        switch (serviceType) {
            case "ejb":
                cmi = new CityEJB();
                break;
            case "rest":
                cmi = new CityRESTClient();
                break;
            case "soap":
                cmi = new CitySOAP();
                break;
            case "mq":
                cmi = new CityMQ(); 
                break;
            case "jms":
                cmi =  new CityJMS();
                break;
            default:
               throw new IllegalArgumentException(serviceType + " not found.");

        }
        return cmi;

    }
}
