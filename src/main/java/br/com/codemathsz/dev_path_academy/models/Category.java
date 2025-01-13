package br.com.codemathsz.dev_path_academy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "name is required")
    @Column(unique = true)
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
