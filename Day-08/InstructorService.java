package com.example.Instructorapi.service;

import com.example.Instructorapi.model.Instructor;
import com.example.Instructorapi.repository.InstructorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private static final Logger logger = LoggerFactory.getLogger(InstructorService.class);

    @Autowired
    private InstructorRepository instructorRepository;

    /**
     * Mega Endpoint Logic: Menggabungkan Search, Filter, dan Pagination.
     */
    public Page<Instructor> getInstructorsCombined(String keyword, String specialization, Pageable pageable) {
        
        // --- SERVICE-LAYER LOGS ---
        logger.info(">>> API CALL: Fetching Instructors");
        logger.info(">>> Parameter - Search Keyword: {}", (keyword != null ? keyword : "NONE"));
        logger.info(">>> Parameter - Specialization Filter: {}", (specialization != null ? specialization : "NONE"));
        logger.info(">>> Pagination - Page Number: {}", pageable.getPageNumber());
        logger.info(">>> Pagination - Page Size: {}", pageable.getPageSize());
        logger.info(">>> Sorting - Sort Value: {}", pageable.getSort());

        if (keyword != null && !keyword.isEmpty()) {
            return instructorRepository.findByNameContainingIgnoreCase(pageable, keyword);
        } 
        else if (specialization != null && !specialization.isEmpty()) {
            return instructorRepository.findBySpecialization(specialization, pageable);
        }
        
        return instructorRepository.findAll(pageable);
    }

    // Get All (Tanpa Pagination)
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

    // Search by Name Only (Legacy)
    public List<Instructor> searchInstructorsByName(String keyword) {
        return instructorRepository.findByNameContainingIgnoreCase(keyword);
    }
}