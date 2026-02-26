package com.centroweg.school_management.dto.lesson;

import java.time.LocalDateTime;

public record LessonRequestDTO(
        Long turmaId,
        LocalDateTime dateTime,
        String topic
) {
}
