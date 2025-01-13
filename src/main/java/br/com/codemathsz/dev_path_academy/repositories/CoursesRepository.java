package br.com.codemathsz.dev_path_academy.repositories;

import br.com.codemathsz.dev_path_academy.models.Coursers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoursesRepository extends JpaRepository<Coursers, UUID> {
}
