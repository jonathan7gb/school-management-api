package com.centroweg.school_management.dto.grade;

public record GradeRequestDTO(
        Long studentId,
        Long lessonId,
        double value
) {
}
