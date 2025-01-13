package br.com.codemathsz.dev_path_academy.controllers;

import br.com.codemathsz.dev_path_academy.models.Coursers;
import br.com.codemathsz.dev_path_academy.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CoursesService service;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Coursers course){
        return this.service.createCourse(course);
    }
}
