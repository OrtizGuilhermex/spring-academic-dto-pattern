package com.ctw.spring_academic_dto_pattern.mapper;

import com.ctw.spring_academic_dto_pattern.dto.professor.ProfessorRequestDto;
import com.ctw.spring_academic_dto_pattern.dto.professor.ProfessorResponseDto;
import com.ctw.spring_academic_dto_pattern.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor toEntity(
            ProfessorRequestDto professorRequestDto
    ){
        return new Professor(
                professorRequestDto.id(),
                professorRequestDto.nome(),
                professorRequestDto.email(),
                professorRequestDto.especialidade()
        );
    }

    public ProfessorResponseDto toResponse(
            Professor professor
    ){
        return new ProfessorResponseDto(
                professor.getNome(),
                professor.getEmail(),
                professor.getEspecialidade()
        );
    }
}
