package com.ctw.spring_academic_dto_pattern.dto.professor;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ProfessorRequestDto(
        @Id
        @NotNull
        Long id,
        @NotNull
        String nome,
        @Email
        @NotNull
        String email,
        @NotNull
        String especialidade
) {
}
