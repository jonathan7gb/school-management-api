package com.centroweg.school_management.service;

import com.centroweg.school_management.dto.lesson.LessonRequestDTO;
import com.centroweg.school_management.dto.lesson.LessonResponseDTO;
import com.centroweg.school_management.mapper.LessonMapper;
import com.centroweg.school_management.model.Lesson;
import com.centroweg.school_management.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository repository;
    private final LessonMapper mapper;

    public LessonService(LessonRepository repository, LessonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<LessonResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public LessonResponseDTO create(LessonRequestDTO dto) {
        Lesson lesson = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(lesson));
    }
}
