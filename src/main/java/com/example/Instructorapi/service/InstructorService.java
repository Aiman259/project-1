package com.example.Instructorapi.service;

import com.example.Instructorapi.model.Instructor;
import com.example.Instructorapi.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    // Get All
    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    // Get by ID
    public Optional<Instructor> getInstructorById(String id) {
        return instructorRepository.findById(id);
    }

    // Create
    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    // Update
    public Instructor updateInstructor(String id, Instructor details) {
        return instructorRepository.findById(id).map(instructor -> {
            instructor.setName(details.getName());
            instructor.setEmail(details.getEmail());
            instructor.setSpecialization(details.getSpecialization());
            instructor.setYearsExperience(details.getYearsExperience());
            instructor.setStatus(details.getStatus());
            return instructorRepository.save(instructor);
        }).orElseThrow(() -> new RuntimeException("Instructor not found with id " + id));
    }

    // Delete
    public void deleteInstructor(String id) {
        instructorRepository.deleteById(id);
    }
}