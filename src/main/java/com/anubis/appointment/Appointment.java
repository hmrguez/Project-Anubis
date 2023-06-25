package com.anubis.appointment;

import com.anubis.pet.Pet;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Column(name = "date")
    private LocalDate date;

    public Appointment() {
    }

    public Appointment(Long id, Pet pet, LocalDate date) {
        this.id = id;
        this.pet = pet;
        this.date = date;
    }

    public Appointment(Pet pet, LocalDate date) {
        this.pet = pet;
        this.date = date;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", pet=" + pet +
                ", date=" + date +
                '}';
    }
}