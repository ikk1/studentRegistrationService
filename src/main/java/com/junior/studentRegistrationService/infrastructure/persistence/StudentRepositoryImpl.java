package com.junior.studentRegistrationService.infrastructure.persistence;

import java.util.List;
import java.util.stream.Collectors;

import com.junior.studentRegistrationService.domain.entities.Student;
import com.junior.studentRegistrationService.domain.repositories.StudentRepository;
import com.junior.studentRegistrationService.infrastructure.persistence.mappers.StudentMapper;

public class StudentRepositoryImpl implements StudentRepository {

    private final StudentRepositoryJPA studentRepositoryJPA;
    private final StudentMapper studentMapper;

    public StudentRepositoryImpl(StudentRepositoryJPA studentRepositoryJPA, StudentMapper studentMapper) {
        this.studentRepositoryJPA = studentRepositoryJPA;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> findByEmail(String email) {
        List<StudentEntity> studentsByEmail = studentRepositoryJPA.findByEmail(email);
        List<Student> ret = studentsByEmail.stream().map(s -> studentMapper.toDomainEntity(s)).collect(Collectors.toList());
        return ret;
    }

    @Override
    public void registerStudent(Student student) {
        StudentEntity studentEntity = studentMapper.toJPAEntity(student);
        studentRepositoryJPA.save(studentEntity);
    }
}
