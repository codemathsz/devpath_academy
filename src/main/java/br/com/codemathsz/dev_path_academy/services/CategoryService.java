package br.com.codemathsz.dev_path_academy.services;

import br.com.codemathsz.dev_path_academy.models.Category;
import br.com.codemathsz.dev_path_academy.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category createCategory(Category category){
        return this.repository.save(category);
    }
}
