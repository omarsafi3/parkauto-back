package org.example.parkautoback;

import org.example.parkautoback.config.DatabaseConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.sql.Connection;

@SpringBootApplication
@RestController
public class ParkautoBackApplication {

    public static void main(String[] args) {

        SpringApplication.run(ParkautoBackApplication.class, args);

    }

    @GetMapping("/api/test")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!!", name);

    }
}
