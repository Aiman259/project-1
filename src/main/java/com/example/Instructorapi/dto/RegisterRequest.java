package com.example.Instructorapi.dto; // 1. Pastikan package name betul

public class RegisterRequest { // 2. Pastikan nama class SAMA dengan nama fail
    private String name;
    private String email;
    private String password;

    // Cikgu kena ada Getter & Setter manual kalau tak guna @Data
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}