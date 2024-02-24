package com.junior.studentregistrationservice.application.usecases;

import com.junior.studentregistrationservice.infrastructure.web.dto.StudentDTO;

public interface RegisterStudentUseCase {
    void execute(StudentDTO studentDTO);
    void validateStudent(StudentDTO studentDTO);
}
