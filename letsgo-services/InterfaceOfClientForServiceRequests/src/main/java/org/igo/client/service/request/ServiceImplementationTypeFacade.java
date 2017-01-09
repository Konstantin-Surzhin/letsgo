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
package org.igo.client.service.request;

/**
 *
 * @author surzhin.konstantin
 * @param <T>
 */
public class ServiceImplementationTypeFacade<T> implements ServiceImplementationTypeInterface<T> {

    private final ServiceTypeInterface<T> serviceType;
    private final String serviceImplementationType;
    private String datase = "";
    private String dataBaseAccessType = "";

    ServiceImplementationTypeFacade(final ServiceTypeInterface<T> serviceType, final String serviceImplementationType) {
        this.serviceType = serviceType;
        this.serviceImplementationType = serviceImplementationType;
    }

    /**
     * @return the serviceType
     */
    @Override
    public ServiceTypeInterface getServiceType() {
        return serviceType;
    }

    /**
     * @return the serviceImplementationType
     */
    @Override
    public String getServiceImplementationType() {
        return serviceImplementationType;
    }

    /**
     *
     * @return
     */
    @Override
    public String getPath() {
        final StringBuilder sb = new StringBuilder();
        sb
                .append(datase)
                .append("-")
                .append(dataBaseAccessType)
                .append("-")
                .append(serviceImplementationType)
                .append("-")
                .append(serviceType.getPath());

        return sb.toString().toLowerCase();
    }

    /**
     *
     * @return
     */
    @Override
    public T getUnit() {
        return serviceType.getUnit();
    }

    /**
     * @return the datase
     */
    public String getDatase() {
        return datase;
    }

    /**
     * @param datase the datase to set
     */
    @Override
    public void setDatase(String datase) {
        this.datase = datase;
    }

    /**
     * @return the dataBaseAccessType
     */
    public String getDataBaseAccessType() {
        return dataBaseAccessType;
    }

    /**
     * @param dataBaseAccessType the dataBaseAccessType to set
     */
    @Override
    public void setDataBaseAccessType(String dataBaseAccessType) {
        this.dataBaseAccessType = dataBaseAccessType;
    }
}
