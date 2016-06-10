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
package org.igo.letsgo.spring;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author surzhin.konstantin
 */
@Controller
public class UserController {

    /**
     *
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/result")
    public ModelAndView processUser(@Valid User user, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("result");
        mv.addObject("u", user);

        if (result.hasErrors()) {
            mv.setViewName("signup");
        } else {
            mv.setViewName("result");
        }
        return mv;
    }
}
