package com.codetests.bnta.petAPI.repositories;

import com.codetests.bnta.petAPI.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
