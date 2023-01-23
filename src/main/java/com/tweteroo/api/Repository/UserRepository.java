package com.tweteroo.api.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.Models.UserModels;

public interface UserRepository extends JpaRepository<UserModels, Long> {
    Optional<UserModels> findUserByUsername(String username);
}
