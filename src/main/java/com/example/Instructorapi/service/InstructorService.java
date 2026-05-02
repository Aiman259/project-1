package com.example.Instructorapi.service;

import com.example.Instructorapi.model.Instructor;
import com.example.Instructorapi.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    /**
     * Mega Endpoint Logic: 
     * Menggabungkan Search, Filter, dan Pagination dalam satu fungsi.
     */
    public Page<Instructor> getInstructorsCombined(String keyword, String specialization, Pageable pageable) {
        // 1. Jika ada keyword, buat carian berdasarkan Nama (Search)
        if (keyword != null && !keyword.isEmpty()) {
            return instructorRepository.findByNameContainingIgnoreCase(pageable, keyword);
        } 
        // 2. Jika ada specialization, buat tapisan (Filter)
        else if (specialization != null && !specialization.isEmpty()) {
            return instructorRepository.findBySpecialization(specialization, pageable);
        }
        // 3. Jika tiada parameter, pulangkan semua data dengan Pagination & Sorting
        return instructorRepository.findAll(pageable);
    }

    // Get All (Tanpa Pagination - Jika masih diperlukan)
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

    // Update (Pastikan semua field dihantar supaya tidak jadi null)
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

    // Search by Name Only (Legacy method)
    public List<Instructor> searchInstructorsByName(String keyword) {
        return instructorRepository.findByNameContainingIgnoreCase(keyword);
    }
}