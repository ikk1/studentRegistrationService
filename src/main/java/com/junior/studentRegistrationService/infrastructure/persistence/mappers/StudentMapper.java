package com.junior.studentRegistrationService.infrastructure.persistence.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.junior.studentRegistrationService.application.usecases.dto.StudentDTO;
import com.junior.studentRegistrationService.domain.entities.Student;
import com.junior.studentRegistrationService.domain.valueobjects.EmailMapper;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentEntity;

@Mapper(componentModel = "spring", uses = EmailMapper.class)
public interface StudentMapper {

    @Mapping(target = "email", source = "email")
    StudentEntity toJPAEntity(Student student);

    @Mapping(target = "email", source = "email")
    Student toDomainEntity(StudentEntity studentEntity);
    
    @Mapping(target = "email", source = "email")
    Student toDomainEntity(StudentDTO studentDTO);

    @Mapping(target = "email", source = "email")
    StudentDTO toDto(Student student);
    
}
