package com.example.Instructorapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.Indexed;

@Document(collection = "instructors")
public class Instructor {
    
    @Id
    private String id;
    
    private String name;
    
    private String email;

    @Indexed // Indexing untuk speed up filtering
    private String specialization;
    
    private int yearsExperience;
    
    private String status;

    // --- GETTERS AND SETTERS ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public int getYearsExperience() { return yearsExperience; }
    public void setYearsExperience(int yearsExperience) { this.yearsExperience = yearsExperience; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}