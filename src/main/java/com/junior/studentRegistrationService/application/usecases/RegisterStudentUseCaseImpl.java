package com.junior.studentregistrationservice.application.usecases;

import com.junior.studentregistrationservice.domain.Student;
import com.junior.studentregistrationservice.domain.StudentRepository;
import com.junior.studentregistrationservice.infrastructure.mappers.StudentMapper;
import com.junior.studentregistrationservice.infrastructure.messaging.RabbitMQSenderService;
import com.junior.studentregistrationservice.infrastructure.web.dto.StudentDTO;

import io.micrometer.common.util.StringUtils;

public class RegisterStudentUseCaseImpl implements RegisterStudentUseCase {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final RabbitMQSenderService rabbitMQSenderService;

    public RegisterStudentUseCaseImpl(StudentRepository studentRepository, StudentMapper studentMapper, RabbitMQSenderService rabbitMQSenderService){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.rabbitMQSenderService = rabbitMQSenderService;
    }

    @Override
    public void execute(StudentDTO studentDTO){
        validateStudent(studentDTO);
        Student student = studentMapper.toDomainEntity(studentDTO);
        studentRepository.registerStudent(student);
        rabbitMQSenderService.sendMessage(studentDTO.name(), studentDTO.email());
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
