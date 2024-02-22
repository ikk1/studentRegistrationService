package com.junior.studentRegistrationService.application.usecases;

import com.junior.studentRegistrationService.application.usecases.dto.StudentDTO;
import com.junior.studentRegistrationService.application.usecases.mappers.StudentMapper;
import com.junior.studentRegistrationService.domain.entities.Student;
import com.junior.studentRegistrationService.domain.repositories.StudentRepository;

import io.micrometer.common.util.StringUtils;

public class RegisterStudentUseCase {

    private final StudentRepository studentRepository;

    public RegisterStudentUseCase(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void execute(StudentDTO studentDTO){
        validateStudent(studentDTO);
        Student student = StudentMapper.toEntity(studentDTO);
        studentRepository.registerStudent(student);
    }

    private void validateStudent(StudentDTO studentDTO){
        if(studentDTO.email() == null)
            throw new IllegalArgumentException("Invalid e-mail address!");
        if(StringUtils.isBlank(studentDTO.name()))
            throw new IllegalArgumentException("Name can't be blank!");
        if(StringUtils.isBlank(studentDTO.address()))
            throw new IllegalArgumentException("Address can't be blank!");
        if(studentDTO.course() == null)
            throw new IllegalArgumentException("You must fill course!");
    }
}
