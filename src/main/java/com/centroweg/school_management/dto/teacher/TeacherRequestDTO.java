package com.centroweg.school_management.dto.teacher;

public record TeacherRequestDTO (
        String name,
        String email,
        String subject
) {
}
