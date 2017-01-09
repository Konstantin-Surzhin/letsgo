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
package org.igo.letsgo.jsf.jsp.user;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.MediaType;
import org.igo.letsgo.jsf.jsp.user.entity.User;

/**
 *
 * @author surzhin.konstantin
 */
@ManagedBean(name = "userManagedBean")
@SessionScoped
public class UserManagedBean {
    @PersistenceContext
    private EntityManager em;
    public static final String PAGE_TITLE = "Управление пользователями";
    private String userName = "Tomcat";
    private Integer userCode = 1;
    private String persistenceType = "jpa";
    private String techMetod = "ejb";
    private String msgMediaType = MediaType.TEXT_PLAIN;
    private String dbName = "h2";
    private final List<User> userList = new ArrayList<>();

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userCode
     */
    public Integer getUserCode() {
        return userCode;
    }

    /**
     * @param userCode the userCode to set
     */
    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
    }

    /**
     * @return the persistenceType
     */
    public String getPersistenceType() {
        return persistenceType;
    }

    /**
     * @param persistenceType the persistenceType to set
     */
    public void setPersistenceType(String persistenceType) {
        this.persistenceType = persistenceType;
    }

    /**
     * @return the techMetod
     */
    public String getTechMetod() {
        return techMetod;
    }

    /**
     * @param techMetod the techMetod to set
     */
    public void setTechMetod(String techMetod) {
        this.techMetod = techMetod;
    }

    /**
     * @return the msgMediaType
     */
    public String getMsgMediaType() {
        return msgMediaType;
    }

    /**
     * @param msgMediaType the msgMediaType to set
     */
    public void setMsgMediaType(String msgMediaType) {
        this.msgMediaType = msgMediaType;
    }

    /**
     * @return the dbName
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * @param dbName the dbName to set
     */
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    /**
     * @return the cityList
     */
    public List<User> getUserList() {
        return userList;
    }
    
    /**
     *
     */
    public void addUser(){
        
    }
}
