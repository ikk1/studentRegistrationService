package com.junior.studentRegistrationService.application.usecases.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.junior.studentRegistrationService.application.usecases.dto.StudentDTO;
import com.junior.studentRegistrationService.domain.entities.Student;
import com.junior.studentRegistrationService.domain.valueobjects.EmailMapper;

@Mapper(uses = EmailMapper.class)
public interface StudentMapper {

    @Mapping(target = "email", source = "email")
    StudentDTO toDto(Student student);

    @Mapping(target = "email", source = "email")
    Student toEntity(StudentDTO studentDTO);
}