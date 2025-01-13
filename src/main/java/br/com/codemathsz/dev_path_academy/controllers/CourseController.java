package br.com.codemathsz.dev_path_academy.controllers;

import br.com.codemathsz.dev_path_academy.models.Coursers;
import br.com.codemathsz.dev_path_academy.services.CoursesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CoursesService service;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Coursers course){
        return this.service.createCourse(course);
    }

    @GetMapping("/")
    public ResponseEntity<List<Coursers>> getAll(){
        return ResponseEntity.ok().body(this.service.getAllCourses());
    }
}
