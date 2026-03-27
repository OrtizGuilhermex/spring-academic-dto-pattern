package com.ctw.spring_academic_dto_pattern.controller;

import com.ctw.spring_academic_dto_pattern.dto.curso.CursoRequestDto;
import com.ctw.spring_academic_dto_pattern.dto.curso.CursoResponseDto;
import com.ctw.spring_academic_dto_pattern.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public CursoResponseDto cadastrarCurso(
            @RequestBody CursoRequestDto cursoRequestDto,
            @RequestParam Long professorId
    ){
        return cursoService.cadastrarCurso(cursoRequestDto, professorId);
    }

    @GetMapping
    public List<CursoResponseDto> listarCursos(){
        return cursoService.listarCursos();
    }

    @GetMapping("/professor/nome/{nome}")
    public List<CursoResponseDto> buscarCursoProfessorNome(
            @PathVariable String nome
    ){
        return cursoService.buscarCursoProfessorNome(nome);
    }

    @GetMapping("/professor/id/{id}")
    public List<CursoResponseDto> buscarCursoProfessorId(
            @PathVariable Long id
    ){
        return cursoService.buscarCursoProfessorId(id);
    }

    @GetMapping("/buscar")
    public CursoResponseDto buscarCursoPorIdTitulo(
            @RequestParam Long id,
            @RequestParam String titulo
    ){
        return cursoService.buscarCursoPorIdTitulo(id, titulo);
    }
}
