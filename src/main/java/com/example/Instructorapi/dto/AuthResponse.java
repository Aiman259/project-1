package com.example.Instructorapi.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private String tokenType = "Bearer";
    private String email;
    private String role;
}