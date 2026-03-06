package com.centroweg.school_management.dto.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record StudentRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        @NotNull(message = "O nome não pode ser nulo")
        String name,

        @NotBlank(message = "O email é obrigatório")
        @NotNull(message = "O email não pode ser nulo")
        @Email(message = "Formato de email inválido")
        String email,

        @NotBlank(message = "A matrícula é obrigatória")
        @NotNull(message = "A matrícula não pode ser nula")
        String registration,

        @NotBlank(message = "A data de nascimento é obrigatória")
        @NotNull(message = "A data de nascimento não pode ser nula")
        @Past(message = "A data de nascimento não pode ser no futuro!")
        LocalDate dateOfBirth
) {
}
