/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.spring.jsp.city;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author surzhin.konstantin
 */
@Controller
public class CityController {

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("city", new City());
        return "index";
    }

    @PostMapping(value = "addCity")
    public String addCity(Model model, @ModelAttribute City city) {

        model.addAttribute("name", city.getName());
        model.addAttribute("lang", city.getLanguage());
        model.addAttribute("id", city.getId());
        return "result";
    }
}
