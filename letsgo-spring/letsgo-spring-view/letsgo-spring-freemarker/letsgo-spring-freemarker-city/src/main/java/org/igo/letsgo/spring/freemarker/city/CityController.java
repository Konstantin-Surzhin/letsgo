/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.letsgo.spring.freemarker.city;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author surzhin.konstantin
 */
@Controller
public class CityController {

    private static final List<City> cityList = new ArrayList<>();

    static {
        cityList.add(new City(1,"Москва"));
    }

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Hello World!");
        mv.addObject("cityList", cityList);
        mv.setViewName("index");
        return mv;
    }
}
