package com.example.Instructorapi.controller;

import com.example.Instructorapi.model.Instructor;
import com.example.Instructorapi.service.InstructorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public List<Instructor> getAll() {
        return instructorService.getAllInstructors();
    }

    @PostMapping
    public String create(@RequestBody Instructor instructor) {
        instructorService.addInstructor(instructor);
        return "Instructor " + instructor.getName() + " berjaya ditambah!";
    }
}