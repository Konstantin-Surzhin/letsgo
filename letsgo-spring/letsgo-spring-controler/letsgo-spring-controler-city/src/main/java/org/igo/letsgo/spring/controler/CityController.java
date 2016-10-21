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

import java.util.List;
import java.util.ResourceBundle;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.igo.entities.City;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author surzhin.konstantin
 */
@Controller
public class CityController {

    private EntityManager entityManager;
    private final ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle");

    @GetMapping(value = "/city")
    public String index(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("head", bundle.getString("head"));
        model.addAttribute("submit", bundle.getString("submit"));
        model.addAttribute("message", bundle.getString("message"));
        return "city";
    }

    @Transactional
    @PostMapping(value = "/city")
    public String addCity(Model model, @ModelAttribute City city) {
        TypedQuery<Long> q = getEntityManager().createNamedQuery("City.checkByCityName", Long.class);
        q.setParameter("cityName", city.getCityName());

        if (q.getSingleResult() != 0L) {
            model.addAttribute("error", java.text.MessageFormat.format(bundle.getString("error"),
                    new Object[]{city.getCityName()}));
            return "databaseError";
        }
        getEntityManager().persist(city);

        TypedQuery<City> cities = getEntityManager().createNamedQuery("City.findAll", City.class);
        List<City> list = cities.getResultList();
        model.addAttribute("cities", list);
        return "result";
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
