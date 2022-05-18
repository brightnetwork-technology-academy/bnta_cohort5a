package com.bnta.vetservice.components;


import com.bnta.vetservice.models.Pet;
import com.bnta.vetservice.models.Vet;
import com.bnta.vetservice.repositories.PetRepository;
import com.bnta.vetservice.repositories.VetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired //dependency injection
    PetRepository petRepository;

    @Autowired
    VetRepository vetRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Vet vet1 = new Vet("Emma");
        vetRepository.save(vet1);

        Pet pet1 = new Pet("Betty", "dog", vet1);
        petRepository.save(pet1);

        Pet pet2 = new Pet("Ella", "Turtle", vet1);
        petRepository.save(pet2);

        Vet vet2 = new Vet("Joe");
        vetRepository.save(vet2);

        Pet pet3 = new Pet("Mabel", "dog", vet2);
        petRepository.save(pet3);

    }
}
