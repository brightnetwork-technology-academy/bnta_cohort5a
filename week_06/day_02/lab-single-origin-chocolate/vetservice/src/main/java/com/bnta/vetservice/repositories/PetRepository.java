package com.bnta.vetservice.repositories;

import com.bnta.vetservice.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

//    return all pets with the type dog
    List<Pet> findPetByType(String type);

}
