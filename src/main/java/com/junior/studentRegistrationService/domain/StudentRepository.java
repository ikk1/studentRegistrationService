package com.junior.studentRegistrationService.domain;

import java.util.List;

public interface StudentRepository {

    List<Student> findByEmail(String email);
    void registerStudent(Student student);

}