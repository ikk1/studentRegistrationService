package com.junior.studentRegistrationService.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.junior.studentRegistrationService.application.usecases.ListStudentUseCaseImpl;
import com.junior.studentRegistrationService.application.usecases.RegisterStudentUseCaseImpl;
import com.junior.studentRegistrationService.infrastructure.mappers.StudentMapper;
import com.junior.studentRegistrationService.infrastructure.messaging.RabbitMQSenderService;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentRepositoryImpl;

@Configuration
public class StudentConfig {

    @Bean
    RegisterStudentUseCaseImpl registerStudent(StudentRepositoryImpl studentRepository, StudentMapper studentMapper,
            RabbitMQSenderService rabbitMQSenderService) {
        return new RegisterStudentUseCaseImpl(studentRepository, studentMapper, rabbitMQSenderService);
    }

    @Bean
    ListStudentUseCaseImpl listStudent(StudentRepositoryImpl studentRepository, StudentMapper studentMapper) {
        return new ListStudentUseCaseImpl(studentRepository, studentMapper);
    }
}
