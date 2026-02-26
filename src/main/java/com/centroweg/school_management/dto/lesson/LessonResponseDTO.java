package com.centroweg.school_management.dto.lesson;

import java.time.LocalDateTime;

public record LessonResponseDTO(
        Long id,
        String teamName,
        LocalDateTime dateTime,
        String topic
) {
}
