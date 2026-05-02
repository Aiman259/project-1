package com.example.Instructorapi.service;

import com.example.Instructorapi.model.Instructor;
import com.example.Instructorapi.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // Pastikan import ini ada
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    // --- KEMASKINI: Guna Pageable untuk sokong Sorting & Pagination ---
    public Page<Instructor> getAllInstructorsPaged(Pageable pageable) {
        return instructorRepository.findAll(pageable);
    }

    public Optional<Instructor> getInstructorById(String id) {
        return instructorRepository.findById(id);
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

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

    public void deleteInstructor(String id) {
        instructorRepository.deleteById(id);
    }

    public List<Instructor> searchInstructorsByName(String keyword) {
        return instructorRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Instructor> getInstructors(String specialization) {
        if (specialization != null) {
            return instructorRepository.findBySpecialization(specialization);
        }
        return instructorRepository.findAll();
    }
}