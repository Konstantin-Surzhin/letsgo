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
package org.igo.letsgo.jsf.jsp.user.registration;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author surzhin.konstantin
 */
@Named(value = "userRegistrationManagedBean")
@RequestScoped
public class UserRegistrationManagedBean {

    
    private String login;
    private String password;
    private String rpassword;
    /**
     * Creates a new instance of UserRegistrationManagedBean
     */
    public UserRegistrationManagedBean() {
    }
    public void addUser(){
        
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the rpassword
     */
    public String getRpassword() {
        return rpassword;
    }

    /**
     * @param rpassword the rpassword to set
     */
    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }
}
