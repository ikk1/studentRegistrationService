package com.junior.studentRegistrationService.domain.repositories;

import com.junior.studentRegistrationService.domain.entities.Student;

public interface StudentRepository {

    Student findByEmail(String email);
    void registerStudent(Student student);

}