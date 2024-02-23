package com.junior.studentRegistrationService.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.junior.studentRegistrationService.application.services.RabbitMQSenderService;
import com.junior.studentRegistrationService.application.usecases.RegisterStudentUseCaseImpl;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentRepositoryImpl;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentRepositoryJPA;
import com.junior.studentRegistrationService.infrastructure.persistence.mappers.StudentMapper;

@Configuration
@ComponentScan("com.junior.studentRegistrationService.infrastructure.persistence.mappers")
public class StudentConfig {
    
    @Bean
    RegisterStudentUseCaseImpl registerStudent(StudentRepositoryImpl studentRepository, StudentMapper studentMapper, RabbitMQSenderService rabbitMQSenderService){
        return new RegisterStudentUseCaseImpl(studentRepository, studentMapper, rabbitMQSenderService);
    }

    @Bean
    StudentRepositoryImpl studentRepositoryImpl(StudentRepositoryJPA studentRepositoryJPA, StudentMapper studentMapper) {
        return new StudentRepositoryImpl(studentRepositoryJPA, studentMapper);
    }

    @Bean
    StudentMapper studentMapper(){
        return new StudentMapper();
    }

}