package com.centroweg.school_management.dto.student;

import java.time.LocalDate;
import java.util.Date;

public record StudentRequestDTO(
        String name,
        String email,
        String registration,
        LocalDate dateOfBirth
) {
}
