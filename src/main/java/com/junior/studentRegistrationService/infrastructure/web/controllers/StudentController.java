package com.junior.studentRegistrationService.infrastructure.web.controllers;

import com.junior.studentRegistrationService.infrastructure.mappers.StudentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junior.studentRegistrationService.application.usecases.RegisterStudentUseCaseImpl;
import com.junior.studentRegistrationService.infrastructure.web.dto.StudentDTO;

@RestController
public class StudentController {

    private RegisterStudentUseCaseImpl registerStudentUseCase;

    private StudentMapper mapper;

    public StudentController(RegisterStudentUseCaseImpl registerStudentUseCase, StudentMapper studentMapper) {
        this.registerStudentUseCase = registerStudentUseCase;
        this.mapper = studentMapper;
    }

    @PostMapping("/students")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDTO studentDTO) {
        try {
            var student = mapper.toDomainEntity(studentDTO);
            registerStudentUseCase.execute(student);
            return ResponseEntity.status(HttpStatus.CREATED).body("Student registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to register student: " + e.getMessage());
        }
    }
}
