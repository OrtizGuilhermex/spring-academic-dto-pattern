package com.ctw.spring_academic_dto_pattern.repository;

import com.ctw.spring_academic_dto_pattern.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {

    List<Curso> findCursoByProfessorNome(String nome);
    List<Curso> findCursoByProfessorId(Long id);
    Optional<Curso> findByIdAndTitulo(Long id, String titulo);

}
