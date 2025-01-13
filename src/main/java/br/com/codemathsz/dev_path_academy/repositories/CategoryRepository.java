package br.com.codemathsz.dev_path_academy.repositories;

import br.com.codemathsz.dev_path_academy.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID>{
}
