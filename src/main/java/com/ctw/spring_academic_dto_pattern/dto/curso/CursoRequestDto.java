package com.ctw.spring_academic_dto_pattern.dto.curso;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public record CursoRequestDto(
        @Id
        @NotNull
        Long id,
        @NotNull
        String titulo,
        @NotNull
        Long professorId
) {
}
