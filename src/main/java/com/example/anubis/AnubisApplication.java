package com.example.anubis;

import com.example.anubis.pet.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class AnubisApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnubisApplication.class, args);
    }



}
