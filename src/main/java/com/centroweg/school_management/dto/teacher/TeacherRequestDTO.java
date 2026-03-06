package com.centroweg.school_management.dto.teacher;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TeacherRequestDTO (
        @NotBlank(message = "O nome é obrigatório")
        @NotNull(message = "O nome não pode ser nulo")
        String name,

        @NotBlank(message = "O email é obrigatório")
        @NotNull(message = "O email não pode ser nulo")
        String email,

        @NotBlank(message = "A disciplina do professor é obrigatória")
        @NotNull(message = "A disciplina do professor não pode ser nula")
        String subject
) {
}
