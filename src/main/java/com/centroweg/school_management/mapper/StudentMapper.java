package com.centroweg.school_management.mapper;

import com.centroweg.school_management.dto.student.StudentRequestDTO;
import com.centroweg.school_management.dto.student.StudentResponseDTO;
import com.centroweg.school_management.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequestDTO dto) {
        return new Student(
                dto.name(),
                dto.email(),
                dto.registration(),
                dto.dateOfBirth()
        );
    }

    public StudentResponseDTO toDTO(Student student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getRegistration(),
                student.getDateOfBirth()
        );
    }
}