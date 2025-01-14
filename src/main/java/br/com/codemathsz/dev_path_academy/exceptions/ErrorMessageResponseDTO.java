package br.com.codemathsz.dev_path_academy.exceptions;

import lombok.Builder;

@Builder
public record ErrorMessageResponseDTO(String message, String field) {
}
