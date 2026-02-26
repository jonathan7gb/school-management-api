package com.centroweg.school_management.service;

import com.centroweg.school_management.dto.grade.GradeRequestDTO;
import com.centroweg.school_management.dto.grade.GradeResponseDTO;
import com.centroweg.school_management.mapper.GradeMapper;
import com.centroweg.school_management.model.Grade;
import com.centroweg.school_management.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final GradeRepository repository;
    private final GradeMapper mapper;

    public GradeService(GradeRepository repository, GradeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<GradeResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public GradeResponseDTO create(GradeRequestDTO dto) {

        if(dto.value() < 0 || dto.value() > 10) {
            throw new RuntimeException("Grade must be between 0 and 10");
        }

        Grade grade = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(grade));
    }
}
