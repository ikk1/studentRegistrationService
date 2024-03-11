package com.junior.studentRegistrationService.infrastructure.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.junior.studentRegistrationService.domain.Student;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentEntity;
import com.junior.studentRegistrationService.infrastructure.web.dto.StudentDTO;

@Mapper(componentModel = "spring", uses = ValueObjectMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StudentMapper {

    StudentEntity toJPAEntity(Student student);

    Student toDomainEntity(StudentEntity studentEntity);

    Student toDomainEntity(StudentDTO studentDTO);

    StudentDTO toDTO(Student student);

}