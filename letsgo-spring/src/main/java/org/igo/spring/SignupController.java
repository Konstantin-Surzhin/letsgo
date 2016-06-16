/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author surzhin.konstantin
 */
@Controller
public class SignupController {

    @RequestMapping(value = "/signup")
    public ModelAndView sayHello() {
        ModelAndView mv = new ModelAndView("signup", "user", new User());
        mv.addObject("message", "Let's signup!");
        mv.setViewName("signup");
        return mv;
    }
}
