package com.centroweg.school_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "turma")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            name = "turma_aluno",
            joinColumns = @JoinColumn(name = "turma_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id")
    )
    private List<Student> students = new ArrayList<>();

    public Team(String name, Course course, Teacher teacher) {
        this.name = name;
        this.course = course;
        this.teacher = teacher;
    }
}
