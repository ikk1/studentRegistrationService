package com.junior.studentRegistrationService.infrastructure.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.junior.studentRegistrationService.domain.Student;
import com.junior.studentRegistrationService.infrastructure.web.dto.StudentDTO;

@Mapper(componentModel = "spring", uses = ValueObjectMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR )
public interface StudentMapper {

    @Mapping(target = "email", source = "email")
    Student toDomainEntity(StudentDTO studentDTO);

}