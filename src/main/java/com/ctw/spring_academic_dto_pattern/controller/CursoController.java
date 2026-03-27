package com.ctw.spring_academic_dto_pattern.controller;

import com.ctw.spring_academic_dto_pattern.dto.curso.CursoRequestDto;
import com.ctw.spring_academic_dto_pattern.dto.curso.CursoResponseDto;
import com.ctw.spring_academic_dto_pattern.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoResponseDto> cadastrarCurso(
            @RequestBody CursoRequestDto cursoRequestDto,
            @RequestParam Long professorId
    ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cursoService.cadastrarCurso(cursoRequestDto, professorId));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> listarCursos(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.listarCursos());
    }

    @GetMapping("/professor/nome/{nome}")
    public ResponseEntity<List<CursoResponseDto>> buscarCursoProfessorNome(
            @PathVariable String nome
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.buscarCursoProfessorNome(nome));
    }

    @GetMapping("/professor/id/{id}")
    public ResponseEntity<List<CursoResponseDto>> buscarCursoProfessorId(
            @PathVariable Long id
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.buscarCursoProfessorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<CursoResponseDto> buscarCursoPorIdTitulo(
            @RequestParam Long id,
            @RequestParam String titulo
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(cursoService.buscarCursoPorIdTitulo(id, titulo));
    }
}
