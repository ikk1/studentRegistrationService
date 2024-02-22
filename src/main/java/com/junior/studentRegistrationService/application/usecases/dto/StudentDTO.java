package com.junior.studentRegistrationService.application.usecases.dto;

import com.junior.studentRegistrationService.domain.enums.Course;

public record StudentDTO(String name, String email, String address, Course course) {}