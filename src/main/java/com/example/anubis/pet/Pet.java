package com.example.anubis.pet;

public class Pet {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Long id;
    public String name;
    public String race;

    public Pet(){

    }

    public Pet(Long id, String name, String race){
        this.id = id;
        this.name = name;
        this.race = race;
    }

    public Pet(String name, String race){
        this.name = name;
        this.race = race;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                '}';
    }
}
