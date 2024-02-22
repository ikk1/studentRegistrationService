package com.junior.studentRegistrationService.application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junior.studentRegistrationService.application.usecases.RegisterStudentUseCaseImpl;
import com.junior.studentRegistrationService.application.usecases.dto.StudentDTO;

@RestController
public class StudentController {

    private RegisterStudentUseCaseImpl registerStudentUseCase;

    public StudentController(RegisterStudentUseCaseImpl registerStudentUseCase) {
        this.registerStudentUseCase = registerStudentUseCase;
    }

    @PostMapping("/students")
    public ResponseEntity<String> registerStudent(@RequestBody StudentDTO studentDTO) {
        try {
            registerStudentUseCase.execute(studentDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Student registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to register student: " + e.getMessage());
        }
    }
}
