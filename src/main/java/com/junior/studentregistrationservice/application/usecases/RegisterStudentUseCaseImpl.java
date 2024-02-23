package com.junior.studentregistrationservice.application.usecases;

import com.junior.studentregistrationservice.domain.Student;
import com.junior.studentregistrationservice.domain.StudentRepository;

public class RegisterStudentUseCaseImpl implements RegisterStudentUseCase {

    private final StudentRepository studentRepository;

    public RegisterStudentUseCaseImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void execute(Student student){
        studentRepository.registerStudent(student);
    }
}
