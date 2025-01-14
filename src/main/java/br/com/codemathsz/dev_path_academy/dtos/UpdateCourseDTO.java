package br.com.codemathsz.dev_path_academy.dtos;

import lombok.Builder;

import java.util.UUID;

public record UpdateCourseDTO(String name, UUID categoryId) {
}