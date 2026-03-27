package com.ctw.spring_academic_dto_pattern.service;

import com.ctw.spring_academic_dto_pattern.dto.curso.CursoRequestDto;
import com.ctw.spring_academic_dto_pattern.dto.curso.CursoResponseDto;
import com.ctw.spring_academic_dto_pattern.mapper.CursoMapper;
import com.ctw.spring_academic_dto_pattern.model.Curso;
import com.ctw.spring_academic_dto_pattern.model.Professor;
import com.ctw.spring_academic_dto_pattern.repository.CursoRepository;
import com.ctw.spring_academic_dto_pattern.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final ProfessorRepository professorRepository;
    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    public CursoResponseDto cadastrarCurso(
            CursoRequestDto cursoRequestDto,
            Long professorId
    ){
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(()-> new RuntimeException("Professor não encontrado"));

        Curso curso = cursoMapper.toEntity(cursoRequestDto,professor);

        cursoRepository.save(curso);

        return cursoMapper.toResponse(curso);
    }

    public List<CursoResponseDto> listarCursos(){
        List<Curso> cursoList = cursoRepository.findAll();

        return cursoList.stream()
                .map(cursoMapper::toResponse)
                .toList();
    }

    public List<CursoResponseDto> buscarCursoProfessorNome(
            String nome
    ){
        List<Curso> cursoList = cursoRepository.findCursoByProfessorNome(nome);

        return cursoList.stream()
                .map(cursoMapper::toResponse)
                .toList();
    }

    public List<CursoResponseDto> buscarCursoProfessorId(
            Long id
    ){
        List<Curso> cursoList = cursoRepository.findCursoByProfessorId(id);

        return cursoList.stream()
                .map(cursoMapper::toResponse)
                .toList();
    }

    public CursoResponseDto buscarCursoPorIdTitulo(
            Long id,
            String titulo
    ){
        Curso curso = cursoRepository.findByIdAndTitulo(id,titulo)
                .orElseThrow(()-> new RuntimeException("Curso não encontrado"));

        return cursoMapper.toResponse(curso);
    }
}
