package com.centroweg.school_management.controller;

import com.centroweg.school_management.dto.student.StudentResponseDTO;
import com.centroweg.school_management.dto.team.TeamRequestDTO;
import com.centroweg.school_management.dto.team.TeamResponseDTO;
import com.centroweg.school_management.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TeamController {

    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping
    public List<TeamResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TeamResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public TeamResponseDTO create(@RequestBody TeamRequestDTO dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
