package com.junior.studentRegistrationService.infrastructure.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.junior.studentRegistrationService.domain.Student;
import com.junior.studentRegistrationService.domain.StudentRepository;

@Component
public class StudentRepositoryImpl implements StudentRepository {

    private final StudentRepository studentRepository;

    public StudentRepositoryImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findByEmail(String email) {
        List<Student> studentsByEmail = studentRepository.findByEmail(email);
        return studentsByEmail;
    }

    @Override
    public void registerStudent(Student student) {
        studentRepository.registerStudent(student);
    }
}
