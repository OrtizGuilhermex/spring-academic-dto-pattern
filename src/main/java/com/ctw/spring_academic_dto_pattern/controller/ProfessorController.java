package com.ctw.spring_academic_dto_pattern.controller;

import com.ctw.spring_academic_dto_pattern.dto.professor.ProfessorRequestDto;
import com.ctw.spring_academic_dto_pattern.dto.professor.ProfessorResponseDto;
import com.ctw.spring_academic_dto_pattern.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ProfessorResponseDto cadastrarProfessor(
            @RequestBody ProfessorRequestDto professorRequestDto
    ){
        return professorService.cadastrarProfessor(professorRequestDto);
    }

    @GetMapping
    public List<ProfessorResponseDto> listarProfessores(){
        return professorService.listarProfessores();
    }
}
