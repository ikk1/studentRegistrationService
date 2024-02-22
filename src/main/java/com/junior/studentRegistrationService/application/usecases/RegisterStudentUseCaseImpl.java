package com.junior.studentRegistrationService.application.usecases;

import com.junior.studentRegistrationService.application.usecases.dto.StudentDTO;
import com.junior.studentRegistrationService.domain.entities.Student;
import com.junior.studentRegistrationService.domain.repositories.StudentRepository;
import com.junior.studentRegistrationService.infrastructure.persistence.mappers.StudentMapper;

import io.micrometer.common.util.StringUtils;

public class RegisterStudentUseCaseImpl implements RegisterStudentUseCase{

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public RegisterStudentUseCaseImpl(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public void execute(StudentDTO studentDTO){
        validateStudent(studentDTO);
        Student student = studentMapper.toDomainEntity(studentDTO);
        studentRepository.registerStudent(student);
    }

    @Override
    public void validateStudent(StudentDTO studentDTO){
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
