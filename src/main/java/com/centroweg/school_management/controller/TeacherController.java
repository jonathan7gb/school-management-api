package com.centroweg.school_management.controller;

import com.centroweg.school_management.dto.teacher.TeacherRequestDTO;
import com.centroweg.school_management.dto.teacher.TeacherResponseDTO;
import com.centroweg.school_management.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public List<TeacherResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TeacherResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public TeacherResponseDTO create(@RequestBody TeacherRequestDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public TeacherResponseDTO update(@PathVariable Long id,
                                     @RequestBody TeacherRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}