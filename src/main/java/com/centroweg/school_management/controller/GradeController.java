package com.centroweg.school_management.controller;

import com.centroweg.school_management.dto.grade.GradeRequestDTO;
import com.centroweg.school_management.dto.grade.GradeResponseDTO;
import com.centroweg.school_management.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class GradeController {

    private final GradeService service;

    public GradeController(GradeService service) {
        this.service = service;
    }

    @GetMapping
    public List<GradeResponseDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public GradeResponseDTO create(@RequestBody GradeRequestDTO dto) {
        return service.create(dto);
    }

}
