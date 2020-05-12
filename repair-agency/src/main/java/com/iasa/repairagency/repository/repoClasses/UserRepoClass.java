package com.iasa.repairagency.repository.repoClasses;


import com.iasa.repairagency.model.User;
import com.iasa.repairagency.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepoClass {

    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByNameAndRole(String name, String role){
        return userRepository.findByNameAndRole(name, role);
    }
}
