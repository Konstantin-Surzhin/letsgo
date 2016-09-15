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
package org.igo.letsgo.spring.controler.degree;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.igo.entities.Degree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author surzhin.konstantin
 */
@Controller
public class DegreeController {
    @PersistenceContext
    EntityManager em;
    @GetMapping(value = "/degree")
    public String index(Model model) {
        model.addAttribute("degree", new Degree());
        model.addAttribute("degree_head", java.util.ResourceBundle.getBundle("Degree").getString("degree_head"));
        model.addAttribute("submit", java.util.ResourceBundle.getBundle("City").getString("submit"));
        model.addAttribute("message", java.util.ResourceBundle.getBundle("City").getString("message"));
        return "degree";
    }
}
