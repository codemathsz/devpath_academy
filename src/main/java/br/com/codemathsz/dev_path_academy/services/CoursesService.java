package br.com.codemathsz.dev_path_academy.services;

import br.com.codemathsz.dev_path_academy.dtos.UpdateCourseDTO;
import br.com.codemathsz.dev_path_academy.exceptions.CategoryNotFoundException;
import br.com.codemathsz.dev_path_academy.exceptions.CourseNotFoundException;
import br.com.codemathsz.dev_path_academy.models.Coursers;
import br.com.codemathsz.dev_path_academy.repositories.CategoryRepository;
import br.com.codemathsz.dev_path_academy.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CoursesService {

    @Autowired
    private CoursesRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<Object> createCourse(Coursers course){
        try{
            this.categoryRepository.findById(course.getCategoryId()).orElseThrow(
                () -> new CategoryNotFoundException(course.getCategoryId().toString())
            );
            var result =  this.repository.save(course);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public List<Coursers> getAllCourses(){
        return this.repository.findAll();
    }

    public ResponseEntity<Coursers> updateById(String id, UpdateCourseDTO courseDTO){
        Coursers course = this.repository.findById(UUID.fromString(id))
            .orElseThrow(() -> new CourseNotFoundException(id)
        );

        if(courseDTO.name() != null){
            course.setName(courseDTO.name());
        }
        if(courseDTO.categoryId() != null){
            var categoryResult = this.categoryRepository.findById(courseDTO.categoryId()).orElseThrow(
                    () -> new CategoryNotFoundException(courseDTO.categoryId().toString())
            );
            course.setCategoryId(courseDTO.categoryId());
            course.setCategory(categoryResult);
        }

        var result = this.repository.save(course);
        return ResponseEntity.ok().body(result);
    }

    public ResponseEntity<Object> deleteCourseById(String id){
        this.repository.findById(UUID.fromString(id))
            .orElseThrow(() -> new CourseNotFoundException(id)
        );
        this.repository.deleteById(UUID.fromString(id));
        return ResponseEntity.ok().body("Curso deletado");
    }
}
