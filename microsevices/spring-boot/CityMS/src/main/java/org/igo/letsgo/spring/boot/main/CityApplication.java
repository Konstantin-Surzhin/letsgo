/*
 * Copyright (C) 2016 surzhin.konstantin.
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
package org.igo.letsgo.spring.boot.main;

import org.igo.letsgo.spring.boot.domain.City;
import org.igo.letsgo.spring.boot.repository.CityRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.igo.letsgo.spring.boot.domain")
@ComponentScan(basePackages = {"org.igo.letsgo.spring.boot"})
@EnableJpaRepositories("org.igo.letsgo.spring.boot.repository")
public class CityApplication {

    @Bean
    InitializingBean saveData(CityRepository repo) {
        return () -> {
            repo.save(new City("Москва"));
            repo.save(new City("Leningad"));
            repo.save(new City("Voronez"));
            repo.save(new City("Pskov"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CityApplication.class, args);
    }
}
