package com.centroweg.school_management.controller;

import com.centroweg.school_management.dto.course.CourseRequestDTO;
import com.centroweg.school_management.dto.course.CourseResponseDTO;
import com.centroweg.school_management.dto.team.TeamResponseDTO;
import com.centroweg.school_management.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<CourseResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CourseResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public CourseResponseDTO create(@RequestBody CourseRequestDTO dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}