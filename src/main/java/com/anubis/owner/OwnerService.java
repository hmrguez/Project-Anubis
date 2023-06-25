package com.anubis.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final IOwnerRepository ownerRepository;

    @Autowired
    public OwnerService(IOwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(Long ownerId) {
        return ownerRepository.findById(ownerId).orElseThrow(() -> new IllegalStateException("Owner with id " + ownerId + " does not exist"));
    }

    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public void deleteOwner(Long ownerId) {
        ownerRepository.deleteById(ownerId);
    }

    @Transactional
    public void updateOwner(Long ownerId, String name, String email) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(() -> new IllegalStateException("Owner with id " + ownerId + " does not exist"));

        if (name != null && name.length() > 0 && !name.equals(owner.getName())) {
            owner.setName(name);
        }

        if (email != null && email.length() > 0 && !email.equals(owner.getEmail())) {
            Optional<Owner> byEmail = ownerRepository.findByEmail(email);
            if(byEmail.isPresent()){
                throw new IllegalStateException("Another user already has the email + " + email);
            }

            owner.setEmail(email);
        }
    }
}
