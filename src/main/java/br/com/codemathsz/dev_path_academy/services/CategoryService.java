package br.com.codemathsz.dev_path_academy.services;

import br.com.codemathsz.dev_path_academy.dtos.UpdateCategoryDTO;
import br.com.codemathsz.dev_path_academy.exceptions.CategoryNotFoundException;
import br.com.codemathsz.dev_path_academy.models.Category;
import br.com.codemathsz.dev_path_academy.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public ResponseEntity<Object> createCategory(Category category){
        try {
            var result = this.repository.save(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public List<Category> getAllCategories(){
        return this.repository.findAll();
    }

    public ResponseEntity<Object> updateById(String id, UpdateCategoryDTO categoryDTO){
        var category = this.repository.findById(UUID.fromString(id))
            .orElseThrow(() -> new CategoryNotFoundException(id)
        );
        if(categoryDTO.name() != null){
            category.setName(categoryDTO.name());
            return ResponseEntity.ok().body(this.repository.save(category));
        }
        return ResponseEntity.badRequest().body("Erro ao atualizar categoria");
    }
}
