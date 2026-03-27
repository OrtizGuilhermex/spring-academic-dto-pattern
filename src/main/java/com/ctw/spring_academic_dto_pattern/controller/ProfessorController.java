package com.ctw.spring_academic_dto_pattern.controller;

import com.ctw.spring_academic_dto_pattern.dto.professor.ProfessorRequestDto;
import com.ctw.spring_academic_dto_pattern.dto.professor.ProfessorResponseDto;
import com.ctw.spring_academic_dto_pattern.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> cadastrarProfessor(
            @RequestBody ProfessorRequestDto professorRequestDto
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(professorService.cadastrarProfessor(professorRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> listarProfessores(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(professorService.listarProfessores());
    }
}
