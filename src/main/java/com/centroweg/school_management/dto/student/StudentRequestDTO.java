package com.centroweg.school_management.dto.student;

import java.util.Date;

public record StudentRequestDTO(
        String name,
        String email,
        String registration,
        Date date_of_birth
) {
}
