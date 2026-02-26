package com.centroweg.school_management.service;

import com.centroweg.school_management.dto.student.StudentRequestDTO;
import com.centroweg.school_management.dto.student.StudentResponseDTO;
import com.centroweg.school_management.mapper.StudentMapper;
import com.centroweg.school_management.model.Student;
import com.centroweg.school_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentService(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<StudentResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public StudentResponseDTO findById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return mapper.toDTO(student);
    }

    public StudentResponseDTO create(StudentRequestDTO dto) {

        if(repository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email already exists");
        }

        Student student = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(student));
    }

    public StudentResponseDTO update(Long id, StudentRequestDTO dto) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.name());
        student.setEmail(dto.email());
        student.setRegistration(dto.registration());
        student.setDateOfBirth(dto.dateOfBirth());

        return mapper.toDTO(repository.save(student));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}