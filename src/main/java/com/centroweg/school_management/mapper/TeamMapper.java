package com.centroweg.school_management.mapper;

import com.centroweg.school_management.dto.teacher.TeacherResponseDTO;
import com.centroweg.school_management.dto.team.TeamRequestDTO;
import com.centroweg.school_management.dto.team.TeamResponseDTO;
import com.centroweg.school_management.model.Course;
import com.centroweg.school_management.model.Teacher;
import com.centroweg.school_management.model.Team;
import com.centroweg.school_management.repository.CourseRepository;
import com.centroweg.school_management.repository.TeacherRepository;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final CourseMapper courseMapper;
    private final TeacherMapper teacherMapper;

    public TeamMapper(CourseRepository courseRepository,
                      TeacherRepository teacherRepository,
                      CourseMapper courseMapper,
                      TeacherMapper teacherMapper
    ) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.courseMapper = courseMapper;
        this.teacherMapper = teacherMapper;
    }

    public Team toEntity (TeamRequestDTO t){

        Course course = courseRepository.findById(t.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Teacher teacher = teacherRepository.findById(t.teacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        return new Team(
                t.name(),
                course,
                teacher
        );
    }

    public TeamResponseDTO toDto(Team team){
        return new TeamResponseDTO(
                team.getId(),
                team.getName(),
                courseMapper.toDto(team.getCourse()),
                teacherMapper.toDto(team.getTeacher())
        );
    }
}
