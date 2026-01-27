package com.spring.Coaching.Management.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Coaching.Management.Entity.User;
import com.spring.Coaching.Management.Repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {

        return userRepository
                .findByEmailAndPassword(user.getEmail(), user.getPassword())
                .orElseThrow(() -> new RuntimeException("Invalid Email or Password"));
    }
}