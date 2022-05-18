package com.bnta.music_store2.repositories;

import com.bnta.music_store2.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
