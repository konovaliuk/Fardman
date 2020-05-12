package com.iasa.repairagency.repository;

import com.iasa.repairagency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.StringReader;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNameAndRole(String name, String role);
}
