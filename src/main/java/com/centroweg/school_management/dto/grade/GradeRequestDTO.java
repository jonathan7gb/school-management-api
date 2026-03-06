package com.centroweg.school_management.dto.grade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GradeRequestDTO(
        @NotBlank(message = "O id do estudante é obrigatório")
        @NotNull(message = "O id do estudante não pode ser nulo")
        Long studentId,

        @NotBlank(message = "O id da aula é obrigatório")
        @NotNull(message = "O id da aula não pode ser nulo")
        Long lessonId,

        @NotBlank(message = "A nota é obrigatória")
        @NotNull(message = "A nota não pode ser nula")
        @Size(min = 0, max = 10, message = "A nota deve ser entre 0 e 10!")
        double value
) {
}
