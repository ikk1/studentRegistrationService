package com.junior.studentregistrationservice.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.junior.studentregistrationservice.application.usecases.ListStudentUseCaseImpl;
import com.junior.studentregistrationservice.application.usecases.RegisterStudentUseCaseImpl;
import com.junior.studentregistrationservice.infrastructure.mappers.StudentMapper;
import com.junior.studentregistrationservice.infrastructure.messaging.RabbitMQSenderService;
import com.junior.studentregistrationservice.infrastructure.persistence.StudentRepositoryImpl;

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
