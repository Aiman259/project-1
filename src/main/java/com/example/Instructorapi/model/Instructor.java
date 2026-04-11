package com.example.Instructorapi.model;

public class Instructor {
    private String name;
    private String email;
    private String specialization;
    private int yearsExperience;

    public Instructor(String name, String email, String specialization, int yearsExperience) {
        this.name = name;
        this.email = email;
        this.specialization = specialization;
        this.yearsExperience = yearsExperience;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public int getYearsExperience() { return yearsExperience; }
    public void setYearsExperience(int yearsExperience) { this.yearsExperience = yearsExperience; }
}
