package com.junior.studentRegistrationService.infrastructure.web.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junior.studentRegistrationService.application.usecases.ListStudentUseCaseImpl;
import com.junior.studentRegistrationService.application.usecases.RegisterStudentUseCaseImpl;
import com.junior.studentRegistrationService.infrastructure.web.dto.StudentDTO;

@RestController
public class StudentController {

    private RegisterStudentUseCaseImpl registerStudentUseCase;
    private ListStudentUseCaseImpl listStudentUseCase;

    public StudentController(RegisterStudentUseCaseImpl registerStudentUseCase,
            ListStudentUseCaseImpl listStudentUseCase) {
        this.registerStudentUseCase = registerStudentUseCase;
        this.listStudentUseCase = listStudentUseCase;
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

    @GetMapping("/students")
    public ResponseEntity<List<StudentDTO>> listAllStudents() {
        try {
            List<StudentDTO> listAllStudents = listStudentUseCase.listAllStudents();
            return ResponseEntity.status(HttpStatus.OK).body(listAllStudents);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}
