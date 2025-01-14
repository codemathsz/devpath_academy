package br.com.codemathsz.dev_path_academy.controllers;

import br.com.codemathsz.dev_path_academy.dtos.UpdateCategoryDTO;
import br.com.codemathsz.dev_path_academy.models.Category;
import br.com.codemathsz.dev_path_academy.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Category category){
        return this.service.createCategory(category);
    }

    @GetMapping("/")
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok().body(this.service.getAllCategories());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable String id,@Valid @RequestBody UpdateCategoryDTO categoryDTO){
        return this.service.updateById(id, categoryDTO);
    }
}
