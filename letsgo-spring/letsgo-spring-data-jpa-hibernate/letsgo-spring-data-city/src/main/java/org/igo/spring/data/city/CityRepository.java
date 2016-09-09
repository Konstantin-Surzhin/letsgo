/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.spring.data.city;

import java.util.List;
import org.igo.entities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author surzhin.konstantin
 */
@Repository
public interface CityRepository extends CrudRepository<City, Long>{
    
    City findByFirstName(String firstName);
    List<City> findByLastName(String lastName);
}

