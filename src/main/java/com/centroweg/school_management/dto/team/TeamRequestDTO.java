package com.centroweg.school_management.dto.team;

import java.util.List;

public record TeamRequestDTO(
        String name,
        Long courseId,
        Long teacherId
) {
}
