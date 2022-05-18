package com.bnta.vetservice;

import com.bnta.vetservice.models.Pet;
import com.bnta.vetservice.repositories.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class VetserviceApplicationTests {

	@Autowired
	PetRepository petRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindDogsInPets(){
		List<Pet> found = petRepository.findPetByType("dog");
		assertThat(found.size()).isEqualTo(2);
	}

}
