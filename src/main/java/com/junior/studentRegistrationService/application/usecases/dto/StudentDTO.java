package com.junior.studentRegistrationService.application.usecases.dto;

import com.junior.studentRegistrationService.domain.enums.Course;
import com.junior.studentRegistrationService.domain.valueobjects.Email;

public record StudentDTO(String name, Email email, String address, Course course) {}