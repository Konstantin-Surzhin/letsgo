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
package org.igo.entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import org.jboss.resteasy.links.RESTServiceDiscovery;

/**
 *
 * @author surzhin.konstantin
 */
@XmlRootElement
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @XmlID
    private String id;
    @XmlAttribute
    private String user_name;
    @XmlElementRef
    private RESTServiceDiscovery rest;

    public User() {
    }

    public User(final Integer id, final String user_name) {
        this.id = id.toString();
        this.user_name = user_name;
    }
}
