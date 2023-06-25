package com.example.anubis.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Long> {

}
