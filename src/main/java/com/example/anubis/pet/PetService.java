package com.example.anubis.pet;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

    public List<Pet> getPets(){
        return new ArrayList<>();
    }
}
