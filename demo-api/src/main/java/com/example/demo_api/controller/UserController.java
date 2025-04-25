package com.example.demo_api.controller;
// im vijay krishna
import com.example.demo_api.model.User;
import com.example.demo_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")  // Optional: Needed if you're calling from a frontend app (like React)
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ POST - Create multiple users
    @PostMapping
    public List<User> createUsers(@RequestBody List<User> users) {
        return users.stream()
                .map(userService::addUser)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUserById(id, user);

    }


    // ✅ GET - List all users
    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    // ✅ GET - Get a single user by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // ✅ DELETE - Delete a user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
