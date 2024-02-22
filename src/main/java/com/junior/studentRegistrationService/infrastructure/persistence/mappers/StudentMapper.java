package com.junior.studentRegistrationService.infrastructure.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.junior.studentRegistrationService.domain.entities.Student;
import com.junior.studentRegistrationService.domain.valueobjects.EmailMapper;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentEntity;

@Mapper(uses = EmailMapper.class)
public interface StudentMapper {

    @Mapping(target = "email", source = "email")
    StudentEntity toEntity(Student student);

    @Mapping(target = "email", source = "email")
    Student toDomain(StudentEntity studentEntity);

}
