package com.example.Instructorapi.controller;

import com.example.Instructorapi.dto.RegisterRequest;
import com.example.Instructorapi.dto.LoginRequest; // Pastikan import ni ada
import com.example.Instructorapi.model.User;
import com.example.Instructorapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // --- 1. ENDPOINT REGISTER ---
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        User user = new User();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setRole("USER");

        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully as USER!");
    }

    // --- 2. ENDPOINT LOGIN (Letak di sini) ---
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return userRepository.findByEmail(loginRequest.getEmail())
                .map(user -> {
                    if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                        return ResponseEntity.ok("Login Successful! Welcome " + user.getName());
                    } else {
                        return ResponseEntity.badRequest().body("Error: Invalid password!");
                    }
                })
                .orElse(ResponseEntity.badRequest().body("Error: User not found!"));
    }
}