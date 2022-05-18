package com.bnta.music_store2.repositories;

import com.bnta.music_store2.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// todo: test with and without @component annotation
public interface ProductRepository extends JpaRepository<Product, Long> {

}
