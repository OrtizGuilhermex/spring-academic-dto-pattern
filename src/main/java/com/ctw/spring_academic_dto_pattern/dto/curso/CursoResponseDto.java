package com.ctw.spring_academic_dto_pattern.dto.curso;

import jakarta.validation.constraints.NotNull;

public record CursoResponseDto(
        String titulo,
        Long professorId
) {
}
