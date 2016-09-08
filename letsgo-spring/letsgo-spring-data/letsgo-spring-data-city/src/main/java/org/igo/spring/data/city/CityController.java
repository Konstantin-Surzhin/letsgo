/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.spring.data.city;

import org.igo.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CityRepository cityRepository;

    @GetMapping(value = "/city")
    public String index(Model model) {
        model.addAttribute("city", new City());
        return "city";
    }

    @PostMapping(value = "addCity")
    public String addCity(Model model, @ModelAttribute City city) {

        model.addAttribute("name", city.getName());
        model.addAttribute("id", city.getId());
        return "result";
    }
}
