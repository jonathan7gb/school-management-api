package com.centroweg.school_management.mapper;

import com.centroweg.school_management.dto.teacher.TeacherRequestDTO;
import com.centroweg.school_management.dto.teacher.TeacherResponseDTO;
import com.centroweg.school_management.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public Teacher toEntity(TeacherRequestDTO t){
        return new Teacher(
                t.name(),
                t.email(),
                t.subject()
        );
    }

    public TeacherResponseDTO toDto(Teacher t){
        return new TeacherResponseDTO(
                t.getId(),
                t.getName(),
                t.getEmail(),
                t.getSubject()
        );
    }
}
