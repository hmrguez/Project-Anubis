package com.example.anubis.owner;

import com.example.anubis.pet.Pet;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();

    public Owner() {
    }

    public Owner(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pets = new ArrayList<>();
    }

    public Owner(String name, String email) {
        this.name = name;
        this.email = email;
        this.pets = new ArrayList<>();
    }
}