package com.example.Instructorapi.controller;

import com.example.Instructorapi.dto.CreateInstructorRequest;
import com.example.Instructorapi.model.Instructor;
import com.example.Instructorapi.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    // Dependency Injection melalui Constructor
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<Instructor> getInstructors() {
        return instructorService.getAllInstructors();
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody CreateInstructorRequest request) {
        // Tukar borang (DTO) kepada objek sebenar (Model)
        Instructor newInstructor = new Instructor(
            request.getName(),
            request.getEmail(),
            request.getSpecialization(),
            request.getYearsExperience()
        );
        
        return instructorService.addInstructor(newInstructor);
    }
}