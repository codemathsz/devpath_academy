package br.com.codemathsz.dev_path_academy.services;

import br.com.codemathsz.dev_path_academy.models.Coursers;
import br.com.codemathsz.dev_path_academy.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository repository;

    public ResponseEntity<Object> createCourse(Coursers course){
        try{
            var result =  this.repository.save(course);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
