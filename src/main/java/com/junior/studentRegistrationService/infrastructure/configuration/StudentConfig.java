package com.junior.studentRegistrationService.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.junior.studentRegistrationService.application.usecases.RegisterStudentUseCaseImpl;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentRepositoryImpl;
import com.junior.studentRegistrationService.infrastructure.persistence.StudentRepositoryJPA;
import com.junior.studentRegistrationService.infrastructure.mappers.StudentMapper;

@Configuration
@ComponentScan("com.junior.studentRegistrationService.infrastructure.persistence.mappers")
public class StudentConfig {
    
    @Bean
    public RegisterStudentUseCaseImpl registerStudent(StudentRepositoryImpl studentRepository){
        return new RegisterStudentUseCaseImpl(studentRepository);
    }

}
