package com.centroweg.school_management.mapper;

import com.centroweg.school_management.dto.course.CourseRequestDTO;
import com.centroweg.school_management.dto.course.CourseResponseDTO;
import com.centroweg.school_management.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toEntity(CourseRequestDTO c){
        return new Course(
                c.name(),
                c.code()
        );
    }

    public CourseResponseDTO toDto(Course c){
        return new CourseResponseDTO(
                c.getId(),
                c.getName(),
                c.getCode()
        );
    }
}
