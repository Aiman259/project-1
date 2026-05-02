package com.example.Instructorapi.repository;

import com.example.Instructorapi.model.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InstructorRepository extends MongoRepository<Instructor, String> {
    
    // Fungsi untuk cari nama yang mengandungi keyword (ignore case supaya tak kisah huruf besar/kecil)
    List<Instructor> findByNameContainingIgnoreCase(String keyword);
    List<Instructor> findBySpecialization(String specialization);
}