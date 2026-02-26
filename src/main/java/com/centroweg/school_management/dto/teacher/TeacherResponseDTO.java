package com.centroweg.school_management.dto.teacher;

public record TeacherResponseDTO (
        Long id,
        String name,
        String email,
        String subject
){
}
