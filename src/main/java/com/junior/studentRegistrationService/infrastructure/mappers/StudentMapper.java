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

    @Mapping(target = "email", source = "email")
    StudentEntity toJPAEntity(Student student);

    @Mapping(target = "email", source = "email")
    Student toDomainEntity(StudentEntity studentEntity);
    
    @Mapping(target = "email", source = "email")
    Student toDomainEntity(StudentDTO studentDTO);

    
}
