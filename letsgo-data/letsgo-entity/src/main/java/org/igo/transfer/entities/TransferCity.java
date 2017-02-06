/*
 * Copyright (C) 2017 surzhin.konstantin
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
package org.igo.transfer.entities;

import javax.xml.bind.annotation.XmlRootElement;
import org.igo.entities.City;

/**
 *
 * @author surzhin.konstantin
 */
@XmlRootElement
public class TransferCity {

    private int id;
    private long latitude;
    private long longitude;
    private String cityName;
    private String oktmo;

    public TransferCity(final City city) {
        this.id = city.getId();
        this.latitude = city.getLatitude();
        this.longitude = city.getLongitude();
        this.cityName  = city.getCityName();
        this.oktmo = city.getOktmo();
    }


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the latitude
     */
    public long getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public long getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return the oktmo
     */
    public String getOktmo() {
        return oktmo;
    }

    /**
     * @param oktmo the oktmo to set
     */
    public void setOktmo(String oktmo) {
        this.oktmo = oktmo;
    }
}
