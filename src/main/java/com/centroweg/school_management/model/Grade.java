package com.centroweg.school_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "nota")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable = false)
    private Lesson lesson;

    @Column(name = "valor", nullable = false)
    private double value;

    public Grade(Student student, Lesson lesson, double value) {
        this.student = student;
        this.lesson = lesson;
        this.value = value;
    }
}
