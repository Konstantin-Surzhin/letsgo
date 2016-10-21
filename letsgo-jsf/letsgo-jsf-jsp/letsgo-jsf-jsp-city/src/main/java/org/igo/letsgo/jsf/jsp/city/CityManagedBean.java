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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.igo.letsgo.jsf.jsp.city.entity.City;

/**
 *
 * @author pl
 */
@ManagedBean(name = "cityManagedBean")
@SessionScoped
public class CityManagedBean {

    @PersistenceContext
    EntityManager em;
    private final String pageTitle = "Управление городами";
    private String cityName = "Москва";
    private Integer cityCode = 1;
    private String addMetod = "jpa";

    private final List<City> cityList = new ArrayList<>();

    /**
     * Creates a new instance of CityManagedBean
     */
    public CityManagedBean() {

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

    public void addCity() {

        switch (addMetod) {
            case "jdbc":
                addCityJDBC();
                break;
            case "jpa":
                addCityJPA();
                break;
            case "ejb":
                addCityEJB();
                break;
            case "rest":
                addCityRESTful();
                break;
            case "soap":
                addCitySOAP();
                break;
            case "mq":
                addCityMQ();
                break;

            case "jms":
                addCityJMS();
                break;
            default:
                System.out.println("добавлен город: " + cityName);
                break;

        }
    }

    private void addCityJDBC() {

        System.out.println("(JPA) добавлен город: " + cityName);

    }

//    UserTransaction utx; 
//try {
//    InitialContext context = new InitialContext();
//    utx = (UserTransaction) context.lookup("java.transaction.UserTransaction");
//} catch(Exception e){} 
    private void addCityJPA() {
        try {
            City city = new City(cityName);

            InitialContext context = new InitialContext();
            UserTransaction utx = (UserTransaction) context.lookup("java:comp/UserTransaction");

            utx.begin();
            em.persist(city);
            utx.commit();

            cityList.add(city);
            System.out.println("(JPA) добавлен город: " + city);
        } catch (HeuristicMixedException | HeuristicRollbackException | IllegalStateException | RollbackException | SecurityException | SystemException | NotSupportedException | NamingException ex) {
            Logger.getLogger(CityManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addCityEJB() {

        System.out.println("(EJB) добавлен город: " + cityName);

    }

    private void addCityRESTful() {

        System.out.println("(RESTful) добавлен город: " + cityName);

    }

    private void addCitySOAP() {

        System.out.println("(SOAP) добавлен город: " + cityName);

    }

    private void addCityMQ() {

        System.out.println("(SOAP) добавлен город: " + cityName);

    }

    private void addCityJMS() {

        System.out.println("(SOAP) добавлен город: " + cityName);

    }

    /**
     * @return the cityList
     */
    public List<City> getCityList() {
        return cityList;
    }

    /**
     * @return the addMetod
     */
    public String getAddMetod() {
        return addMetod;
    }

    /**
     * @param addMetod the addMetod to set
     */
    public void setAddMetod(String addMetod) {
        this.addMetod = addMetod;
    }

    /**
     * @return the cityCode
     */
    public Integer getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode the cityCode to set
     */
    public void setCityCode(Integer cityCode) {
        this.cityCode = cityCode;
    }
}
