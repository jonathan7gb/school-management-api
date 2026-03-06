package com.centroweg.school_management.dto.course;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CourseRequestDTO (
        @NotBlank(message = "O nome é obrigatório")
        @NotNull(message = "O nome não pode ser nulo")
        String name,

        @NotBlank(message = "O código é obrigatório")
        @NotNull(message = "O código não pode ser nulo")
        String code
){
}
