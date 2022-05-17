package com.bnta.vetservice.repositories;

import com.bnta.vetservice.models.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
