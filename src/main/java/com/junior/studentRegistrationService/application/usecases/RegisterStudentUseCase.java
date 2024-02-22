package com.junior.studentRegistrationService.application.usecases;

import com.junior.studentRegistrationService.application.usecases.dto.StudentDTO;

public interface RegisterStudentUseCase {
    void execute(StudentDTO studentDTO);
    void validateStudent(StudentDTO studentDTO);
}
