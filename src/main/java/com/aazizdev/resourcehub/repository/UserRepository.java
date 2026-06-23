package com.aazizdev.resourcehub.repository;

import com.aazizdev.resourcehub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);





}
