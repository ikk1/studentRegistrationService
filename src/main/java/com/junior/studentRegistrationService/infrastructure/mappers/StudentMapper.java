package com.junior.studentRegistrationService.infrastructure.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.junior.studentRegistrationService.infrastructure.web.dto.StudentDTO;
import com.junior.studentRegistrationService.domain.Student;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentEntity;

@Mapper(componentModel = "spring",
        uses = ValueObjectMapper.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StudentMapper {

    StudentEntity toJPAEntity(Student student);

    Student toDomainEntity(StudentEntity studentEntity);

    Student toDomainEntity(StudentDTO studentDTO);

}
