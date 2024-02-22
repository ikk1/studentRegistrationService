package com.junior.studentRegistrationService.domain.repositories;

import java.util.List;

import com.junior.studentRegistrationService.domain.entities.Student;

public interface StudentRepository {

    List<Student> findByEmail(String email);
    void registerStudent(Student student);

}