package com.codetests.bnta.petAPI.components;

import com.codetests.bnta.petAPI.models.Pet;
import com.codetests.bnta.petAPI.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PetRepository petRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Pet ella = new Pet("Ella", "Tortoise", "Eastern Hermanns", 7);
        petRepository.save(ella);

        Pet poppy = new Pet("Poppy", "Dog", "Springer Spaniel", 4);
        petRepository.save(poppy);
    }
}
