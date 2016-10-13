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
package org.igo.letsgo.jsf.team.primefaces;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pl
 */
@SessionScoped
@ManagedBean(name="TeamManagedBean")
public class TeamManagedBean implements Serializable {

    private String teamName="Список команд";
    private String pageHeader="Управление командами игроков";

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
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
