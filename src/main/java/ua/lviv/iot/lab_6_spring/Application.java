package ua.lviv.iot.lab_6_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.lab_6_spring.controller",
        "ua.lviv.iot.lab_6_spring.service",
        "ua.lviv.iot.lab_6_spring.repository",
        "ua.lviv.iot.lab_6_spring.config"})
@EntityScan({"ua.lviv.iot.lab_6_spring.domain"})
@EnableJpaRepositories({"ua.lviv.iot.lab_6_spring.repository"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
