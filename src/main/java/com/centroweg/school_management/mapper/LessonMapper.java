package com.centroweg.school_management.mapper;

import com.centroweg.school_management.dto.lesson.LessonRequestDTO;
import com.centroweg.school_management.dto.lesson.LessonResponseDTO;
import com.centroweg.school_management.model.Lesson;
import com.centroweg.school_management.model.Team;
import com.centroweg.school_management.repository.TeamRepository;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper {

    private final TeamRepository teamRepository;

    public LessonMapper(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Lesson toEntity(LessonRequestDTO dto) {

        Team team = teamRepository.findById(dto.turmaId())
                .orElseThrow(() -> new RuntimeException("Team not found"));

        return new Lesson(
                team,
                dto.dateTime(),
                dto.topic()
        );
    }

    public LessonResponseDTO toDTO(Lesson lesson) {
        return new LessonResponseDTO(
                lesson.getId(),
                lesson.getTeam().getName(),
                lesson.getDateTime(),
                lesson.getTopic()
        );
    }
}
