package com.example.Instructorapi.service;

import com.example.Instructorapi.model.User;
import com.example.Instructorapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Simpan User Baru (Register)
    public User registerUser(User user) {
        // Check kalau email dah ada dalam database
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Error: Email is already in use!");
        }
        return userRepository.save(user);
    }

    // Ambil Semua User
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Cari User guna Email (untuk Login nanti)
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}