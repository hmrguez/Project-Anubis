package com.example.anubis.pet;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    public List<Pet> getPets(){

        Pet pet = new Pet(120l, "Fluffy", "Cat");
        Pet pet2 = new Pet(121l ,"Cer", "Dog");

        return List.of(pet, pet2);
    }
}
