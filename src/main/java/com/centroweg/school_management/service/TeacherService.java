package com.centroweg.school_management.service;

import com.centroweg.school_management.dto.teacher.TeacherRequestDTO;
import com.centroweg.school_management.dto.teacher.TeacherResponseDTO;
import com.centroweg.school_management.model.Teacher;
import com.centroweg.school_management.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    public List<TeacherResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TeacherResponseDTO findById(Long id) {
        Teacher teacher = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found!"));

        return toDTO(teacher);
    }

    public TeacherResponseDTO create(TeacherRequestDTO dto) {

        if (repository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email já cadastrado");
        }

        Teacher teacher = new Teacher(
                dto.name(),
                dto.email(),
                dto.subject()
        );

        repository.save(teacher);

        return toDTO(teacher);
    }

    public TeacherResponseDTO update(Long id, TeacherRequestDTO dto) {

        Teacher teacher = repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Teacher not found!"));

        teacher.setName(dto.name());
        teacher.setEmail(dto.email());
        teacher.setSubject(dto.subject());

        repository.save(teacher);

        return toDTO(teacher);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private TeacherResponseDTO toDTO(Teacher teacher) {
        return new TeacherResponseDTO(
                teacher.getId(),
                teacher.getName(),
                teacher.getEmail(),
                teacher.getSubject()
        );
    }
}