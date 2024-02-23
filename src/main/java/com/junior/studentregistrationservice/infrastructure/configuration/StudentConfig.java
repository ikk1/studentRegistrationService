package com.junior.studentregistrationservice.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.junior.studentregistrationservice.application.usecases.RegisterStudentUseCaseImpl;
import com.junior.studentregistrationservice.infrastructure.persistence.StudentRepositoryImpl;

@Configuration
public class StudentConfig {
    
    @Bean
    public RegisterStudentUseCaseImpl registerStudent(StudentRepositoryImpl studentRepository){
        return new RegisterStudentUseCaseImpl(studentRepository);
    }

}
