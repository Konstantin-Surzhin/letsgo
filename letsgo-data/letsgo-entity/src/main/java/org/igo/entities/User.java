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
import java.net.URI;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author surzhin.konstantin
 */
@XmlRootElement(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private URI uri;
    private String user_name;

    /**
     *
     */
    public User() {
    }

    /**
     *
     * @param id
     * @param user_name
     */
    public User(final int id, final String user_name) {
        this.id = id;
        this.user_name = user_name;
    }

    /**
     * @return the id
     */
    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return the user_name
     */
    @XmlElement(name = "name")
    public String getUserName() {
        return user_name;
    }

    /**
     * @param user_name the user_name to set
     */
    public void setUserName(final String user_name) {
        this.user_name = user_name;
    }

    /**
     * @return the uri
     */
    @XmlAttribute(name = "uri")
    public String getUri() {
        final StringBuilder sb = new StringBuilder(uri.toString());
        sb.append("/").append(id);
        
        return sb.toString();
    }

    /**
     * @param uri the uri to set
     */
    public void setUri(URI uri) {
        this.uri = uri;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        hash = 19 * hash + Objects.hashCode(this.uri);
        hash = 19 * hash + Objects.hashCode(this.user_name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.user_name, other.user_name)) {
            return false;
        }
        return Objects.equals(this.uri, other.uri);
    }

}
