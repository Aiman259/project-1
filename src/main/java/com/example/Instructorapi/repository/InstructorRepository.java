package com.example.Instructorapi.repository;

import com.example.Instructorapi.model.Instructor;
import org.springframework.data.domain.Page; // WAJIB ADA
import org.springframework.data.domain.Pageable; // WAJIB ADA
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface InstructorRepository extends MongoRepository<Instructor, String> {
    
    // KEMASKINI: Tambah Pageable sebagai parameter PERTAMA dan tukar return type ke Page
    Page<Instructor> findByNameContainingIgnoreCase(Pageable pageable, String name);
    
    // KEMASKINI: Tambah Pageable di sini juga
    Page<Instructor> findBySpecialization(String specialization, Pageable pageable);

    // Ini versi lama (cikgu boleh simpan atau buang kalau dah tak guna)
    List<Instructor> findByNameContainingIgnoreCase(String name);
}