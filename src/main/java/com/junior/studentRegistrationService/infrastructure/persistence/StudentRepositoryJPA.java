package com.junior.studentRegistrationService.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryJPA extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findByEmail(String email);

}
