package com.ctw.spring_academic_dto_pattern.repository;

import com.ctw.spring_academic_dto_pattern.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
