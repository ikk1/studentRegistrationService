package com.junior.studentRegistrationService.application.usecases;

import com.junior.studentRegistrationService.domain.Student;
import com.junior.studentRegistrationService.domain.StudentRepository;
import com.junior.studentRegistrationService.infrastructure.mappers.StudentMapper;
import com.junior.studentRegistrationService.infrastructure.messaging.SenderService;
import com.junior.studentRegistrationService.infrastructure.web.dto.StudentDTO;

import io.micrometer.common.util.StringUtils;

public class RegisterStudentUseCaseImpl implements RegisterStudentUseCase {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final SenderService senderService;

    public RegisterStudentUseCaseImpl(StudentRepository studentRepository, StudentMapper studentMapper, SenderService senderService){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.senderService = senderService;
    }

    @Override
    public void execute(StudentDTO studentDTO){
        validateStudent(studentDTO);
        Student student = studentMapper.toDomainEntity(studentDTO);
        studentRepository.registerStudent(student);
        senderService.sendMessage(studentDTO.name(), studentDTO.email());
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
