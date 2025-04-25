package com.example.demo_api.service;

import com.example.demo_api.model.User;
import com.example.demo_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a single user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Add a new user
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Update an existing user by ID
    public User updateUserById(Long id, User updatedUser) {
        if (userRepository.existsById(id)) {
            updatedUser.setId(id); // ensure ID is preserved
            return userRepository.save(updatedUser);
        } else {
            return null; // or throw new EntityNotFoundException("User not found")
        }
    }
}
