/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.spring.data.city;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import org.igo.entities.City;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
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

//    @PersistenceContext
//    EntityManager em;
    // CityRepository cityRepository;
//    @Inject
//    JpaTransactionManager tx;
    // @Transactional
    @Resource
    private SessionContext sessionContext;

    @GetMapping(value = "/city")
    public String index(Model model) {
        City city = new City();
        city.setCityName("Ржев");
        model.addAttribute("city",city );
        
        return "city";
    }

    @PostMapping(value = "addCity")
    public String addCity(Model model, @ModelAttribute City city) {

        model.addAttribute("name", city.getCityName());
        model.addAttribute("id", city.getId());
        return "result";
    }
}
