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
package org.igo.letsgo.jsf.user.degree.primefaces;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pl
 */
@SessionScoped
@ManagedBean(name="UserDegreeManagedBean")
public class UserDegreeManagedBean implements Serializable {

    private String userDegreeName="Мастер спорта";
    private String pageHeader="Управление спортивными разрядами";

    /**
     * @return the userDegreeName
     */
    public String getUserDegreeName() {
        return userDegreeName;
    }

    /**
     * @param userDegreeName the userDegreeName to set
     */
    public void setUserDegreeName(String userDegreeName) {
        this.userDegreeName = userDegreeName;
    }

    /**
     * @return the pageHeader
     */
    public String getPageHeader() {
        return pageHeader;
    }

    /**
     * @param pageHeader the pageHeader to set
     */
    public void setPageHeader(String pageHeader) {
        this.pageHeader = pageHeader;
    }
    
}
