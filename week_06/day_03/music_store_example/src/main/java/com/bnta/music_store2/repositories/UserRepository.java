package com.bnta.music_store2.repositories;

import com.bnta.music_store2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
