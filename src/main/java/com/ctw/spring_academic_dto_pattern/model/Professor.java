package com.ctw.spring_academic_dto_pattern.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String especialidade;

    @OneToMany(mappedBy = "professor")
    private List<Curso> cursos;

    public Professor(Long id, String nome, String email, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
    }

    public Professor(String nome, String email, String especialidade) {
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
    }
}
