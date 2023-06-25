package com.anubis.owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/owner")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/{ownerId}")
    public Owner getOwnerById(@PathVariable Long ownerId) {
        return ownerService.getOwnerById(ownerId);
    }

    @PostMapping
    public void saveOwner(@RequestBody Owner owner) {
        ownerService.saveOwner(owner);
    }

    @DeleteMapping("/{ownerId}")
    public void deleteOwner(@PathVariable Long ownerId) {
        ownerService.deleteOwner(ownerId);
    }

    @PutMapping("/{ownerId}")
    public void updateOwnerOwner(@PathVariable Long ownerId, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
        ownerService.updateOwner(ownerId, name, email);
    }
}