package com.junior.studentregistrationservice.application.usecases;

import java.util.List;
import java.util.stream.Collectors;

import com.junior.studentregistrationservice.domain.Student;
import com.junior.studentregistrationservice.domain.StudentRepository;
import com.junior.studentregistrationservice.infrastructure.mappers.StudentMapper;
import com.junior.studentregistrationservice.infrastructure.web.dto.StudentDTO;

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
