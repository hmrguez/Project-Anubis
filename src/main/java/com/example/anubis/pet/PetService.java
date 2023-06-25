package com.example.anubis.pet;

import com.example.anubis.owner.IOwnerRepository;
import com.example.anubis.owner.Owner;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final IPetRepository petRepository;
    private final IOwnerRepository ownerRepository;

    @Autowired
    public PetService(IPetRepository petRepository, IOwnerRepository ownerRepository) {
        this.petRepository = petRepository;

        this.ownerRepository = ownerRepository;
    }

    public List<Pet> getPets(){
        return petRepository.findAll();
    }

    public void insertPet(Pet pet){
        petRepository.save(pet);
    }

    public void deletePet(Long petId) {
        boolean byId = petRepository.existsById(petId);
        if(!byId){
            throw new IllegalStateException("Pet with the Id " + petId+ " doesn't exists");
        }

        petRepository.deleteById(petId);
    }

    @Transactional
    public void updatePet(Long petId, Long ownerId) {
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new IllegalStateException("Pet with id " + petId + " does not exist"));
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new IllegalStateException("Owner with id " + ownerId + " does not exist"));

        pet.setOwner(owner);
    }
}
