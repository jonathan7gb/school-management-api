package com.centroweg.school_management.dto.team;

import com.centroweg.school_management.dto.course.CourseResponseDTO;
import com.centroweg.school_management.dto.teacher.TeacherResponseDTO;

import java.util.List;

public record TeamResponseDTO(
        Long id,
        String name,
        CourseResponseDTO course,
        TeacherResponseDTO teacher,
        List<String> studentsName
) {
}
