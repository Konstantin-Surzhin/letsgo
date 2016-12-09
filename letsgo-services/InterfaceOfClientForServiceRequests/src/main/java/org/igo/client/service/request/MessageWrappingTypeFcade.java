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
public class MessageWrappingTypeFcade<T> implements MessageWrappingTypeInterface<T> {

    private final UnitInterface<T> unitIntf;
    private final String messageType;

    MessageWrappingTypeFcade(UnitInterface<T> unitIntf, String messageType) {
        this.unitIntf = unitIntf;
        this.messageType = messageType;
    }

    @Override
    public String getPath() {
        final StringBuilder sb = new StringBuilder();
        return sb.append(messageType).append("-").append(unitIntf.getPath()).toString().toLowerCase();
    }

    @Override
    public T getUnit() {
        return unitIntf.getUnit();
    }
}
