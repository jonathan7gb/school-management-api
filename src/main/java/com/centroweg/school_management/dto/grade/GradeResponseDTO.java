package com.centroweg.school_management.dto.grade;

public record GradeResponseDTO(
        Long id,
        String studentName,
        String lessonTopic,
        double value
) {
}
