package com.centroweg.school_management.mapper;

import com.centroweg.school_management.dto.grade.GradeRequestDTO;
import com.centroweg.school_management.dto.grade.GradeResponseDTO;
import com.centroweg.school_management.model.Grade;
import com.centroweg.school_management.model.Student;
import com.centroweg.school_management.model.Lesson;
import com.centroweg.school_management.repository.StudentRepository;
import com.centroweg.school_management.repository.LessonRepository;
import org.springframework.stereotype.Component;

@Component
public class GradeMapper {

    private final StudentRepository studentRepository;
    private final LessonRepository lessonRepository;

    public GradeMapper(StudentRepository studentRepository,
                       LessonRepository lessonRepository) {
        this.studentRepository = studentRepository;
        this.lessonRepository = lessonRepository;
    }

    public Grade toEntity(GradeRequestDTO dto) {

        Student student = studentRepository.findById(dto.studentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));

        Lesson lesson = lessonRepository.findById(dto.lessonId())
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        return new Grade(
                student,
                lesson,
                dto.value()
        );
    }

    public GradeResponseDTO toDTO(Grade grade) {
        return new GradeResponseDTO(
                grade.getId(),
                grade.getStudent().getName(),
                grade.getLesson().getTopic(),
                grade.getValue()
        );
    }
}