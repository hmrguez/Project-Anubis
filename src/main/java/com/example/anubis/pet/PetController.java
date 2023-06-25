package com.example.anubis.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerNewPet(@RequestBody Pet pet){
        petService.insertPet(pet);
    }

    @DeleteMapping(path = "{petId}")
    public void deletePet(@PathVariable("petId") Long petId){
        petService.deletePet(petId);
    }

    @PutMapping(path="{petId}")
    public void updatePet(@PathVariable("petId") Long petId, @RequestParam(required = false) Long ownerId){
        petService.updatePet(petId, ownerId);
    }
}
