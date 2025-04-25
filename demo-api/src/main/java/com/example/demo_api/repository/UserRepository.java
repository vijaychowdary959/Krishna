package com.example.demo_api.repository;

import com.example.demo_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// This will allow Spring Data JPA to auto-generate queries like save(), findAll(), findById(), deleteById(), etc.
public interface UserRepository extends JpaRepository<User, Long> {
}
