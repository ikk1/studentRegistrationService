package com.junior.studentRegistrationService.domain;

import java.util.List;

import com.junior.studentRegistrationService.domain.Student;

public interface StudentRepository {

    List<Student> findByEmail(String email);
    void registerStudent(Student student);

}