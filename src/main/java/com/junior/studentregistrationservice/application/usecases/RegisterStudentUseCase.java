package com.junior.studentregistrationservice.application.usecases;

import com.junior.studentregistrationservice.domain.Student;

public interface RegisterStudentUseCase {
    void execute(Student student);
}
