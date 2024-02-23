package com.junior.studentRegistrationService.application.usecases;

import com.junior.studentRegistrationService.domain.Student;
import com.junior.studentRegistrationService.domain.StudentRepository;

public class RegisterStudentUseCaseImpl implements RegisterStudentUseCase {

    private final StudentRepository studentRepository;

    public RegisterStudentUseCaseImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public void execute(Student student){
        studentRepository.enroll(student);
    }
}
