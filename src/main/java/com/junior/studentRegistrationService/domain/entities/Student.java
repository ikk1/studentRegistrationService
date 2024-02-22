package com.junior.studentRegistrationService.domain.entities;

import com.junior.studentRegistrationService.domain.enums.Course;
import com.junior.studentRegistrationService.domain.valueobjects.Email;

public class Student {
    private Long id;
    private String name;
    private Email email;
    private String address;
    private Course course; 
}