package com.centroweg.school_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "aula")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "turma_id", nullable = false)
    private Team team;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "assunto", nullable = false)
    private String topic;

    public Lesson(Team team, LocalDateTime dateTime, String topic) {
        this.team = team;
        this.dateTime = dateTime;
        this.topic = topic;
    }
}
