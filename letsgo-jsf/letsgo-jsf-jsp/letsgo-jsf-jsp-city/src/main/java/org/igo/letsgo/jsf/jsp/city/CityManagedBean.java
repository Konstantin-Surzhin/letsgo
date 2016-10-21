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
package org.igo.letsgo.jsf.jsp.city;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author pl
 */
@ManagedBean(name="cityManagedBean")
@SessionScoped
public class CityManagedBean {
    private final String pageTitle = "Управление городами";
    private String cityName ="Москва";
    private final List<String> cityList = new ArrayList<>();
 
    /**
     * Creates a new instance of CityManagedBean
     */
    public CityManagedBean() {
        cityList.add(cityName);
    }

    /**
     * @return the pageTitle
     */
    public String getPageTitle() {
        return pageTitle;
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
    
    public void addCity(){
        
         System.out.println("добавлен город: " + cityName);
         getCityList().add(cityName);
    }

    /**
     * @return the cityList
     */
    public List<String> getCityList() {
        return cityList;
    }
}
