package com.ctw.spring_academic_dto_pattern.service;

import com.ctw.spring_academic_dto_pattern.dto.professor.ProfessorRequestDto;
import com.ctw.spring_academic_dto_pattern.dto.professor.ProfessorResponseDto;
import com.ctw.spring_academic_dto_pattern.mapper.ProfessorMapper;
import com.ctw.spring_academic_dto_pattern.model.Professor;
import com.ctw.spring_academic_dto_pattern.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    public ProfessorResponseDto cadastrarProfessor(
            ProfessorRequestDto professorRequestDto
    ){
        Professor professor = professorMapper.toEntity(professorRequestDto);

        professorRepository.save(professor);

        return professorMapper.toResponse(professor);
    }

    public List<ProfessorResponseDto> listarProfessores(){
        List<Professor> professorList = professorRepository.findAll();

        return professorList.stream()
                .map(professorMapper::toResponse)
                .toList();
    }

}
