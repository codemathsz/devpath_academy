package br.com.codemathsz.dev_path_academy.exceptions;

import java.util.UUID;

public class CategoryNotFoundException extends RuntimeException{

    public CategoryNotFoundException(String categoryId){
        super(String.format("Category[%s] not found", categoryId));
    }
}
