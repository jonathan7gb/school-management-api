package com.centroweg.school_management.controller;

import com.centroweg.school_management.dto.student.StudentRequestDTO;
import com.centroweg.school_management.dto.student.StudentResponseDTO;
import com.centroweg.school_management.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public StudentResponseDTO create(@RequestBody StudentRequestDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO update(@PathVariable Long id,
                                     @RequestBody StudentRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}