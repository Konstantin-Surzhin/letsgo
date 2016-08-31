/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.spring.jsp.city;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author surzhin.konstantin
 */
@XmlRootElement
public class City {

    private String name;
    private String language;
    private Integer id;

    public String getName() {
       return name;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getId() {
        return id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param Language the Language to set
     */
    public void setLanguage(String Language) {
        this.language = Language;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Integer Id) {
        this.id = Id;
    }

}
