package com.junior.studentRegistrationService.application.usecases;

import java.util.List;
import java.util.stream.Collectors;

import com.junior.studentRegistrationService.domain.Student;
import com.junior.studentRegistrationService.domain.StudentRepository;
import com.junior.studentRegistrationService.infrastructure.mappers.StudentMapper;
import com.junior.studentRegistrationService.infrastructure.web.dto.StudentDTO;

public class ListStudentUseCaseImpl implements ListStudentUseCase {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public ListStudentUseCaseImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDTO> listAllStudents() {
        List<Student> listAllStudents = studentRepository.listAllStudents();
        return listAllStudents.stream().map(s -> studentMapper.toDTO(s)).collect(Collectors.toList());
    }

}
