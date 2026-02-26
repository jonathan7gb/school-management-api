package com.centroweg.school_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "aluno")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "matricula", nullable = false, length = 20)
    private String registration;

    @Column(name = "data_nascimento", nullable = false)
    private Date date_of_birth0;

    @ManyToMany(mappedBy = "students")
    private List<Team> team = new ArrayList<>();

    public Student(String name, String email, String registration, Date date_of_birth0) {
        this.name = name;
        this.email = email;
        this.registration = registration;
        this.date_of_birth0 = date_of_birth0;
    }
}
