package com.junior.studentregistrationservice.application.usecases;

import java.util.List;

import com.junior.studentregistrationservice.infrastructure.web.dto.StudentDTO;

public interface ListStudentUseCase {
    List<StudentDTO> listAllStudents();
}
