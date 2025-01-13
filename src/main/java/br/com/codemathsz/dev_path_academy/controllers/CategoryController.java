package br.com.codemathsz.dev_path_academy.controllers;

import br.com.codemathsz.dev_path_academy.models.Category;
import br.com.codemathsz.dev_path_academy.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Category category){
        return this.service.createCategory(category);
    }
}
