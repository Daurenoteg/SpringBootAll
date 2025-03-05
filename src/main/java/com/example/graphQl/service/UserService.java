package com.example.graphQl.service;

import com.example.graphQl.models.User;
import com.example.graphQl.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(String name, String email) {
        return userRepository.save(new User(null, name, email));
    }

    public User updateUser(Long id, String name, String email) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (name != null) user.setName(name);
            if (email != null) user.setEmail(email);
            return userRepository.save(user);
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}