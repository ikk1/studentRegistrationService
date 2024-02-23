package com.junior.studentregistrationservice.infrastructure.web.dto;

public record StudentDTO(String name, String email, String address, CourseDTO course) {}