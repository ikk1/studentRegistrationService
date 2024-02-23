package com.junior.studentRegistrationService.application.usecases;

import com.junior.studentRegistrationService.domain.Student;

public interface RegisterStudentUseCase {
    void execute(Student student);
}
