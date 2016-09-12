/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.spring.data.city;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.igo.entities.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author surzhin.konstantin
 */
@Controller
@SessionAttributes("city")
public class CityController {

    @PersistenceContext
    EntityManager em;
    // CityRepository cityRepository;

    @Transactional
    @GetMapping(value = "/city")
    public String index(Model model) {
        City city = new City();
        city.setCityName("Москва");
        em.persist(city);

        model.addAttribute("city", city);
        return "city";
    }

    //@Transactional(readOnly = true)
    @GetMapping(value = "/addCity")
    public String addCity( Model model, @ModelAttribute City city) {
       //City c =(City) model.asMap().get("city");
       //City c = em.merge(city);
        model.addAttribute("city", city);
        return "result";
    }
}
