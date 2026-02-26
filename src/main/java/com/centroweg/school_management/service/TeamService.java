package com.centroweg.school_management.service;

import com.centroweg.school_management.dto.team.TeamRequestDTO;
import com.centroweg.school_management.dto.team.TeamResponseDTO;
import com.centroweg.school_management.mapper.TeamMapper;
import com.centroweg.school_management.model.Team;
import com.centroweg.school_management.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository repository;
    private final TeamMapper mapper;

    public TeamService(TeamRepository repository, TeamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<TeamResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public TeamResponseDTO findById(Long id) {
        Team team = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));

        return mapper.toDto(team);
    }

    public TeamResponseDTO create(TeamRequestDTO dto) {
        Team team = mapper.toEntity(dto);
        return mapper.toDto(repository.save(team));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
