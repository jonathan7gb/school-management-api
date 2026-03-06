package com.centroweg.school_management.dto.team;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record TeamRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        @NotNull(message = "O nome não pode ser nulo")
        String name,

        @NotBlank(message = "O id do curso é obrigatório")
        @NotNull(message = "O id do curso não pode ser nulo")
        Long courseId,

        @NotBlank(message = "O id do professor é obrigatório")
        @NotNull(message = "O id do professor não pode ser nulo")
        Long teacherId
) {
}
