package com.junior.studentRegistrationService.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.junior.studentRegistrationService.application.usecases.RegisterStudentUseCaseImpl;
import com.junior.studentRegistrationService.infrastructure.mappers.StudentMapper;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentRepositoryImpl;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentRepositoryJPA;
import com.junior.studentRegistrationService.infrastructure.services.RabbitMQSenderService;

@Configuration
public class StudentConfig {

    @Bean
    RegisterStudentUseCaseImpl registerStudent(StudentRepositoryImpl studentRepository, StudentMapper studentMapper,
            RabbitMQSenderService rabbitMQSenderService) {
        return new RegisterStudentUseCaseImpl(studentRepository, studentMapper, rabbitMQSenderService);
    }
}
