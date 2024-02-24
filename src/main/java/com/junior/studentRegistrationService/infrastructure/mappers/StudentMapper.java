package com.junior.studentregistrationservice.infrastructure.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.junior.studentregistrationservice.domain.Student;
import com.junior.studentregistrationservice.infrastructure.persistence.StudentEntity;
import com.junior.studentregistrationservice.infrastructure.web.dto.StudentDTO;

@Mapper(componentModel = "spring", uses = ValueObjectMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StudentMapper {

    StudentEntity toJPAEntity(Student student);

    Student toDomainEntity(StudentEntity studentEntity);

    Student toDomainEntity(StudentDTO studentDTO);

}