package com.example.Instructorapi.service;

import com.example.Instructorapi.model.Instructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorService {
    
    // Simpan data dalam List (In-memory)
    private List<Instructor> instructors = new ArrayList<>();

    public InstructorService() {
        // Required: Tambah 2 sample instructor masa startup
        instructors.add(new Instructor("Aiman", "aiman@example.com", "Java Spring Boot", 5));
        instructors.add(new Instructor("Cikgu Zharfan", "zharfan@kv.edu.my", "Electronics", 10));
    }

    public List<Instructor> getAllInstructors() {
        return instructors;
    }

    public Instructor addInstructor(Instructor instructor) {
        instructors.add(instructor);
        return instructor;
    }
}
