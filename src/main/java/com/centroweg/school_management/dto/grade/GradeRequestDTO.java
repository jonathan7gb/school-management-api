package com.centroweg.school_management.dto.grade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GradeRequestDTO(
        @NotBlank(message = "O id do estudante é obrigatório")
        @NotNull(message = "O id do estudante não pode ser nulo")
        Long studentId,

        @NotBlank(message = "O id da aula é obrigatório")
        @NotNull(message = "O id da aula não pode ser nulo")
        Long lessonId,

        @NotBlank(message = "A nota é obrigatória")
        @NotNull(message = "A nota não pode ser nula")
        double value
) {
}
