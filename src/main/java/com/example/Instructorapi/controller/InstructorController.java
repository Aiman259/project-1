package com.example.Instructorapi.controller;

import com.example.Instructorapi.model.Instructor;
import com.example.Instructorapi.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // Pastikan import springframework.data.domain
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

   
  @GetMapping
public Page<Instructor> getInstructors(
        @RequestParam(required = false) String keyword,
        @RequestParam(required = false) String specialization,
        @PageableDefault(page = 0, size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
    
    return instructorService.getInstructorsCombined(keyword, specialization, pageable);
}

    @GetMapping("/search")
    public List<Instructor> search(@RequestParam String keyword) {
        return instructorService.searchInstructorsByName(keyword);
    }

    @GetMapping("/{id}")
    public Instructor getById(@PathVariable String id) {
        return instructorService.getInstructorById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));
    }

    @PostMapping
    public Instructor create(@RequestBody Instructor instructor) {
        return instructorService.createInstructor(instructor);
    }

    @PutMapping("/{id}")
    public Instructor update(@PathVariable String id, @RequestBody Instructor instructor) {
        return instructorService.updateInstructor(id, instructor);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        instructorService.deleteInstructor(id);
        return "Instructor with id " + id + " has been deleted.";
    }
}