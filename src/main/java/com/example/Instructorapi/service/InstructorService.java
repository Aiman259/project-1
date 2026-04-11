package com.example.Instructorapi.service;

import com.example.Instructorapi.model.Instructor;
import com.example.Instructorapi.model.HealthStatus; 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    
    private List<Instructor> instructors = new ArrayList<>();

    public InstructorService() {
        // Data contoh
        instructors.add(new Instructor("Aiman", "aiman@example.com", "Java Spring Boot", 5));
    }

    public List<Instructor> getAllInstructors() {
        return instructors;
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }
}
