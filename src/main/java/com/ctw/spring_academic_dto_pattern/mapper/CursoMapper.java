package com.ctw.spring_academic_dto_pattern.mapper;

import com.ctw.spring_academic_dto_pattern.dto.curso.CursoRequestDto;
import com.ctw.spring_academic_dto_pattern.dto.curso.CursoResponseDto;
import com.ctw.spring_academic_dto_pattern.model.Curso;
import com.ctw.spring_academic_dto_pattern.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public Curso toEntity(
            CursoRequestDto cursoRequestDto,
            Professor professor
    ){
        return new Curso(
                cursoRequestDto.id(),
                cursoRequestDto.titulo(),
                professor
        );
    }

    public CursoResponseDto toResponse(
            Curso curso
    ){
        return new CursoResponseDto(
                curso.getTitulo(),
                curso.getProfessor().getId()
        );
    }
}
