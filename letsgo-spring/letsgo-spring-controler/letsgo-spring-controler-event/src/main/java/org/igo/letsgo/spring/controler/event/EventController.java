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
package org.igo.letsgo.spring.controler.event;

import org.springframework.ui.Model;
import org.igo.entities.Event;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
/**
 *
 * @author surzhin.konstantin
 */
public class EventController {

    @PersistenceContext
    EntityManager em;
        @GetMapping(value = "/event")
    public String index(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("event_head", java.util.ResourceBundle.getBundle("City").getString("event_head"));
        model.addAttribute("submit", java.util.ResourceBundle.getBundle("City").getString("submit"));
        model.addAttribute("message", java.util.ResourceBundle.getBundle("City").getString("message"));
        return "event";
    }
}
