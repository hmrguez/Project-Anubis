package com.example.anubis.owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long> {

    @Query("SELECT o from Owner o where o.email=?1")
    Optional<Owner> findByEmail(String email);
}
