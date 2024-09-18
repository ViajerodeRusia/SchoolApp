package com.school.SchoolApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.school.SchoolApp.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
