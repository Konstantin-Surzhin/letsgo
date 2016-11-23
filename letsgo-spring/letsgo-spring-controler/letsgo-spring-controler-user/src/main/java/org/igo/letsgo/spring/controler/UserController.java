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
package org.igo.letsgo.spring.controler;

import java.util.ResourceBundle;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.igo.entities.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author surzhin.konstantin
 */
@Controller
public class UserController {

    private EntityManager entityManager;
    private final ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle");

    @GetMapping(value = "/user")
    public String index(Model model) {
        model.addAttribute("league", new UserDetails());
        model.addAttribute("head", bundle.getString("head"));
        model.addAttribute("submit", bundle.getString("submit"));
        model.addAttribute("message", bundle.getString("message"));
        return "moveComment";
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * @param entityManager the entityManager to set
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
