package com.example.Instructorapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Document(collection = "instructors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    @Id
    private String id;
    private String name;
    private String email;
    private String specialization;
    private int yearsExperience;
    private String status;
}