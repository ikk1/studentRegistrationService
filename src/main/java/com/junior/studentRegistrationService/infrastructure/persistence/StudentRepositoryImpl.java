package com.junior.studentRegistrationService.infrastructure.persistence;

import java.util.List;
import java.util.stream.Collectors;

import com.junior.studentRegistrationService.domain.entities.Student;
import com.junior.studentRegistrationService.domain.repositories.StudentRepository;
import com.junior.studentRegistrationService.domain.valueobjects.Email;

public class StudentRepositoryImpl implements StudentRepository {

    private final StudentRepositoryJPA studentRepositoryJPA;

    public StudentRepositoryImpl(StudentRepositoryJPA studentRepositoryJPA) {
        this.studentRepositoryJPA = studentRepositoryJPA;
    }

    @Override
    public List<Student> findByEmail(String email) {
        List<StudentEntity> studentsByEmail = studentRepositoryJPA.findByEmail(email);
        List<Student> ret = studentsByEmail.stream()
                .map(s -> new Student(s.getName(), new Email(s.getEmail()), s.getAddress(), s.getCourse()))
                .collect(Collectors.toList());
        return ret;
    }

    @Override
    public void registerStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setEmail(student.getEmail().getAddress());
        studentEntity.setAddress(student.getAddress());
        studentEntity.setCourse(student.getCourse());
        studentRepositoryJPA.save(studentEntity);
    }
}
