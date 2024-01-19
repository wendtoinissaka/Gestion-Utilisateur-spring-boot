package com.example.demo.controller;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Wendtoin Issaka
 */


@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/user")
    User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
     User getUser(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
     User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userRepository.findById(id)
                .map(u -> {
                    u.setUsername(userDetails.getUsername());
                    u.setName(userDetails.getName());
                    u.setEmail(userDetails.getEmail());
                    return userRepository.save(u);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("user/{id}")
     String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
         return "User with id "+ "has been deleted successfully";

    }


}
