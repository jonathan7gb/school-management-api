package com.centroweg.school_management.controller;

import com.centroweg.school_management.dto.lesson.LessonRequestDTO;
import com.centroweg.school_management.dto.lesson.LessonResponseDTO;
import com.centroweg.school_management.service.LessonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
public class LessonController {

    private final LessonService service;

    public LessonController(LessonService service) {
        this.service = service;
    }

    @GetMapping
    public List<LessonResponseDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public LessonResponseDTO create(@RequestBody LessonRequestDTO dto) {
        return service.create(dto);
    }


}