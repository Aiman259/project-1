package com.example.Instructorapi.dto;

public class CreateInstructorRequest {
    private String name;
    private String email;
    private String specialization;
    private int yearsExperience;

    // Getters and Setters (Wajib ada supaya Spring boleh baca JSON)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public int getYearsExperience() { return yearsExperience; }
    public void setYearsExperience(int yearsExperience) { this.yearsExperience = yearsExperience; }
}

