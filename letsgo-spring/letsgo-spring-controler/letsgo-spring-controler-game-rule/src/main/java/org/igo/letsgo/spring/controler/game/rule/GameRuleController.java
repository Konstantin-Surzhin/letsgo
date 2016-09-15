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
package org.igo.letsgo.spring.controler.game.rule;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.igo.entities.GameRule;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author surzhin.konstantin
 */
public class GameRuleController {

    @PersistenceContext
    EntityManager em;

    @GetMapping(value = "/gameRule")
    public String index(Model model) {
        model.addAttribute("game_rule", new GameRule());
        model.addAttribute("game_rule_head", java.util.ResourceBundle.getBundle("City").getString("game_rule_head"));
        model.addAttribute("submit", java.util.ResourceBundle.getBundle("City").getString("submit"));
        model.addAttribute("message", java.util.ResourceBundle.getBundle("City").getString("message"));
        return "game_rule";
    }
}
