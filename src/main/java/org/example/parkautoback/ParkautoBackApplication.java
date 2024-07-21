package org.example.parkautoback;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkautoBackApplication {

    public static void main(String[] args) {

        SpringApplication.run(ParkautoBackApplication.class, args);

    }
    
}
