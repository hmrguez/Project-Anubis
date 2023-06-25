package com.example.anubis.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/pet")
public class PetController {

    public final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }


    @GetMapping
    public List<Pet> getPets(){
        return this.petService.getPets();
    }
}
