package com.junior.studentRegistrationService.infrastructure.persistence.mappers;


import com.junior.studentRegistrationService.application.usecases.dto.StudentDTO;
import com.junior.studentRegistrationService.domain.entities.Student;
import com.junior.studentRegistrationService.domain.valueobjects.Email;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentEntity;

public class StudentMapper {

    public StudentEntity toJPAEntity(Student student){
        return new StudentEntity(student.getName(), student.getEmail().getAddress(), student.getAddress(), student.getCourse());
    }

    public Student toDomainEntity(StudentEntity studentEntity){
        return new Student(studentEntity.getName(), new Email(studentEntity.getEmail()), studentEntity.getAddress(), studentEntity.getCourse());
    }
    
    public Student toDomainEntity(StudentDTO studentDTO){
        return new Student(studentDTO.name(), new Email(studentDTO.email()), studentDTO.address(), studentDTO.course());
    }

    public StudentDTO toDto(Student student){
        return new StudentDTO(student.getName(), student.getEmail().getAddress(), student.getAddress(), student.getCourse());
    }
    
}
