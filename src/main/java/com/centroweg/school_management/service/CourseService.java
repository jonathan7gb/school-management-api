package com.centroweg.school_management.service;

import com.centroweg.school_management.dto.course.CourseRequestDTO;
import com.centroweg.school_management.dto.course.CourseResponseDTO;
import com.centroweg.school_management.mapper.CourseMapper;
import com.centroweg.school_management.model.Course;
import com.centroweg.school_management.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;

    public CourseService(CourseRepository repository, CourseMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CourseResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public CourseResponseDTO findById(Long id) {
        Course course = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return mapper.toDto(course);
    }

    public CourseResponseDTO create(CourseRequestDTO dto) {
        Course course = mapper.toEntity(dto);
        return mapper.toDto(repository.save(course));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}