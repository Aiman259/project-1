package com.example.Instructorapi.repository;

import com.example.Instructorapi.model.Instructor;
import org.springframework.data.domain.Page; // WAJIB ADA
import org.springframework.data.domain.Pageable; // WAJIB ADA
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface InstructorRepository extends MongoRepository<Instructor, String> {
    
    
    Page<Instructor> findByNameContainingIgnoreCase(Pageable pageable, String name);
    

    Page<Instructor> findBySpecialization(String specialization, Pageable pageable);

    
    List<Instructor> findByNameContainingIgnoreCase(String name);
}