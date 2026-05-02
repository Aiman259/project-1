package com.example.Instructorapi.dto;

public class LoginRequest {
    private String email;
    private String password;

    // WAJIB ADA NI supaya AuthController boleh baca data dari Postman
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setter (pilihan tapi bagus ada)
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}