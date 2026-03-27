package com.ctw.spring_academic_dto_pattern.dto.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ProfessorResponseDto(
        String nome,
        String email,
        String especialidade
) {
}
