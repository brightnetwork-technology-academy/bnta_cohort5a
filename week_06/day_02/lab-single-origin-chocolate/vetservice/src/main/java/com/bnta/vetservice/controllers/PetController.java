package com.bnta.vetservice.controllers;

import com.bnta.vetservice.models.Pet;
import com.bnta.vetservice.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pets") // localhost:8080/pets
public class PetController {

    @Autowired
    PetRepository petRepository;

//    INDEX
//    Handles
//    GET /pets
//    GET /pets?type=dog
    @GetMapping //localhost:8080/pets
    public ResponseEntity<List<Pet>> getAllPetsAndFilters(
            @RequestParam(required = false, name = "type") String type
    ){
        if(type != null){
            return new ResponseEntity<>(petRepository.findPetByType(type), HttpStatus.OK);
        }
        return new ResponseEntity<>(petRepository.findAll(), HttpStatus.OK);
    }



//    SHOW
    @GetMapping(value = "/{id}") // localhost:8080/pets/1
    public ResponseEntity<Optional<Pet>> getPet(@PathVariable Long id){
        return new ResponseEntity<>(petRepository.findById(id), HttpStatus.OK);
    }

//    POST
    @PostMapping // POST localhost:8080/pets
    public ResponseEntity<Pet> createPet(@RequestBody Pet newPet){
        petRepository.save(newPet);
        return new ResponseEntity<>(newPet, HttpStatus.CREATED);

    }


}
