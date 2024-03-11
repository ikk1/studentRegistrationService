package com.junior.studentRegistrationService.application.usecases;

import java.util.List;

import com.junior.studentRegistrationService.infrastructure.web.dto.StudentDTO;

public interface ListStudentUseCase {
    List<StudentDTO> listAllStudents();
}
