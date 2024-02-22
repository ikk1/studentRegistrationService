package com.junior.studentRegistrationService.application.usecases.mappers;

import com.junior.studentRegistrationService.application.usecases.dto.StudentDTO;
import com.junior.studentRegistrationService.domain.entities.Student;

public class StudentMapper {
    public static StudentDTO toDto(Student student) {
        return new StudentDTO(student.getName(), student.getEmail(), student.getAddress(), student.getCourse());
    }
    public static Student toEntity(StudentDTO studentDTO){
        return new Student(studentDTO.name(), studentDTO.email(), studentDTO.address(), studentDTO.course());
    }
}