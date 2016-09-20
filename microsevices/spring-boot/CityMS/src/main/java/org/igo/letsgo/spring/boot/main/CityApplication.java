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
