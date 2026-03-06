package com.centroweg.school_management.dto.lesson;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record LessonRequestDTO(

        @NotBlank(message = "O id da turma é obrigatório")
        @NotNull(message = "O id da turma não pode ser nulo")
        Long turmaId,

        @NotBlank(message = "A data da aula é obrigatória")
        @NotNull(message = "A data da aula não pode ser nula")
        LocalDateTime dateTime,

        @NotBlank(message = "O assunto da aula é obrigatório")
        @NotNull(message = "O assunto da aula não pode ser nulo")
        String topic
) {
}
